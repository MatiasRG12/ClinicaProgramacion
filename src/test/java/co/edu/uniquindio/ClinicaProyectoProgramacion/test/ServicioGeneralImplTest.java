package co.edu.uniquindio.ClinicaProyectoProgramacion.test;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.servicios.impl.ServicioGeneralImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ServicioGeneralImplTest {

    @Autowired
    private ServicioGeneralImpl servicioGeneral;

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetalleCitacionTest() throws Exception {
        try {
            servicioGeneral.verDetalleCita(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarContraseniaTest() throws Exception {
        try {
            servicioGeneral.cambiarPassword(new CambiarContraseniaDTO(
                    003,
                    "passwordMedicoUno",
                    "nuevaContrasenia"
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
