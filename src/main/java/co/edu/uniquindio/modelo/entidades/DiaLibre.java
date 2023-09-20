package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DiaLibre implements Serializable {

    @Id
    private String codigo;

    private LocalDateTime fecha;

    @ManyToOne
    private Medico medico;
}