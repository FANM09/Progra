package Controlador;
import Vista.VentanaRealizarReserva;
import Modelo.Usuario;
import Vista.VentanaFuncionario;
import Vista.VentanaRegistroUsuario;
import Vista.VentanaLogin;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Jeremy
 */
public class ControladorRealizarReserva implements ActionListener{
  VentanaRealizarReserva vista = new VentanaRealizarReserva();
  
  public ControladorRealizarReserva() {
        this.vista.setVisible(true);
        this.vista.botonBuscar.addActionListener(this);

    }

  @Override
  public void actionPerformed(ActionEvent ae) {
    
  }
  
}
