package src.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.vistas.AgregarJugadores;

/**
 *
 * @author Lucho
 */
public class ModificarIntegrante {

    private String nombreE = "", nombre = "", apellido = "", posicion = "";
    private int edad = 0, id = 0;
    private double sueldo = 0.0, cotizacion = 0.0;

    public ModificarIntegrante(String nombreE, String nombre, String apellido, int edad, int id, String posicion, double sueldo, double cotizacion) {
        this.nombreE = nombreE;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.cotizacion = cotizacion;
        this.id = id;
    }

    public void modificarIntegrante() {

        try {

            String Query = "update " + nombreE + " set nombre = '" + nombre + "', apellido = '" + apellido + "', edad = " + edad + ", posicion =  '" + posicion + "', sueldo = " + sueldo + ",  cotizacion =  " + cotizacion + " where id = " + id;

            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement(Query);

            pst.executeUpdate();

            cn.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarJugadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
