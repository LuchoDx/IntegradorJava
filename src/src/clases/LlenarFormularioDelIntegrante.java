package src.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lucho
 */
public class LlenarFormularioDelIntegrante {

    public void LlenarFormulario(String equipo, int id, JTextField nombre, JTextField apellido, JTextField sueldo, JTextField cotizacion) {
        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select nombre, apellido, sueldo, cotizacion from " + equipo + " where id = " + id);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                nombre.setText(rs.getString(1));
                apellido.setText(rs.getString(2));
                sueldo.setText(rs.getString(3));
                cotizacion.setText(rs.getString(4));

            }

            cn.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del jugador " + ex);
        }
    }

}
