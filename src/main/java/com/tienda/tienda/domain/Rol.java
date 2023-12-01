package com.tienda.tienda.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable {
    
    private static final long serialVersionUTD= 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private Long idRol;
    private String nombre;
    
    @Column(name="id_usuario")
    private String idUsuario;
    
    
    
}
