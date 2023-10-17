package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public record ActualizarMedicoAdminDTO(

        String cedula,
        Especialidad especialidad,
        Jornada jornada

) {

}
