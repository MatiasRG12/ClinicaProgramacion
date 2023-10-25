package co.edu.uniquindio.dto.MedicoDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DiaLibreDTO(

        @NotBlank
        int codigoMedico,

        @NotNull
        LocalDateTime fecha
) {
}
