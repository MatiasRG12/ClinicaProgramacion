package co.edu.uniquindio.dto.MedicoDTOs;

public record AtencionMedicaDTO(

        int codigoCita,
        String sintomasPaciente,
        String diagnostico,
        String tratamiento,
        String notas
) {
}
