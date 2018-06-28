package com.skcc.cloudz.zcp.configuration.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.skcc.cloudz.zcp.api.iam.domain.vo.ZcpUserVo;
import com.skcc.cloudz.zcp.common.security.service.SecurityService;
import com.skcc.cloudz.zcp.portal.management.user.service.UserService;

public class UserNamespaceInterceptor extends HandlerInterceptorAdapter {
    
    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserService userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || !modelAndView.hasView()) {
            return;
        }
        
        String id = securityService.getUserDetails().getUserId();
        
        ZcpUserVo zcpUserVo = userService.getUser(id);
        
        modelAndView.addObject("userNamespaces", zcpUserVo.getNamespaces());
        modelAndView.addObject("userDefaultNamespace", zcpUserVo.getDefaultNamespace());
    }

}
