package com.salesianostriana.bicis.services;


import com.salesianostriana.bicis.util.EditEstacionDto;
import com.salesianostriana.bicis.model.Estacion;
import com.salesianostriana.bicis.repositories.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EstacionService {


    private EstacionRepository estacionRepository;


    public List<Estacion> findAll(){
        List<Estacion> estaciones = estacionRepository.findAll();
        if (estaciones.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado estaciones");
        }
        return estaciones;
    }


    public Optional<Estacion> findById(Long id){
        Optional<Estacion> estacionesOp = estacionRepository.findById(id);
        if (estacionesOp.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado estaciones con ese id");
        }
        return estacionesOp;
    }


    public Estacion save(EditEstacionDto dto) {
        return estacionRepository.save(Estacion.builder()
                .nombre(dto.nombre())
                .numero(dto.numero())
                .coordenadas(dto.coordenadas())
                .capacidad(dto.capacidad())
                .build());
    }


    public Optional<Estacion> update(Long id, EditEstacionDto dto) {
        Optional<Estacion> estacionOptionalUpdate = estacionRepository.findById(id)
                .map(old -> {
                    old.setNombre(dto.nombre());
                    old.setNumero(dto.numero());
                    old.setCapacidad(dto.capacidad());
                    old.setCoordenadas(dto.coordenadas());
                    return estacionRepository.save(old);
                });


        if (estacionOptionalUpdate.isEmpty()){
            throw new EntityNotFoundException("No se ha encontrado esa estacion");
        }


        return estacionOptionalUpdate;
    }


    public void deleteById(Long id) {
        Optional <Estacion> estacionOpId = estacionRepository.findById(id);
        if (estacionOpId.isEmpty()) {
            throw new EntityNotFoundException("No se ha encontrado una estación con el ID proporcionado");
        }
        estacionRepository.deleteById(id);
    }
}
