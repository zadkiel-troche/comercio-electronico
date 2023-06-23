/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comercio.comElectronico.Repositories;
import com.comercio.comElectronico.Models.MarcasModel;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author jeree
 */
public interface MarcasRepositorie extends JpaRepository<MarcasModel, Long> {
    
}
