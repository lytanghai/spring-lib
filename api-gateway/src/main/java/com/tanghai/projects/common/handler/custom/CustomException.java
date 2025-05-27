package com.tanghai.projects.common.handler.custom;


public class CustomException extends RuntimeException {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public CustomException(String message) {
        super(message);
    }
}