package pe.edu.idat.proyecto.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto.gestion.Repository.ClienteRepository;
import pe.edu.idat.proyecto.gestion.Repository.SolicitudRepository;
import pe.edu.idat.proyecto.gestion.Repository.TecnicoRepository;
import pe.edu.idat.proyecto.gestion.dto.SolicitudDto;
import pe.edu.idat.proyecto.gestion.model.Cliente;
import pe.edu.idat.proyecto.gestion.model.Solicitud;
import pe.edu.idat.proyecto.gestion.model.Tecnico;

import java.util.Date;
import java.util.List;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;


    // Crear solicitud
    public Solicitud create(SolicitudDto dto){

        Solicitud solicitud = Solicitud.builder()
                .descripcion(dto.getDescripcion())
                .estado(dto.getEstado())
                .fechaRegistro(new Date())
                .cliente(buscarCliente(dto.getDniCliente()))
                .tecnico(buscarTecnico(dto.getDniTecnico()))
                .build();

        return solicitudRepository.create(solicitud);
    }


    // Listar
    public List<Solicitud> list(){
        return solicitudRepository.list();
    }


    // Buscar por id
    public Solicitud findById(Integer id){
        return solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }


    // Actualizar
    public Solicitud update(Integer id, SolicitudDto dto){

        Solicitud solicitud = findById(id);

        solicitud.setDescripcion(dto.getDescripcion());
        solicitud.setEstado(dto.getEstado());
        solicitud.setCliente(buscarCliente(dto.getDniCliente()));
        solicitud.setTecnico(buscarTecnico(dto.getDniTecnico()));

        return solicitudRepository.update(solicitud);
    }


    // Eliminar
    public void delete(Integer id){
        solicitudRepository.delete(id);
    }



    private Cliente buscarCliente(String dni){
        if(dni == null) return null;

        return clienteRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    private Tecnico buscarTecnico(String dni){

        if(dni == null) return null;

        return tecnicoRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Tecnico no encontrado"));
    }
}