package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.model.Turno;
import com.example.Clinica_Odontologica.repository.OdontologoRepository;
import com.example.Clinica_Odontologica.repository.PacienteRepository;
import com.example.Clinica_Odontologica.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TurnoService  {

@Autowired
private TurnoRepository turnoRepository;

    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    final static Logger LOGGER = Logger.getLogger(TurnoService.class);

    public Turno crearTurno(Turno turno) throws ResourceNotFoundException {
        Turno turno1 = new Turno();
        turno1.setFecha(turno.getFecha());
        turno1.setHora(turno.getHora());
        LOGGER.info("id odontologo: " + turno.getOdontologo().getId());
        LOGGER.info("id paciente: " + turno.getPaciente().getId());
        Odontologo odontologo = odontologoRepository.findById(turno.getOdontologo().getId()).orElseThrow(() -> new ResourceNotFoundException("Odontologo no encontrado"));
        Paciente paciente = pacienteRepository.findById(turno.getPaciente().getId()).orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
        if (odontologo != null && paciente != null) {
            turno1.setOdontologo(odontologo);
            turno1.setPaciente(paciente);
            turnoRepository.save(turno1);
            return turno1;
        }else {
            throw new ResourceNotFoundException("No se pudo crear el turno");
        }


    }

    public Turno buscarTurno(Long id) throws ResourceNotFoundException {
        return turnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado"));
    }
    public List<Turno> buscarTodosTurnos() throws ResourceNotFoundException {
        return turnoRepository.findAll();
    }
}
