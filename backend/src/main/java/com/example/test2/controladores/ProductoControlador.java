package com.example.test2.controladores;

import com.example.test2.entidades.Producto;
import com.example.test2.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/producto")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public List<Producto> obtenerProductos(){
        return productoServicio.obtenerProductos();
    }

    @GetMapping(value = "/{id}")
    public Producto obtenerProductos(@PathVariable("id") Long id){
        return productoServicio.buscarPorId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Producto crearProducto(HttpServletRequest request, @RequestBody Producto producto){
        return productoServicio.crearProducto(producto);
    }
}
