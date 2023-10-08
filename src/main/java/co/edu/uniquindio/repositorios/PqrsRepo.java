package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PqrsRepo extends JpaRepository<Pqrs,Integer> {
    List<Pqrs> findByEstado(int estado);
}
