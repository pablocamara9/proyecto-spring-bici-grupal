package com.salesianostriana.bicis.repositories;

import com.salesianostriana.bicis.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
//Repositorio de bicicleta
public interface BicicletaRepository
        extends JpaRepository<Bicicleta, Long> {
}
