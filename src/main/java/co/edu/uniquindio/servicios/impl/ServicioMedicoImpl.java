package co.edu.uniquindio.servicios.impl;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.MedicoDTOs.*;
import co.edu.uniquindio.modelo.entidades.AtencionMedica;
import co.edu.uniquindio.modelo.entidades.Cita;
import co.edu.uniquindio.modelo.entidades.DiaLibre;
import co.edu.uniquindio.modelo.entidades.Medico;
import co.edu.uniquindio.repositorios.AtencionMedicaRepo;
import co.edu.uniquindio.repositorios.CitaRepo;
import co.edu.uniquindio.repositorios.DiaLibreRepo;
import co.edu.uniquindio.repositorios.MedicoRepo;
import co.edu.uniquindio.servicios.interfaces.ServicioMedico;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ServicioMedico")
@AllArgsConstructor
public class ServicioMedicoImpl implements ServicioMedico {

    private final MedicoRepo medicoRepo;
    private final CitaRepo citaRepo;
    private final AtencionMedicaRepo atencionMedicaRepo;
    private final DiaLibreRepo diaLibreRepo;

    @Override
    public int editarInfoBasica(EditarPerfilMedicoDTO dto) throws Exception {
        Optional<Medico> opcional = medicoRepo.findById(dto.codigo());
        if(opcional.isEmpty()){
            throw new Exception("No es posible editar la informacion");
        }
        Medico m = opcional.get();
        m.setCiudad(dto.ciudad());
        m.setTelefono(dto.telefono());
        m.setFoto(dto.urlFoto());

        medicoRepo.save(m);
        return m.getCodigo();
    }

    @Override
    public List<InfoCitaDTOMedico> listarCitasHoy(int codigoMedico) throws Exception {
        List<Cita> listaAux =  citaRepo.findAllByMedicoCodigoAndFechaCitaEquals(codigoMedico,LocalDateTime.now());
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTOMedico> listaCitas = new ArrayList<>();
        for (Cita c : listaAux) {
            listaCitas.add(new InfoCitaDTOMedico(
                    c.getCodigo(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getPaciente().getNombre()
            ));
        }
        return listaCitas;
    }

    @Override
    public DatosCitaDTO atenderCita(int codigoCita) throws Exception{
        Optional<Cita> opcional = citaRepo.findById(codigoCita);
        if(opcional.isEmpty()){
            throw new Exception();
        }
        Cita cita = opcional.get();
        return new DatosCitaDTO(
                cita.getFechaCita(),
                cita.getMedico().getNombre(),
                cita.getPaciente().getNombre(),
                cita.getPaciente().getTipoSangre(),
                cita.getMotivo()
        );
    }

    @Override
    public void finalizarAtencionCita(AtencionMedicaDTO dto) throws Exception {
        Optional<Cita> opcional = citaRepo.findById(dto.codigoCita());
        if(opcional.isEmpty()){
            throw new Exception();
        }
        AtencionMedica atencion = new AtencionMedica();
        Cita cita = opcional.get();
        atencion.setCita(cita);
        atencion.setSintomasPaciente(dto.sintomasPaciente());
        atencion.setDiagnostico(dto.diagnostico());
        atencion.setTratamiento(dto.tratamiento());
        atencion.setNota(dto.notas());

        atencionMedicaRepo.save(atencion);
    }

    @Override
    public List<InfoCitaDTOMedico> listarCitasProximas(int codigoMedico) throws Exception {
        List<Cita> listaAux = citaRepo.findAllByMedicoCodigoAndFechaCitaGreaterThanEqual(codigoMedico,LocalDateTime.now());
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTOMedico> listaCitas = new ArrayList<>();
        for (Cita c : listaAux) {
            listaCitas.add(new InfoCitaDTOMedico(
                    c.getCodigo(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getPaciente().getNombre()
            ));
        }
        return listaCitas;
    }

    @Override
    public List<InfoCitaHistorialPacienteDTO> listarHistorialMedicoPaciente(int codigoPaciente) throws Exception {
        List<Cita> listaAux = citaRepo.buscarPorIdPaciente(codigoPaciente);
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaHistorialPacienteDTO> listaCitasHistorial = new ArrayList<>();
        for (Cita c : listaAux) {
            listaCitasHistorial.add(new InfoCitaHistorialPacienteDTO(
                    c.getCodigo(),
                    c.getEstado(),
                    c.getFechaCita(),
                    c.getMedico().getNombre()
            ));
        }
        return listaCitasHistorial;
    }

    @Override
    public void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        Optional<DiaLibre> opcional = diaLibreRepo.findByFecha(diaLibreDTO.fecha());
        List<Cita> citasMedico = citaRepo.findAllByMedicoCodigo(diaLibreDTO.codigoMedico());

        //Si la fecha del dia encontrado es despues de hoy o es hoy, no se puede agendar
        if(opcional.isPresent() && opcional.get().getFecha().isAfter(LocalDateTime.now())
                ||(opcional.isPresent())&&opcional.get().getFecha().isEqual(LocalDateTime.now())){
            throw new Exception("No se puede tener mas de un dia libre agendado");
        } else if (!citasMedico.isEmpty()) {
            for (Cita cita : citasMedico) {
                //Si la fecha de la cita es igual a la que se quiere agendar, no se puede agendar
                if(cita.getFechaCita().equals(diaLibreDTO.fecha())){
                    throw new Exception("No se puede agendar porque este dia ya tiene citas por atender");
                }
            }
        }

        Optional<Medico> opcionalMedico = medicoRepo.findById(diaLibreDTO.codigoMedico());
        if(opcionalMedico.isEmpty()){
            throw new Exception();
        }
        Medico medico = opcionalMedico.get();

        DiaLibre diaLibre = new DiaLibre();
        diaLibre.setFecha(diaLibreDTO.fecha());
        diaLibre.setMedico(medico);

        diaLibreRepo.save(diaLibre);
    }

    @Override
    public List<InfoCitaDTOMedico> listarHistorialAtenciones(int codigoMedico) throws Exception{
        List<Cita> listaAux = citaRepo.findAllByMedicoCodigo(codigoMedico);
        if(listaAux.isEmpty()){
            throw new Exception();
        }
        List<InfoCitaDTOMedico> listaCitas = new ArrayList<>();
        for (Cita cita : listaAux) {
            if (cita.getFechaCita().isBefore(LocalDateTime.now())){//SOLO LISTA LAS CITAS DE DIAS ANTERIORIES A HOY
                listaCitas.add(new InfoCitaDTOMedico(
                        cita.getCodigo(),
                        cita.getFechaCita(),
                        cita.getHoraCita(),
                        cita.getPaciente().getNombre()
                ));
            }

        }
        return listaCitas;
    }
}
