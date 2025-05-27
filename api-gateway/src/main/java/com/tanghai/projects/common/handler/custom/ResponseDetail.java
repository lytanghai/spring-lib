package com.tanghai.projects.common.handler.custom;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDetail {
    private Date dateTime;
    private int httpStatus;
    private String path;
}