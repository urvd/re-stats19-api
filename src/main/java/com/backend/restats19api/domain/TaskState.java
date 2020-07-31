package com.backend.restats19api.domain;

public enum TaskState {
    START("2"), INPROCESS("1"), OVER("0");

    private String code;

    TaskState(String code) {
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
