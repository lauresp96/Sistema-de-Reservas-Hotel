package org.mihailivadaru.sistemadegestionhotel.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double total;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Habitacion habitacion;



}
