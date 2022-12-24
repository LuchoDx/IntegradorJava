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
public class LlenarComboIntegrantes {

    public void LlenarIntegrantes(JComboBox c1, String equipo) {
        try {
            c1.removeAllItems();

            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select nombre from " + equipo);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                c1.addItem(rs.getString(1));

            }

            cn.desconectar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los nombres " + ex);
        }

    }
}
