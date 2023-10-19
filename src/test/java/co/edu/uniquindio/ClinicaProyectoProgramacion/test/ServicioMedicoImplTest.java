package co.edu.uniquindio.ClinicaProyectoProgramacion.test;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.MedicoDTOs.*;
import co.edu.uniquindio.servicios.impl.ServicioMedicoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@SpringBootTest
@Transactional
public class ServicioMedicoImplTest {

    @Autowired
    private ServicioMedicoImpl servicioMedico;

    @Test
    @Sql("classpath:dataset.sql")
    public void editarInfoBasicaTest() throws Exception {
        int nuevo = servicioMedico.editarInfoBasica(new EditarPerfilMedicoDTO(
                003,
                "Armenia",
                "3225205682",
                "nuevaFoto"
        ));

        Assertions.assertTrue(nuevo>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarContraseniaTest() throws Exception {
        try {
            servicioMedico.cambiarContrasenia(new CambiarContraseniaDTO(
                    003,
                    "passwordMedicoUno",
                    "nuevaContrasenia"
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasHoyTest() throws Exception {
        try {
            servicioMedico.listarCitasHoy(003);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void atenderCitaTest() throws Exception {
        try {
            servicioMedico.atenderCita(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void finalizarCitaTest() throws Exception {
        try {
            servicioMedico.finalizarAtencionCita(new AtencionMedicaDTO(
                    1000,
                    "Dolores",
                    "Dolores",
                    "Acetaminofen",
                    "Se remite a"
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasProximasTest() throws Exception {
        List<InfoCitaDTOMedico> cita;
        try {
            cita = servicioMedico.listarCitasProximas(003);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioMedico.listarCitasProximas(003).size()>0);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialMedicoPacienteTest() throws Exception {
        List<InfoCitaHistorialPacienteDTO> historial;
        try {
            historial = servicioMedico.listarHistorialMedicoPaciente(005);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioMedico.listarHistorialMedicoPaciente(005).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDiaLibreTest() {
        try {
            servicioMedico.agendarDiaLibre(new DiaLibreDTO(003, LocalDateTime.of(2023, Month.NOVEMBER, 23, 14, 20)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialAtencionesTest() throws Exception {
        List<InfoCitaDTOMedico> historial;
        try {
            historial = servicioMedico.listarHistorialAtenciones(003);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioMedico.listarHistorialAtenciones(003).size()>0);
    }

}