package com.apper;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Service
public class IdGeneratorService {
    public String generateRandomCharacters(int length) {
        String generatedString = RandomStringUtils.randomAlphanumeric(length);
        System.out.println("verification code: " + generatedString);
        return generatedString;
    }

    public String nextId() {
        String generatedId = UUID.randomUUID().toString();
        System.out.println("generated id: " + generatedId);
        return generatedId;
    }

}
