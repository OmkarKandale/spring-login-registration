package com.neo.springloginregistration.controller;

import com.neo.springloginregistration.model.User;
import com.neo.springloginregistration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    public final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailID = user.getEmailId();
        if (tempEmailID != null && !"".equals(tempEmailID)) {
            User userObj = registrationService.fetchUserByEmailId(tempEmailID);
            if (userObj != null) {
                throw new Exception("user with "+tempEmailID+" already exist");
            }
        }
        User userObj = null;
        userObj = registrationService.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPassword = user.getPassword();
        User userObj = null;
        if (tempEmailId != null && tempPassword != null) {
            userObj = registrationService.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
        }
        if (userObj == null) {
            throw new Exception("Bad credentials");
        }
        return userObj;
    }
}
