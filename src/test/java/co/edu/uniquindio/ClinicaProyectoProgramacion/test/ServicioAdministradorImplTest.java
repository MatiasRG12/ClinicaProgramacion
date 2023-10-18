package co.edu.uniquindio.ClinicaProyectoProgramacion.test;

import co.edu.uniquindio.dto.AdminDTOs.*;
import co.edu.uniquindio.dto.CompartidosDTOs.DetallePqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.InfoPqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.MensajePqrsDTO;
import co.edu.uniquindio.dto.PacienteDTOs.InfoCitaDTO;
import co.edu.uniquindio.modelo.entidades.MensajePqrs;
import co.edu.uniquindio.modelo.entidades.Pqrs;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoMedico;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import co.edu.uniquindio.servicios.impl.ServicioAdministradorImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
public class ServicioAdministradorImplTest {

    @Autowired
    private ServicioAdministradorImpl servicioAdministrador;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearMedicoTest() throws Exception {

        MedicoDTO medicoDTO = new MedicoDTO(
                "Pepito Perez",
                "654789631",
                "Armenia",
                Especialidad.MEDICINA_GENERAL,
                "321542154",
                "correo@correo.com",
                "123456",
                Jornada.DIURNA,
                EstadoMedico.A);

        try {
            servicioAdministrador.crearMedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMedicoTest() throws Exception {

       int nuevo = servicioAdministrador.actualizarMedico(new ActualizarMedicoAdminDTO(
               "123456789",
               Especialidad.NEUROLOGIA,
               Jornada.NOCTURNA));

        Assertions.assertTrue(nuevo>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMedicosTest() throws Exception {

        List<InfoMedicoDTO> listaMedicos;
        try {
            listaMedicos = servicioAdministrador.listarMedicos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioAdministrador.listarMedicos().size()>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetalleMedicoTest() throws Exception {

        DetalleMedicoDTO detalleMedicoDTO;
        try {
            detalleMedicoDTO = servicioAdministrador.verDetalleMedico("123456789");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(detalleMedicoDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarMedicosNombreTest() throws Exception {

        List<InfoMedicoDTO> listaMedicos;
        try {
            listaMedicos = servicioAdministrador.filtrarMedicosNombre("Pepe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioAdministrador.filtrarMedicosNombre("Pepe").size()>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarMedicosEspecialidadTest() throws Exception {

        List<InfoMedicoDTO> listaMedicos;
        try {
            listaMedicos = servicioAdministrador.filtrarMedicosEspecialidad(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertFalse(servicioAdministrador.filtrarMedicosEspecialidad(0).isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarMedicosNombreEspecialidadTest() throws Exception {

        List<InfoMedicoDTO> listaMedicos;
        FiltroMedicosNomEspDTO medicoDTO = new FiltroMedicosNomEspDTO(
                "Pepe",
                0
        );
        try {
            listaMedicos = servicioAdministrador.filtrarMedicosNombreEspecialidad(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioAdministrador.filtrarMedicosNombreEspecialidad(medicoDTO).size()>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarPQRSEstadoTest() throws Exception {

        List<InfoPqrsDTO> listaPQRS;
        try {
            listaPQRS = servicioAdministrador.filtrarPQRSEstado(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioAdministrador.filtrarPQRSEstado(0).size()>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verMotivoPQRSTest() throws Exception {

        String motivo;
        try {
            motivo = servicioAdministrador.verMotivoPQRS(123);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(motivo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void escogerPQRSTest() throws Exception {

        try {
            servicioAdministrador.escogerPQRS(123, 1004871091);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSTest() throws Exception {

        List<InfoPqrsDTO> listaPQRS;
        try {
            listaPQRS = servicioAdministrador.listarPQRS();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioAdministrador.listarPQRS().size()>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePQRSTest() throws Exception {

        DetallePqrsDTO detallePqrsDTO;
        try {
            detallePqrsDTO = servicioAdministrador.verDetallePQRS(123);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(detallePqrsDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void convertirMensajesTest() throws Exception {

         List<MensajePqrs> listaMensajes2 = new ArrayList<>();;
            try {
                List<MensajePqrsDTO> listaMensajes = servicioAdministrador.convertirMensajes(listaMensajes2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Assertions.assertTrue(servicioAdministrador.convertirMensajes(listaMensajes2).isEmpty());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoPQRSTest() throws Exception {

        try {
            servicioAdministrador.cambiarEstadoPQRS(123, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasAdminTest() throws Exception {

        List<InfoCitaDTOAdmin> listaCitas;
        try {
            listaCitas = servicioAdministrador.listarCitasAdmin();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioAdministrador.listarCitasAdmin().size()>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarPorMedicoTest() throws Exception {

        List<InfoCitaDTOAdmin> listaCitas;
        try {
            listaCitas = servicioAdministrador.filtrarPorMedico("DavidMedicoPersona");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioAdministrador.filtrarPorMedico("DavidMedicoPersona").size()>0);
    }

}
