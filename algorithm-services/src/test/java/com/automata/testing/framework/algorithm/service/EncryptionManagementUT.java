package com.automata.testing.framework.algorithm.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.automata.testing.framework.algorithm.service.EncrypteRotation13ServiceImpl;
import com.automata.testing.framework.algorithm.service.IDecryptionService;
import com.automata.testing.framework.algorithm.service.IEncryptionService;

/**
 * Dependencies
 */

/**
 * Unit test for algorithms.
 * 
 * @author GELIBERT
 */
@SpringBootTest(classes = EncrypteRotation13ServiceImpl.class)
public class EncryptionManagementUT {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes
    
    /**
     * Encryption service to use.
     */
    private IEncryptionService encryptionService;
    
    /**
     * Decryption service to use.
     */
    private IDecryptionService decryptionService;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods
    
    /**
     * Testing the ROT 13 Algorithm.
     */
    @Test
    public void iDontKnowTest() {
	
	// Testing with data ABC, that should be changed in NOP
	String res = encryptionService.encode("ABC");
	
	Assertions.assertEquals("NOP", res);
	
	res = encryptionService.encode("XYZ");
	Assertions.assertEquals("efg", res);
	
    }
    
    /**
     * Testing Synchronous encoding and decoding.
     */
    @Test
    public void iDontKnowTest2() {
	
	// Testing the decoding algorithm.
	String toTest = RandomStringUtils.randomAlphabetic(30).toUpperCase();
	Assertions.assertEquals(toTest, decryptionService.decode(encryptionService.encode(toTest)));
    }

    // -------------------------------------- Setters and Getters

}
