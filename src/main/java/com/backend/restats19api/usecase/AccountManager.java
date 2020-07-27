package com.backend.restats19api.usecase;

import com.backend.restats19api.repositories.UsersRepository;
import com.backend.restats19api.domain.ErrorCode;
import com.backend.restats19api.domain.RessourceException;
import com.backend.restats19api.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountManager {

    UsersRepository usersRepository;

    @Autowired
    public AccountManager(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findUser(String username) throws RessourceException {
        try{
            return usersRepository.findByUsername(username);
        }catch (Exception e){
            throw new RessourceException(ErrorCode.NOT_FOUND);
        }
    }
    public Users findUser(Long id) throws RessourceException {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RessourceException(ErrorCode.NOT_FOUND));
    }
}
