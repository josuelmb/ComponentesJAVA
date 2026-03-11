package pe.edu.idat.proyecto.gestion.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto.gestion.dto.ClienteDto;
import pe.edu.idat.proyecto.gestion.model.Cliente;
import pe.edu.idat.proyecto.gestion.service.ClienteService;

import java.util.List;

@RequestMapping("/v1/clientes") // Define la ruta base del endpoint
@RestController // Define un controlador REST
@RequiredArgsConstructor // Genera el constructor automáticamente para la inyección
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
     @Operation(summary = "Crear Cliente", description = "Permite crear clientes desde un entorno externo")

    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = clienteService.create(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    } //Valid activa validaciones del Dto


    @GetMapping
    @Operation(summary = "Listar Cliente", description = "Permite visualizar clientes desde un entorno externo")

    public ResponseEntity<List<Cliente>> list(){
        return ResponseEntity.ok(clienteService.list());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por idCliente", description = "Permite buscar clientes por id desde un entorno externo")

    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping("/dni/{dni}")
    @Operation(summary = "Buscar por dniCLiente", description = "Permite buscar clientes por dni desde un entorno externo")

    public Cliente findByDni(@PathVariable String dni) {
        return clienteService.findByDni(dni);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar por idCliente", description = "Permite actualizar clientes por id desde un entorno externo")
    public ResponseEntity<Cliente> update(@PathVariable Integer id,
                                          @Valid @RequestBody ClienteDto clienteDto){
//Path captura valor URL y pasa como parametro al metodo controller
        Cliente cliente = clienteService.update(id, clienteDto);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar por idCliente", description = "Permite eliminar clientes por id desde un entorno externo")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

