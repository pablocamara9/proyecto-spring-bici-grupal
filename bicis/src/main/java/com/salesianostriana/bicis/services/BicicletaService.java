package com.salesianostriana.bicis.services;

import com.salesianostriana.bicis.model.Bicicleta;
import com.salesianostriana.bicis.repositories.BicicletaRepository;
import com.salesianostriana.bicis.util.EditBicicletaDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;


    public List<Bicicleta> findAllBicicleta(){
        List<Bicicleta> bicicletas = bicicletaRepository.findAll();
        //Devuelve un Optional(O bien la lista de bibicletas o un error)
        return Optional.ofNullable(bicicletas)
                .orElseThrow(() -> new EntityNotFoundException("No hay bicicletas azin"));
    }

    public Bicicleta findBicicleta(Long id){
        return bicicletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ id));
    }

    public Bicicleta save(EditBicicletaDto nuevo){
    return bicicletaRepository.save(Bicicleta.builder()
            .marca(nuevo.marca())
            .modelo(nuevo.modelo())
            .estado(nuevo.estado())
            .build());
    }

    public Bicicleta edit(EditBicicletaDto editBicicletaDto, Long id) {
        return bicicletaRepository.findById(id)
                .map(old -> {
                    old.setMarca(editBicicletaDto.marca());
                    old.setEstado(editBicicletaDto.estado());
                    old.setModelo(editBicicletaDto.modelo());
                    return bicicletaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay bibicletas con ID: "+ id));

    }

    public void delete(Long id){
        bicicletaRepository.deleteById(id);
    }
}
