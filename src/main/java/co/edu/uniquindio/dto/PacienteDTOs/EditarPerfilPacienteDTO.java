package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record EditarPerfilPacienteDTO(

        @NotBlank
        int codigo,

        String ciudad,

        @Length(max = 15)
        String telefono,

        String alergias,

        String fotoUrl

) {
}
