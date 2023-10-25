package co.edu.uniquindio.ClinicaProyectoProgramacion.test;

import co.edu.uniquindio.dto.CompartidosDTOs.CambiarContraseniaDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.DetallePqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.InfoPqrsDTO;
import co.edu.uniquindio.dto.CompartidosDTOs.MensajePqrsDTO;
import co.edu.uniquindio.dto.PacienteDTOs.*;
import co.edu.uniquindio.modelo.entidades.Cita;
import co.edu.uniquindio.modelo.entidades.MensajePqrs;
import co.edu.uniquindio.modelo.enumeraciones.Eps;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import co.edu.uniquindio.servicios.impl.ServicioGeneralImpl;
import co.edu.uniquindio.servicios.impl.ServicioPacienteImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServicioPacienteImplTest {

    @Autowired
    private ServicioPacienteImpl servicioPaciente;
    @Autowired
    private ServicioGeneralImpl servicioGeneral;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarPacienteTest(){
        RegistroPacienteDTO registroPacienteDTO = new RegistroPacienteDTO(
                "Karla Sanz",
                "4321",
                "3134697423",
                "karlas@gmail.com",
                LocalDateTime.of(2023, Month.NOVEMBER, 23, 14, 20),
                "url_foto",
                Eps.NUEVA_EPS,
                TipoSangre.A_NEGATIVO,
                "alergias",
                "correo@corre.com",
                "pass_prueba");

        try {
            servicioPaciente.registrarPaciente(registroPacienteDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void editarInfoBasicaTest() throws Exception {
        int nuevo = servicioPaciente.editarInfoBasica(new EditarPerfilPacienteDTO(
                005,
                "Armenia",
                "3134697423",
                "alergias",
                "url_foto"
                ));
        Assertions.assertTrue(nuevo>0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPacienteTest() throws Exception {
        try {
            servicioPaciente.eliminarCuenta(new EliminarCuentaDTO(005, "passwordPacienteCinco"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void enviarLinkRecuperacionTest() throws Exception {

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPasswordTest() throws Exception {
        try {
            servicioGeneral.cambiarPassword(new CambiarContraseniaDTO(
                    005,
                    "passwordPacienteCinco",
                    "newPasswordPacienteCinco"
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPQRSTest() throws Exception {
        CrearPqrsDTO pqrsPacienteDTO = new CrearPqrsDTO(0, "Mala atencion", 1000);

        int nuevo;

        try {
            nuevo = servicioPaciente.crearPQRS(pqrsPacienteDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotEquals(0, nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSPacienteTest() throws Exception {
        List<InfoPqrsDTO> pqrs;
        try {
            pqrs = servicioPaciente.listarPQRSPaciente(005);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.listarPQRSPaciente(005).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarPqrsPorTipoTest() throws Exception {
        List<InfoPqrsDTO> cita;
        try {
            cita = servicioPaciente.filtrarPqrsPorTipo(new FiltroPqrsTipoDTO(005, 0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.filtrarPqrsPorTipo(new FiltroPqrsTipoDTO(005, 0)).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePqrsTest() throws Exception {
        DetallePqrsDTO pqrs;
        try {
            pqrs = servicioPaciente.verDetallePqrs(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(servicioPaciente.verDetallePqrs(2000));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void convertirMensajesTest() throws Exception {

        List<MensajePqrs> listaMensajes2 = new ArrayList<>();;
        try {
            List<MensajePqrsDTO> listaMensajes = servicioPaciente.convertirMensajes(listaMensajes2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.convertirMensajes(listaMensajes2).isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMedicosEspecialidadTest() throws Exception {
        List<ItemMedicoDTO> medicos;
        try {
            medicos = servicioPaciente.listarMedicosEspecialidad(Especialidad.MEDICINA_GENERAL.ordinal());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.listarMedicosEspecialidad(Especialidad.MEDICINA_GENERAL.ordinal()).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFechasMedicoTest() throws Exception {
        List<ItemFechaMedicoDTO> fechas;
        try {
            fechas = servicioPaciente.listarFechasMedico(003);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.listarFechasMedico(003).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void estaOcupadoTest() throws Exception {
        boolean ocupado;
        List<Cita> citas = new ArrayList<>();
        try {
            ocupado = servicioPaciente.estaOcupado(citas, LocalTime.of(23, 14, 20));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(servicioPaciente.estaOcupado(citas, LocalTime.of(23, 14, 20)));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarCitaTest() throws Exception {
        int nueva;
        try {
            nueva = servicioPaciente.agendarCita(new AgendarCitaDTO(
                    003,
                    005,
                    "Dolores",
                    LocalDateTime.of(2023, Month.NOVEMBER, 23, 14, 20),
                    LocalTime.of(23, 14, 20)
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotEquals(0, nueva);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPacienteTest() throws Exception {
        List<InfoCitaDTO> citas;
        try {
            citas = servicioPaciente.listarCitasPaciente(005);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.listarCitasPaciente(005).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPorMedicoTest() throws Exception {
        List<InfoCitaDTO> citas;
        try {
            citas = servicioPaciente.filtrarCitasPorMedico(new FiltroCitaMedicoDTO(005, "MedicoUno"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.filtrarCitasPorMedico(new FiltroCitaMedicoDTO(005, "MedicoUno")).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPorFechaTest() throws Exception {
        List<InfoCitaDTO> citas;
        try {
            citas = servicioPaciente.filtrarCitasPorFecha(new FiltroCitaFechaDTO(005, LocalDateTime.of(2005, Month.NOVEMBER, 18, 20, 30)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.filtrarCitasPorFecha(new FiltroCitaFechaDTO(005, LocalDateTime.of(2005, Month.NOVEMBER, 18, 20, 30))).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPorEspecialidadTest() throws Exception {
        List<InfoCitaDTO> citas;
        try {
            citas = servicioPaciente.filtrarCitasPorEspecialidad(new FiltroCitaEspDTO(005, 0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.filtrarCitasPorEspecialidad(new FiltroCitaEspDTO(005, 0)).size()>0);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPorMedicoFechaEspecialidadTest() throws Exception {
        List<InfoCitaDTO> citas;
        try {
            citas = servicioPaciente.filtrarCitasPorMedicoFechaEspecialidad(new FiltroMedFechaEspDTO(005, "MedicoUno", LocalDateTime.of(2005, Month.NOVEMBER, 18, 20, 30), 0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(servicioPaciente.filtrarCitasPorMedicoFechaEspecialidad(new FiltroMedFechaEspDTO(005, "MedicoUno", LocalDateTime.of(2005, Month.NOVEMBER, 18, 20, 30), 0)).size()>0);

    }

}
