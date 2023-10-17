package co.edu.uniquindio.modelo.entidades;

import co.edu.uniquindio.modelo.enumeraciones.EstadoCita;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private int codigo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaCreacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaCita;

    @Column(nullable = false)
    private LocalTime horaCita;

    @Column(length = 100)
    private String motivo;

    @Column(nullable = false)
    private EstadoCita estado;


    @OneToOne(mappedBy = "cita")
    private AtencionMedica atencionMedica;

    @OneToMany(mappedBy = "codigoCita")
    private List<Pqrs> pqrsLista;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;
}
