package src.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucho
 */
public class EliminarSeleccionado {

    private String seleccionAEliminar = "";

    public EliminarSeleccionado(String seleccion) {
        this.seleccionAEliminar = seleccion;
    }

    public void Eliminar() {

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("drop table " + seleccionAEliminar);

            pst.execute();

            cn.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la seleccion [ " + seleccionAEliminar + " ] " + e);
        }

    }
}
