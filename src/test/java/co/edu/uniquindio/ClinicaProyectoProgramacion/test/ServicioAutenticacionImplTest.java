package co.edu.uniquindio.ClinicaProyectoProgramacion.test;

import co.edu.uniquindio.dto.extrasDTOs.LoginDTO;
import co.edu.uniquindio.dto.extrasDTOs.TokenDTO;
import co.edu.uniquindio.servicios.impl.ServicioAutenticacionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ServicioAutenticacionImplTest {

    @Autowired
    private ServicioAutenticacionImpl servicioAutenticacion;

    @Test
    public void encode(){
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println( b.encode("medicoUno") );
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest(){
        LoginDTO login = new LoginDTO("paciente@gmail.com", "pacienteUno");
        try {
            TokenDTO tokenDTO = servicioAutenticacion.login(login);
            Assertions.assertNotNull(tokenDTO);
            System.out.println(tokenDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
