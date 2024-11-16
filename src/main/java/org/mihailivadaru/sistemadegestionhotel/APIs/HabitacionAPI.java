package org.mihailivadaru.sistemadegestionhotel.APIs;

import org.mihailivadaru.sistemadegestionhotel.entidades.Habitacion;
import org.mihailivadaru.sistemadegestionhotel.servicios.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionAPI {

    @Autowired
    private HabitacionService habitacionService;

    // Ver todas las habitaciones
    @GetMapping
    public ResponseEntity<List<Habitacion>> obtenerHabitaciones() {
        List<Habitacion> habitaciones = habitacionService.obtenerTodasHabitaciones();
        return ResponseEntity.ok(habitaciones);
    }

    // Ver habitación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacionPorId(@PathVariable Long id) {
        Optional<Habitacion> habitacion = habitacionService.buscarHabitacionPorId(id);
        return habitacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/disponibles")
    public List<Habitacion> obtenerHabitacionesDisponibles() {
        return habitacionService.obtenerHabitacionesDisponibles();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarHabitacion(@RequestBody Habitacion habitacion) {
        habitacionService.guardarHabitacion(habitacion);
        return ResponseEntity.ok("Habitacion guardada con exito");
    }

    // Eliminar habitación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHabitacion(@PathVariable Long id) {
        boolean eliminado = habitacionService.eliminarHabitacion(id);
        if (eliminado) {
            return ResponseEntity.ok("Habitación eliminada con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
