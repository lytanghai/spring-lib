package com.tanghai.projects.discovery.biz.dto;

import com.tanghai.projects.common.type.MethodType;
import com.tanghai.projects.common.type.StatusType;
import com.tanghai.projects.common.type.Type;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscoveryDTO {
    private String id;
    private String url;
    private String serviceName;

    @Enumerated(EnumType.ORDINAL)
    private Type type;
    private String requestHeader;
    private String requestPayload;

    @Enumerated(EnumType.ORDINAL)
    private MethodType methodType;
    private boolean isAvailable;
    private StatusType statusType;
    private Date createdAt;
    private Date lastUpdatedAt;
}
