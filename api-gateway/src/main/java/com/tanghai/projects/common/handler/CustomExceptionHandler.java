package com.tanghai.projects.common.handler;

import com.tanghai.projects.common.handler.custom.CustomException;
import com.tanghai.projects.common.handler.custom.ResponseDetail;
import com.tanghai.projects.common.handler.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleCustomException(HttpServletRequest request, CustomException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(ex.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTraceId(UUID.randomUUID().toString());
        
        ResponseDetail responseDetail = new ResponseDetail();
        responseDetail.setDateTime(new Date());
        responseDetail.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        responseDetail.setPath(request.getRequestURI());
        response.setResponseDetail(responseDetail);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, CustomException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(ex.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTraceId(UUID.randomUUID().toString());
        ResponseDetail responseDetail = new ResponseDetail();
        responseDetail.setDateTime(new Date());
        responseDetail.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDetail.setPath(request.getRequestURI());
        response.setResponseDetail(responseDetail);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}