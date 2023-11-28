package com.tienda.tienda.service;

import com.tienda.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    //Se obtiene un array list con todas las productos de la tabla
    public List<Producto> getProductos(boolean activo);

    //Se obtiene una producto segun el Id pasado por parametro
    public Producto getProducto(Producto producto);

    //Se actualiza una producto o se inserta una nueva .. (Si no hay id es un insert);
    public void save(Producto producto);

    //Se elimina una producto segun el id pasado;
    public void delete(Producto producto);

    //Metodo para obtener un listado de productos  filtrado por precio
    //ordenado por precio, ordenado por descripcion
    public List<Producto> consultaQuery(double precioInf,
            double precioSup);

    public List<Producto> consultaJPQL(double precioInf,
            double precioSup);

    public List<Producto> consultaSQL(double precioInf,
            double precioSup);

}
