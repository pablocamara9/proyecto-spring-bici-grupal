package com.salesianostriana.bicis.repositories;

import com.salesianostriana.bicis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
