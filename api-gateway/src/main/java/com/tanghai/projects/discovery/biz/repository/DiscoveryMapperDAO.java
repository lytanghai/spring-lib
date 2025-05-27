package com.tanghai.projects.discovery.biz.repository;

import com.tanghai.projects.discovery.biz.dto.DiscoveryDTO;
import com.tanghai.projects.discovery.biz.entity.DiscoveryEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
//@Repository
public interface DiscoveryMapperDAO {

    @Insert("INSERT INTO public.url_discovery(url, service_name, type, request_header, request_payload, method, is_available, status, created_at)\n" +
            "\tVALUES (#{url}, #{serviceName}, #{type}, #{requestHeader}, #{requestPayload}, #{methodType}, #{isAvailable}, #{statusType}, #{createdAt});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(DiscoveryDTO discoveryDTO);

    @Select("SELECT * FROM public.url_discovery WHERE url = #{url} LIMIT 1")
    @Results({
            @Result(property = "type" , column = "type"),
            @Result(property = "methodType" , column = "method_type")
    })
    DiscoveryEntity findEntityByUrl(String url);
}
