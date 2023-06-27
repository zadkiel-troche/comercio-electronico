package com.comercio.comElectronico.security;

import com.comercio.comElectronico.Models.Rol;
import com.comercio.comElectronico.Models.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class SecurityUser implements UserDetails {
    
    private final Usuario user;
    
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
        //return null; //user.getAuthorities().stream().map(SecurityAuthority::new).toList();
        Collection<Rol> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Rol role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        }
         
        return authorities;
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
