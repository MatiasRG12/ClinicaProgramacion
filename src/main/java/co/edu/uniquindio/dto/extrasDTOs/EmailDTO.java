package co.edu.uniquindio.dto.extrasDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailDTO(
        @NotBlank
        String destinatario,
        @NotBlank @Email
        String asunto,
        @NotBlank
        String mensaje
){

}
