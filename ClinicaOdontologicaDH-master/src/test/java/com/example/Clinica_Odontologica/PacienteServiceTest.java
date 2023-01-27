package com.example.Clinica_Odontologica;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.services.PacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    private PacienteService pacienteService;

    @Test
    public void testCrearPaciente() throws ResourceNotFoundException {
        Paciente paciente = new Paciente();
        paciente.setNombre("MAti");
        paciente.setApellido("safsa");
        paciente.setDni(3523523);
        pacienteService.crearPaciente(paciente);
        Paciente paciente1 = pacienteService.buscarPaciente(1L);
        assertNotNull(paciente1);
    }
    @Test
    public void testBuscarPaciente() throws ResourceNotFoundException {
        Paciente paciente = new Paciente();
        paciente.setNombre("Guille");
        paciente.setApellido("paez");
        paciente.setDni(4534632);
        pacienteService.crearPaciente(paciente);
        Paciente paciente1 = pacienteService.buscarPaciente(1L);
        assertNotNull(paciente1);
    }
}