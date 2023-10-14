package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.extrasDTOs.EmailDTO;
import org.springframework.stereotype.Service;

@Service
public interface ServicioEmail {

    void enviarCorreo(EmailDTO emailDTO) throws Exception;
}
