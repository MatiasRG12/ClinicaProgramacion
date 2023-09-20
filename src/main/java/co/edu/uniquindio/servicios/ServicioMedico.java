package co.edu.uniquindio.servicios;

public interface ServicioMedico {

    void listarCitasPendientes();

    void atenderCita();

    void listarCitasPaciente(); //historial médico

    void agendarDiaLibre();

    void listarCitasRealizadasMedico();

}
