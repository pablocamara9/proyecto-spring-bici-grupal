package com.salesianostriana.bicis.util;

import com.salesianostriana.bicis.model.Bicicleta;

// DTO de Bicicleta
public record EditBicicletaDto(String marca, String estado, String modelo) {

    public static EditBicicletaDto of(Bicicleta bicicleta) {
        return new EditBicicletaDto(
                bicicleta.getMarca(),
                bicicleta.getEstado(),
                bicicleta.getModelo()
        );
    }
}



