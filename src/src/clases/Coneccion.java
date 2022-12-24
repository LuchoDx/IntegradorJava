package src.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucho
 */
public class Coneccion {

    String bd = "mundial";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "admin";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cn = null;

    public Connection conectar() {

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url + bd, user, password);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR en la coneccion: " + ex);
        }
        return cn;
    }

    public void desconectar() {
        try {
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al desconectarse" + ex);
        }
    }
}
