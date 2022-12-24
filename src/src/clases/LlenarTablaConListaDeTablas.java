package src.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucho
 */
public class LlenarTablaConListaDeTablas {

    public void LlenarLista(JTable tablaEliminar) {
        DefaultTableModel tabla = new DefaultTableModel() {
            //Hacemos que la tabla no sea editable
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        tabla.addColumn("Equipo");
        tablaEliminar.setModel(tabla);

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("show tables");

            ResultSet rs = pst.executeQuery();

            String datos[] = new String[1];

            while (rs.next()) {
                datos[0] = rs.getString(1);
                tabla.addRow(datos);

            }

            cn.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las tablas " + ex);
        }
    }
}
