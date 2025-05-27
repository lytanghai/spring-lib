package com.tanghai.projects.common.handler;

import com.tanghai.projects.common.core.ReponseBody;
import com.tanghai.projects.common.type.ApplicationHandlerCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends Throwable {

    private static final long serialVersionUID = 123877231231444233L;

    private String code;

    protected ReponseBody responseMessage;

    public BaseException(ApplicationHandlerCode code, String message) {
        super(message);
        this.code = code.getCode();

    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code, String message, ReponseBody responseMessage) {
        super(message);
        this.code = code;
        this.responseMessage = responseMessage;
    }

    public BaseException(String code, String message, Throwable throwable) {
        super(message,throwable);
        this.code = code;
    }

    public BaseException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }
}
