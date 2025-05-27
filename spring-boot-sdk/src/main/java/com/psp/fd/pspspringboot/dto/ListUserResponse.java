package com.psp.fd.pspspringboot.dto;

import java.util.List;

public class ListUserResponse {
    private String message;

    private List<Integer> ids;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
