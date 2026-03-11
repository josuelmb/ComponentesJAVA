package pe.edu.idat.proyecto.gestion.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TecnicoDto {
    @Valid

    @NotBlank(message = "El dni es obligatorio")
    private String dni;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotBlank (message = "El Especialidad es obligatorio")
    private String especialidad;



}
