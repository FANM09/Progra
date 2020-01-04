package Controlador;
import Vista.VentanaEstudiante;
import Vista.VentanaFuncionario;
import Vista.VentanaRegistroUsuario;
import Vista.VentanaLogin;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Controlador.ControladorRealizarReserva;
/**
 *
 * @author Jeremy
 */
public class ControladorMenuEstudiante implements ActionListener {
  
  VentanaEstudiante vista=new VentanaEstudiante();
  
  public ControladorMenuEstudiante(){
    this.vista.setVisible(true);
    
    
    this.vista.botonRealizarReserva.addActionListener(this);
    this.vista.botonRealizarComentario.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    switch (ae.getActionCommand()) {
            case "Realizar Reserva":
                this.vista.setVisible(false);
                ControladorRealizarReserva controladorReserva= new ControladorRealizarReserva();
                break;
            case "Salir":
                
                break;
            default:
                break;
        }
    
  }
  
}
