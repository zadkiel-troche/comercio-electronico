package com.comercio.comElectronico.Repositories;

import com.comercio.comElectronico.Models.Authority;
import com.comercio.comElectronico.utils.AuthorityName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiRepository extends JpaRepository<Authority, Long>{
    
    Optional<Authority> findByName(AuthorityName name);
    
}
