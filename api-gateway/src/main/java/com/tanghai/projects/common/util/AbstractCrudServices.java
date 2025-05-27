package com.tanghai.projects.common.util;


import com.tanghai.projects.common.handler.BaseException;
import com.tanghai.projects.common.handler.custom.CustomException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.SystemException;

public interface AbstractCrudServices<T> {

    void register(HttpServletRequest httpServlet, T t) throws SystemException, BaseException, CustomException;

    void create(T t) throws SystemException;

    void update(T t, String id) throws SystemException;

    void delete(String id) throws SystemException;

    T findOne(String id) throws SystemException;

}
