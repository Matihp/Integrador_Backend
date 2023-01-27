package com.example.Clinica_Odontologica;

import com.example.Clinica_Odontologica.model.Domicilio;
import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.services.OdontologoService;
import com.example.Clinica_Odontologica.services.PacienteService;
import com.example.Clinica_Odontologica.services.TurnoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters =false)
public class TurnosServiceTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    TurnoService turnoService;

    public void cargarDAtos(){
        Domicilio domicilio=new Domicilio();
        Paciente paciente=pacienteService.crearPaciente(new Paciente(343,"hola","quetal",34324234,domicilio,'fgfdg'));
    }
    @Test
    public void listarTurnos() throws Exception {
        MvcResult respuesta = mockMvc.perform(MockMvcRequestBuilders.get("/turno")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assert.assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
}
