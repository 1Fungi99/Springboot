package com.example.SpringBoot.Module2.SpringBoot.Services;

import com.example.SpringBoot.Module2.SpringBoot.Models.User;
import com.example.SpringBoot.Module2.SpringBoot.Shared.Dto.UserDto;

import java.util.*;

public interface UserService {
    //    @Override
    //    public void createUser(User user) {
    //        userRepository.save(user);
    //    }
    UserDto createUser(UserDto userDto);

//    List<User> getUsers();
//
//    UserDto createUser(UserDto user);
//
//    User getUser(String emailAddress);
//
//    Optional<User> getUserByID(Long id);
//
//    void deleteUserByID(Long id);
}
