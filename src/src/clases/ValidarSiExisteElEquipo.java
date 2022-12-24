package src.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.vistas.AgregarDirectorTecnico;

/**
 *
 * @author Lucho
 */
public class ValidarSiExisteElEquipo {

    ArrayList equipos = new ArrayList();

    public void validar(String nombreDeEquipo, JFrame jf) {

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("show tables");

            ResultSet rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
                equipos.add(i, rs.getString(1));
                i = i + 1;
            }
            boolean esIgual = false;

            for (int j = 0; j < equipos.size(); j++) {

                if (equipos.get(j).equals(nombreDeEquipo)) {
                    esIgual = true;
                    break;
                } else {
                    esIgual = false;
                }
            }

            if (esIgual) {
                //Mensaje si el equipo ya existe en la base de datos
                JOptionPane.showMessageDialog(null, "El equipo ya existe");
            } else {
                //Accion de crear nueva tabla si el equipo no existe en la base de datos
                String QueryDos = "create table if not exists " + nombreDeEquipo + "(\n"
                        + "	id int auto_increment not null,\n"
                        + "    nombre varchar (20) not null,\n"
                        + "    apellido varchar (20) not null,\n"
                        + "    edad int(2) not null,\n"
                        + "    posicion varchar(20) not null,\n"
                        + "    sueldo double not null,\n"
                        + "    cotizacion double not null,\n"
                        + "    fecha_creacion timestamp not null default current_timestamp,\n"
                        + "     primary key (id)\n"
                        + ");";

                PreparedStatement pstDos = con.prepareStatement(QueryDos);
                pstDos.execute();

                AgregarDirectorTecnico pasarNombre = new AgregarDirectorTecnico(nombreDeEquipo);
                pasarNombre.setVisible(true);
                jf.setVisible(false);
            }

            cn.desconectar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las tablas " + ex);
        }

    }
}
