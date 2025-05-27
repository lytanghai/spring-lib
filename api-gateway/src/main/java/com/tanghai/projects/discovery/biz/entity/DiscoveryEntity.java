package com.tanghai.projects.discovery.biz.entity;

import com.tanghai.projects.common.type.MethodType;
import com.tanghai.projects.common.type.StatusType;
import com.tanghai.projects.common.type.Type;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = DiscoveryEntity.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = "url")
})
@Getter
@Setter
public class DiscoveryEntity {
    public static final String TABLE_NAME = "url_discovery";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "url")
    private String url;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column(name = "request_header")
    private String requestHeader;

    @Column(name = "request_payload")
    private String requestPayload;

    @Column(name = "method")
    @Enumerated(EnumType.ORDINAL)
    private MethodType methodType;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "status")
    private StatusType statusType;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "last_updated_at")
    private Date lastUpdatedAt;

}
