package com.salesianostriana.bicis.util;

import com.salesianostriana.bicis.model.Bicicleta;
import com.salesianostriana.bicis.model.Estacion;
import com.salesianostriana.bicis.model.Uso;
import com.salesianostriana.bicis.model.Usuario;
import com.salesianostriana.bicis.repositories.BicicletaRepository;
import com.salesianostriana.bicis.repositories.EstacionRepository;
import com.salesianostriana.bicis.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    //private final UsuarioRepository usuarioRepository;
    private final BicicletaRepository bicicletaRepository;
    //private final EstacionRepository estacionRepositoriy;
    //private final EstacionRepository estacionRepository;

    @PostConstruct
    public void run(){
        bicicletaRepository.getAllByModelo(String modelo);

 /*
        //Usuarios de prueba
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

        //Estaciones de pureba
        Estacion e = Estacion.builder().nombre("Santa Justa").build();

        //Bicicletas de prueba
        Bicicleta bicicleta1 = Bicicleta.builder()
                .marca("Orbea")
                .modelo("MX 40")
                .estado("Disponible")
                .build();

        Bicicleta bicicleta2 = Bicicleta.builder()
                .marca("Trek")
                .modelo("Marlin 7")
                .estado("Disponible")
                .build();

        Bicicleta bicicleta3 = Bicicleta.builder()
                .marca("Giant")
                .modelo("Talon 1")
                .estado("En mantenimiento")
                .build();

        //Usos de prueba
        Uso uso =  Uso.builder()
                .fechaInicio(LocalDateTime.of(2025, 1, 21, 19, 47))
                .fechaFin(LocalDateTime.of(2025, 1, 21, 20, 47))
                .coste(5.50)
                .build();

        Uso uso2 = Uso.builder()
                .fechaInicio(LocalDateTime.of(2025, 2, 21, 19, 47))
                .fechaFin(LocalDateTime.of(2025, 2, 21, 20, 47))
                .coste(3.50)
                .build();

        Uso uso3 = Uso.builder()
                .fechaInicio(LocalDateTime.of(2026, 1, 21, 19, 47))
                .fechaFin(LocalDateTime.of(2026, 1, 21, 20, 47))
                .coste(7.00)
                .build();



        usuario.addUso(uso);
        usuario.addUso(uso3);
        usuario1.addUso(uso2);

        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario1);

        estacionRepository.save(e);

        e.addBici(bicicleta1);
        e.addBici(bicicleta2);
        e.addBici(bicicleta3);

        bicicletaRepository.save(bicicleta1);
        bicicletaRepository.save(bicicleta2);
        bicicletaRepository.save(bicicleta3);
        bicicleta1.addUso(uso);
        bicicleta2.addUso(uso2);
        bicicleta1.addUso(uso3);




        System.out.println(usuario);
        System.out.println(usuario.getListaUsos());
        System.out.println(usuario1);
        System.out.println(usuario1.getListaUsos());

        System.out.println(bicicleta1);
        System.out.println(bicicleta1.getListaUsos());
        System.out.println(bicicleta2);
        System.out.println(bicicleta2.getListaUsos());

*/
    }
}
