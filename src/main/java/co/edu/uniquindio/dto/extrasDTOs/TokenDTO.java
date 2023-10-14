package co.edu.uniquindio.dto.extrasDTOs;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token
) {
}
