package pe.edu.idat.proyecto.gestion;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Anotacion,todo se trabaja en anotaciones
public class GestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);
	}

}
