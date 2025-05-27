package com.tanghai.projects.discovery.biz.service.impl;

import com.tanghai.projects.common.handler.custom.CustomException;
import com.tanghai.projects.common.type.ApplicationHandlerCode;
import com.tanghai.projects.common.type.StatusType;
import com.tanghai.projects.discovery.biz.dto.DiscoveryDTO;
import com.tanghai.projects.discovery.biz.repository.DiscoveryMapperDAO;
import com.tanghai.projects.discovery.biz.service.DiscoveryService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.SystemException;
import java.util.Date;

@Service
@Slf4j
@Getter
public class DiscoveryServiceImpl implements DiscoveryService {

    @Autowired
    private DiscoveryMapperDAO discoveryRepository;



    @Override
    public void register(HttpServletRequest httpServletRequest, DiscoveryDTO discoveryDTO) throws CustomException {

        if(discoveryRepository.findEntityByUrl(discoveryDTO.getUrl()) != null)
            throw new CustomException(
                    ApplicationHandlerCode.ENTITY_IS_EXIST.getCode(),
                    ApplicationHandlerCode.ENTITY_IS_EXIST.getMessage());

        discoveryDTO.setStatusType(StatusType.ACTIVE);
        discoveryDTO.setAvailable(false);
        discoveryDTO.setCreatedAt(new Date());

        discoveryRepository.save(discoveryDTO);
    }

    @Override
    public void create(DiscoveryDTO discoveryDTO) throws SystemException {

    }

    @Override
    public void update(DiscoveryDTO discoveryDTO, String id) throws SystemException {

    }

    @Override
    public void delete(String id) throws SystemException {

    }

    @Override
    public DiscoveryDTO findOne(String id) throws SystemException {
        return null;
    }
}
