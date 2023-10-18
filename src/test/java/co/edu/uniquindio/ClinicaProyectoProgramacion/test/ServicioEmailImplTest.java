package co.edu.uniquindio.ClinicaProyectoProgramacion.test;

import co.edu.uniquindio.dto.extrasDTOs.EmailDTO;
import co.edu.uniquindio.servicios.impl.ServicioEmailImpl;
import jakarta.validation.constraints.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ServicioEmailImplTest {

    @Autowired
    private ServicioEmailImpl servicioEmail;

    @Test
    @Sql("classpath:dataset.sql")
    public void enviarCorreoTest() throws Exception {
        servicioEmail.enviarCorreo(new EmailDTO(
                "davidAdmin@gmail.com",
                "Test de correo",
                "Hola esto es un correo de prueba"
        ));
    }
}
