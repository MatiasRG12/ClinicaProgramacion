package co.edu.uniquindio.dto.extrasDTOs;

import lombok.Getter;
import lombok.Setter;


public record ValidacionDTO(

        String campo,
        String error

) {
}
