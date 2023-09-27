package co.edu.uniquindio.modelo.entidades;

import co.edu.uniquindio.modelo.enumeraciones.Eps;
import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("paciente")
public class Paciente extends Persona implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fechaNacimiento;

    @Column(nullable = false)
    private TipoSangre tipoSangre;

    private String alergia;

    @Column(nullable = false)
    private Eps eps;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> listaCitasPaciente;


}