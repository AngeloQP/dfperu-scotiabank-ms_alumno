package com.dfperu.scotiabank.ms_alumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que lanza la aplicación Spring Boot del microservicio "ms_alumno".
 */
@SpringBootApplication
public class MsAlumnoApplication {

	/**
	 * Punto de entrada de la aplicación.
	 *
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(MsAlumnoApplication.class, args);
	}
}
