package co.edu.uniquindio.dto.MedicoDTOs;


import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record DatosCitaDTO(

        @NotNull
        LocalDateTime fechaCita,

        @NotBlank
        @Length(max = 40)
        String nombreMedico,

        @NotBlank
        @Length(max = 40)
        String nombrePaciente,

        @NotNull
        TipoSangre tipoSangrePaciente,

        @NotBlank
        String motivoCita
) {
}
