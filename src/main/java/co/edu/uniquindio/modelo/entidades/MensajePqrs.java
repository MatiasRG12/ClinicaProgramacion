package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MensajePqrs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 250)
    private String texto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fecha;

    @ManyToOne
    private Pqrs pqrs;

    @OneToOne
    private MensajePqrs mensaje;

}
