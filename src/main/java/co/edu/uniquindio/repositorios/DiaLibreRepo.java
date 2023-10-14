package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.DiaLibre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaLibreRepo extends JpaRepository<DiaLibre,Integer> {
    Optional<DiaLibre> findByFecha(LocalDateTime fecha);

    List<DiaLibre> findAllByMedicoCodigo(int idMedico);
}
