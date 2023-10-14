package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.MedicoDTOs.*;

import java.time.LocalDateTime;
import java.util.List;

public interface ServicioMedico {

    int editarInfoBasica(EditarPerfilMedicoDTO dto) throws Exception;

    void cambiarContrasenia(CambiarContraseniaDTO dto)throws Exception;

    List<InfoCitaDTOMedico> listarCitasHoy(int codigoMedico)throws Exception;

    //CUANDO EL MEDICO DECIDE ATENDER UNA CITA EL SELECCIONA LA CITA Y SE LE ABRE UNA VENTANA CON
    //UN FORMULARIO DONDE EL MEDICO RELLENA LA INFO DE LA ATENCIONMEDICA DE LA CITA, REQUIERE ESO
    //UN METODO AQUI?

    List<InfoCitaDTOMedico> listarCitasProximas(int codigoMedico)throws Exception;

    List<InfoCitaHistorialPacienteDTO> listarHistorialMedicoPaciente(int codigoPaciente)throws Exception;

    DatosCitaDTO atenderCita(int codigoCita) throws Exception;

    void finalizarAtencionCita(AtencionMedicaDTO dto) throws Exception;

    void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<InfoCitaDTOMedico> listarHistorialAtenciones(int codigoMedico) throws Exception;

}
