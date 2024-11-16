package org.mihailivadaru.sistemadegestionhotel.repositorios;

import org.mihailivadaru.sistemadegestionhotel.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoRol extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNombre(String nombre);
}

