package com.tienda.tienda.service.impl;

import com.tienda.tienda.dao.ProductoDao;
import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServiceImpl1 
        implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activo) {
        var productos = productoDao.findAll();
        
        //Si son solo activas (activo = true) debo filtrar las incativas...
        if(activo){
            productos.removeIf(e -> !e.isActivo());
        
        }
        
        return productos;
    }

    @Override
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto) {
       return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    @Transactional
    @Override
    public void save(Producto producto) {
         productoDao.save(producto);
        
    }
    @Transactional
    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
      //Metodo para obtener un listado de productos  filtrado por precio
    //ordenado por precio, ordenado por descripcion
    
    @Transactional(readOnly=true)
    @Override
    public List<Producto> consultaQuery(double precioInf,
                                       double precioSup){
    return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Producto> consultaJPQL(double precioInf,
                                       double precioSup){
    return productoDao.consultaJPQL(precioInf, precioSup);
    }
    
        
    @Transactional(readOnly=true)
    @Override
    public List<Producto> consultaSQL(double precioInf,
                                       double precioSup){
    return productoDao.consultaSQL(precioInf, precioSup);
    }
}
