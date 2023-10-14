package co.edu.uniquindio.servicios.impl;

import co.edu.uniquindio.dto.CompartidosDTOs.DetalleCitaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.RegistroRespuestaDTO;
import co.edu.uniquindio.modelo.entidades.Cita;
import co.edu.uniquindio.modelo.entidades.MensajePqrs;
import co.edu.uniquindio.modelo.entidades.Pqrs;
import co.edu.uniquindio.repositorios.CitaRepo;
import co.edu.uniquindio.repositorios.MensajePqrsRepo;
import co.edu.uniquindio.repositorios.PqrsRepo;
import co.edu.uniquindio.servicios.interfaces.ServicioGeneral;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service("ServicioGeneral")
@AllArgsConstructor
public class ServicioGeneralImpl implements ServicioGeneral {

    private final CitaRepo citaRepo;
    private final PqrsRepo pqrsRepo;
    private final MensajePqrsRepo mensajePqrsRepo;

    @Override
    public DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception {
        Optional<Cita> opcional = citaRepo.findById(codigoCita);
        if(opcional.isEmpty()){
            throw new Exception("No hay contenido para mostrar");
        }
        Cita c = opcional.get();
        return new DetalleCitaDTO(
                c.getFechaCita(),
                c.getMedico().getNombre(),
                c.getPaciente().getNombre(),
                c.getPaciente().getTipoSangre(),
                c.getMotivo(),
                c.getAtencionMedica().getSintomasPaciente(),
                c.getAtencionMedica().getDiagnostico(),
                c.getAtencionMedica().getTratamiento(),
                c.getAtencionMedica().getNota()
        );
    }

    @Override //REVISAR
    public int responderPQRS(RegistroRespuestaDTO dto) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(dto.codigoPqrs());
        if(opcional.isEmpty()){
            throw new Exception();
        }
        MensajePqrs mensajeNuevo = new MensajePqrs();
        mensajeNuevo.setPqrs(opcional.get());
        mensajeNuevo.setFecha(LocalDateTime.now());
        mensajeNuevo.setTexto(dto.mensaje());

        MensajePqrs respuesta = mensajePqrsRepo.save(mensajeNuevo);
        return respuesta.getCodigo();
    }
}
