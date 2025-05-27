package com.psp.fd.pspspringboot.service;

import com.psp.fd.pspspringboot.util.Config;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

@Service
public class JWT {

    private String getPublicKey() {
        return "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArUyfWD0TbXnqmxwr3FNp\n" +
                "k5B1m8hFaw1+ml+UmAgvwn4Dd35kMDo7cE1eUeVJrDVlAyRKI6JebdVwq8RgHYT7\n" +
                "X5CFJd1WlZhtYjOX/evmKOyELVUm+IjVIsHE5JVr6H4f1chx5s8s8qETvNwPInVV\n" +
                "pfE35zO3nHGp15dowSJqs/xVpSVRKovrPEKmnsd5vLyQrpdFWqVwZHg1HBCTtqqB\n" +
                "2tNzRVrQaUTlKdV/B0QeSYYFHxakME+lXwOslihlJLHE1h9JvcXX1QsAvqjv+mvQ\n" +
                "bKSydJvw6aFaGKPqzZnz6jXYoi6i30gJU9WBWCw/PWLmmE7FIHpFVHpcj6Zw9b26\n" +
                "JQIDAQAB\n" +
                "-----END PUBLIC KEY-----";
    }

    private String getPrivateKey() {
        return "-----BEGIN RSA PRIVATE KEY-----\n" +
                "MIIEowIBAAKCAQEArUyfWD0TbXnqmxwr3FNpk5B1m8hFaw1+ml+UmAgvwn4Dd35k\n" +
                "MDo7cE1eUeVJrDVlAyRKI6JebdVwq8RgHYT7X5CFJd1WlZhtYjOX/evmKOyELVUm\n" +
                "+IjVIsHE5JVr6H4f1chx5s8s8qETvNwPInVVpfE35zO3nHGp15dowSJqs/xVpSVR\n" +
                "KovrPEKmnsd5vLyQrpdFWqVwZHg1HBCTtqqB2tNzRVrQaUTlKdV/B0QeSYYFHxak\n" +
                "ME+lXwOslihlJLHE1h9JvcXX1QsAvqjv+mvQbKSydJvw6aFaGKPqzZnz6jXYoi6i\n" +
                "30gJU9WBWCw/PWLmmE7FIHpFVHpcj6Zw9b26JQIDAQABAoIBAGKCDI224gU36QDU\n" +
                "iaYLEBdeZUvxEmyg1hdgP3IQLT3MLaJOCRtU7paOlA/PWwp1q36WsUICONUMH6iz\n" +
                "zsLY5Z7T4qu8XkxYwcyxcTNYVZNrplKydZ2PAkBojsg0m4sjrmryLrS5jV4566NO\n" +
                "H5hBxDa4oENfJX7bKWUwXs5yBt9Zn4Nni2kejyonzlw05LgQB98x2Yt1IWBUbmx7\n" +
                "0Gh7qKeTUj/RIzO95KxdXp8TAgHqC8I8xvmbo1pyoNg0tOFOAHrBqu+tKYpieqSM\n" +
                "nDSIX7wCBJrRbGouuOlx90lA3sPL9TKJk2ZtAsa9wWB22kE+ya+xsQ8gqZ7Uz30c\n" +
                "UF3NAf0CgYEA3SQAls5/dp1jb9glc8IStg32mRlgCVcxmY39g8cHN0ne/oy3oCKc\n" +
                "wdzs7LAt0/+/MupO7/Fwj7sHcmy4vLExFVcSrweeKhJ81ObdYLzD+RSFN6HqjwpI\n" +
                "2kXHmVciVgjugleXkxdzUUMiWshmd0VekAhhpCragynIWrstisgtFB8CgYEAyJ4D\n" +
                "FZKwBO7eRp2ZT204ZFwoWqKLpgepqw8CxsoKg3pacYZcGSxkQQ3Z8sHWkrZFMroz\n" +
                "qR/JFLSUwuvYnMaUCBA5gDKAe7N6a9BExnLuAjVtpM4FESvUT2qpkiPNwZh//UMZ\n" +
                "6tgNgBhWdhNAa2V5BiL/KZI8vFYDVZCiSRW7CTsCgYBuCRYJ9CJUgSgTZPfty6nH\n" +
                "0Nbdg1TYEPzrLU3yHjym9CjzfE16bv6VMDrr4xZKoL0gtpokpnyd6DBibVrW+Uw1\n" +
                "FCiF00KOKLjYry+EjSjubZmD/xtZpYJuqb4RvNum97bGQJN5a3fD/aXAimsB+hB9\n" +
                "ls4PBAvKrCW3j9+vaL+VfQKBgANAPECPPfb2f/eY+jEFThKiQ60kUSsBmMhC2AKs\n" +
                "p3r18p1AViG6TG2ZcdyzM2zxMzHdPpURBMsnGfoGpF32AdQXnzbqmpZmlCdHGrY0\n" +
                "ipLSltJC3GYo1anryo+psN3gQMKz4amikqVuv4fuS+7xmAJ3crcTvZQ3uJocW+Tf\n" +
                "S0adAoGBAIAQWRrU6AiATtRdED+DbLc46LvmfhpzR2TGLQRSLSvvlP0mtmKI1YRo\n" +
                "qib2ppj/8oq1tu/I3w9TGGhXYt7zfpUM5bF2ceGoSaO7bxnMGk0mlg2zPlG25Yk3\n" +
                "m6hggv43agLtTsu1yuYKYCA7QgR7NDs6abFvqH+v9M06kqCYhi0P\n" +
                "-----END RSA PRIVATE KEY-----";
    }
    public String encryption(Map<String,Object> map) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidKeySpecException, IOException {
        PublicKey publicKey = getPublic(getPublicKey());
        PrivateKey privateKey = getPrivate(getPrivateKey());

        String iat = "1703397813";

        JSONObject payload4Check = new JSONObject(map);
        String signedStepCheck = iat + payload4Check;

        System.out.println("sign:" + signedStepCheck);

        //Let's sign our message
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(signedStepCheck.getBytes(StandardCharsets.UTF_8));

        byte[] signature = privateSignature.sign();

        //Let's check the signature
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(signedStepCheck.getBytes(StandardCharsets.UTF_8));
        boolean isCorrect = publicSignature.verify(signature);

        System.out.println("Signature correct: " + isCorrect);
        System.out.println(Base64.getEncoder().encodeToString(signature));

        return Base64.getEncoder().encodeToString(signature);
    }

    public static PublicKey getPublic(String str) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        getBC();
        StringReader stringReader = new StringReader(str);
        PEMParser pemParser = new PEMParser(stringReader);
        SubjectPublicKeyInfo serverCertificate = (SubjectPublicKeyInfo)pemParser.readObject();
        pemParser.close();
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(serverCertificate.getEncoded()));
    }

    static Provider getBC() {
        Provider provider = Security.getProvider("BC");
        if (provider == null) {
            provider = new BouncyCastleProvider();
            Security.addProvider((Provider)provider);
        }

        return (Provider)provider;
    }

    public static KeyPair getKeyPair(String str) throws IOException {
        Provider provider = getBC();
        StringReader stringReader = new StringReader(str);
        PEMParser pemParser = new PEMParser(stringReader);
        Object object = pemParser.readObject();
        pemParser.close();
        JcaPEMKeyConverter converter = (new JcaPEMKeyConverter()).setProvider(provider);
        return converter.getKeyPair((PEMKeyPair)object);
    }

    public static PrivateKey getPrivate(String str) throws IOException {
        return getKeyPair(str).getPrivate();
    }
}

