package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.CompartidosDTOs.ReestablecerContraseniaDTO;
import co.edu.uniquindio.dto.PacienteDTOs.RegistroPacienteDTO;
import co.edu.uniquindio.dto.extrasDTOs.LoginDTO;
import co.edu.uniquindio.dto.extrasDTOs.MensajeDTO;
import co.edu.uniquindio.servicios.interfaces.ServicioEmail;
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

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/")
public class NoAuthController {

    private final ServicioGeneral servicioGeneral;
    private final ServicioPaciente servicioPaciente;
    private final MessageSource ms;

    @PostMapping("/login")
    void login(LoginDTO loginDTO) throws Exception{

    }

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<Integer>> registrarPaciente(@Valid @RequestBody RegistroPacienteDTO pacienteDTO) throws Exception{
        int codigoRegistrado = servicioPaciente.registrarPaciente(pacienteDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null, LocaleContextHolder.getLocale()),codigoRegistrado));
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



}
