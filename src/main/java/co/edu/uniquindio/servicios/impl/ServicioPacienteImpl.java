package co.edu.uniquindio.servicios.impl;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetallePqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.InfoPqrsDTO;
import co.edu.uniquindio.dto.extrasDTOs.EmailDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.MensajePqrsDTO;
import co.edu.uniquindio.dto.PacienteDTOs.*;
import co.edu.uniquindio.modelo.entidades.*;
import co.edu.uniquindio.modelo.enumeraciones.*;
import co.edu.uniquindio.repositorios.*;
import co.edu.uniquindio.servicios.interfaces.ServicioEmail;
import co.edu.uniquindio.servicios.interfaces.ServicioPaciente;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ServicioPaciente")
@AllArgsConstructor
public class ServicioPacienteImpl implements ServicioPaciente {

    private final PacienteRepo pacienteRepo;
    private final CitaRepo citaRepo;
    private final PqrsRepo pqrsRepo;
    private final MedicoRepo medicoRepo;
    private final DiaLibreRepo diaLibreRepo;
    private final PersonaRepo personaRepo;


    @Override
    public int registrarPaciente(RegistroPacienteDTO pacienteDTO) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Persona opcional = personaRepo.buscarPorCedula(pacienteDTO.cedula());
        if(opcional != null){
            System.out.println(pacienteDTO.cedula());
            throw new Exception("Ya existe el usuario");
        }
        Paciente pacienteNuevo = new Paciente();
        pacienteNuevo.setEmail(pacienteDTO.correo());
        pacienteNuevo.setContrasenia(encoder.encode(pacienteDTO.contrasenia()));
        pacienteNuevo.setCedula(pacienteDTO.cedula());
        pacienteNuevo.setNombre(pacienteDTO.nombre());
        pacienteNuevo.setTelefono(pacienteDTO.telefono());
        pacienteNuevo.setFoto(pacienteDTO.fotoUrl());
        pacienteNuevo.setCiudad(pacienteDTO.ciudad());
        pacienteNuevo.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        pacienteNuevo.setTipoSangre(pacienteDTO.tipoSangre());
        pacienteNuevo.setAlergia(pacienteDTO.alergias());
        pacienteNuevo.setEps(pacienteDTO.eps());

        pacienteRepo.save(pacienteNuevo);
        return pacienteNuevo.getCodigo();
    }

    @Override
    public int editarInfoBasica(EditarPerfilPacienteDTO pacienteDTO) throws Exception {
        Optional<Paciente> opcional = pacienteRepo.findById(pacienteDTO.codigo());
        if(opcional.isEmpty()){
            throw new Exception("Error al actualizar la informacion");
        }
        Paciente pacienteEncontrado = opcional.get();
        pacienteEncontrado.setCiudad(pacienteDTO.ciudad());
        pacienteEncontrado.setTelefono(pacienteDTO.telefono());
        pacienteEncontrado.setAlergia(pacienteDTO.alergias());
        pacienteEncontrado.setFoto(pacienteDTO.fotoUrl());

        pacienteRepo.save(pacienteEncontrado);
        return pacienteEncontrado.getCodigo();
    }

    @Override
    public void eliminarCuenta(EliminarCuentaDTO eCuentaDTO) throws Exception {
        Optional<Paciente> opcional = pacienteRepo.findById(eCuentaDTO.codigo());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if((opcional.isEmpty())||!(encoder.matches(opcional.get().getContrasenia(), eCuentaDTO.contrasenia()))){
            throw new Exception("error, no se puede eliminar la cuenta");
        }
        Paciente paciente = opcional.get();
        pacienteRepo.delete(paciente);
    }



    @Override
    public int crearPQRS(CrearPqrsDTO pqrsDTO) throws Exception {
        Optional<Cita> opcional = citaRepo.findById(pqrsDTO.codigoCita());
        Long cantidadPqrsActivos = pqrsRepo.contarActivos(EstadoPqrs.EN_PROCESO);
        if(opcional.isEmpty() || cantidadPqrsActivos >=3){
            throw new Exception("Error, no puede tener mas de tres solicitudes en estado EN PROCESO");
        }
        Pqrs pqrs = new Pqrs();
        pqrs.setTipo(pqrsDTO.tipoSolicitud());
        pqrs.setEstado(EstadoPqrs.NUEVO);
        pqrs.setFechaCreacion(LocalDateTime.now());
        pqrs.setCodigoCita(opcional.get());
        pqrs.setDescripcion(pqrsDTO.motivo());

        pqrsRepo.save(pqrs);
        return pqrs.getCodigo();
    }

    @Override
    public List<InfoPqrsDTO> listarPQRSPaciente(int codigoPaciente) throws Exception{
        List<Pqrs> listaAux = pqrsRepo.buscarPorCitasDePaciente(codigoPaciente);
        if(listaAux.isEmpty()){
            throw new Exception("No hay contenido para mostrar");
        }
        List<InfoPqrsDTO> listaPqrs = new ArrayList<>();
        for (Pqrs p : listaAux) {
            listaPqrs.add(new InfoPqrsDTO(
                    p.getCodigo(),
                    p.getTipo(),
                    p.getEstado(),
                    p.getFechaCreacion(),
                    p.getDescripcion()
            ));
        }
        return listaPqrs;
    }

    @Override
    public List<InfoPqrsDTO> filtrarPqrsPorTipo(FiltroPqrsTipoDTO dto) throws Exception{
        TipoPqrs t = TipoPqrs.values()[dto.tipoPqrs()];
        List<Pqrs> listaAux = pqrsRepo.findAllByCodigoCitaPacienteCodigoAndTipo(dto.codigoPaciente(),t);
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoPqrsDTO> listaPqrs = new ArrayList<>();
        for (Pqrs p : listaAux) {
            listaPqrs.add(new InfoPqrsDTO(
                    p.getCodigo(),
                    p.getTipo(),
                    p.getEstado(),
                    p.getFechaCreacion(),
                    p.getDescripcion()
            ));
        }
        return listaPqrs;
    }

    @Override
    public DetallePqrsDTO verDetallePqrs(int codigo) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findByCodigo(codigo);
        if(opcional.isEmpty()){
            throw new Exception("No hay un pqrs con el codigo: " + codigo);
        }
        Pqrs p = opcional.get();
        return new DetallePqrsDTO(
                p.getCodigo(),
                p.getTipo(),
                p.getEstado(),
                p.getFechaCreacion(),
                p.getDescripcion(),
                convertirMensajes(p.getMensajes())
        );
    }

    public List<MensajePqrsDTO> convertirMensajes(List<MensajePqrs> mensajes) {
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
    public List<ItemMedicoDTO> listarMedicosEspecialidad(int codigoEspecialidad) throws Exception{
        Especialidad e = Especialidad.values()[codigoEspecialidad];
        List<Medico> listaAux = medicoRepo.findAllByEspecialidad(e);
        if(listaAux.isEmpty()){
            throw new Exception("No hay medicos para mostrar");
        }
        List<ItemMedicoDTO> medicos = new ArrayList<>();
        for (Medico m: listaAux) {
            if(m.getEstado() == EstadoMedico.A){ //SOLO SE LISTAN LOS MEDICOS ACTIVOS
                medicos.add(new ItemMedicoDTO(
                        m.getCodigo(),
                        m.getEspecialidad()
                ));
            }
        }
        return medicos;
    }

    @Override
    public List<ItemFechaMedicoDTO> listarFechasMedico(int idMedico) throws Exception{
        Optional<Medico> medicoOptional = medicoRepo.findById(idMedico);
        List<Cita> citasAgendadas = citaRepo.findAllByMedicoCodigoAndFechaCitaGreaterThanEqual(idMedico, LocalDateTime.now());
        List<LocalDateTime> horarios = new ArrayList<>();
        List<DiaLibre> diasLibres = diaLibreRepo.findAllByMedicoCodigo(idMedico);

        if(medicoOptional.isEmpty()){ //Se verifica que el opcional no esta vacio
            throw new Exception("No hay contenido para mostrar");
        }
        //Se obtiene el contenido del opcional
        Medico encontrado = medicoOptional.get();
        //Se verifica cuales son las citas que estan disponibles
        LocalDateTime fecha = LocalDateTime.now();

        while( fecha.isBefore( LocalDateTime.now().plusDays(5) ) ) {
            if (medicoOptional.get().getJornada() == Jornada.DIURNA) { //Verificacion si jornada es Diurna
                LocalTime hora = LocalTime.of(7, 0);
                for (DiaLibre diaLibre : diasLibres) { //No se tienen en cuenta para listar los dias libres
                    if(!fecha.isEqual(diaLibre.getFecha())) {

                        while (hora.isBefore(LocalTime.of(19, 0))) {
                            if (!estaOcupado(citasAgendadas, hora)) {
                                horarios.add(LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), hora.getHour(), hora.getMinute()));
                            }
                            hora = hora.plusMinutes(30);
                        }
                    }
                }

                fecha = fecha.plusDays(1);
            } else{                                                    //Verificacion si jornada es Nocturna
                LocalTime hora = LocalTime.of(10, 0);
                for (DiaLibre diaLibre : diasLibres) { //No se tienen en cuenta para listar los dias libres
                    if(!fecha.isEqual(diaLibre.getFecha())) {

                        while (hora.isBefore(LocalTime.of(19, 0))) {
                            if (!estaOcupado(citasAgendadas, hora)) {
                                horarios.add(LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), hora.getHour(), hora.getMinute()));
                            }
                            hora = hora.plusMinutes(30);
                        }
                    }
                }
            }
        }
        //Se crea una lista de ItemFechaMedicoDTO y se rellena con cada uno de los elementos de la lista
        //con los datos correspondientes
        return getItemFechaMedicoDTOS(horarios, encontrado);
    }

    private List<ItemFechaMedicoDTO> getItemFechaMedicoDTOS(List<LocalDateTime> horarios, Medico encontrado) {
        List<ItemFechaMedicoDTO> disponibles = new ArrayList<>();
        for(LocalDateTime h : horarios) {
            disponibles.add(new ItemFechaMedicoDTO(
                    LocalDate.of(h.getYear(),h.getMonth(),h.getDayOfMonth()),
                    LocalTime.of(h.getHour(),h.getMinute()),
                    encontrado.getNombre()
            ));
        }
        return disponibles;
    }

    public boolean estaOcupado(List<Cita> citasAgendadas, LocalTime hora) {
        for(Cita c: citasAgendadas){
            if(c.getHoraCita().equals(hora)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int agendarCita(AgendarCitaDTO citaDTO) throws Exception{

        Optional<Medico>medicoOptional = medicoRepo.findById(citaDTO.codigoMedico());
        Optional<Paciente>pacienteOptional = pacienteRepo.findById(citaDTO.codigoPaciente());
        if(medicoOptional.isEmpty()||pacienteOptional.isEmpty()){
            throw new Exception("Error");
        }
        Cita citaNueva = new Cita();
        citaNueva.setFechaCreacion(LocalDateTime.now());
        citaNueva.setFechaCita(citaDTO.fechaCita());
        citaNueva.setHoraCita(citaDTO.horaCita());
        citaNueva.setMotivo(citaDTO.motivoCita());
        citaNueva.setEstado(EstadoCita.PROGRAMADA);
        citaNueva.setMedico(medicoOptional.get());
        citaNueva.setPaciente(pacienteOptional.get());

        citaRepo.save(citaNueva);
        return citaNueva.getCodigo();
    }

    @Override //LISTA TODAS LAS CITAS
    public List<InfoCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception{
        List<Cita> listaOpcional = citaRepo.buscarPorIdPaciente(codigoPaciente);
        if(listaOpcional.isEmpty()){
            throw new Exception("No hay citas para mostrar");
        }
        List<InfoCitaDTO> listaCitas = new ArrayList<>();
        for (Cita c: listaOpcional) {
            listaCitas.add(new InfoCitaDTO(
                    c.getCodigo(),
                    c.getMedico().getEspecialidad(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getNombre()
            ));
        }
        return listaCitas;
    }


    @Override
    public List<InfoCitaDTO> filtrarCitasPorMedico(FiltroCitaMedicoDTO filtroDTO) throws Exception {

        List<Cita> listaAux = citaRepo.findAllByPacienteCodigoAndMedicoNombre(filtroDTO.codigoPaciente(), filtroDTO.nombreMedico());
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTO> listaCitas = new ArrayList<>();
        for (Cita c : listaAux) {
            listaCitas.add(new InfoCitaDTO(
                    c.getCodigo(),
                    c.getMedico().getEspecialidad(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getNombre()
            ));
        }
        return listaCitas;
    }

    @Override
    public List<InfoCitaDTO> filtrarCitasPorFecha(FiltroCitaFechaDTO filtroDTO) throws Exception {
        List<Cita> listaAux = citaRepo.findAllByPacienteCodigoAndFechaCita(filtroDTO.codigoPaciente(), filtroDTO.fecha());
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTO> listaCitas = new ArrayList<>();
        for (Cita c : listaAux) {
            listaCitas.add(new InfoCitaDTO(
                    c.getCodigo(),
                    c.getMedico().getEspecialidad(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getNombre()
            ));
        }
        return listaCitas;
    }

    @Override
    public List<InfoCitaDTO> filtrarCitasPorEspecialidad(FiltroCitaEspDTO filtroDTO) throws Exception {
        Especialidad e = Especialidad.values()[filtroDTO.codigoEspecialidad()];
        List<Cita> listaAux = citaRepo.findAllByPacienteCodigoAndMedicoEspecialidad(filtroDTO.codigoPaciente(), e);
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTO> listaCitas = new ArrayList<>();
        for (Cita c : listaAux) {
            listaCitas.add(new InfoCitaDTO(
                    c.getCodigo(),
                    c.getMedico().getEspecialidad(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getNombre()
            ));
        }
        return listaCitas;
    }

    @Override
    public List<InfoCitaDTO> filtrarCitasPorMedicoFechaEspecialidad(FiltroMedFechaEspDTO filtroDTO) throws Exception {
        Especialidad e = Especialidad.values()[filtroDTO.especialidad()];
        List<Cita> listaAux = citaRepo.filtrar(filtroDTO.codigoPaciente(), filtroDTO.nombreMedico(), filtroDTO.fecha(),e);
        if (listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTO> listaCitas = new ArrayList<>();
        for (Cita c: listaAux) {
            listaCitas.add(new InfoCitaDTO(
                    c.getCodigo(),
                    c.getMedico().getEspecialidad(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getNombre()
            ));
        }
        return listaCitas;
    }

}
