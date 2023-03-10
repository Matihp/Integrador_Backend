package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.model.AppUserRoles;
import com.example.Clinica_Odontologica.model.Usuario;
import com.example.Clinica_Odontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;
    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("hola");
        //String otraPas = passwordEncoder.encode("1234");
        userRepository.save(new Usuario("wily","Baez","admin@gmail.com","clave", AppUserRoles.ADMIN));
        userRepository.save(new Usuario("pepe","Lopez","user@gmail.com","clave", AppUserRoles.USER));
    }
}
