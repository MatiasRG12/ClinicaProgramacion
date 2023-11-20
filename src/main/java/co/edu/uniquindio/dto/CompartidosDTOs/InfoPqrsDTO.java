package co.edu.uniquindio.dto.CompartidosDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.modelo.enumeraciones.TipoPqrs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record InfoPqrsDTO(

        int codigo,

        @NotNull
        TipoPqrs tipo,

        @NotNull
        EstadoPqrs estado,

        @NotNull
        LocalDateTime fechaCreacion,
        @NotBlank
        String motivo


) {
}
