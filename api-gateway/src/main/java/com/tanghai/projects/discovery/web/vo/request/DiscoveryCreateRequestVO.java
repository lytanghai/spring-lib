package com.tanghai.projects.discovery.web.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanghai.projects.common.type.MethodType;
import com.tanghai.projects.common.type.StatusType;
import com.tanghai.projects.common.type.Type;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
public class DiscoveryCreateRequestVO {

    private String id;

    @NotNull @NotBlank
    private String url;

    @JsonProperty(value = "service_name")
    private String serviceName;

    @JsonProperty(value = "type")
    private Type type;

    @JsonProperty(value = "request_header")
    private String requestHeader;

    @JsonProperty(value = "request_payload")
    private String requestPayload;

    @JsonProperty(value = "method_type")
    private MethodType methodType;

    private boolean isAvailable;

    private StatusType statusType;

    public String getType() {
        return type.toString();
    }

    public String getMethodType() {
        return methodType.toString();
    }
}
