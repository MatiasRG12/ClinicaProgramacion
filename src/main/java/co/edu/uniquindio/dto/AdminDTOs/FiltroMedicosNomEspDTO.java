package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record FiltroMedicosNomEspDTO(

        @NotBlank
        @Length(max = 40)
        String nombre,

        @NotNull
        int codigoEspecialidad
) {
}
