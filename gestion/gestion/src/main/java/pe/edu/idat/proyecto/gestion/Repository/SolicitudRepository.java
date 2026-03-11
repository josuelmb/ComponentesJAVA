package pe.edu.idat.proyecto.gestion.Repository;

import org.springframework.stereotype.Repository;
import pe.edu.idat.proyecto.gestion.model.Solicitud;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SolicitudRepository {

    private final Map<Integer, Solicitud> solicitudes = new HashMap<>();
    private final AtomicInteger contador = new AtomicInteger(1);


    // Crear solicitud
    public Solicitud create(Solicitud solicitud){

        solicitud.setIdSolicitud(contador.getAndIncrement());
        solicitudes.put(solicitud.getIdSolicitud(), solicitud);

        return solicitud;
    }


    // Listar solicitudes
    public List<Solicitud> list(){
        return new ArrayList<>(solicitudes.values());
    }


    // Buscar por id
    public Optional<Solicitud> findById(Integer id){
        return Optional.ofNullable(solicitudes.get(id));
    }


    // Actualizar
    public Solicitud update(Solicitud solicitud){

        solicitudes.put(solicitud.getIdSolicitud(), solicitud);

        return solicitud;
    }


    // Eliminar
    public void delete(Integer id){
        solicitudes.remove(id);
    }
}