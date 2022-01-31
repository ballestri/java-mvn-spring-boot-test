package com.automata.testing.framework.user.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */



/**
 * Dependencies
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automata.testing.framework.user.dto.UserDTO;
import com.automata.testing.framework.user.model.UserEntity;
import com.automata.testing.framework.user.repository.IUserRepository;

import com.automata.testing.framework.algorithm.service.IEncryptionService;
import com.automata.testing.framework.user.dto.UserSignupDTO;


import lombok.extern.slf4j.Slf4j;


/**
 * The Implementation of the service.
 * 
 * @author GELIBERT
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    @Autowired
    private IUserRepository repository;

    @Autowired
    private IEncryptionService encryptionService;
    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    @Override
    public void createUser(UserDTO user) {
	log.info("Saving data for user {}", user);
	// TODO Implement the password encryption process.
        UserSignupDTO userSignupDTO = (UserSignupDTO) user;
        userSignupDTO.setPassword(encryptionService.encode(userSignupDTO.getPassword()));
	// We create the user in database.
	UserEntity savingUser = UserEntity.builder().firstName(userSignupDTO.getFirstName()).lastName(userSignupDTO.getLastName()).emailAddress(userSignupDTO.getEmailAddress()).password(userSignupDTO.getPassword()).build();
	log.debug("Saving the user {}", user);
	repository.save(savingUser);
    }

    public void deleteUser(Integer id){
        repository.deleteById(id);
    }

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
