package co.edu.uniquindio.dto.PacienteDTOs;

public record CrearPqrsDTO(
        int tipoSolicitud,
        String motivo,
        int codigoCita
) {
}
