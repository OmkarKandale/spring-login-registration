package com.neo.springloginregistration.service;

import com.neo.springloginregistration.model.User;
import com.neo.springloginregistration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public User saveUser(User user) {
        return registrationRepository.save(user);
    }

    public User fetchUserByEmailId(String email) {
        return registrationRepository.findByEmailId(email);
    }

    public User fetchUserByEmailIdAndPassword(String email, String password) {
        return registrationRepository.findByEmailIdAndPassword(email, password);
    }
}
