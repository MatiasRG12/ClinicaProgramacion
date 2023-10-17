package co.edu.uniquindio.ClinicaProyectoProgramacion.test;

import co.edu.uniquindio.dto.AdminDTOs.ActualizarMedicoAdminDTO;
import co.edu.uniquindio.dto.AdminDTOs.MedicoDTO;
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

        /** ((((Segun la guia para los Test)))
        int nuevoMedico = servicioAdministrador.crearMedico(medicoDTO);
        Assertions.assertTrue(nuevoMedico>0);
         */

        ///Segun el codigo que el profesor subió para los Test
        try {
            servicioAdministrador.crearMedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMedicoTest() throws Exception {

       int nuevo = servicioAdministrador.actualizarMedico(new ActualizarMedicoAdminDTO(
               "123456789",
               Especialidad.NEUROLOGIA,
               Jornada.NOCTURNA));

        Assertions.assertTrue(nuevo>0);
    }
    */

}
