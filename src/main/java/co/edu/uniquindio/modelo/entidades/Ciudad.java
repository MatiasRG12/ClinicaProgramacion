package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 20)
    private String nombre;


    @OneToMany(mappedBy = "ciudad")
    private List<Persona> listaPersonas;

}
