package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.AtencionMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionMedicaRepo extends JpaRepository<AtencionMedica,Integer> {
}
