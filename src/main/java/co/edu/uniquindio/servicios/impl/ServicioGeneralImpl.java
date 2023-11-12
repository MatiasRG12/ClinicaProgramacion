package co.edu.uniquindio.servicios.impl;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetalleCitaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.ReestablecerContraseniaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.RegistroRespuestaDTO;
import co.edu.uniquindio.dto.extrasDTOs.EmailDTO;
import co.edu.uniquindio.modelo.entidades.*;
import co.edu.uniquindio.modelo.enumeraciones.Eps;
import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import co.edu.uniquindio.repositorios.*;
import co.edu.uniquindio.servicios.interfaces.ServicioEmail;
import co.edu.uniquindio.servicios.interfaces.ServicioGeneral;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("ServicioGeneral")
@AllArgsConstructor
public class ServicioGeneralImpl implements ServicioGeneral {

    private final CitaRepo citaRepo;
    private final PqrsRepo pqrsRepo;
    private final MensajePqrsRepo mensajePqrsRepo;
    private final PacienteRepo pacienteRepo;
    private final UsuarioRepo usuarioRepo;

    private final ServicioEmail servicioEmail;

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

    @Override
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

    @Override //POR AHORA SOLO SE ENVIA ESE MENSAJE SIN UN ENLACE YA QUE NO HAY CONTROLADORES AUN (NO HAY MAPEOS)
    public void enviarLinkRecuperacion(String correo) throws Exception{
        String asunto = "Clinica Salvese Quien Pueda - Recuperacion de Cuenta";
        String mensaje = "Hola, haz click en el siguiente enlace para recuperar tu cuenta: ";
        servicioEmail.enviarCorreo(new EmailDTO(correo,asunto,mensaje));
    }

    @Override
    public int reestablecerContrasenia(ReestablecerContraseniaDTO dto) throws Exception {
        Optional<Usuario> opcional = usuarioRepo.findByEmail(dto.correo());
        if(opcional.isEmpty()){
            throw new Exception();
        }
        Usuario usuario = opcional.get();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setContrasenia(encoder.encode(dto.ContraseniaNueva()));
        usuarioRepo.save(usuario);
        return usuario.getCodigo();
    }


    @Override
    public void cambiarPassword(CambiarContraseniaDTO dto) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> opcional = usuarioRepo.findById(dto.codigo());
        if(opcional.isEmpty()||!(encoder.matches(opcional.get().getContrasenia(), dto.contraseniaActual()))){
            throw new Exception("error, no se puede cambiar la contraseña");
        }
        Usuario usuarioEncontrado = opcional.get();
        usuarioEncontrado.setContrasenia(encoder.encode(dto.contraseniaNueva()));
        usuarioRepo.save(usuarioEncontrado);
    }

    //Implementacion de los metodos que listan EPS y TipoSangre
    @Override
    public List<Eps> listarEps() throws Exception {
        return List.of(Eps.values());
    }


    @Override
    public List<TipoSangre> listarTiposSangre() throws Exception {
        List<TipoSangre> listaTipoSangre = List.of(TipoSangre.values());
        if (listaTipoSangre.isEmpty()){
            throw new Exception("No hay tipos de sangre");
        }
        return listaTipoSangre;
    }

    /**
    @Override
    public List<TipoSangre> listarTiposSangre() {

        return List.of(TipoSangre.values());
    } */




}
