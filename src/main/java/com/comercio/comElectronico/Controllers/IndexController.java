package com.comercio.comElectronico.Controllers;

import com.comercio.comElectronico.Models.Empresa;
import com.comercio.comElectronico.Models.Marcas;
import com.comercio.comElectronico.Models.Producto;
import com.comercio.comElectronico.Models.Usuario;
import com.comercio.comElectronico.Repositories.EmpresaRepository;
import com.comercio.comElectronico.Repositories.MarcasRepository;
import com.comercio.comElectronico.Repositories.ProductoRepository;
import com.comercio.comElectronico.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    private EmpresaRepository empresa_repo;
    
    @Autowired
    private UserRepository usuario_repo;
    
    @Autowired
    private MarcasRepository marcas_repo;
    
    @Autowired
    private ProductoRepository productos_repo;
    
    
    @GetMapping("/")
    public String index(Usuario usuario, Empresa empresa, Marcas marca, Producto producto, Model modelo){
        
        var lista_empre = empresa_repo.findAll();
        modelo.addAttribute("lista_empresas", lista_empre);
        
        var lista_usuarios = usuario_repo.findAll();
        modelo.addAttribute("lista_usuarios", lista_usuarios);
        
        var lista_marcas = marcas_repo.findAll();
        modelo.addAttribute("lista_marcas", lista_marcas);
        
        var lista_productos = productos_repo.findAll();
        modelo.addAttribute("lista_productos", lista_productos);
        
        return "index";
    
    }
}
