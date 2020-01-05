package Controlador;

import Modelo.Reserva;
import Vista.VentanaCancelarReserva;
import java.awt.event.ActionEvent;

public class ControladorCancelarReservaDAO {

    public VentanaCancelarReserva vista;

    public ControladorCancelarReservaDAO(VentanaCancelarReserva pVista) {
        vista = pVista;
        this.vista.bt.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Buscar":
                buscarSala();
                break;
            case "Atrás":
                cerrarVentana();
                break;
            case "Búsqueda Avanzada":
                buscarSalaEspecifica();
                break;
            case "Añadir Participante":
                añadirParticipante();
                break;
            case "Crear Reserva":
                agregarReserva();
                break;
            default:
                break;
        }
    }
}
