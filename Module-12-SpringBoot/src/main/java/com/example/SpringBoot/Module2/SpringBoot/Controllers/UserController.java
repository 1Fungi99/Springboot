package com.example.SpringBoot.Module2.SpringBoot.Controllers;

import com.example.SpringBoot.Module2.SpringBoot.Model.Request.UserRequest;
import com.example.SpringBoot.Module2.SpringBoot.Model.Response.UserResponse;
import com.example.SpringBoot.Module2.SpringBoot.Services.UserService;
import com.example.SpringBoot.Module2.SpringBoot.Shared.Dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

@RestController
@RequestMapping("users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )

    public UserResponse createUser(@RequestBody UserRequest userRequest) {

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto createdUser = userService.createUser(userDto);

        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;

    }

//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<User> getUsers(){
//        List<User> returnValue = userService.getUsers();
//        return returnValue;
//
//    }
//
//    @GetMapping(path="/id={id}")
//    public Optional<User> getUserByID(@PathVariable Long id){
//        Optional<User> returnValue = userService.getUserByID(id);
//        return returnValue;
//    }
//
//    @GetMapping(path = "/emailAddress={emailAddress}")
//    public User getUser(@PathVariable String emailAddress){
//        User returnValue = userService.getUser(emailAddress);
//        return returnValue;
//    }
//
//    @PostMapping
//    public void newUser(@RequestBody User user){
//        userService.createUser(user);
//    }
//
//    @PutMapping
//    public void updateUser() {
//
//    }
//
//    @DeleteMapping(path="id={id}")
//    public void deleteUserByID(@PathVariable Long id){
//        userService.deleteUserByID(id);
//    }



}
