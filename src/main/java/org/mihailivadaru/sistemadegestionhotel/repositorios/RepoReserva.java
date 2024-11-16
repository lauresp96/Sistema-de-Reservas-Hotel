package org.mihailivadaru.sistemadegestionhotel.repositorios;

import org.mihailivadaru.sistemadegestionhotel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepoReserva extends JpaRepository<Reserva, Long> {

    List<Reserva> findByHabitacionIdAndFechaInicioBeforeAndFechaFin(Long habitacionId, LocalDate fechaFin, LocalDate fechaInicio);
}
