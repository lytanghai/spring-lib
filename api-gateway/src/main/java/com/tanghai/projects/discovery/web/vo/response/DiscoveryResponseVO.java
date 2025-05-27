package com.tanghai.projects.discovery.web.vo.response;

import com.tanghai.projects.common.type.MethodType;
import com.tanghai.projects.common.type.StatusType;
import com.tanghai.projects.common.type.Type;
import lombok.Data;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Setter
public class DiscoveryResponseVO {
    private String id;
    private String url;
    private String serviceName;
    private Type type;
    private String requestHeader;
    private String requestPayload;
    private MethodType methodType;
    private boolean isAvailable;
    private StatusType statusType;
    private HttpStatus httpStatus;
}
