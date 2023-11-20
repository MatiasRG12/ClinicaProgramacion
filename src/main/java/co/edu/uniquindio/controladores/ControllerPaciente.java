package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.CompartidosDTOs.*;
import co.edu.uniquindio.dto.PacienteDTOs.*;
import co.edu.uniquindio.dto.extrasDTOs.MensajeDTO;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
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
@RequiredArgsConstructor
@Validated
@RequestMapping("/inicioPaciente")
public class ControllerPaciente {

    private final ServicioPaciente servicioPaciente;
    private final ServicioGeneral servicioGeneral;
    private final MessageSource ms;

    @PutMapping("/infoPersonal/editarInfo")
    public ResponseEntity<MensajeDTO<Integer>> editarInfoBasica(@Valid @RequestBody EditarPerfilPacienteDTO pacienteDTO) throws Exception{
        int codigoPaciente = servicioPaciente.editarInfoBasica(pacienteDTO);
       // return ResponseEntity.
               //status(HttpStatus.OK)
               // .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),codigoPaciente));
        return ResponseEntity.ok().body( new MensajeDTO<>(false," ",codigoPaciente));
    }

    @PutMapping("/infoPersonal/cambiarContrasenia")
    public ResponseEntity<MensajeDTO<String>> cambiarPassword(@Valid @RequestBody CambiarContraseniaDTO dto) throws Exception{
        servicioGeneral.cambiarPassword(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),null));
    }

    @DeleteMapping("/infoPersonal/eliminar")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@Valid @RequestBody EliminarCuentaDTO eCuentaDTO) throws Exception{
        servicioPaciente.eliminarCuenta(eCuentaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),null));
    }

    @PutMapping("/pqrs/crear")
    public ResponseEntity<MensajeDTO<Integer>> crearPQRS(@Valid @RequestBody CrearPqrsDTO pqrsDTO) throws Exception{
        int codigoPqrs = servicioPaciente.crearPQRS(pqrsDTO);
        //return ResponseEntity
               // .status(HttpStatus.OK)
              //  .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),codigoPqrs));
        return ResponseEntity.ok().body( new MensajeDTO<>(false," ",codigoPqrs));
    }

    @GetMapping("/pqrs/listar/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<InfoPqrsDTO>>> listarPQRSPaciente(@PathVariable int codigoPaciente) throws Exception{
        List<InfoPqrsDTO> listaPqrs = servicioPaciente.listarPQRSPaciente(codigoPaciente);
       // return ResponseEntity
              //  .status(HttpStatus.OK)
               // .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaPqrs));
        return ResponseEntity.ok().body( new MensajeDTO<>(false," ",listaPqrs));

    }

    @GetMapping("/pqrs/verDetalle/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePqrsDTO>> verDetallePqrs(@PathVariable int codigo)throws Exception{
        DetallePqrsDTO detallePqrs = servicioPaciente.verDetallePqrs(codigo);
        //return ResponseEntity
              //  .status(HttpStatus.OK)
              //  .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),detallePqrs));
        return ResponseEntity.ok().body( new MensajeDTO<>(false," ",detallePqrs));
    }

    @PutMapping("/pqrs/responder")
    public ResponseEntity<MensajeDTO<Integer>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO dto)throws Exception{
        int codigoPqrs = servicioGeneral.responderPQRS(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),codigoPqrs));
    }

    @GetMapping("/pqrs/filtrar-tipo")
    public ResponseEntity<MensajeDTO<List<InfoPqrsDTO>>> filtrarPqrsPorTipo(@Valid @RequestBody FiltroPqrsTipoDTO dto) throws Exception{
        List<InfoPqrsDTO> listaPqrs = servicioPaciente.filtrarPqrsPorTipo(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaPqrs));
    }

    @GetMapping("/citasMedicas/fechasMedico/{idMedico}")
    public ResponseEntity<MensajeDTO<List<ItemFechaMedicoDTO>>> listarFechasMedico(@PathVariable int idMedico) throws Exception{
        List<ItemFechaMedicoDTO> listaFechas = servicioPaciente.listarFechasMedico(idMedico);
       // return ResponseEntity
                //.status(HttpStatus.OK)
               // .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaFechas));
        return ResponseEntity.ok().body( new MensajeDTO<>(false," ",listaFechas));
    }

    @PutMapping("/citasMedicas/agendar")
    public ResponseEntity<MensajeDTO<Integer>> agendarCita(@Valid @RequestBody AgendarCitaDTO citaDTO)throws Exception{
        int codigoCitaAgendada = servicioPaciente.agendarCita(citaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),codigoCitaAgendada));
    }

    @GetMapping("/citasMedicas/medicos-especialidad/{especialidad}")
    public ResponseEntity<MensajeDTO<List<ItemMedicoDTO>>> listarMedicosEspecialidad(@PathVariable int especialidad) throws Exception{
        List<ItemMedicoDTO> listaMedicos = servicioPaciente.listarMedicosEspecialidad(especialidad);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaMedicos));
    }

    @GetMapping("/historialCitas/listar/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> listarCitasPaciente(@PathVariable int codigoPaciente) throws Exception{
        List<InfoCitaDTO> listaCitas = servicioPaciente.listarCitasPaciente(codigoPaciente);
        //return ResponseEntity
               // .status(HttpStatus.OK)
              //  .body(new MensajeDTO<>(false,ms.getMessage("",null, LocaleContextHolder.getLocale()),listaCitas));
        return ResponseEntity.ok().body( new MensajeDTO<>(false," ",listaCitas));
    }

    @GetMapping("/historial/filtrar-medico")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> filtrarCitasPorMedico(@Valid @RequestBody FiltroCitaMedicoDTO filtroDTO) throws Exception{
        List<InfoCitaDTO> listaCitas = servicioPaciente.filtrarCitasPorMedico(filtroDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaCitas));
    }

    @GetMapping("/hitorial/filtrar-fecha")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> filtrarCitasPorFecha(@Valid @RequestBody FiltroCitaFechaDTO filtroDTO) throws Exception{
        List<InfoCitaDTO> listaCitas = servicioPaciente.filtrarCitasPorFecha(filtroDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaCitas));
    }

    @GetMapping("/historial/filtrar-esp")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> filtrarCitasPorEspecialidad(@Valid @RequestBody FiltroCitaEspDTO filtroDTO) throws Exception{
        List<InfoCitaDTO> listaCitas = servicioPaciente.filtrarCitasPorEspecialidad(filtroDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaCitas));
    }

    @GetMapping("/historial/filtrar-medico-fecha-esp")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> filtrarCitasPorMedicoFechaEspecialidad(@Valid @RequestBody FiltroMedFechaEspDTO filtroDTO) throws Exception{
        List<InfoCitaDTO> listaCitas = servicioPaciente.filtrarCitasPorMedicoFechaEspecialidad(filtroDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),listaCitas));
    }

    @GetMapping("/historial/verDetalle/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleCitaDTO>> verDetalleCita(@PathVariable int codigoCita) throws Exception{
        DetalleCitaDTO detalleCita = servicioGeneral.verDetalleCita(codigoCita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO<>(false,ms.getMessage("",null,LocaleContextHolder.getLocale()),detalleCita));
    }



}
