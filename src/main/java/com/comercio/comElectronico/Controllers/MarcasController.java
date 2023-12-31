package com.comercio.comElectronico.Controllers;

import com.comercio.comElectronico.Models.Marcas;
import com.comercio.comElectronico.Repositories.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class MarcasController {
    
    @Autowired
    private MarcasRepository marcas_repo;
    
    @PostMapping("/new")
    public String guardar(Marcas marcas){
        marcas_repo.save(marcas);
        
        return "redirect:/?new-brand-created";
    }
    
    @GetMapping("/edit/{id_marca}")
    public String edit(Marcas marca, Model modelo){
        var eid = marca.getId_marca();
        marca = marcas_repo.findById(eid).orElse(null);
        modelo.addAttribute("marcas", marca);
        
        return "form-edit-marca";
    }
    
    @GetMapping("/delete/{id_marca}")
    public String borrar(Marcas marcas){
        marcas_repo.delete(marcas);
        return "redirect:/?brand-delete-success";
    }
}
