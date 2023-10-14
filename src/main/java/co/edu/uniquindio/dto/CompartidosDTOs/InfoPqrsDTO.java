package co.edu.uniquindio.dto.CompartidosDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.modelo.enumeraciones.TipoPqrs;

import java.time.LocalDateTime;

public record InfoPqrsDTO(int codigo,
                          TipoPqrs tipo,
                          EstadoPqrs estado,
                          LocalDateTime fechaCreacion
) {
}
