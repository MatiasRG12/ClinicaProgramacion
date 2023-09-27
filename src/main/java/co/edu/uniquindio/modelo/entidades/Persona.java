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

    @Id
    @Column(nullable = false,length = 15,unique = true)
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(length = 30)
    private String nombre;

    @Column(length = 15)
    private String telefono;

    private String foto;

    @ManyToOne
    private Ciudad ciudad;

}