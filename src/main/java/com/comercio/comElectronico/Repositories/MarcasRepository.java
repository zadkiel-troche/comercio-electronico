package com.comercio.comElectronico.Repositories;
import com.comercio.comElectronico.Models.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long> {
    
}
