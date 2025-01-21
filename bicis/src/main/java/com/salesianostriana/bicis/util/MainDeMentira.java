package com.salesianostriana.bicis.util;

import com.salesianostriana.bicis.model.Uso;
import com.salesianostriana.bicis.model.Usuario;
import com.salesianostriana.bicis.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final UsuarioRepository usuarioRepository;

    @PostConstruct
    public void run(){
        Usuario usuario = Usuario.builder()
                .nombre("Carlos")
                .pin("1234A")
                .saldo(150.00)
                .numTarjeta(123)
                .build();

        Usuario usuario1 = Usuario.builder()
                .nombre("Pepe")
                .pin("1234A")
                .saldo(150.00)
                .numTarjeta(123)
                .build();


        Uso uso = Uso.builder()
                .fechaInicio(LocalDateTime.of(2025, 1, 21, 19, 47))
                .fechaFin(LocalDateTime.of(2025, 1, 21, 20, 47))
                .coste(5.50)
                .build();

        Uso uso1 = Uso.builder()
                .fechaInicio(LocalDateTime.of(2025, 2, 21, 19, 47))
                .fechaFin(LocalDateTime.of(2025, 2, 21, 20, 47))
                .coste(3.50)
                .build();

        Uso uso2 = Uso.builder()
                .fechaInicio(LocalDateTime.of(2026, 1, 21, 19, 47))
                .fechaFin(LocalDateTime.of(2025, 1, 21, 20, 47))
                .coste(5.50)
                .build();

        usuario.addUso(uso);
        usuario.addUso(uso1);
        usuario1.addUso(uso2);

        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario1);

        System.out.println(usuario);
        System.out.println(usuario.getListaUsos());
        System.out.println(usuario1);
        System.out.println(usuario1.getListaUsos());

    }
}
