package com.comercio.comElectronico.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    
    public UserModel(String nombre, String email, String pass, int id_empresa, List<Authority> autorities){
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.id_empresa = id_empresa;
        this.authorities = authorities;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String email;
    private String pass;
    private int id_empresa;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_roles", 
            joinColumns = @JoinColumn(name = "usuarios", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles", referencedColumnName = "id")
            )
    private List<Authority> authorities;
}
