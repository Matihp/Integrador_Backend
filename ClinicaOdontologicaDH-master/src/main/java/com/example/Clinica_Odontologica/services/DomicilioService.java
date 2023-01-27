package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.model.Domicilio;
import com.example.Clinica_Odontologica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DomicilioService {

@Autowired
private DomicilioRepository domicilioRepository;

    public void crearDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    public Domicilio buscarDomicilio(Long id) {
        return domicilioRepository.findById(id).orElse(null);
    }
}
