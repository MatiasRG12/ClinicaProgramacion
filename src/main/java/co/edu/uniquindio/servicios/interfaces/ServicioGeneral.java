package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.CompartidosDTOs.DetalleCitaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.RegistroRespuestaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioGeneral {

    //Compartido por Paciente, Administrador y Medico
    DetalleCitaDTO verDetalleCita(int CodigoCita) throws Exception;

    //Compartido por Paciente y Administrador
    int responderPQRS(RegistroRespuestaDTO dto)throws Exception;
}
