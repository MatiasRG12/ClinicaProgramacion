package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record FiltroCitaMedicoDTO(

        @NotBlank
        int codigoPaciente,

        @NotBlank
        @Length(max = 40)
        String nombreMedico
) {
}
