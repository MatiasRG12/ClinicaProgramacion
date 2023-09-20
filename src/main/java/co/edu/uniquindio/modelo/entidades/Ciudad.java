package co.edu.uniquindio.modelo.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad implements Serializable {

    @Id
    private String codigo;

    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Persona> listaPersonas;

}
