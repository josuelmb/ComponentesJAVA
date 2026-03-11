package pe.edu.idat.proyecto.gestion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //Encapsular Getter and setter
@AllArgsConstructor //Constructor
@NoArgsConstructor // Constructor vacio
@Builder //Cargar campos de los atributos

public class Solicitud {

    private Integer idSolicitud;
    private String descripcion;
    private String estado;
    private Date fechaRegistro;
    private Cliente cliente;
    private Tecnico tecnico;

}