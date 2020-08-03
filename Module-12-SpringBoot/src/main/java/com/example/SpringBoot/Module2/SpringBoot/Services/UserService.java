package com.example.SpringBoot.Module2.SpringBoot.Services;

import com.example.SpringBoot.Module2.SpringBoot.Shared.Dto.UserDto;

import java.util.*;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getUsers();

    UserDto findUserByEmail(String emailAddress);

    UserDto findUserByUserId(String userId);

    UserDto updateUserByEmail(String email, UserDto requestedUpdate);

    UserDto updateUserById(String userId, UserDto requestedUpdate);

    UserDto deleteUserById(String userId);

    UserDto deleteUserByEmail(String emailAddress);
}
