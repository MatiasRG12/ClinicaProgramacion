package co.edu.uniquindio.modelo.entidades;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("medico")
public class Medico extends Persona implements Serializable {

    private Especialidad especialidad;
    private Jornada jornada;

    @OneToMany(mappedBy = "medico")
    private List<Cita> listaCitasMedico;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> listaDiasLibres;

}
