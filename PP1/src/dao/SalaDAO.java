package dao;

import Conexion.ConexionJavaMySQL;
import Modelo.Sala;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SalaDAO {

    ConexionJavaMySQL cn = new ConexionJavaMySQL();
    Connection cc = cn.getConexion();

    public boolean registrarSala(Sala pSala) {
        try {
            CallableStatement agregarSala = cc.prepareCall("{call agregarSala(?,?,?,?,?)}");
            agregarSala.setString(1, pSala.getIdSala());
            agregarSala.setString(2, pSala.getUbicacion());
            agregarSala.setInt(3, pSala.getCapacidadMaxima());
            agregarSala.setInt(4, pSala.getEstado());
            agregarSala.setInt(5, pSala.getIdHorario());
            agregarSala.execute();
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
    
    public boolean modificarEstadoSala(Sala pSala) {
        try {
            CallableStatement modificarEstado = cc.prepareCall("{call modificarEstadoSala(?,?)}");
            modificarEstado.setString(1, pSala.getIdSala());
            modificarEstado.setInt(2, pSala.getEstado());
            modificarEstado.execute();
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
    
    public boolean modificarUbicacionSala(Sala pSala) {
        try {
            CallableStatement modificarEstado = cc.prepareCall("{call modificarUbicacionSala(?,?)}");
            modificarEstado.setString(1, pSala.getIdSala());
            modificarEstado.setString(2, pSala.getUbicacion());
            modificarEstado.execute();
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
