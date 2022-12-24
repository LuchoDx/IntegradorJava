package src.clases;

import src.vistas.AgregarJugadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucho
 */
public class AgregarIntegrante {

    private String nombreE = "", nombre = "", apellido = "", posicion = "";
    private int edad = 0;
    private double sueldo = 0.0, cotizacion = 0.0;

    public AgregarIntegrante(String nombreE, String nombre, String apellido, int edad, String posicion, double sueldo, double cotizacion) {
        this.nombreE = nombreE;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.cotizacion = cotizacion;
    }

    public void agregarIntegrante() {

        try {

            String Query = "insert into " + nombreE + " (nombre, apellido, edad, posicion, sueldo, cotizacion) values(?,?,?,?,?,?)";

            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement(Query);

            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setInt(3, edad);
            pst.setString(4, posicion);
            pst.setDouble(5, sueldo);
            pst.setDouble(6, cotizacion);
            pst.executeUpdate();

            cn.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarJugadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
