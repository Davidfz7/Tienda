package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao
        extends JpaRepository<Categoria, Long> {
        
        
}
