package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.jwt.AuthenticationResponse;
import com.example.Clinica_Odontologica.jwt.JwtUtil;
import com.example.Clinica_Odontologica.model.Usuario;
import com.example.Clinica_Odontologica.services.OdontologoService;
import com.example.Clinica_Odontologica.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    final static Logger LOGGER = Logger.getLogger(OdontologoService.class);

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Usuario usuario) throws Exception {
        try {
            LOGGER.info("Iniciando autenticación");
            LOGGER.info("Usuario: " + usuario.getEmail());
            LOGGER.info("Contraseña: " + usuario.getPassword());


                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword()));


        }catch (BadCredentialsException e ) {
            LOGGER.error("Error en el login: " + e);

            return ResponseEntity.status(404).body("Usuario o contraseña incorrectos");
        }

        final UserDetails userDetails = userService.loadUserByUsername(usuario.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        LOGGER.info("Token generado: " + jwt);
        //RESPONSE user and jwt
        return ResponseEntity.status(200).body(new AuthenticationResponse(jwt,usuario.getEmail()) );



    }

}
