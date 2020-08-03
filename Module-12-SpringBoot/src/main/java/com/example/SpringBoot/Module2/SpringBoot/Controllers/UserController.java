package com.example.SpringBoot.Module2.SpringBoot.Controllers;

import com.example.SpringBoot.Module2.SpringBoot.Model.Request.UserRequest;
import com.example.SpringBoot.Module2.SpringBoot.Model.Response.UserResponse;
import com.example.SpringBoot.Module2.SpringBoot.Services.UserService;
import com.example.SpringBoot.Module2.SpringBoot.Shared.Dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import org.springframework.beans.BeanUtils;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto createdUser = userService.createUser(userDto);
        UserResponse returnValue = new UserResponse();

        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        List<UserDto> dtoList = userService.getUsers();
        List<UserResponse> returnValue = new ArrayList<UserResponse>();

        for (int i = 0; i < dtoList.size(); i++) {
            returnValue.add(new UserResponse());
        }

        for (int i = 0; i < dtoList.size(); i++) {
            BeanUtils.copyProperties(dtoList.get(i), returnValue.get(i));
        }

        return returnValue;
    }

    @GetMapping(path = "/email={emailAddress}")
    public UserResponse findUserByEmail(@PathVariable String emailAddress) {
        UserDto foundUser = userService.findUserByEmail(emailAddress);
        UserResponse returnValue = new UserResponse();

        BeanUtils.copyProperties(foundUser, returnValue);

        return returnValue;
    }

    @GetMapping(path = "/id={userId}")
    public UserResponse findUserById(@PathVariable String userId) {
        UserDto foundUser = userService.findUserByUserId(userId);
        UserResponse returnValue = new UserResponse();

        BeanUtils.copyProperties(foundUser, returnValue);

        return returnValue;
    }

    @PutMapping(path = "email={emailAddress}")
    public UserResponse updateUserByEmail(@PathVariable String email, @RequestBody UserRequest userRequest) {
        UserDto requestedUpdate = new UserDto();
        BeanUtils.copyProperties(userRequest, requestedUpdate);

        UserDto updatedUser = userService.updateUserByEmail(email, requestedUpdate);
        UserResponse returnValue = new UserResponse();

        BeanUtils.copyProperties(updatedUser, returnValue);

        return returnValue;
    }

    @PutMapping(path = "id={userId}")
    public UserResponse updateUserById(@PathVariable String userId, @RequestBody UserRequest userRequest) {
        UserDto requestedUpdate = new UserDto();
        BeanUtils.copyProperties(userRequest, requestedUpdate);

        UserDto updatedUser = userService.updateUserById(userId, requestedUpdate);
        UserResponse returnValue = new UserResponse();

        BeanUtils.copyProperties(updatedUser, returnValue);

        return returnValue;
    }

    @DeleteMapping(path = "id={userId}")
    public UserResponse deleteUserById(@PathVariable String userId) {
        UserDto deletedUser = userService.deleteUserById(userId);
        UserResponse returnValue = new UserResponse();

        BeanUtils.copyProperties(deletedUser, returnValue);

        return returnValue;
    }

    @DeleteMapping(path = "/email={emailAddress}")
    public UserResponse deleteUserByEmail(@PathVariable String emailAddress) {

        UserDto deletedUser = userService.deleteUserByEmail(emailAddress);
        UserResponse returnValue = new UserResponse();

        BeanUtils.copyProperties(deletedUser, returnValue);

        return returnValue;
    }

}
