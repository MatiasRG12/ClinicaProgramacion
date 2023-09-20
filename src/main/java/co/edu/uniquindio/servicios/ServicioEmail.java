package co.edu.uniquindio.servicios;

import co.edu.uniquindio.dto.EmailDTO;

public interface ServicioEmail {
    String enviarCorreo(EmailDTO emailDTO) throws Exception;
}
