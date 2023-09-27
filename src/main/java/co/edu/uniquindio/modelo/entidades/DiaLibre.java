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

public class DiaLibre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private int codigo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fecha;


    @ManyToOne
    private Medico medico;
}