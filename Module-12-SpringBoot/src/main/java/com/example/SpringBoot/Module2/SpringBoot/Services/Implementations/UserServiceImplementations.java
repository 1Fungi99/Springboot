package com.example.SpringBoot.Module2.SpringBoot.Services.Implementations;

import com.example.SpringBoot.Module2.SpringBoot.Models.User;
import com.example.SpringBoot.Module2.SpringBoot.Services.UserService;
import com.example.SpringBoot.Module2.SpringBoot.Repositories.UserRepository;
import com.example.SpringBoot.Module2.SpringBoot.Shared.Dto.UserDto;
import com.example.SpringBoot.Module2.SpringBoot.Shared.Utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImplementations implements UserService {

    private final UserRepository userRepository;
    private final Utils utils;

    public UserServiceImplementations(UserRepository userRepository, Utils utils) {
        this.userRepository = userRepository;
        this.utils = utils;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser);

        newUser.setEncryptedPassword("test");
        newUser.setEmailVerificationStatus(true);
        newUser.setUserId(utils.generateUserId(30));

        User storedUserDetails = userRepository.save(newUser);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> userList = new ArrayList<User>();
        userList = (List<User>) userRepository.findAll();

        List<UserDto> returnValue = new ArrayList<UserDto>();

        for (int i = 0; i < userRepository.count(); i++) {
            returnValue.add(new UserDto());
        }

        for (int i = 0; i < userRepository.count(); i++) {
            BeanUtils.copyProperties(userList.get(i), returnValue.get(i));
        }

        return returnValue;
    }

    @Override
    public UserDto findUserByEmail(String emailAddress) {
        UserDto foundDtoUser = new UserDto();
        User foundUser = userRepository.findByEmailAddress(emailAddress);

        BeanUtils.copyProperties(foundUser, foundDtoUser);

        return foundDtoUser;
    }

    @Override
    public UserDto findUserByUserId(String userId) {
        UserDto foundDtoUser = new UserDto();
        User foundUser = userRepository.findByUserId(userId);

        BeanUtils.copyProperties(foundUser, foundDtoUser);

        return foundDtoUser;
    }

    @Override
    public UserDto updateUserByEmail(String email, UserDto requestedUpdate) {
        User updateUser = new User();
        BeanUtils.copyProperties(requestedUpdate, updateUser);

        User oldUserData = userRepository.findByEmailAddress(email);
        UserDto returnValue = new UserDto();

        updateUser.setId(oldUserData.getId());
        updateUser.setUserId(oldUserData.getUserId());
        updateUser.setEncryptedPassword("test1");
        updateUser.setEmailVerificationStatus(oldUserData.isEmailVerificationStatus());

        User updatedUserDetails = userRepository.save(updateUser);
        BeanUtils.copyProperties(updatedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto updateUserById(String userId, UserDto requestedUpdate) {

        User updateUser = new User();
        BeanUtils.copyProperties(requestedUpdate, updateUser);

        User oldUserData = userRepository.findByUserId(userId);
        UserDto returnValue = new UserDto();

        updateUser.setId(oldUserData.getId());
        updateUser.setUserId(oldUserData.getUserId());
        updateUser.setEncryptedPassword("test1");
        updateUser.setEmailVerificationStatus(oldUserData.isEmailVerificationStatus());

        User updatedUserDetails = userRepository.save(updateUser);

        BeanUtils.copyProperties(updatedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto deleteUserById(String userId) {
        UserDto foundDtoUser = new UserDto();
        User foundUser = userRepository.findByUserId(userId);

        BeanUtils.copyProperties(foundUser, foundDtoUser);
        userRepository.deleteById(foundUser.getId());

        return foundDtoUser;
    }

    @Override
    public UserDto deleteUserByEmail(String emailAddress) {
        UserDto foundDtoUser = new UserDto();
        User foundUser = userRepository.findByEmailAddress(emailAddress);

        BeanUtils.copyProperties(foundUser, foundDtoUser);
        userRepository.deleteById(foundUser.getId());

        return foundDtoUser;
    }

}
