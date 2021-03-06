package com.skcc.cloudz.zcp.common.security.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skcc.cloudz.zcp.common.security.vo.JwtIdToken;
import com.skcc.cloudz.zcp.common.security.vo.OpenIdConnectUserDetailsVo;

@Component
public class SecurityService {
    
    public OpenIdConnectUserDetailsVo getUserDetails() {
        OpenIdConnectUserDetailsVo userDetailsVo = (OpenIdConnectUserDetailsVo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        return userDetailsVo;
    }
    
    public OAuth2AccessToken getAccessToken() {
        OpenIdConnectUserDetailsVo userDetailsVo = this.getUserDetails();
        
        return userDetailsVo.getToken();
    }
    
    public JwtIdToken getIdToken() {
        ObjectMapper objectMapper = new ObjectMapper();
        JwtIdToken jwtIdTokenVo = null;
        
        try {
            OAuth2AccessToken accessToken = this.getAccessToken();
            String idToken = accessToken.getAdditionalInformation().get("id_token").toString();
            
            final Jwt tokenDecoded = JwtHelper.decode(idToken);
            
            jwtIdTokenVo = objectMapper.readValue(tokenDecoded.getClaims(), JwtIdToken.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jwtIdTokenVo;
    }
    
    public static String getUserId() {
        OpenIdConnectUserDetailsVo userDetailsVo = (OpenIdConnectUserDetailsVo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetailsVo.getUserId();
    }
    
    public static OpenIdConnectUserDetailsVo getUserDetail() {
        return (OpenIdConnectUserDetailsVo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
