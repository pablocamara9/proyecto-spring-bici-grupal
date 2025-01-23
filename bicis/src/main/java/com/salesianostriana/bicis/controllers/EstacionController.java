package com.salesianostriana.bicis.controllers;


import com.salesianostriana.bicis.model.Estacion;
import com.salesianostriana.bicis.util.EditEstacionDto;
import com.salesianostriana.bicis.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/estaciones/")
@RequiredArgsConstructor
public class EstacionController {


    private final EstacionService estacionService;


    @GetMapping
    public List<Estacion> getAll() {
        return estacionService.findAll();
    }


    @GetMapping("/{id}")
    public Estacion getById(@PathVariable Long id) {
        return estacionService.findById(id);
    }


    @PostMapping
    public ResponseEntity<Estacion> create(@RequestBody EditEstacionDto nueva) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estacionService.save(nueva));
    }


    @PutMapping("/{id}")
    public Estacion edit(@RequestBody EditEstacionDto editDto,
                         @PathVariable Long id) {
        return estacionService.update(id, editDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
