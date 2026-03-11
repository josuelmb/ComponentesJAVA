package pe.edu.idat.proyecto.gestion.model;
//Estas representan las tablas de la base de datos.

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data //Encapsular Getter and setter
@AllArgsConstructor//Constructor
@NoArgsConstructor // Constructor vacio
@Builder //Cargar campos de los atributos,

public class Cliente {
    private Integer idCliente;
    private String dni;
    private String nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Correo;
    private Date fechaRegistro;

}
