package co.edu.uniquindio.modelo.entidades;

import co.edu.uniquindio.modelo.enumeraciones.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita implements Serializable {

    @Id
    private String codigo;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaCita;

    private String motivo;

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
