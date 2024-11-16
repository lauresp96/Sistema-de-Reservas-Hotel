package org.mihailivadaru.sistemadegestionhotel.repositorios;

import org.mihailivadaru.sistemadegestionhotel.entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoHabitacion extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByDisponibleTrue();

}
