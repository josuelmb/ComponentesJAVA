package pe.edu.idat.proyecto.gestion.service;
//Se crea la logica como crear, validar
//Depdende de la info de la DTO, tenemos que crear esa info primero

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto.gestion.Repository.ClienteRepository;
import pe.edu.idat.proyecto.gestion.dto.ClienteDto;
import pe.edu.idat.proyecto.gestion.model.Cliente;

import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    // Inyección de dependencias
    @Autowired
    private ClienteRepository clienteRepository;

    // Crear cliente
    public Cliente create(ClienteDto clienteDto){

        //Usamos los builders
        Cliente cliente = Cliente.builder()
                .dni(clienteDto.getDni())
                .nombre(clienteDto.getNombre())
                .ApellidoPaterno(clienteDto.getApellidoPaterno())
                .ApellidoMaterno(clienteDto.getApellidoMaterno())
                .Correo(clienteDto.getCorreo())
                .fechaRegistro(new Date())
                .build();

        return clienteRepository.create(cliente);
    }

    // Listar clientes
    public List<Cliente> list(){
        return clienteRepository.list();
    }

    // Buscar cliente por ID
    public Cliente findById(Integer idCliente){
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
    //Buscar por dni
    public Cliente findByDni(String dni) {
        return clienteRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    // Actualizar cliente
    public Cliente update(Integer idCliente, ClienteDto clienteDto){

        Cliente cliente = findById(idCliente);

        cliente.setDni(clienteDto.getDni());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidoPaterno(clienteDto.getApellidoPaterno());
        cliente.setApellidoMaterno(clienteDto.getApellidoMaterno());
        cliente.setCorreo(clienteDto.getCorreo());
        return clienteRepository.update(cliente);
    }

    // Eliminar cliente
    public void delete(Integer idCliente){

        Cliente cliente = findById(idCliente);

        clienteRepository.delete(cliente.getIdCliente());
    }

}