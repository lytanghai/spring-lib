package com.tanghai.projects.common.type;

import com.tanghai.projects.common.constant.ResponseCode;

public enum ApplicationHandlerCode implements ApplicationCode{

    //SUCCESS
    SUCCESS(ResponseCode.SUCCESS,"Success"),

    //WARNING
    WARNING("Warning"),

    //ERROR
    ERROR("ERROR"),
    ENTITY_IS_EXIST(ResponseCode.E401, "Entity is not null"),

    //EXPECTED
    EXPECTED("Expected");

    private String code;
    private String message;

    ApplicationHandlerCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    ApplicationHandlerCode(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
