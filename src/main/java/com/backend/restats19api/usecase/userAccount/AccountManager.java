package com.backend.restats19api.usecase.userAccount;

import com.backend.restats19api.domain.utils.ResultStatusCode;
import com.backend.restats19api.repositories.UsersRepository;
import com.backend.restats19api.domain.utils.ErrorCode;
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

    public ResultStatusCode newUser(Users user) throws RessourceException {
        if(usersRepository.existsByUsername(user.getUsername())){
            throw new RessourceException(ErrorCode.EXIST);
        }
        try{
            user.setConnectstatus(true);
            usersRepository.save(user);
            return ResultStatusCode.SAVED;
        }catch (Exception e){
            return ResultStatusCode.UNSAVED;
        }
    }

    public ResultStatusCode changeUser(Users userChanged) throws RessourceException {
        Users search = findUser(userChanged.getIduser());
        if(userChanged.getUsername().equals(search.getUsername())
                && userChanged.getPassword().equals(search.getPassword())){
            return ResultStatusCode.UNMODIFIED;
        }
        if(!userChanged.getUsername().equals(search.getUsername())){
            search.setUsername(userChanged.getUsername());
        }
        if(!userChanged.getPassword().equals(search.getPassword())){
            search.setPassword(userChanged.getPassword());
        }
        return ResultStatusCode.MODIFIED;
    }

    public ResultStatusCode quitUser(Long id) throws RessourceException {
        assert(findUser(id) != null);
        usersRepository.deleteById(id);
        return ResultStatusCode.DELETED;
    }
}
