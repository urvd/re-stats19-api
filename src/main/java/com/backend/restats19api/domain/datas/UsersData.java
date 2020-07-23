package com.backend.restats19api.domain.datas;

import com.backend.restats19api.entities.Tasks;
import com.backend.restats19api.entities.Users;
import lombok.Data;

import java.util.List;
import java.util.Set;

public class UsersData extends Users {

    public String getUsername() {
        return super.getUsername();
    }

    public Set<Tasks> getTasks() {
        return super.getTasks();
    }
}
