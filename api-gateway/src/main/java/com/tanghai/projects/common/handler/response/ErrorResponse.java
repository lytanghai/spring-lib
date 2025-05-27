package com.tanghai.projects.common.handler.response;

import com.tanghai.projects.common.handler.custom.ResponseDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private String traceId;
    private ResponseDetail responseDetail;
}