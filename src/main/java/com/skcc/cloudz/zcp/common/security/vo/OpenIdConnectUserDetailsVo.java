package com.skcc.cloudz.zcp.common.security.vo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.skcc.cloudz.zcp.api.iam.domain.vo.ZcpUserVo;
import com.skcc.cloudz.zcp.common.domain.vo.CommonVo;

public class OpenIdConnectUserDetailsVo extends CommonVo implements UserDetails {
    private static final long serialVersionUID = -899359145312156965L;
    
    private String userId;
    private String username;
    private String email;
    private String firstName;
    private String clusterRole;
    private List<String> namespaces;
    private String defaultNamespace;
    private int usedNamespace;
    private OAuth2AccessToken token;
    
    public OpenIdConnectUserDetailsVo() {}

    public OpenIdConnectUserDetailsVo(Map<String, String> userInfo, OAuth2AccessToken token, ZcpUserVo zcpUserVo) {
        this.userId = userInfo.get("sub");
        this.email = userInfo.get("email");
        this.token = token;
        
        if (zcpUserVo != null) {
            this.username = zcpUserVo.getUsername();
            this.firstName = zcpUserVo.getFirstName();
            this.namespaces = zcpUserVo.getNamespaces();
            this.defaultNamespace = zcpUserVo.getDefaultNamespace();
            this.usedNamespace = zcpUserVo.getUsedNamespace();
            this.clusterRole = !StringUtils.isEmpty(zcpUserVo.getClusterRole()) ? zcpUserVo.getClusterRole() : "";
        }
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClusterRole() {
        return clusterRole;
    }

    public void setClusterRole(String clusterRole) {
        this.clusterRole = clusterRole;
    }

    public List<String> getNamespaces() {
        return namespaces;
    }

    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    public String getDefaultNamespace() {
        return defaultNamespace;
    }

    public void setDefaultNamespace(String defaultNamespace) {
        this.defaultNamespace = defaultNamespace;
    }

    public int getUsedNamespace() {
        return usedNamespace;
    }

    public void setUsedNamespace(int usedNamespace) {
        this.usedNamespace = usedNamespace;
    }

    public OAuth2AccessToken getToken() {
        return token;
    }

    public void setToken(OAuth2AccessToken token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
