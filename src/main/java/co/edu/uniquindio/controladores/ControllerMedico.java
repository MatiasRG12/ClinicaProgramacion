package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetalleCitaDTO;
import co.edu.uniquindio.dto.MedicoDTOs.*;
import co.edu.uniquindio.dto.extrasDTOs.MensajeDTO;
import co.edu.uniquindio.servicios.interfaces.ServicioGeneral;
import co.edu.uniquindio.servicios.interfaces.ServicioMedico;
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
@RequiredArgsConstructor
@Validated
@RequestMapping("/inicioMedico")
public class ControllerMedico {

    private final ServicioMedico servicioMedico;
    private final ServicioGeneral servicioGeneral;
    private final MessageSource ms;

    @PutMapping("/infoPersonal/editarInfo")
    public ResponseEntity<MensajeDTO<Integer>> editarInfoBasica(@Valid @RequestBody EditarPerfilMedicoDTO dto) throws Exception{
        int codigoMedico = servicioMedico.editarInfoBasica(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null, LocaleContextHolder.getLocale()),codigoMedico));
    }

    //Compartido
    @PutMapping("/infoPersonal/cambiarContrasenia")
    public ResponseEntity<MensajeDTO<String>> cambiarContrasenia(@Valid @RequestBody CambiarContraseniaDTO dto)throws Exception{
        servicioGeneral.cambiarPassword(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),null));
    }

    //METODOS RESTANTES (SERVICIOGENERAL)

    @GetMapping("/citasMedicas/listarCitasHoy/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTOMedico>>> listarCitasHoy(@PathVariable int codigoMedico)throws Exception{
        List<InfoCitaDTOMedico> citasMedico = servicioMedico.listarCitasHoy(codigoMedico);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),citasMedico));
    }

    @GetMapping("/citasMedicas/listarCitasProx/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTOMedico>>> listarCitasProximas(@PathVariable int codigoMedico)throws Exception{
        List<InfoCitaDTOMedico> citasMedico = servicioMedico.listarCitasProximas(codigoMedico);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),citasMedico));
    }

    @GetMapping("/citasMedicas/atender/{codigoCita}")
    public ResponseEntity<MensajeDTO<DatosCitaDTO>> atenderCita(@PathVariable int codigoCita) throws Exception{
        DatosCitaDTO datos = servicioMedico.atenderCita(codigoCita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),datos));
    }

    @GetMapping("/citasMedicas/listar/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<InfoCitaHistorialPacienteDTO>>> listarHistorialMedicoPaciente(@PathVariable int codigoPaciente)throws Exception{
        List<InfoCitaHistorialPacienteDTO> historialPaciente = servicioMedico.listarHistorialMedicoPaciente(codigoPaciente);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),historialPaciente));
    }

    //Compartido
    @GetMapping("/citasMedicas/verDetalle/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleCitaDTO>> verDetalleCita(@PathVariable int codigoCita) throws Exception{
        DetalleCitaDTO detalleCita = servicioGeneral.verDetalleCita(codigoCita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),detalleCita));
    }

    @PutMapping("/citasMedicas/finalizarAtencion")
    public ResponseEntity<MensajeDTO<String>> finalizarAtencionCita(@Valid @RequestBody AtencionMedicaDTO dto) throws Exception {
        servicioMedico.finalizarAtencionCita(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),null));
    }

    @PutMapping("/disponibilidad/diaLibre")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO) throws Exception{
        servicioMedico.agendarDiaLibre(diaLibreDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),null));
    }

    @GetMapping("/historialAtenciones/listarHistorial/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTOMedico>>> listarHistorialAtenciones(@PathVariable int codigoMedico) throws Exception{
        List<InfoCitaDTOMedico> historialAtenciones = servicioMedico.listarHistorialAtenciones(codigoMedico);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),historialAtenciones));
    }

}
