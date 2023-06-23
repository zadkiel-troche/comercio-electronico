package com.comercio.comElectronico.services;

import com.comercio.comElectronico.Repositories.UserRepository;
import com.comercio.comElectronico.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsServices implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    public SecurityUserDetailsServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        var optUser = this.userRepository.findByNombre(nombre);
        
        if(optUser.isPresent()){
            return new SecurityUser(optUser.get());
        }
        
        throw new UsernameNotFoundException("Username not found: " + nombre);
    }
    
}
