package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.dto.OdontologoDto;
import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OdontologoService {

    final static Logger LOGGER = Logger.getLogger(OdontologoService.class);
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    @Autowired
    ObjectMapper objectMapper;


    public void crearOdontologo(Odontologo odontologo) {
        OdontologoDto odontologoDto=objectMapper.convertValue(odontologo, OdontologoDto.class);
        odontologoRepository.save(odontologo);
    }

    public Odontologo buscarOdontologo(Long id) throws ResourceNotFoundException {

        Optional<Odontologo> odontologoOptional= odontologoRepository.findById(id);
        if(odontologoOptional.isPresent()){

            return odontologoOptional.get();
        }else{
            LOGGER.error("No se encontro el odontologo con id: "+id);
            throw new ResourceNotFoundException("No se encontro el odontologo con id: "+id);
        }
    }

    public List<Odontologo> buscarTodosOdontologos() {
        return odontologoRepository.findAll();
    }


    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoOptional= odontologoRepository.findById(id);
        if(odontologoOptional.isPresent()){
            odontologoRepository.delete(odontologoOptional.get());
        }else{
            LOGGER.error("No se encontro el odontologo con id: "+id);
            throw new ResourceNotFoundException("No se encontro el odontologo con id: "+id);
        }
    }

    public void actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoOptional= odontologoRepository.findById(odontologo.getId());
        LOGGER.info("Actualizando odontologo con id: "+odontologo.getId());
        if(odontologoOptional.isPresent()){
            LOGGER.info("Se actualizo el odontologo con id: "+odontologo.getId());
            odontologoRepository.save(odontologoOptional.get());
        }else{
            LOGGER.error("No se encontro el odontologo con id: "+odontologo.getId());
            throw new ResourceNotFoundException("No se encontro el odontologo con id: "+odontologo.getId());
        }
    }
}
