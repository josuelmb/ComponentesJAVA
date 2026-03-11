package pe.edu.idat.proyecto.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto.gestion.dto.SolicitudDto;
import pe.edu.idat.proyecto.gestion.model.Solicitud;
import pe.edu.idat.proyecto.gestion.service.SolicitudService;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;


    // Crear solicitud
    @PostMapping
    public Solicitud create(@RequestBody SolicitudDto dto){
        return solicitudService.create(dto);
    }


    // Listar solicitudes
    @GetMapping
    public List<Solicitud> list(){
        return solicitudService.list();
    }


    // Buscar solicitud por id
    @GetMapping("/{id}")
    public Solicitud findById(@PathVariable Integer id){
        return solicitudService.findById(id);
    }


    // Actualizar solicitud
    @PutMapping("/{id}")
    public Solicitud update(@PathVariable Integer id,
                            @RequestBody SolicitudDto dto){
        return solicitudService.update(id, dto);
    }


    // Eliminar solicitud
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        solicitudService.delete(id);
    }

}