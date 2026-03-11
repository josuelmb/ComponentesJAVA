package pe.edu.idat.proyecto.gestion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Encapsular Getter and setter
@AllArgsConstructor //Constructor
@NoArgsConstructor // Constructor vacio
@Builder //Cargar campos de los atributos


public class Tecnico {

    private Integer idTecnico;
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
}