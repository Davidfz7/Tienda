
package com.tienda.tienda.service;

import com.tienda.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activo);
    
}
