package co.edu.uniquindio.repositorios;

import co.edu.uniquindio.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByEmail(String correo);

    Optional<Usuario> findByEmail(int correo);
}
