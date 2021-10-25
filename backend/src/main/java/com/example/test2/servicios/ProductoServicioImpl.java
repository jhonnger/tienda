package com.example.test2.servicios;

import com.example.test2.entidades.Producto;
import com.example.test2.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto  producto) {
        Date date = new Date();

        producto.setEstado(Boolean.TRUE);
        producto.setFecha(new Timestamp(date.getTime()));
        return productoRepositorio.save(producto);
    }
}
