package com.comercio.comElectronico.Repositories;

import com.comercio.comElectronico.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositorie extends JpaRepository<UserModel, Long> {
    
}
