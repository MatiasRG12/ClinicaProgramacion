package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


public record ActualizarMedicoAdminDTO(

        @NotBlank //Agregar mensaje
        @Length(max = 15)
        String cedula,

        @NotNull
        Especialidad especialidad,

        @NotNull
        Jornada jornada

) {

}
