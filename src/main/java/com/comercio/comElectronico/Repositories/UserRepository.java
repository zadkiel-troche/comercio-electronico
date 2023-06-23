package com.comercio.comElectronico.Repositories;

import com.comercio.comElectronico.Models.UserModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByNombre(String nombre);
    
}
