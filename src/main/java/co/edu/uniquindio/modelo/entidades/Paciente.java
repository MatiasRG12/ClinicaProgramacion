package co.edu.uniquindio.modelo.entidades;

import co.edu.uniquindio.modelo.enumeraciones.Eps;
import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("paciente")
public class Paciente extends Persona implements Serializable {


    private String fechaNacimiento;
    private TipoSangre tipoSangre;
    private String alergia;
    private Eps eps;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> listaCitasPaciente;


}