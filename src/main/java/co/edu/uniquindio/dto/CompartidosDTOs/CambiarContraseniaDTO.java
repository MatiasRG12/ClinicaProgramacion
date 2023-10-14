package co.edu.uniquindio.dto.CompartidosDTOs;

public record CambiarContraseniaDTO(
        int codigo,
        String contraseniaActual,
        String contraseniaNueva
) {
}
