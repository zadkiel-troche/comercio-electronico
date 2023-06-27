package com.comercio.comElectronico.Controllers;

import com.comercio.comElectronico.Models.Usuario;
import com.comercio.comElectronico.Repositories.EmpresaRepository;
import com.comercio.comElectronico.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsuarioController {
    
    @Autowired
    private UserRepository user_repo;
            
    @Autowired
    private EmpresaRepository empresa_repo;
    
    @PostMapping("/new")
    public String guardar(Usuario usuario){
        user_repo.save(usuario);
        
        return "redirect:/?new-user-created";
    }
    
    @GetMapping("/edit/{id_usuario}")
    public String edit(Usuario usuario, Model modelo){
        var eid = usuario.getId_usuario();
        usuario = user_repo.findById(eid).orElse(null);
        modelo.addAttribute("usuario", usuario);
        
        var lista_empre = empresa_repo.findAll();
        modelo.addAttribute("lista_empresas", lista_empre);
        return "form-edit-user";
    }
    
    @GetMapping("/delete/{id_usuario}")
    public String borrar(Usuario usuario){
        user_repo.delete(usuario);
        
        return "redirect:/?user-delete-success";
    }
}
