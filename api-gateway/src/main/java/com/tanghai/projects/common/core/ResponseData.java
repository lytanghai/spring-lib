package com.tanghai.projects.common.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class ResponseData {
    private String message;
    private int status;
    private Object data;
}