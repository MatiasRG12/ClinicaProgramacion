package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.Cita;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    @Query("SELECT c FROM Cita c WHERE c.paciente.codigo = :codigoPaciente")
    List<Cita> buscarPorIdPaciente(int codigoPaciente);

    List<Cita> findAllByMedicoEspecialidad(Especialidad especialidad);

    List<Cita> findAllByMedicoCodigoAndFechaCitaGreaterThanEqual(int codigoMedico, LocalDateTime hoy);

    List<Cita> findAllByPacienteCodigoAndMedicoNombre(int codigoPaciente, String nombreMedico);

    List<Cita> findAllByPacienteCodigoAndFechaCita(int codigoPaciente, LocalDateTime fecha);

    List<Cita> findAllByPacienteCodigoAndMedicoEspecialidad(int codigoPaciente, Especialidad especialidad);

    @Query("SELECT c FROM Cita c WHERE c.paciente.codigo=:cp AND c.medico.nombre=:nm AND c.fechaCita=:fecha AND c.medico.especialidad=:e")
    List<Cita> filtrar(int cp, String nm, LocalDateTime fecha, Especialidad e);

    List<Cita> findAllByMedicoNombre(String nombreMedico);

    List<Cita> findAllByMedicoCodigoAndFechaCitaEquals(int codigoMedico, LocalDateTime now);

    List<Cita> findAllByMedicoCodigo(int codigoMedico);
}
