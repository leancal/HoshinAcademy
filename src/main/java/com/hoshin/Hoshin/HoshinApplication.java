package com.hoshin.Hoshin;

import com.hoshin.Hoshin.Repositorios.ClienteRepositorio;
import com.hoshin.Hoshin.models.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HoshinApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoshinApplication.class, args);
	}

	@Autowired
	private PasswordEncoder contraseñaEncriptada;

	@Bean
	public CommandLineRunner initData(ClienteRepositorio clienteRepositorio ) {
		return args -> {
			cliente client1= new cliente("Melba","Morel", "MelbaMorel@gmail.com",contraseñaEncriptada.encode("perro"));
			clienteRepositorio.save(client1);



		};

	}

}