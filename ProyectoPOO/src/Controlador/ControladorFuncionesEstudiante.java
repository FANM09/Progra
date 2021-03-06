package Controlador;

import Modelo.Reserva;
import Vista.VentanaCancelarReserva;
import Vista.VentanaEstudiante;
import Vista.VentanaRegistroReservas;
import dao.EstudianteDAO;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFuncionesEstudiante implements ActionListener {

    public VentanaEstudiante vista;

    public ControladorFuncionesEstudiante(VentanaEstudiante pVista) {
        vista = pVista;
        this.vista.btAgregarReserva.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Agregar Reserva":
                agregarSala();
                break;
            case "Cancelar Reserva":
                agregarSala();
                break;
            default:
                break;
        }
    }

    public void agregarSala() {
        VentanaRegistroReservas vista = new VentanaRegistroReservas();
        Reserva reserva = new Reserva();
        UsuarioDAO daoUsuario = new UsuarioDAO();
        EstudianteDAO daoEstudiante = new EstudianteDAO();
        ControladorAgregarReservaDAO controladorReserva = new ControladorAgregarReservaDAO(vista, reserva);
        controladorReserva.vista.txtNU.setText(this.vista.txtNU.getText());
        String cedula = String.valueOf(daoUsuario.obtenerCedula(controladorReserva.vista.txtNU.getText()));
        int carnet = daoEstudiante.obtenerCarnet(controladorReserva.vista.txtNU.getText());
        controladorReserva.vista.txtCedula.setText(cedula);
        controladorReserva.vista.txtCarnet.setText(String.valueOf(carnet));
        controladorReserva.vista.setVisible(true);
        controladorReserva.vista.setLocationRelativeTo(null);
    }
    
    public void cancelarReserva(){
        VentanaCancelarReserva vista = new VentanaCancelarReserva();
        ControladorCancelarReservaDAO controladorCancelarReserva = new ControladorCancelarReservaDAO(vista);
        controladorCancelarReserva.vista.setVisible(true);
        controladorCancelarReserva.vista.setLocationRelativeTo(null);
    }
}
