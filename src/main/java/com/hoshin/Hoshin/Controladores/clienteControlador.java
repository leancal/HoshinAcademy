package com.hoshin.Hoshin.Controladores;


import com.hoshin.Hoshin.DTO.clienteDTO;
import com.hoshin.Hoshin.models.cliente;
import com.hoshin.Hoshin.servicios.serviciosCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class clienteControlador {

     @Autowired
     private com.hoshin.Hoshin.servicios.serviciosCliente serviciosCliente;

    @Autowired
    private PasswordEncoder contraseñaEncriptada;


    @RequestMapping("/api/clientes") //@RequestMaping es una peticion asociada a una ruta
    public List<clienteDTO> getClients() {
        return serviciosCliente.getClienteDTO();

    }

    @RequestMapping("/api/clientes/{id}") // end point
    public clienteDTO getClienteId(@PathVariable Long id) { //Trae lo que varia de la ruta , en este caso el id

        return serviciosCliente.getClienteId(id);

    }


    @PostMapping("/api/clientes")

    public ResponseEntity<Object> register(

            @RequestParam String primerNombre, @RequestParam String apellido,

            @RequestParam String email, @RequestParam String contraseña) {


        if (primerNombre.isEmpty()) {
            return new ResponseEntity<>("Name missing", HttpStatus.FORBIDDEN);
        }

        if ( apellido.isEmpty()) {
            return new ResponseEntity<>("LastName missing", HttpStatus.FORBIDDEN);
        }

        if (contraseña.isEmpty()) {
            return new ResponseEntity<>("Email missing", HttpStatus.FORBIDDEN);
        }


        if (serviciosCliente.findByEmail(email) != null) {
            return new ResponseEntity<>("email already in use", HttpStatus.FORBIDDEN);

        }

        cliente nuevoCliente = new cliente(primerNombre, apellido, email, contraseñaEncriptada.encode(contraseña));
        serviciosCliente.guardarCliente(nuevoCliente);

        return new ResponseEntity<>( HttpStatus.CREATED);

    }



}
