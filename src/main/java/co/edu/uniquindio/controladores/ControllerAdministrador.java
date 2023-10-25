package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.AdminDTOs.*;
import co.edu.uniquindio.dto.CompartidosDTOs.DetalleCitaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetallePqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.InfoPqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.RegistroRespuestaDTO;
import co.edu.uniquindio.dto.extrasDTOs.MensajeDTO;
import co.edu.uniquindio.servicios.interfaces.ServicioAdministrador;
import co.edu.uniquindio.servicios.interfaces.ServicioGeneral;
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
@RequestMapping("/inicioAdmin")
public class ControllerAdministrador {

    private final ServicioAdministrador servicioAdministrador;
    private final ServicioGeneral servicioGeneral;
    private final MessageSource ms;

    @PostMapping("/gestionPMedico/crearMedico")
    public ResponseEntity<MensajeDTO<Integer>> crearMedico(@Valid @RequestBody MedicoDTO medicoDTO) throws Exception {
        int codigoMedicoAgregado = servicioAdministrador.crearMedico(medicoDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null, LocaleContextHolder.getLocale()),codigoMedicoAgregado));
    }

    @PutMapping("/gestionPMedico/actualizarMedico")
    public ResponseEntity<MensajeDTO<Integer>> actualizarMedico(@Valid @RequestBody ActualizarMedicoAdminDTO medicoDTO) throws Exception {
        int  codigoMedicoActualizado = servicioAdministrador.actualizarMedico(medicoDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false, ms.getMessage("",null, LocaleContextHolder.getLocale()),codigoMedicoActualizado));
    }

    @GetMapping("/gestionPMedico/listarMedicos")
    public ResponseEntity<MensajeDTO<List<InfoMedicoDTO>>> listarMedicos() throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false, ms.getMessage("",null,LocaleContextHolder.getLocale()),servicioAdministrador.listarMedicos()));
    }

    @GetMapping("/gestionPMedico/detalleMedico/{cedulaMedico}")
    public ResponseEntity<MensajeDTO<DetalleMedicoDTO>> verDetalleMedico(@PathVariable String cedulaMedico) throws Exception{
    DetalleMedicoDTO detalleMedicoDTO = servicioAdministrador.verDetalleMedico(cedulaMedico);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),detalleMedicoDTO));
    }

    @GetMapping("/gestionPMedico/filtrar-nombre/{nombreMedico}")
    public ResponseEntity<MensajeDTO<List<InfoMedicoDTO>>> filtrarMedicosNombre(@PathVariable String nombreMedico) throws Exception {
        List<InfoMedicoDTO> medicos = servicioAdministrador.filtrarMedicosNombre(nombreMedico);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),medicos));
    }

    @GetMapping("/gestionPMedico/filtrar-especialidad/{codigoEspecialidad}")
    public ResponseEntity<MensajeDTO<List<InfoMedicoDTO>>> filtrarMedicosEspecialidad(@PathVariable int codigoEspecialidad) throws Exception {
        List<InfoMedicoDTO> medicos = servicioAdministrador.filtrarMedicosEspecialidad((codigoEspecialidad));
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),medicos));
    }

    @GetMapping("/gestionPMedico/filtrar-nombre-especialidad")
    public ResponseEntity<MensajeDTO<List<InfoMedicoDTO>>> filtrarMedicosNombreEspecialidad(@Valid @RequestBody FiltroMedicosNomEspDTO dto) throws Exception {
        List<InfoMedicoDTO> medicos = servicioAdministrador.filtrarMedicosNombreEspecialidad(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null, LocaleContextHolder.getLocale()),medicos));
    }

    @GetMapping("/gestionPqrs/listar")
    public ResponseEntity<MensajeDTO<List<InfoPqrsDTO>>> listarPQRS() throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),servicioAdministrador.listarPQRS()));
    }

    @GetMapping("/gestionPqrs/filtrar-estado/{estado}")
    public ResponseEntity<MensajeDTO<List<InfoPqrsDTO>>> filtrarPQRSEstado(@PathVariable int estado) throws Exception {
        List<InfoPqrsDTO> pqrs = servicioAdministrador.filtrarPQRSEstado(estado);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false, ms.getMessage("",null,LocaleContextHolder.getLocale()),pqrs));
    }

    @GetMapping("/gestionPqrs/motivoPqrs/{codigoPqrs}")
    public ResponseEntity<MensajeDTO<String>> verMotivoPQRS(@PathVariable int codigoPqrs) throws Exception {
        String motivo = servicioAdministrador.verMotivoPQRS(codigoPqrs);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),motivo));
    }

    @PostMapping("/gestionPqrs/escogerPqrs")
     public ResponseEntity<MensajeDTO<String>>escogerPQRS(@Valid @RequestBody EscogerPqrsDTO dto) throws Exception{
        servicioAdministrador.escogerPQRS(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),null));
    }

    @GetMapping("/gestionPqrs/detallePqrs/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePqrsDTO>> verDetallePQRS(@PathVariable int codigo) throws Exception {
        DetallePqrsDTO detallePqrs = servicioAdministrador.verDetallePQRS(codigo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),detallePqrs));
    }

    @PutMapping("/gestionPqrs/detallePqrs/responder")
    public ResponseEntity<MensajeDTO<Integer>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO dto)throws Exception{
        int codigoPqrs = servicioGeneral.responderPQRS(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),codigoPqrs));
    }

    @PutMapping("/gestionPqrs/detallePqrs/cambiarEstado")
    public ResponseEntity<MensajeDTO<String>> cambiarEstadoPQRS(@Valid @RequestBody CambiarEstadoPqrsDTO dto) throws Exception{
        servicioAdministrador.cambiarEstadoPQRS(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),null));
    }

    @GetMapping("/historialConsultas/listarCitas")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTOAdmin>>> listarCitasAdmin() throws Exception{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false, ms.getMessage("",null,LocaleContextHolder.getLocale()), servicioAdministrador.listarCitasAdmin()));
    }

    @GetMapping("/historialConsultas/filtrar-medico/{nombreMedico}")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTOAdmin>>> filtrarPorMedico(@PathVariable String nombreMedico) throws Exception{
        List<InfoCitaDTOAdmin> citas = servicioAdministrador.filtrarPorMedico(nombreMedico);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),citas));
    }

    //Compartido
    @GetMapping("/historialConsultas/verDetalle/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleCitaDTO>> verDetalleCita(@PathVariable int codigoCita) throws Exception{
        DetalleCitaDTO detalleCita = servicioGeneral.verDetalleCita(codigoCita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),detalleCita));
    }

}
