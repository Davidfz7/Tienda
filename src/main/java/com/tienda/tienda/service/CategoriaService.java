
package com.tienda.tienda.service;

import com.tienda.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    //Se obtiene un array list con todas las categorias de la tabla
    public List<Categoria> getCategorias(boolean activo);
    
    
    //Se obtiene una categoria segun el Id pasado por parametro
    public Categoria getCategoria(Categoria categoria);
    
    
    //Se actualiza una categoria o se inserta una nueva .. (Si no hay id es un insert);
    
    public void save(Categoria categoria);
    
    //Se elimina una categoria segun el id pasado;
    
    public void delete(Categoria categoria);
    
}
