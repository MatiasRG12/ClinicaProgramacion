package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.MensajePqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajePqrsRepo extends JpaRepository<MensajePqrs,Integer> {

}
