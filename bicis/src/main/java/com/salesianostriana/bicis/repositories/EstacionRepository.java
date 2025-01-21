package com.salesianostriana.bicis.repositories;

import com.salesianostriana.bicis.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {
}
