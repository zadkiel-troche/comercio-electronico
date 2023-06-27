package com.comercio.comElectronico.Controllers;

import com.comercio.comElectronico.Models.Producto;
import com.comercio.comElectronico.Repositories.MarcasRepository;
import com.comercio.comElectronico.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductoController {
    
    @Autowired
    private ProductoRepository productos_repo;
    
    @Autowired
    private MarcasRepository marcas_repo;
    
    @PostMapping("/new")
    public String guardar(Producto producto){
        productos_repo.save(producto);
        
        return "redirect:/?new-product-created";
    }
    
    @GetMapping("/edit/{id_producto}")
    public String edit(Producto producto, Model modelo){
        var eid = producto.getId_producto();
        producto = productos_repo.findById(eid).orElse(null);
        modelo.addAttribute("producto", producto);
        
        var lista_marcas = marcas_repo.findAll();
        modelo.addAttribute("lista_marcas", lista_marcas);
        
        return "form-edit-prod";
    }
    
    @GetMapping("/delete/{id_producto}")
    public String borrar(Producto producto){
        productos_repo.delete(producto);
        return "redirect:/?product-delete-success";
    }
}
