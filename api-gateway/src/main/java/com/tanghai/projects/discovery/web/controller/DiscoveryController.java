package com.tanghai.projects.discovery.web.controller;

import com.tanghai.projects.common.constant.ResponseCode;
import com.tanghai.projects.common.core.ReponseBody;
import com.tanghai.projects.common.core.ResponseData;
import com.tanghai.projects.common.handler.BaseException;
import com.tanghai.projects.discovery.biz.dto.DiscoveryDTO;
import com.tanghai.projects.discovery.biz.mapper.DiscoveryMapper;
import com.tanghai.projects.discovery.biz.service.DiscoveryService;
import com.tanghai.projects.discovery.web.vo.request.DiscoveryCreateRequestVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Tag(name = "[Discovery Service]")
@RestController
@RequestMapping("api/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryService discoveryService;

    @PostMapping("/register")
    public ResponseData register(@RequestBody @Valid DiscoveryCreateRequestVO discoveryCreateRequestVO,
                                                      HttpServletRequest httpServletRequest) throws BaseException {
        DiscoveryDTO discoveryDTO = DiscoveryMapper.MAP.transform(discoveryCreateRequestVO);
        discoveryService.register(httpServletRequest, discoveryDTO);
        return new ReponseBody()
                .withData(DiscoveryMapper.MAP.discoveryResponse(discoveryDTO))
                .withMessage(ResponseCode.SUCCESS)
                .withStatus(HttpStatus.OK.value())
                .build();
    }
}
