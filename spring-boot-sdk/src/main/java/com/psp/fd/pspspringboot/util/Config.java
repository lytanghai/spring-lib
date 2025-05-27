package com.psp.fd.pspspringboot.util;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class Config {

    public PublicKey getPublic(String str) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        getBC();
        StringReader stringReader = new StringReader(str);
        PEMParser pemParser = new PEMParser(stringReader);
        SubjectPublicKeyInfo serverCertificate = (SubjectPublicKeyInfo)pemParser.readObject();
        pemParser.close();
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(serverCertificate.getEncoded()));
    }

    private Provider getBC() {
        Provider provider = Security.getProvider("BC");
        if (provider == null) {
            provider = new BouncyCastleProvider();
            Security.addProvider(provider);
        }

        return provider;
    }

    public KeyPair getKeyPair(String str) throws IOException {
        Provider provider = getBC();
        StringReader stringReader = new StringReader(str);
        PEMParser pemParser = new PEMParser(stringReader);
        Object object = pemParser.readObject();
        pemParser.close();
        JcaPEMKeyConverter converter = (new JcaPEMKeyConverter()).setProvider(provider);
        return converter.getKeyPair((PEMKeyPair)object);
    }

    public PrivateKey getPrivate(String str) throws IOException {
        return getKeyPair(str).getPrivate();
    }

    public String encryptPayload(String iat, String payload, PrivateKey privateKey, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String signed = iat + payload;

        System.out.println("sign [step check]:" + signed);

        //Let's sign our message
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(signed.getBytes(StandardCharsets.UTF_8));

        byte[] signature = privateSignature.sign();

        //Let's check the signature
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(signed.getBytes(StandardCharsets.UTF_8));
        boolean isCorrect = publicSignature.verify(signature);


        System.out.println("Signature correct: " + isCorrect);

        String signatureEncoded = Base64.getEncoder().encodeToString(signature);
        System.out.println(signatureEncoded);

        return signatureEncoded;
    }
}
