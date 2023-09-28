package co.edu.uniquindio.servicios.impl;


import co.edu.uniquindio.dto.*;
import co.edu.uniquindio.modelo.entidades.Medico;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.repositorios.*;
import co.edu.uniquindio.servicios.interfaces.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAdministradorImpl implements ServicioAdministrador {

    private MedicoRepo medicoRepo;

    @Override
    public String crearMedico(MedicoDTO medicoDTO) throws Exception{

        Medico medico = new Medico();
        medico.setNombre(medicoDTO.nombre());
        medico.setCedula(medicoDTO.cedula());
        medico.setCiudad(medicoDTO.ciudad()); //revisar esta parte
        medico.setEspecialidad(Especialidad.values()[medicoDTO.codigoEspecialidad()]);
        medico.setTelefono(medicoDTO.telefono());
        medico.setEmail(medicoDTO.correo());
        medico.setContrasenia(medicoDTO.password());




        Medico medicoNuevo = medicoRepo.save(medico);
        return null;
    }

    @Override
    public String actualizarMedico(int codigo, MedicoDTO medico) throws Exception {
        return null;
    }

    @Override
    public String eliminarMedico(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<MedicoDTOAdmin> listarMedicos() throws Exception {
        return null;
    }

    @Override
    public InfoMedicoDTO obtenerMedico(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<PQRSDTOAdmin> listarPQRS() throws Exception {
        return null;
    }

    @Override
    public String responderPQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public InfoPQRSDTO verDetallePQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<CitaDTOAdmin> listarCitas() throws Exception {
        return null;
    }
}
