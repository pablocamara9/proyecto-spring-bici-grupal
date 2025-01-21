package com.salesianostriana.bicis.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Estacion {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "estacion",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Bicicleta> listaBicicletas = new ArrayList<>();

    public void addBici(Bicicleta b) {
        b.setEstacion(this);
        this.listaBicicletas.add(b);
    }

    public void deleteBici(Bicicleta b) {
        this.listaBicicletas.remove(b);
    }
}
