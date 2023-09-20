package co.edu.uniquindio.modelo.entidades;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pqrs implements Serializable{

    @Id
    private String codigo;

    private String tipo;

    private EstadoPqrs estado;

    private LocalDateTime fechaCreacion;

    private String descripcion;

    @ManyToOne
    private Cita codigoCita;

    @OneToMany(mappedBy = "pqrs")
    private List<MensajePqrs> mensajes;

    @ManyToOne
    private Administrador administrador;
}
