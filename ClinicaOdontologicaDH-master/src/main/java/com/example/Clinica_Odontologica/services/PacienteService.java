package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService  {
    final static Logger LOGGER = Logger.getLogger(PacienteService.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    public void crearPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public Paciente buscarPaciente(Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional= pacienteRepository.findById(id);
        if(pacienteOptional.isPresent()){
            LOGGER.info("Se encontro el paciente con id: "+id);
            return pacienteOptional.get();
        }else{
            LOGGER.error("No se encontro el paciente con id: "+id);
            throw new ResourceNotFoundException("No se encontro el paciente con id: "+id);
        }
    }

    public void actualizarPaciente(Paciente paciente) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional= pacienteRepository.findById(paciente.getId());
        if(pacienteOptional.isPresent()){
            LOGGER.info("Se encontro el paciente con id: "+paciente.getId());
            pacienteRepository.save(paciente);
        }else{
            LOGGER.error("No se encontro el paciente con id: "+paciente.getId());
            throw new ResourceNotFoundException("No se encontro el paciente con id: "+paciente.getId());
        }
    }

    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional= pacienteRepository.findById(id);
        if(pacienteOptional.isPresent()){
            LOGGER.info("Se encontro el paciente con id: "+id);
            pacienteRepository.delete(pacienteOptional.get());
        }else{
            LOGGER.error("No se encontro el paciente con id: "+id);
            throw new ResourceNotFoundException("No se encontro el paciente con id: "+id);
        }
    }

    public List<Paciente> buscarTodosPacientes() throws ResourceNotFoundException {
        List<Paciente> pacientes = pacienteRepository.findAll();
        if(pacientes.isEmpty()){
            LOGGER.error("No se encontraron pacientes");
            throw new ResourceNotFoundException("No se encontraron pacientes");
        }else{
            LOGGER.info("Se encontraron "+pacientes.size()+" pacientes");
            return pacientes;
        }
    }
}
