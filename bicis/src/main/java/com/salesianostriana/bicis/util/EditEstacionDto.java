package com.salesianostriana.bicis.util;

public record EditEstacionDto(
        String nombre,
        int numero,
        String coordenadas,
        int capacidad
) {
}
