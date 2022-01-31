package com.automata.testing.framework.algorithm.service;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PermuteServiceImpl implements IPermuteService {
    @Autowired
    private IEncryptionService encryptionService;

    @Override
    public String permute(String input) {

        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i+1 <= input.length()) {
            char firstChar=input.charAt(i);
            if(i+1 != input.length()) {
                char secondChar = input.charAt(i+1);
                sb.append(secondChar);
                sb.append(firstChar);
            }else {
                sb.append(encryptionService.encode(String.valueOf(firstChar)));
            }
            i = i+2;
        }

        log.info("Result is {}", sb);
        return sb.toString();
    }
}
