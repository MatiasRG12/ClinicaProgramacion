package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente,Integer> {
    Optional<Paciente> findByCedula(String cedula);

    Optional<Paciente> findByNombreAndContrasenia(String nombreUsuario, String contrasenia);

}
