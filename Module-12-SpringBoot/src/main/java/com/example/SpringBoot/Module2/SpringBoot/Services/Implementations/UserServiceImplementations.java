package com.example.SpringBoot.Module2.SpringBoot.Services.Implementations;

import com.example.SpringBoot.Module2.SpringBoot.Models.User;
import com.example.SpringBoot.Module2.SpringBoot.Services.UserService;
import com.example.SpringBoot.Module2.SpringBoot.Repositories.UserRepository;
import com.example.SpringBoot.Module2.SpringBoot.Shared.Dto.UserDto;
import com.example.SpringBoot.Module2.SpringBoot.Shared.Utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementations implements UserService {

    private final UserRepository userRepository;
    private final Utils utils;

    public UserServiceImplementations(UserRepository userRepository, Utils utils) {
        this.userRepository = userRepository;
        this.utils = utils;
    }

//    @Override
//    public List<User> getUsers() {
//        List<User> returnValue =  new ArrayList<User>();
//        returnValue = (List<User>) userRepository.findAll();
//        return returnValue;
//    }


//    @Override
//    public void createUser(User user) {
//        userRepository.save(user);
//    }
    @Override
    public UserDto createUser(UserDto userDto){
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
//    @Override
//    public User getUser(String emailAddress) {
//        User returnValue = userRepository.findByEmailAddress(emailAddress);
//        return returnValue;
//    }

//    @Override
//    public Optional<User> getUserByID(Long id) {
//        Optional<User> returnValue = userRepository.findById(id);
//        return returnValue;
//    }

//    @Override
//    public void deleteUserByID(Long id) {
//        userRepository.deleteById(id);
//    }


}
