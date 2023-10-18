package co.edu.uniquindio.servicios.interfaces;


import co.edu.uniquindio.dto.AdminDTOs.*;
import co.edu.uniquindio.dto.CompartidosDTOs.InfoPqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetallePqrsDTO;

import java.util.List;

public interface ServicioAdministrador {

    int crearMedico(MedicoDTO medico) throws Exception;

    int actualizarMedico(ActualizarMedicoAdminDTO medicoDTO) throws Exception;

    List<InfoMedicoDTO> listarMedicos() throws Exception;

    DetalleMedicoDTO verDetalleMedico(String cedulaMedico) throws Exception;

    List<InfoMedicoDTO> filtrarMedicosNombre(String nombreMedico) throws Exception;

    List<InfoMedicoDTO> filtrarMedicosEspecialidad(int codigoEspecialidad) throws Exception;

    List<InfoMedicoDTO> filtrarMedicosNombreEspecialidad(FiltroMedicosNomEspDTO dto) throws Exception;

    //-------------------------------------------------------------------------------------------//

    List<InfoPqrsDTO> listarPQRS() throws Exception;

    List<InfoPqrsDTO> filtrarPQRSEstado(int estado) throws Exception;

    String verMotivoPQRS(int codigoPqrs) throws Exception; //REVISAR

    void escogerPQRS(int codigo, int codigoAdmin) throws Exception;

    DetallePqrsDTO verDetallePQRS(int codigo) throws Exception;

    void cambiarEstadoPQRS(int codigoPqrs, int estado) throws Exception;

    //-------------------------------------------------------------------------------------------//

    List<InfoCitaDTOAdmin> listarCitasAdmin() throws Exception;
    List<InfoCitaDTOAdmin> filtrarPorMedico(String nombreMedico) throws Exception;

}
