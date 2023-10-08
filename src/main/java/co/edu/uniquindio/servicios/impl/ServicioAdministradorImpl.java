package co.edu.uniquindio.servicios.impl;


import co.edu.uniquindio.dto.*;
import co.edu.uniquindio.dto.AdminDTOs.ActualizarMedicoAdminDTO;
import co.edu.uniquindio.dto.AdminDTOs.DetalleCitaDTOAdmin;
import co.edu.uniquindio.dto.AdminDTOs.InfoCitaDTOAdmin;
import co.edu.uniquindio.dto.InfoMedicoDTO;
import co.edu.uniquindio.dto.AdminDTOs.DetallePqrsDTOAdmin;
import co.edu.uniquindio.modelo.entidades.Cita;
import co.edu.uniquindio.modelo.entidades.Medico;
import co.edu.uniquindio.modelo.entidades.MensajePqrs;
import co.edu.uniquindio.modelo.entidades.Pqrs;
import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.repositorios.*;
import co.edu.uniquindio.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ServicioAdministrador")
@AllArgsConstructor
public class ServicioAdministradorImpl implements ServicioAdministrador {

    private final MedicoRepo medicoRepo;
    private final PqrsRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final MessageSource ms;

    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception{
        if(medicoRepo.findByCedula(medicoDTO.cedula()).isPresent()){
           throw new Exception("Medico ya existe");
        }
        Medico medicoNuevo = new Medico();
        medicoNuevo.setEmail(medicoDTO.correo());
        medicoNuevo.setContrasenia(medicoDTO.password()); //ENCRIPTAR CONTRASEÑA
        medicoNuevo.setNombre(medicoDTO.nombre());
        medicoNuevo.setTelefono(medicoDTO.telefono());
        medicoNuevo.setCiudad(medicoDTO.ciudad());
        medicoNuevo.setEspecialidad(medicoDTO.especialidad());
        medicoNuevo.setJornada(medicoDTO.jornada());
        medicoNuevo.setEstado(medicoDTO.estado());
        medicoRepo.save(medicoNuevo);
        return medicoNuevo.getCodigo();
    }

    @Override
    public int actualizarMedico(ActualizarMedicoAdminDTO medicoDTO) throws Exception {

        Optional<Medico> opcional = medicoRepo.findByCedula(medicoDTO.cedula());
        if(opcional.isEmpty()){
            throw new Exception("Medico no existe");
        }
        Medico medicoEncontrado = opcional.get();
        medicoEncontrado.setCedula(medicoDTO.cedula());
        medicoEncontrado.setEspecialidad(medicoDTO.especialidad());
        medicoEncontrado.setJornada(medicoDTO.jornada());

        medicoRepo.save(medicoEncontrado);

        return medicoEncontrado.getCodigo();
    }

    @Override
    public List<InfoMedicoDTO> listarMedicos() throws Exception {
        List<Medico> listaMedicos = medicoRepo.findAll();
        if(listaMedicos.isEmpty()){
            throw new Exception("No hay medicos");
        }
        List<InfoMedicoDTO> medicosEncontrados = new ArrayList<>();
        for (Medico medico: listaMedicos) {
            medicosEncontrados.add(new InfoMedicoDTO(
                    medico.getNombre(),
                    medico.getCedula(),
                    medico.getCiudad(),
                    medico.getEspecialidad(),
                    medico.getTelefono(),
                    medico.getEmail(),
                    medico.getJornada(),
                    medico.getEstado()) );
        }
        return medicosEncontrados;
    }

    @Override                           //REVISAR LA PARTE DE FILTRAR POR ESPECIALIDAD
    public InfoMedicoDTO obtenerMedico(String cedula) throws Exception {
        Optional<Medico> opcional = medicoRepo.findByCedula(cedula);
        if (opcional.isEmpty()){
            throw new Exception("Medico no existe");
        }
        Medico medicoEncontrado = opcional.get();
        return new InfoMedicoDTO(
                medicoEncontrado.getNombre(),
                medicoEncontrado.getCedula(),
                medicoEncontrado.getCiudad(),
                medicoEncontrado.getEspecialidad(),
                medicoEncontrado.getTelefono(),
                medicoEncontrado.getEmail(),
                medicoEncontrado.getJornada(),
                medicoEncontrado.getEstado()
        );
    }

    @Override
    public List<InfoPqrsDTO> filtrarPQRSEstado(int estado) throws Exception {

        List<Pqrs> lista = pqrsRepo.findByEstado(estado);
        if(lista.isEmpty()){
            throw new Exception("No hay ningun pqrs con el estado: " + EstadoPqrs.values()[estado]);
        }
        List<InfoPqrsDTO> pqrsEncontrados = new ArrayList<>();
        for (Pqrs p:lista) {
            pqrsEncontrados.add(new InfoPqrsDTO(
                    p.getCodigo(),
                    p.getTipo(),
                    p.getEstado(),
                    p.getFechaCreacion()
            ));
        }
        return pqrsEncontrados;
    }

    @Override
    public List<InfoPqrsDTO> listarPQRS() throws Exception {
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        if(listaPqrs.isEmpty()){
            throw new Exception("No hay ningun Pqrs");
        }
        List<InfoPqrsDTO> pqrsEncontrados = new ArrayList<>();
        for (Pqrs p:listaPqrs) {
            pqrsEncontrados.add(new InfoPqrsDTO(
                    p.getCodigo(),
                    p.getTipo(),
                    p.getEstado(),
                    p.getFechaCreacion()
            ));
        }
        return pqrsEncontrados;
    }

    @Override
    public String responderPQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public DetallePqrsDTOAdmin verDetallePQRS(int codigo) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigo);
        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el codigo: " + codigo);
        }
        Pqrs pqrs = opcional.get();
        return new DetallePqrsDTOAdmin(
                pqrs.getCodigo(),
                pqrs.getTipo(),
                pqrs.getEstado(),
                pqrs.getFechaCreacion(),
                pqrs.getDescripcion(),
                convertirMensajes(pqrs.getMensajes())
        );
    }

    private List<MensajePqrsDTO> convertirMensajes(List<MensajePqrs> mensajes) {
        List<MensajePqrsDTO> listaMensajes = new ArrayList<>();
        for (MensajePqrs m: mensajes) {
            listaMensajes.add(new MensajePqrsDTO(
                    m.getCodigo(),
                    m.getTexto(),
                    m.getFecha()) );
        }
        return listaMensajes;
    }

    @Override
    public List<InfoCitaDTOAdmin> listarCitas() throws Exception {
        List<Cita>listaCitas = citaRepo.findAll();
        if(listaCitas.isEmpty()){
            throw new Exception("No hay citas para mostrar");
        }
        List<InfoCitaDTOAdmin> citasEncontradas = new ArrayList<>();
        for (Cita c:listaCitas) {
            citasEncontradas.add(new InfoCitaDTOAdmin(
                    c.getCodigo(),
                    c.getEstado(),
                    c.getFechaCita(),
                    c.getPaciente().getNombre()) );
        }
        return citasEncontradas;
    }

    @Override
    public List<DetalleCitaDTOAdmin> verDetalleCitas() throws Exception {
        return null;
    }

}
