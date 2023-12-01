
package com.tienda.tienda.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UsuarioDetailService {
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;
    
}
