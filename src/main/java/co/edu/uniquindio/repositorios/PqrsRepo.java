package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.Pqrs;
import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.modelo.enumeraciones.TipoPqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PqrsRepo extends JpaRepository<Pqrs,Integer> {
    List<Pqrs> findAllByEstado(EstadoPqrs estado);

    @Query("SELECT p FROM Pqrs p WHERE p.codigoCita.paciente = :codigoPaciente")
    List<Pqrs> buscarPorCitasDePaciente(int codigoPaciente);

    @Query("SELECT COUNT(p) FROM Pqrs p WHERE p.estado = :estadoPqrs")
    Long contarActivos(EstadoPqrs estadoPqrs);

    //List<Pqrs> findAllByPacienteCodigoAndPqrsTipo(int i, TipoPqrs t);

    List<Pqrs> findAllByCodigoCitaPacienteCodigoAndTipo(int codigoPaciente, TipoPqrs t);

}
