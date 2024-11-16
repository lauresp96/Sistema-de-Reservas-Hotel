package org.mihailivadaru.sistemadegestionhotel.APIs;

import org.mihailivadaru.sistemadegestionhotel.entidades.Reserva;
import org.mihailivadaru.sistemadegestionhotel.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaAPI {

    @Autowired
    private ReservaService reservaService;


    // Ver todas las reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerReservas() {
        List<Reserva> reservas = reservaService.obtenerTodasReservas();
        return ResponseEntity.ok(reservas);
    }

    // Ver reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.buscarReservaPorId(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar reserva por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable Long id) {
        boolean eliminada = reservaService.eliminarReserva(id);
        if (eliminada) {
            return ResponseEntity.ok("Reserva eliminada con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearReserva(@RequestBody Reserva reserva) {
        boolean disponible = reservaService.verificarDisponibilidad(
                reserva.getHabitacion().getId(), reserva.getFechaInicio(), reserva.getFechaFin()
        );
        if (!disponible) {
            return ResponseEntity.badRequest().body("Reserva no encontrada");
        }
        reservaService.crearReserva(reserva);
        return ResponseEntity.ok().body("Reserva ha sido creada");
    }
}
