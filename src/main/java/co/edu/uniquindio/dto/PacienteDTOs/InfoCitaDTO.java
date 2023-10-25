package co.edu.uniquindio.dto.PacienteDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record InfoCitaDTO(

        @NotBlank
        int codigo,

        @NotNull
        Especialidad especialidad,

        @NotNull
        LocalDateTime fechaCita, //NO ES FECHA DE CREACION

        @NotNull
        LocalTime horaCita,

        @NotBlank
        @Length(max = 40)
        String nombreMedico

) {
}
