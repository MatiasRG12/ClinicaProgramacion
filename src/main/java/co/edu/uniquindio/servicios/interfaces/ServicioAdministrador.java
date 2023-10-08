package co.edu.uniquindio.servicios.interfaces;


import co.edu.uniquindio.dto.*;
import co.edu.uniquindio.dto.AdminDTOs.ActualizarMedicoAdminDTO;
import co.edu.uniquindio.dto.AdminDTOs.DetalleCitaDTOAdmin;
import co.edu.uniquindio.dto.AdminDTOs.InfoCitaDTOAdmin;
import co.edu.uniquindio.dto.InfoMedicoDTO;
import co.edu.uniquindio.dto.AdminDTOs.DetallePqrsDTOAdmin;

import java.util.List;

public interface ServicioAdministrador {

    int crearMedico(MedicoDTO medico) throws Exception;

    int actualizarMedico(ActualizarMedicoAdminDTO medicoDTO) throws Exception;

    List<InfoMedicoDTO> listarMedicos() throws Exception;

    InfoMedicoDTO obtenerMedico(String cedula) throws Exception;

    //-------------------------------------------------------------------------------------------//

    List<InfoPqrsDTO> filtrarPQRSEstado(int estado) throws Exception;

    List<InfoPqrsDTO> listarPQRS() throws Exception;

    String responderPQRS(int codigo) throws Exception;

    DetallePqrsDTOAdmin verDetallePQRS(int codigo) throws Exception;

    //-------------------------------------------------------------------------------------------//

    List<InfoCitaDTOAdmin> listarCitas() throws Exception;

    List<DetalleCitaDTOAdmin> verDetalleCitas() throws Exception;

}
