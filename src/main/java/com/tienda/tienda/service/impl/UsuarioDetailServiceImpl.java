package com.tienda.tienda.service.impl;

import com.tienda.tienda.dao.UsuarioDao;
import com.tienda.tienda.domain.Rol;
import com.tienda.tienda.domain.Usuario;
import com.tienda.tienda.service.UsuarioDetailService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailServiceImpl 
        implements UsuarioDetailService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
       
        //Se busca el usuario en la tabla de usuario de la BD;
        
       Usuario usuario = usuarioDao.findByUsername(username);
       
       //Se valida si el usuario se encontro
       if(usuario == null){
           //No encontro el usuario
           throw new UsernameNotFoundException(username);
       }
       
       session.setAttribute("usuarioImagen", 
                            usuario.getRutaImagen());
       
       var roles = new ArrayList<GrantedAuthority>();
       
       for(Rol rol : usuario.getRoles()){
           roles.add(new SimpleGrantedAuthority(rol.getNombre()));
       }
       return new User(usuario.getUsername(), 
                       usuario.getPassword(), 
                       roles);
    }
        
}
