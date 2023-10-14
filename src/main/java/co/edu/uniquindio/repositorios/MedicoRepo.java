package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.dto.AdminDTOs.InfoMedicoDTO;
import co.edu.uniquindio.modelo.entidades.Medico;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepo extends JpaRepository <Medico, Integer> {

    Optional<Medico> findByCedula(String cedula);

    List<Medico> findAllByEspecialidad(Especialidad especialidad);

    List<Medico> findAllByNombre(String nombreMedico);

    List<Medico> findAllByNombreAndEspecialidad(String nombre, Especialidad e);
}
