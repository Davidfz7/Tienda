package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductoDao
        extends JpaRepository<Producto, Long> {
    //Metodo para obtener un listado de productos  filtrado por precio
    //ordenado por precio, ordenado por descripcion
        
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf,
                                                                double precioSup);
    
    @Query(value="Select a from Producto a where a.precio between :precioInf and :precioSup order by a.descripcion asc")
    public List<Producto> consultaJPQL(double precioInf,
                                       double precioSup);

    
    @Query(nativeQuery=true, value="Select * from Producto a where a.precio between :precioInf and :precioSup order by a.descripcion asc")
    public List<Producto> consultaSQL(double precioInf,
                                       double precioSup);
}
