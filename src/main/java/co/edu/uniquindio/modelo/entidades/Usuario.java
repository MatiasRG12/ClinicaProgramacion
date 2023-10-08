package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "rol")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private int codigo;

    @EqualsAndHashCode.Include
    @Column(length = 30, unique = true)
    private String email;

    @EqualsAndHashCode.Include
    @Column(name = "contraseña", nullable = false)
    private String contrasenia;

}
