package com.psp.fd.pspspringboot.controller;

import com.psp.fd.pspspringboot.service.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

@RestController()
public class EncryptDecryptController {

    @Autowired
    private JWT jwt;

    @PostMapping("/encode")
    private String encryption(@RequestBody Map<String,Object> mapDTO) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidKeySpecException, IOException {
        return jwt.encryption(mapDTO);
    }

    @GetMapping("/welcome")
    private String test() {
        return "test";
    }
}
