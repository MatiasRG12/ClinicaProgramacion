package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AtencionMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 500)
    private String sintomasPaciente;

    @Column(length = 500)
    private String diagnostico;

    @Column(length = 500)
    private String tratamiento;

    @Column(length = 500)
    private String nota;

    @OneToOne
    private Cita cita;

}
