package co.edu.uniquindio.dto.CompartidosDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.modelo.enumeraciones.TipoPqrs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePqrsDTO(

        @NotBlank
        int codigo,

        @NotNull
        TipoPqrs tipo,

        @NotNull
        EstadoPqrs estado,

        @NotNull
        LocalDateTime fecha,

        @NotBlank @Length(max = 500)
        String motivo,

        List<MensajePqrsDTO> mensajes
) {
}
