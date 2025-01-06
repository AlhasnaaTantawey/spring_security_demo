package com.global.security;

import com.global.entity.AppUser;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetail implements UserDetails {

    private Long id;
    private String userName;
    private String password;
    private String fullName;
     private List<GrantedAuthority> authorities ;

    public AppUserDetail() {
    }
    public AppUserDetail(AppUser user) {
        this.id=user.getId();
        this.userName=user.getUserName();
        this.password=user.getPassword();
        this.fullName=user.getFullName();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (!user.getRolesSet().isEmpty()) {
            user.getRolesSet().forEach(roles ->
                    authorities.add(new SimpleGrantedAuthority( roles.getName()))
            );
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
