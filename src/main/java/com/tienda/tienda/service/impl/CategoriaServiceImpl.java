package com.tienda.tienda.service.impl;

import com.tienda.tienda.dao.CategoriaDao;
import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaServiceImpl 
        implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activo) {
        var categorias = categoriaDao.findAll();
        
        //Si son solo activas (activo = true) debo filtrar las incativas...
        if(activo){
            categorias.removeIf(e -> !e.isActivo());
        
        }
        
        return categorias;
    }

    @Override
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria) {
       return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
         categoriaDao.save(categoria);
        
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
