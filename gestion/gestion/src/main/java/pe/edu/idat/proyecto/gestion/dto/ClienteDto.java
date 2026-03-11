package pe.edu.idat.proyecto.gestion.dto;
//Sirve para transferir datos entre capas.
//Su enfoque va hacia las apps, el modelo a la info que almacena (memoria o BD)

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDto {
   @Valid

    @NotBlank(message = "El DNI es obligatorio") //notblank para espacio en blanco
    private String dni;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El Apellido Paterno es obligatorio")
    private String ApellidoPaterno;
    @NotBlank(message = "El Apellido materno es obligatorio")
    private String ApellidoMaterno;
    private String Correo;
}


