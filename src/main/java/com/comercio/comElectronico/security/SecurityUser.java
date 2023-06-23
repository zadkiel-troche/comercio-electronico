package com.comercio.comElectronico.security;

import com.comercio.comElectronico.Models.UserModel;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class SecurityUser implements UserDetails {
    
    private final UserModel user;
    
    @Override
    public String getUsername() {
        return user.getNombre();
    }
    
    @Override
    public String getPassword() {
        return user.getPass();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; //user.getAuthorities().stream().map(SecurityAuthority::new).toList();
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
    
}
