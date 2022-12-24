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
public class LlenarTablaConSusDatos {

    public void Llenar(JTable tabla, String equipo) {
        DefaultTableModel Equipo = new DefaultTableModel() {
            //Hacemos que la tabla no sea editable
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };
        //titulos de columnas
        Equipo.addColumn("Nombre");
        Equipo.addColumn("Apellido");
        Equipo.addColumn("Edad");
        Equipo.addColumn("Posición");
        Equipo.addColumn("Sueldo");
        Equipo.addColumn("Cotizacion");
        Equipo.addColumn("Fecha Creacion");

        tabla.setModel(Equipo);

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select * from " + equipo);

            ResultSet rs = pst.executeQuery();

            String datos[] = new String[7];

            while (rs.next()) {

                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(7);
                datos[6] = rs.getString(8);

                Equipo.addRow(datos);

            }

            cn.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos" + ex);
        }
    }
}
