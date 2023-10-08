package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepo extends JpaRepository <Medico, Integer> {

    Optional<Medico> findByCedula(String cedula);
}
