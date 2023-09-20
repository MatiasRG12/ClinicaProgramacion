package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajePqrs implements Serializable {

    @Id
    private String codigo;
    private String texto;
    private LocalDateTime fecha;

    @ManyToOne
    private Pqrs pqrs;

    @OneToOne
    private MensajePqrs mensaje;

}
