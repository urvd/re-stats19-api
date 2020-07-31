package com.backend.restats19api.controllers;

import com.backend.restats19api.domain.RessourceException;
import com.backend.restats19api.entities.Users;
import com.backend.restats19api.usecase.userAccount.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Users user) throws RessourceException {
        return ResponseEntity.ok(accountManager.newUser(user).getStatus());
    }

    @PutMapping("/user")
    public ResponseEntity<String> modifyUser(@RequestBody Users user) throws RessourceException {
        return ResponseEntity.ok(accountManager.changeUser(user).getStatus());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long iduser) throws RessourceException {
        return ResponseEntity.ok(accountManager.quitUser(iduser).getStatus());
    }
}
