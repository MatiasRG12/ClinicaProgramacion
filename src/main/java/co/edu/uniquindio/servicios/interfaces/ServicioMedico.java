package co.edu.uniquindio.servicios.interfaces;

public interface ServicioMedico {

    void listarCitasPendientes();

    void atenderCita();

    void listarCitasPaciente(); //historial médico

    void agendarDiaLibre();

    void listarCitasRealizadasMedico();

}
