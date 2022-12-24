package src.clases;

/**
 *
 * @author Lucho
 */
public class EnfrentarEquipos {

    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void CrearEnfrentamiento(String equipUno, String equipDos) {

        int golesEquipUno = (int) Math.floor(Math.random() * 4);
        int golesEquipDos = (int) Math.floor(Math.random() * 4);

        if (golesEquipUno > golesEquipDos) {
            resultado = "Ganó " + equipUno + " por: " + golesEquipUno + " - " + golesEquipDos + " ante " + equipDos;
        } else if (golesEquipUno == golesEquipDos) {
            resultado = "Empate entre " + equipUno + " y " + equipDos + " por: " + golesEquipUno + " - " + golesEquipDos;
        } else {
            resultado = "Ganó " + equipDos + " por: " + golesEquipUno + " - " + golesEquipDos + " ante " + equipUno;
        }

    }

}
