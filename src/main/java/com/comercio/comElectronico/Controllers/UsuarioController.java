package com.comercio.comElectronico.Controllers;

import com.comercio.comElectronico.Models.Usuario;
import com.comercio.comElectronico.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsuarioController {
    
    @Autowired
    private UserRepository user_repo;
    
    @PostMapping("/new")
    public String guardar(Usuario usuario){
        user_repo.save(usuario);
        
        return "redirect:/?new-user-created";
    }
}
