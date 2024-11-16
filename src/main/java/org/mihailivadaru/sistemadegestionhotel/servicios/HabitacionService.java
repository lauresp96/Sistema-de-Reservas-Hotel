package org.mihailivadaru.sistemadegestionhotel.servicios;


import org.mihailivadaru.sistemadegestionhotel.entidades.Habitacion;
import org.mihailivadaru.sistemadegestionhotel.repositorios.RepoHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private RepoHabitacion repoHabitacion;

    public List<Habitacion> obtenerHabitacionesDisponibles() {
        return repoHabitacion.findByDisponibleTrue();
    }

    public void guardarHabitacion(Habitacion habitacion) {
        repoHabitacion.save(habitacion);
    }

    public List<Habitacion> obtenerTodasHabitaciones() {
        return repoHabitacion.findAll();
    }

    public Optional<Habitacion> buscarHabitacionPorId(Long id) {
        return repoHabitacion.findById(id);
    }

    public boolean eliminarHabitacion(Long id) {
        if (repoHabitacion.existsById(id)) {
            repoHabitacion.deleteById(id);
            return true;
        }
        return false;
    }

}
