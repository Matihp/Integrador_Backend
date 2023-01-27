package com.example.Clinica_Odontologica;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.services.OdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceTest {
    private OdontologoService odontologoService;
    @Test
    public void testCrearOdontologo() throws ResourceNotFoundException {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Ale");
        odontologo.setApellido("Lopez");
        odontologo.setMatricula("sf34jfj");
        odontologoService.crearOdontologo(odontologo);
        Odontologo odontologo1 = odontologoService.buscarOdontologo(1L);
        assertNotNull(odontologo1);
    }
    @Test
    public void testBuscarOdontologo() throws ResourceNotFoundException {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("rali");
        odontologo.setApellido("rodriguez");
        odontologo.setMatricula("jws634");
        odontologoService.crearOdontologo(odontologo);
        Odontologo odontologo2 = odontologoService.buscarOdontologo(1L);
        assertNotNull(odontologo2);
    }


}