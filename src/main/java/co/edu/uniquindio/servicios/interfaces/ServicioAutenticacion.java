package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.extrasDTOs.LoginDTO;
import co.edu.uniquindio.dto.extrasDTOs.TokenDTO;
import org.springframework.stereotype.Service;

@Service
public interface ServicioAutenticacion {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
