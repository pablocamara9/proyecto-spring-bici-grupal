package com.salesianostriana.bicis.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Uso {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private double coste;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
