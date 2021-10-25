package com.example.test2.servicios;

import com.example.test2.entidades.Producto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductoServicio {

    public List<Producto> obtenerProductos();

    Producto buscarPorId(Long id);

    Producto crearProducto(Producto producto);
}
