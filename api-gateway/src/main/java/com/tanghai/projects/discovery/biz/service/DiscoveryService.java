package com.tanghai.projects.discovery.biz.service;

import com.tanghai.projects.common.handler.BaseException;
import com.tanghai.projects.common.handler.custom.CustomException;
import com.tanghai.projects.common.util.AbstractCrudServices;
import com.tanghai.projects.discovery.biz.dto.DiscoveryDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface DiscoveryService extends AbstractCrudServices<DiscoveryDTO> {

    void register(HttpServletRequest httpServletRequest, DiscoveryDTO discoveryDTO) throws BaseException, CustomException;
}
