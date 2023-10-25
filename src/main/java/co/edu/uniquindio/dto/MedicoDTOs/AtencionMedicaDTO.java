package co.edu.uniquindio.dto.MedicoDTOs;

import jakarta.validation.constraints.NotBlank;

public record AtencionMedicaDTO(

        @NotBlank
        int codigoCita,
        String sintomasPaciente,
        String diagnostico,
        String tratamiento,
        String notas
) {
}
