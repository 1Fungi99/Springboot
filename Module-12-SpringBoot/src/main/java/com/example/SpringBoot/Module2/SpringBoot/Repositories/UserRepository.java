package com.example.SpringBoot.Module2.SpringBoot.Repositories;

import com.example.SpringBoot.Module2.SpringBoot.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
User findByEmailAddress(String emailAddress);
Optional<User> findById(Long id);
}
