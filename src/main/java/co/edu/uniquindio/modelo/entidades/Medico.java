package co.edu.uniquindio.modelo.entidades;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoMedico;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("medico")

public class Medico extends Persona implements Serializable {

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Especialidad especialidad;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Jornada jornada;

    @Column(nullable = false)
    private EstadoMedico estado;

    @OneToMany(mappedBy = "medico")
    private List<Cita> listaCitasMedico;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> listaDiasLibres;

}
