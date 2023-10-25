package co.edu.uniquindio.servicios.interfaces;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetallePqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.InfoPqrsDTO;
import co.edu.uniquindio.dto.PacienteDTOs.*;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;

import java.util.List;

public interface ServicioPaciente {

    //Su uso es en NoAuthController ya que no requiere token para su uso
    int registrarPaciente(RegistroPacienteDTO pacienteDTO) throws Exception;

    int editarInfoBasica(EditarPerfilPacienteDTO pacienteDTO) throws Exception;

    void eliminarCuenta(EliminarCuentaDTO eCuentaDTO) throws Exception;

    int crearPQRS(CrearPqrsDTO pqrsDTO) throws Exception;

    DetallePqrsDTO verDetallePqrs(int codigo)throws Exception;

    List<InfoPqrsDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    List<InfoPqrsDTO> filtrarPqrsPorTipo(FiltroPqrsTipoDTO dto) throws Exception;

    List<ItemFechaMedicoDTO> listarFechasMedico(int idMedico) throws Exception;

    int agendarCita(AgendarCitaDTO citaDTO)throws Exception;

    List<ItemMedicoDTO> listarMedicosEspecialidad(int codigoEspecialidad) throws Exception;

    List<InfoCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    List<InfoCitaDTO> filtrarCitasPorMedico(FiltroCitaMedicoDTO filtroDTO) throws Exception;

    List<InfoCitaDTO> filtrarCitasPorFecha(FiltroCitaFechaDTO filtroDTO) throws Exception;

    List<InfoCitaDTO> filtrarCitasPorEspecialidad(FiltroCitaEspDTO filtroDTO) throws Exception;

    List<InfoCitaDTO> filtrarCitasPorMedicoFechaEspecialidad(FiltroMedFechaEspDTO filtroDTO) throws Exception;

}
