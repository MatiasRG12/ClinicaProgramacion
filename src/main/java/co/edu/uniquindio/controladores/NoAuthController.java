package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.CompartidosDTOs.ReestablecerContraseniaDTO;
import co.edu.uniquindio.dto.PacienteDTOs.RegistroPacienteDTO;
import co.edu.uniquindio.dto.extrasDTOs.LoginDTO;
import co.edu.uniquindio.dto.extrasDTOs.MensajeDTO;
import co.edu.uniquindio.dto.extrasDTOs.TokenDTO;
import co.edu.uniquindio.modelo.enumeraciones.*;
import co.edu.uniquindio.servicios.interfaces.ServicioAutenticacion;
import co.edu.uniquindio.servicios.interfaces.ServicioGeneral;
import co.edu.uniquindio.servicios.interfaces.ServicioPaciente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class   NoAuthController {

    private final ServicioAutenticacion servicioAutenticacion;
    private final ServicioGeneral servicioGeneral;
    private final ServicioPaciente servicioPaciente;
    private final MessageSource ms;

    @PostMapping("/login")
    ResponseEntity<MensajeDTO<TokenDTO>> login(@RequestBody LoginDTO loginDTO) throws Exception{
        TokenDTO codigoRegistradoLogin = servicioAutenticacion.login(loginDTO);
        //return ResponseEntity
        //  .status(HttpStatus.OK)
        //  .body(new MensajeDTO<>(false,ms.getMessage("",null, LocaleContextHolder.getLocale()),codigoRegistrado));

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "",codigoRegistradoLogin));
    }

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<Integer>> registrarPaciente(@Valid @RequestBody RegistroPacienteDTO pacienteDTO) throws Exception{
        int codigoRegistrado = servicioPaciente.registrarPaciente(pacienteDTO);
        //return ResponseEntity
              //  .status(HttpStatus.OK)
              //  .body(new MensajeDTO<>(false,ms.getMessage("",null, LocaleContextHolder.getLocale()),codigoRegistrado));

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "",codigoRegistrado));
    }

    @PostMapping("/recuperarCuenta/enviarCorreo/{correo}")
    void enviarLinkRecuperacion(@PathVariable String correo) throws Exception{
        servicioGeneral.enviarLinkRecuperacion(correo);
    }

    @PutMapping("/recuperarCuenta/restablecer")
    public ResponseEntity<MensajeDTO<Integer>> reestablecerContrasenia(@Valid @RequestBody ReestablecerContraseniaDTO dto) throws Exception{
        int codigoRestablecido = servicioGeneral.reestablecerContrasenia(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),codigoRestablecido));
    }

    @GetMapping("/listarEps")
    public ResponseEntity<MensajeDTO<List<Eps>>> listarEps() throws Exception{
      // return ResponseEntity
             //  .status(HttpStatus.OK)
               // .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),servicioGeneral.listarEps()));

        return ResponseEntity.ok().body( new MensajeDTO<>(false,"", servicioGeneral.listarEps()));
    }

    @GetMapping("/listarTipoSangre")
    public ResponseEntity<MensajeDTO<List<TipoSangre>>> listarTipoSangre() throws Exception{

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "",servicioGeneral.listarTiposSangre()));
    }

    @GetMapping("/listarEspecialidades")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecialidades() throws Exception{

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "",servicioGeneral.listarEspecialidades()));
    }

    @GetMapping("/listarTipoPqrs")
    public ResponseEntity<MensajeDTO<List<TipoPqrs>>> listarTipoPqrs() throws Exception{

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "",servicioGeneral.listarTipoPqrs()));
    }






}
