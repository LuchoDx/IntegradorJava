package src.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucho
 */
public class LlenarComboEquipos {

    public void Llenar(JComboBox c) {

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("show tables");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c.addItem(rs.getString(1));

            }

            cn.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las tablas " + ex);
        }

    }
}
