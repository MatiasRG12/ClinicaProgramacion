package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.MedicoDTOs.*;
import java.util.List;

public interface ServicioMedico {

    int editarInfoBasica(EditarPerfilMedicoDTO dto) throws Exception;

    List<InfoCitaDTOMedico> listarCitasHoy(int codigoMedico)throws Exception;

    List<InfoCitaDTOMedico> listarCitasProximas(int codigoMedico)throws Exception;

    DatosCitaDTO atenderCita(int codigoCita) throws Exception;

    List<InfoCitaHistorialPacienteDTO> listarHistorialMedicoPaciente(int codigoPaciente)throws Exception;

    void finalizarAtencionCita(AtencionMedicaDTO dto) throws Exception;

    void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<InfoCitaDTOMedico> listarHistorialAtenciones(int codigoMedico) throws Exception;

}
