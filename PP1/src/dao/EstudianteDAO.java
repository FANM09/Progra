package dao;

import Conexion.ConexionJavaMySQL;
import Modelo.Estudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EstudianteDAO {

    ConexionJavaMySQL cn = new ConexionJavaMySQL();
    Connection cc = cn.getConexion();

    public boolean registrarPersona(Estudiante pEstudiante) {
        try {
            CallableStatement insertarPersona = cc.prepareCall("{call agregarPersona(?,?,?,?,?)}");
            insertarPersona.setInt(1, pEstudiante.getCedula());
            insertarPersona.setString(2, pEstudiante.getPrimerNombre());
            insertarPersona.setString(3, pEstudiante.getPrimerApellido());
            insertarPersona.setString(4, pEstudiante.getCorreo());
            insertarPersona.setInt(5, pEstudiante.getTelefono());
            insertarPersona.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                cc.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    
    public boolean modificarEstudiante (Estudiante pEstudiante) {
       try {
            CallableStatement modificarEstudiante = cc.prepareCall("{call modificarEstudiante(?,?,?)}");
            modificarEstudiante.setInt(1, pEstudiante.getCedula());
            modificarEstudiante.setString(2, pEstudiante.getCarrera());
            modificarEstudiante.setInt(3, pEstudiante.getCarnet());
            modificarEstudiante.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                cc.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
}
