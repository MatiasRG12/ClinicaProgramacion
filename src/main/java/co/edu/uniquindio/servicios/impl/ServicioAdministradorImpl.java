package co.edu.uniquindio.servicios.impl;


import co.edu.uniquindio.dto.AdminDTOs.*;
import co.edu.uniquindio.dto.CompartidosDTOs.InfoPqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetallePqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.MensajePqrsDTO;
import co.edu.uniquindio.modelo.entidades.*;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.repositorios.*;
import co.edu.uniquindio.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final AdminRepo adminRepo;
    private final MessageSource ms;

    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (medicoRepo.findByCedula(medicoDTO.cedula()).isPresent()) {
            throw new Exception("Medico ya existe");
        }
        Medico medicoNuevo = new Medico();
        medicoNuevo.setEmail(medicoDTO.correo());
        medicoNuevo.setContrasenia(encoder.encode(medicoDTO.password()));
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
        if (opcional.isEmpty()) {
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
        if (listaMedicos.isEmpty()) {
            throw new Exception("No hay medicos");
        }
        List<InfoMedicoDTO> medicosEncontrados = new ArrayList<>();
        for (Medico medico : listaMedicos) {
            medicosEncontrados.add(new InfoMedicoDTO(
                    medico.getCedula(),
                    medico.getCedula(),
                    medico.getEspecialidad())
            );
        }
        return medicosEncontrados;
    }

    @Override
    public DetalleMedicoDTO verDetalleMedico(int codigoMedico) throws Exception {
        Optional<Medico> opcional = medicoRepo.findById(codigoMedico);
        if (opcional.isEmpty()) {
            throw new Exception("Medico no existe");
        }
        Medico medicoEncontrado = opcional.get();
        return new DetalleMedicoDTO(
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
    public List<InfoMedicoDTO> filtrarMedicosNombre(String nombreMedico) throws Exception {
        List<Medico> listaAux = medicoRepo.findAllByNombre(nombreMedico);
        if (listaAux.isEmpty()){
            throw new Exception("No hay medicos con ese nombre");
        }
        List<InfoMedicoDTO> listaMedicos = new ArrayList<>();
        for (Medico m : listaAux) {
            listaMedicos.add(new InfoMedicoDTO(
                    m.getNombre(),
                    m.getCedula(),
                    m.getEspecialidad()
            ));
        }
        return listaMedicos;
    }

    @Override
    public List<InfoMedicoDTO> filtrarMedicosEspecialidad(int codigoEspecialidad) throws Exception {
        List<Medico> listaAux = medicoRepo.findAllByEspecialidad(Especialidad.values()[codigoEspecialidad]);
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoMedicoDTO> listaMedicos = new ArrayList<>();
        for (Medico m : listaAux) {
            listaMedicos.add(new InfoMedicoDTO(
                    m.getNombre(),
                    m.getCedula(),
                    m.getEspecialidad()
            ));
        }
        return null;
    }

    @Override
    public List<InfoMedicoDTO> filtrarMedicosNombreEspecialidad(FiltroMedicosNomEspDTO dto) throws Exception {
        Especialidad e = Especialidad.values()[dto.codigoEspecialidad()];
        List<Medico> listaAux = medicoRepo.findAllByNombreAndEspecialidad(dto.nombre(),e);
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoMedicoDTO> listaMedicos = new ArrayList<>();
        for (Medico m : listaAux) {
            listaMedicos.add(new InfoMedicoDTO(
                    m.getNombre(),
                    m.getCedula(),
                    m.getEspecialidad()
            ));
        }
        return listaMedicos;
    }

    @Override
    public List<InfoPqrsDTO> filtrarPQRSEstado(int estado) throws Exception {
        List<Pqrs> lista = pqrsRepo.findAllByEstado(EstadoPqrs.values()[estado]);
        if (lista.isEmpty()) {
            throw new Exception("No hay ningun pqrs con el estado: " + EstadoPqrs.values()[estado]);
        }
        List<InfoPqrsDTO> pqrsEncontrados = new ArrayList<>();
        for (Pqrs p : lista) {
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
    public String verMotivo(int codigoPqrs) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPqrs);
        if(opcional.isEmpty()){
            throw new Exception();
        }
        Pqrs p = opcional.get();
        return p.getDescripcion();
    }

    @Override
    public void escogerPqrs(int codigoPqrs, int codigoAdmin) throws Exception {
        Optional<Pqrs> opcionalPqrs = pqrsRepo.findById(codigoPqrs);
        Optional<Administrador> opcionalAdmin= adminRepo.findById(codigoAdmin);
        if(opcionalPqrs.isEmpty() || opcionalAdmin.isEmpty()){
            throw new Exception();
        }
        Pqrs p = opcionalPqrs.get();
        p.setAdministrador(opcionalAdmin.get());

        pqrsRepo.save(p);
    }

    @Override
    public List<InfoPqrsDTO> listarPQRS() throws Exception {
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        if (listaPqrs.isEmpty()) {
            throw new Exception("No hay ningun Pqrs");
        }
        List<InfoPqrsDTO> pqrsEncontrados = new ArrayList<>();
        for (Pqrs p : listaPqrs) {
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
    public DetallePqrsDTO verDetallePQRS(int codigo) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigo);
        if (opcional.isEmpty()) {
            throw new Exception("No existe un PQRS con el codigo: " + codigo);
        }
        Pqrs pqrs = opcional.get();
        return new DetallePqrsDTO(
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
    public void cambiarEstadoPQRS(int codigoPqrs, int estado) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPqrs);
        if(opcional.isEmpty()){
            throw new Exception("No es posible cambiar el estado");
        }
        Pqrs p = opcional.get();
        p.setEstado(EstadoPqrs.values()[estado]);
        pqrsRepo.save(p);
    }

    @Override
    public List<InfoCitaDTOAdmin> listarCitasAdmin() throws Exception {
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
    public List<InfoCitaDTOAdmin> filtrarPorMedico(String nombreMedico) throws Exception {
        List<Cita> listaAux = citaRepo.findAllByMedicoNombre(nombreMedico);
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTOAdmin> listaCitas = new ArrayList<>();
        for (Cita c : listaAux) {
            listaCitas.add(new InfoCitaDTOAdmin(
                    c.getCodigo(),
                    c.getEstado(),
                    c.getFechaCita(),
                    c.getPaciente().getNombre()
            ));
        }
        return listaCitas;
    }

}
