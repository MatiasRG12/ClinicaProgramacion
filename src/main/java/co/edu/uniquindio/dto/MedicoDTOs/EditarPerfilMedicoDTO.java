package co.edu.uniquindio.dto.MedicoDTOs;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record EditarPerfilMedicoDTO(

        @NotBlank
        int codigo,

        @NotBlank
        String ciudad,

        @Length(max = 15)
        String telefono,
        String urlFoto
) {
}
