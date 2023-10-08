package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;

import java.time.LocalDateTime;

public record InfoPqrsDTO(int codigo,
                          String tipo,
                          EstadoPqrs estado,
                          LocalDateTime fechaCreacion
) {
}
