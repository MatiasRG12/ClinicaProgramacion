package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtencionMedica implements Serializable {
    @Id
    private String codigo;
    private String sintomasPaciente;
    private String diagnostico;
    private String tratamiento;
    private String nota;

    @OneToOne
    private Cita cita;

}
