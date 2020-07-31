package com.backend.restats19api.domain.utils;

public enum ResultStatusCode {
    SAVED("saved"),
    UNSAVED("unsaved"),
    MODIFIED("modify"),
    UNMODIFIED("unmodify"),
    DELETED("deleted");

    private String status;

    ResultStatusCode(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
