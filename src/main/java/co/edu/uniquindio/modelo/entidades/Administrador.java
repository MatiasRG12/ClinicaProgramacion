package co.edu.uniquindio.modelo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("admin")

public class Administrador extends Usuario implements Serializable {

    private String nombre;

    @OneToMany(mappedBy = "administrador")
    private List<Pqrs> listaPqrs;

}
