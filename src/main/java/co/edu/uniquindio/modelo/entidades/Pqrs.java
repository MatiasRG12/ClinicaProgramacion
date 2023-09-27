package co.edu.uniquindio.modelo.entidades;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private EstadoPqrs estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaCreacion;

    @Column(length = 500)
    private String descripcion;



    @ManyToOne
    private Cita codigoCita;

    @OneToMany(mappedBy = "pqrs")
    private List<MensajePqrs> mensajes;

    @ManyToOne
    private Administrador administrador;
}
