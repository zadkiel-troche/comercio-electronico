package com.comercio.comElectronico.Controllers;

import com.comercio.comElectronico.Models.Marcas;
import com.comercio.comElectronico.Models.Producto;
import com.comercio.comElectronico.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductoController {
    
    @Autowired
    private ProductoRepository productos_repo;
    
    @PostMapping("/new")
    public String guardar(Producto producto){
        productos_repo.save(producto);
        
        return "redirect:/?new-product-created";
    }
    
    @GetMapping("/delete/{id}")
    public String borrar(Producto producto){
        productos_repo.delete(producto);
        return "redirect:/?product-delete-success";
    }
}
