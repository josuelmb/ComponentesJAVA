package pe.edu.idat.proyecto.gestion.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import pe.edu.idat.proyecto.gestion.model.Cliente;
import pe.edu.idat.proyecto.gestion.model.Tecnico;
@Data
public class SolicitudDto {

    private String descripcion;
    private String estado;

    @NotBlank(message = "El dni es obligatorio")
    private String dniCliente;
    @NotBlank(message = "El dni es obligatorio")
    private String dniTecnico;
}