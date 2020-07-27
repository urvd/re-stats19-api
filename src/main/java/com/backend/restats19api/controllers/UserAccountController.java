package com.backend.restats19api.controllers;

import com.backend.restats19api.domain.RessourceException;
import com.backend.restats19api.entities.Users;
import com.backend.restats19api.usecase.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {

    @Autowired
    AccountManager accountManager;

    @GetMapping("/User")
    public ResponseEntity<Users> getUser(@RequestParam(value = "username") String username) throws RessourceException {
        Users usr = accountManager.findUser(username);
        return ResponseEntity.ok(usr);
    }
}
