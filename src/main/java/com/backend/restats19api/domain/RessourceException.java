package com.backend.restats19api.domain;

import com.backend.restats19api.domain.ErrorCode;

public class RessourceException extends Exception {
    public  RessourceException(ErrorCode errorCode){
        super("Resource " + errorCode.getMessage());
    }
}
