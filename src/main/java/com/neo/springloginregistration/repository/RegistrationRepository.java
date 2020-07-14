package com.neo.springloginregistration.repository;

import com.neo.springloginregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
    public User findByEmailId(String email);
    public User findByEmailIdAndPassword(String email, String password);
}
