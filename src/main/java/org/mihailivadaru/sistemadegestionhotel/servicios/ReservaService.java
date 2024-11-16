package org.mihailivadaru.sistemadegestionhotel.servicios;

import org.mihailivadaru.sistemadegestionhotel.entidades.Reserva;
import org.mihailivadaru.sistemadegestionhotel.repositorios.RepoReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private RepoReserva repoReserva;

    public boolean verificarDisponibilidad(Long habitacionId, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Reserva> reservas = repoReserva.findByHabitacionIdAndFechaInicioBeforeAndFechaFin(habitacionId, fechaInicio, fechaFin);
        return reservas.isEmpty();
    }

    public Reserva crearReserva(Reserva reserva) {
        return repoReserva.save(reserva);
    }

    public List<Reserva> obtenerTodasReservas() {
        return repoReserva.findAll();
    }

    public Optional<Reserva> buscarReservaPorId(Long id) {
        return repoReserva.findById(id);
    }

    public boolean eliminarReserva(Long id) {
        if (repoReserva.existsById(id)) {
            repoReserva.deleteById(id);
            return true;
        }
        return false;
    }
}
