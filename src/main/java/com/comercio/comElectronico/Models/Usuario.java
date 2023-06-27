package com.comercio.comElectronico.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Collection;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "nombre")
    private String nombre;

    private String email;
    private String pass;
    private int id_empresa;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (
            name = "usuarios_roles",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id_usuario"
            ),
            inverseJoinColumns = @JoinColumn (
                    name = "rol_id", referencedColumnName = "id_rol"
            )
    )
    private Collection<Rol> roles;

    public Usuario(Long id_usuario, String nombre, String email, String pass, int id_empresa, Collection<Rol> roles) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.id_empresa = id_empresa;
        this.roles = roles;
    }

    public Usuario(String nombre, String email, String pass, int id_empresa, Collection<Rol> roles) {
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.id_empresa = id_empresa;
        this.roles = roles;
    }

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public Object getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
