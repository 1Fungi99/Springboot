package com.example.SpringBoot.Module2.SpringBoot.Repositories;

import com.example.SpringBoot.Module2.SpringBoot.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmailAddress(String emailAddress);

    User findByUserId(String userId);

}
