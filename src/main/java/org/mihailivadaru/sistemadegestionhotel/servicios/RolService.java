package org.mihailivadaru.sistemadegestionhotel.servicios;

import org.mihailivadaru.sistemadegestionhotel.entidades.Rol;
import org.mihailivadaru.sistemadegestionhotel.repositorios.RepoRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private RepoRol repoRol;

    public Rol findById(Long id) {
        return repoRol.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el rol"));
    }
}
