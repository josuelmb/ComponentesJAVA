package pe.edu.idat.proyecto.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto.gestion.Repository.TecnicoRepository;
import pe.edu.idat.proyecto.gestion.dto.TecnicoDto;
import pe.edu.idat.proyecto.gestion.model.Tecnico;

import java.util.List;

@Service
public class TecnicoService {

    // Inyección de dependencias
    @Autowired
    private TecnicoRepository tecnicoRepository;

    // Crear técnico
    public Tecnico create(TecnicoDto tecnicoDto){

        Tecnico tecnico = Tecnico.builder()
                .dni(tecnicoDto.getDni())
                .nombre(tecnicoDto.getNombre())
                .apellido(tecnicoDto.getApellido())
                .especialidad(tecnicoDto.getEspecialidad())
                .build();

        return tecnicoRepository.create(tecnico);
    }

    // Listar técnicos
    public List<Tecnico> list(){
        return tecnicoRepository.list();
    }

    // Buscar técnico por ID
    public Tecnico findById(Integer idTecnico){
        return tecnicoRepository.findById(idTecnico)
                .orElseThrow(() -> new RuntimeException("Tecnico no encontrado"));
    }
    public Tecnico findByDni(String dni) {
        return tecnicoRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Tecnico no encontrado"));
    }

    // Actualizar técnico
    public Tecnico update(Integer idTecnico, TecnicoDto tecnicoDto){

        Tecnico tecnico = findById(idTecnico);

        tecnico.setDni(tecnicoDto.getDni());
        tecnico.setNombre(tecnicoDto.getNombre());
        tecnico.setApellido(tecnicoDto.getApellido());
        tecnico.setEspecialidad(tecnicoDto.getEspecialidad());

        return tecnicoRepository.update(tecnico);
    }

    // Eliminar técnico
    public void delete(Integer idTecnico){

        Tecnico tecnico = findById(idTecnico);

        tecnicoRepository.delete(tecnico.getIdTecnico());
    }
}