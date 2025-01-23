package com.salesianostriana.bicis.repositories;

import com.salesianostriana.bicis.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Repositorio de bicicleta
public interface BicicletaRepository
        extends JpaRepository<Bicicleta, Long> {

    List<Bicicleta> getAllByModelo(String modelo);

    List<Bicicleta> getAllByMarcaAndEstado(String marca, String estado);
}
