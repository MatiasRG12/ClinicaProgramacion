package co.edu.uniquindio.dto.AdminDTOs;

import jakarta.validation.constraints.NotBlank;

public record EscogerPqrsDTO(

        @NotBlank
        int codigoAdmin,

        @NotBlank
        int codigoPQRS
) {
}
