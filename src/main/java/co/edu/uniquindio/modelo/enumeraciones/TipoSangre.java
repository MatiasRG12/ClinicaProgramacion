package co.edu.uniquindio.modelo.enumeraciones;

public enum TipoSangre {

    A_POSITIVO ("A+"),
    O_POSITIVO ("O+"),
    B_POSITIVO ("B+"),
    AB_POSITIVO ("AB+"),
    A_NEGATIVO ("A-"),
    O_NEGATIVO ("O-"),
    B_NEGATIVO ("B-"),
    AB_NEGATIVO ("AB-");

    private String nombre;

    TipoSangre(String nombre) {

        this.nombre = nombre;
    }
}