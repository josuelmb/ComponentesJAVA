package pe.edu.idat.proyecto.gestion.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto.gestion.dto.TecnicoDto;
import pe.edu.idat.proyecto.gestion.model.Tecnico;
import pe.edu.idat.proyecto.gestion.service.TecnicoService;

import java.util.List;

@RequestMapping("/v1/tecnicos") // Ruta base del endpoint
@RestController // Define un controlador REST
@RequiredArgsConstructor // Genera constructor automáticamente para la inyección
public class TecnicoController {

    private final TecnicoService tecnicoService;

    // Crear técnico
    @PostMapping
    public ResponseEntity<Tecnico> create(@Valid @RequestBody TecnicoDto tecnicoDto){
        Tecnico tecnico = tecnicoService.create(tecnicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnico);
    }

    // Listar todos los técnicos
    @GetMapping
    public ResponseEntity<List<Tecnico>> list(){
        return ResponseEntity.ok(tecnicoService.list());
    }

    // Buscar técnico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
        Tecnico tecnico = tecnicoService.findById(id);
        return ResponseEntity.ok(tecnico);
    }
    //Buscar por Dni
    @GetMapping("/dni/{dni}")
    public Tecnico findByDni(@PathVariable String dni) {
        return tecnicoService.findByDni(dni);
    }

    // Actualizar técnico
    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> update(@PathVariable Integer id,
                                          @Valid @RequestBody TecnicoDto tecnicoDto){
        Tecnico tecnico = tecnicoService.update(id, tecnicoDto);
        return ResponseEntity.ok(tecnico);
    }

    // Eliminar técnico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        tecnicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}