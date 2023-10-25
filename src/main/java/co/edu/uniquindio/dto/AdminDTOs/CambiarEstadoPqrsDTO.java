package co.edu.uniquindio.dto.AdminDTOs;


import jakarta.validation.constraints.NotBlank;

public record CambiarEstadoPqrsDTO(

        @NotBlank
        int codigoPqrs,

        @NotBlank
        int estado
) {
}
