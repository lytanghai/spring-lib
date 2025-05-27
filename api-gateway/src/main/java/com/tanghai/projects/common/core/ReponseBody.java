package com.tanghai.projects.common.core;

public class ReponseBody {
    private String message;
    private int status;
    private Object data;

    public ReponseBody() {
        message = "";
        status = 200;
        data = null;
    }

    public ReponseBody withMessage(String message) {
        this.message = message;
        return this;
    }

    public ReponseBody withStatus(int status) {
        this.status = status;
        return this;
    }

    public ReponseBody withData(Object data) {
        this.data = data;
        return this;
    }

    public ResponseData build() {
        return new ResponseData(message, status, data);
    }
}