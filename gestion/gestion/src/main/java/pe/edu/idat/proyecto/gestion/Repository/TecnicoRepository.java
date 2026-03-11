package pe.edu.idat.proyecto.gestion.Repository;

import org.springframework.stereotype.Repository;
import pe.edu.idat.proyecto.gestion.dto.TecnicoDto;
import pe.edu.idat.proyecto.gestion.model.Tecnico;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TecnicoRepository {

    private final Map<Integer, Tecnico> tecnicos = new HashMap<>();
    private final AtomicInteger secuencialTecnico = new AtomicInteger(1);

    // Crear técnico
    public Tecnico create(Tecnico tecnico){

        if(tecnico.getIdTecnico() == null){
            tecnico.setIdTecnico(secuencialTecnico.getAndIncrement());
        }

        tecnicos.put(tecnico.getIdTecnico(), tecnico);
        return tecnico;
    }

    // Listar técnicos
    public List<Tecnico> list(){
        return new ArrayList<>(tecnicos.values());
    }

    // Buscar técnico por ID
    public Optional<Tecnico> findById(Integer idTecnico){
        return Optional.ofNullable(tecnicos.get(idTecnico));
    }

    //Buscar tecnico por DNI
    public Optional<Tecnico> findByDni(String dni) {
        return tecnicos.values()
                .stream()
                .filter(tecnico -> tecnico.getDni().equals(dni))
                .findFirst();
    }

    // Actualizar técnico
    public Tecnico update(Tecnico tecnico){
        tecnicos.put(tecnico.getIdTecnico(), tecnico);
        return tecnico;
    }

    // Eliminar técnico
    public void delete(Integer idTecnico){
        tecnicos.remove(idTecnico);
    }

    // Verificar si existe
    public boolean existsById(Integer idTecnico){
        return tecnicos.containsKey(idTecnico);
    }
}