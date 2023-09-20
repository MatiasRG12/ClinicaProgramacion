package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@DiscriminatorValue("persona")
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "rol")
public class Persona extends Usuario implements Serializable {

    private String cedula;

    private String nombre;

    private String telefono;

    private String foto;

    @ManyToOne
    private Ciudad ciudad;

}