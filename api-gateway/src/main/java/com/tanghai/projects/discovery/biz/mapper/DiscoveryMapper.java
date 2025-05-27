package com.tanghai.projects.discovery.biz.mapper;

import com.tanghai.projects.discovery.biz.dto.DiscoveryDTO;
import com.tanghai.projects.discovery.biz.entity.DiscoveryEntity;
import com.tanghai.projects.discovery.web.vo.request.DiscoveryCreateRequestVO;
import com.tanghai.projects.discovery.web.vo.response.DiscoveryResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiscoveryMapper {

    DiscoveryMapper MAP = Mappers.getMapper(DiscoveryMapper.class);

    DiscoveryDTO transform(DiscoveryCreateRequestVO createRequestVO);

    DiscoveryResponseVO discoveryResponse(DiscoveryDTO discoveryDTO);

}
