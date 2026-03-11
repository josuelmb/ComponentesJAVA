package pe.edu.idat.proyecto.gestion.Repository;
//Acceso a datos,guardar, buscar,eliminar ,actualizar
//Esta capa maneja el acceso a la base de datos. (( Save(), Delete()findAll()
import org.springframework.stereotype.Repository;
import pe.edu.idat.proyecto.gestion.model.Cliente;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClienteRepository {

    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private final AtomicInteger secuencialCliente = new AtomicInteger(1);

    // Crear cliente
    public Cliente create(Cliente cliente) {

        if (cliente.getIdCliente() == null) {
            cliente.setIdCliente(secuencialCliente.getAndIncrement());
        }

        clientes.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    // Listar clientes
    public List<Cliente> list() {
        return new ArrayList<>(clientes.values());
    }

    // Buscar cliente por ID
    public Optional<Cliente> findById(Integer idCliente) {
        return Optional.ofNullable(clientes.get(idCliente));
    }

    //Buscar cliente por DNI
    public Optional<Cliente> findByDni(String dni) {
        return clientes.values()
                .stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();
    }

    // Actualizar cliente
    public Cliente update(Cliente cliente) {
        clientes.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    // Eliminar cliente
    public void delete(Integer idCliente) {
        clientes.remove(idCliente);
    }

    // Verificar existencia
    public boolean existsById(Integer idCliente) {
        return clientes.containsKey(idCliente);
    }
}
