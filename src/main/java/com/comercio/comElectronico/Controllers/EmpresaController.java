package com.comercio.comElectronico.Controllers;

import com.comercio.comElectronico.Models.Empresa;
import com.comercio.comElectronico.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bussines")
public class EmpresaController {
    
    @Autowired
    private EmpresaRepository empresa_repo;
    
    @PostMapping("/new")
    public String guardar(Empresa empresa){
        empresa_repo.save(empresa);
        
        return "redirect:/?new-bussines-created";
    }
    
    @GetMapping("/delete/{id}")
    public String borrar(Empresa empresa){
        empresa_repo.delete(empresa);
        return "redirect:/?bussines-delete-success";
    }
}
