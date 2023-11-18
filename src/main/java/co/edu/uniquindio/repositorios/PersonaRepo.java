package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.Paciente;
import co.edu.uniquindio.modelo.entidades.Persona;
import co.edu.uniquindio.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonaRepo extends JpaRepository<Persona, Integer> {

    @Query("select p from Persona p where p.cedula = :cedula")
    Persona buscarPorCedula(String cedula);



}
