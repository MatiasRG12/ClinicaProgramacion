package co.edu.uniquindio.dto.CompartidosDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.modelo.enumeraciones.TipoPqrs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record InfoPqrsDTO(

        @NotBlank
        int codigo,

        @NotNull
        TipoPqrs tipo,

        @NotNull
        EstadoPqrs estado,

        @NotNull
        LocalDateTime fechaCreacion
) {
}
