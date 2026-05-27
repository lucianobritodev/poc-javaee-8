package com.lucianobrito.pocjavaee8.domain.repositories;

import com.lucianobrito.pocjavaee8.domain.entities.Usuario;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UsuarioRepository extends BaseRepository<Usuario, Long> {
    public UsuarioRepository() {
        super(Usuario.class);
    }
}
