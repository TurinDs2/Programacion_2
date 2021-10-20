package arreglos_vehiculos_usados;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Arreglos_Vehiculos_Usados {

    private static String Leer;
    private static FileWriter Archivo;
    private static PrintWriter Linea;

    private static String Marca[], Modelo[], Color[];
    private static int Anio[], Recorrido[];
    private static String Motor[], Traccion[];
    private static float Precio[];

    public static void Predefinido() {
        int Cant = 4;
        Marca = new String[Cant];
        Modelo = new String[Cant];
        Color = new String[Cant];
        Anio = new int[Cant];
        Recorrido = new int[Cant];
        Motor = new String[Cant];
        Traccion = new String[Cant];
        Precio = new float[Cant];

        Marca[0] = "Mitsubishi";
        Modelo[0] = "Montero Sport";
        Color[0] = "Negro";
        Anio[0] = 2018;
        Recorrido[0] = 75000;
        Motor[0] = "2.5cc Diesel";
        Traccion[0] = "4x2";
        Precio[0] = 750000;
        Marca[1] = "Nissan";
        Modelo[1] = "Patrol";
        Color[1] = "Verde";
        Anio[1] = 2006;
        Recorrido[1] = 48000;
        Motor[1] = "3.0cc Diesel";
        Traccion[1] = "4x4";
        Precio[1] = 220000;
        Marca[2] = "Suzuki";
        Modelo[2] = "Jimny";
        Color[2] = "Plata";
        Anio[2] = 2018;
        Recorrido[2] = 11000;
        Motor[2] = "1.5cc Gasolina";
        Traccion[2] = "4x4";
        Precio[2] = (float) (20000 * 24.25);
        Marca[3] = "Toyota";
        Modelo[3] = "Hilux 2.4";
        Color[3] = "Gris";
        Anio[3] = 2018;
        Recorrido[3] = 110000;
        Motor[3] = "2.4cc Diesel";
        Traccion[3] = "4x4";
        Precio[3] = 790000;

    }

    public static void ImprimirCLI() {
        System.out.print("+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n"
                + "|Posición|   Marca   |     Modelo     |   Color   |   Año   |   Recorrido   |     Motor     |   Tracción   |   Precio   |\n"
                + "+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n");
        for (int i = 0; i < Marca.length; i++) {
            System.out.printf("|%8d|%11s|%16s|%11s|%9d|%15d|%15s|%14s|L.%10.2f|\n", i, Marca[i], Modelo[i], Color[i], Anio[i], Recorrido[i], Motor[i], Traccion[i], Precio[i]);
        }
        System.out.print("+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n");
    }

    public static void ExportarXls() throws IOException {
        Archivo = new FileWriter("Vehiculos Usados.xls");
        Linea = new PrintWriter(Archivo);

        Linea.print("Posición\tMarca\tModelo\tColor\tAño\tRecorrido\tMotor\tTracción\tPrecio\n");
        for (int i = 0; i < Marca.length; i++) {
            Linea.printf("%d\t%s\t%s\t%s\t%d\t%d\t%s\t%s\tL.%.2f\n", i, Marca[i], Modelo[i], Color[i], Anio[i], Recorrido[i], Motor[i], Traccion[i], Precio[i]);
        }
        Archivo.close();
    }

    public static void Agregar() {
        Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Vehiculos Usados a Registrar:");
        int Cant = Integer.parseInt(Leer);

        String tmpMarca[] = new String[Marca.length + Cant];
        String tmpModelo[] = new String[Modelo.length + Cant];
        String tmpColor[] = new String[Color.length + Cant];
        int tmpAnio[] = new int[Anio.length + Cant];
        int tmpRecorrido[] = new int[Recorrido.length + Cant];
        String tmpMotor[] = new String[Motor.length + Cant];
        String tmpTraccion[] = new String[Traccion.length + Cant];
        float tmpPrecio[] = new float[Precio.length + Cant];

        for (int i = 0; i < tmpMarca.length; i++) {
            if (i < Marca.length) {
                tmpMarca[i] = Marca[i];
                tmpModelo[i] = Modelo[i];
                tmpColor[i] = Color[i];
                tmpAnio[i] = Anio[i];
                tmpRecorrido[i] = Recorrido[i];
                tmpMotor[i] = Motor[i];
                tmpTraccion[i] = Traccion[i];
                tmpPrecio[i] = Precio[i];
            } else {
                tmpMarca[i] = JOptionPane.showInputDialog("Ingrese la Marca #" + (i + 1 - Cant) + ":");
                tmpModelo[i] = JOptionPane.showInputDialog("Ingrese el Modelo #" + (i + 1 - Cant) + ":");
                tmpColor[i] = JOptionPane.showInputDialog("Ingrese el Color #" + (i + 1 - Cant) + ":");
                Leer = JOptionPane.showInputDialog("Ingrese el Año #" + (i + 1 - Cant) + ":");
                tmpAnio[i] = Integer.parseInt(Leer);
                Leer = JOptionPane.showInputDialog("Ingrese el Recorrido #" + (i + 1 - Cant) + ", en Kilometros:");
                tmpRecorrido[i] = Integer.parseInt(Leer);
                tmpMotor[i] = JOptionPane.showInputDialog("Ingrese el Motor #" + (i + 1 - Cant) + ":");
                tmpTraccion[i] = JOptionPane.showInputDialog("Ingrese la Tracción #" + (i + 1 - Cant) + ":");
                Leer = JOptionPane.showInputDialog("Ingrese el Precio #" + (i + 1 - Cant) + ", en Lempiras:");
                tmpPrecio[i] = Float.parseFloat(Leer);
            }
        }
        Marca = tmpMarca;
        Modelo = tmpModelo;
        Color = tmpColor;
        Anio = tmpAnio;
        Recorrido = tmpRecorrido;
        Motor = tmpMotor;
        Traccion = tmpTraccion;
        Precio = tmpPrecio;
    }

    public static void Eliminar() {
        Leer = JOptionPane.showInputDialog("Ingrese la Posición del Vehiculo a Eliminar:");
        int Pos = Integer.parseInt(Leer);

        String tmpMarca[] = new String[Marca.length - 1];
        String tmpModelo[] = new String[Modelo.length - 1];
        String tmpColor[] = new String[Color.length - 1];
        int tmpAnio[] = new int[Anio.length - 1];
        int tmpRecorrido[] = new int[Recorrido.length - 1];
        String tmpMotor[] = new String[Motor.length - 1];
        String tmpTraccion[] = new String[Traccion.length - 1];
        float tmpPrecio[] = new float[Precio.length - 1];

        for (int i = 0; i < Marca.length; i++) {
            if (i < Pos) {
                tmpMarca[i] = Marca[i];
                tmpModelo[i] = Modelo[i];
                tmpColor[i] = Color[i];
                tmpAnio[i] = Anio[i];
                tmpRecorrido[i] = Recorrido[i];
                tmpMotor[i] = Motor[i];
                tmpTraccion[i] = Traccion[i];
                tmpPrecio[i] = Precio[i];
            } else if (i > Pos) {
                tmpMarca[i - 1] = Marca[i];
                tmpModelo[i - 1] = Modelo[i];
                tmpColor[i - 1] = Color[i];
                tmpAnio[i - 1] = Anio[i];
                tmpRecorrido[i - 1] = Recorrido[i];
                tmpMotor[i - 1] = Motor[i];
                tmpTraccion[i - 1] = Traccion[i];
                tmpPrecio[i - 1] = Precio[i];
            }
        }
        Marca = tmpMarca;
        Modelo = tmpModelo;
        Color = tmpColor;
        Anio = tmpAnio;
        Recorrido = tmpRecorrido;
        Motor = tmpMotor;
        Traccion = tmpTraccion;
        Precio = tmpPrecio;
    }

    public static char Menu() {
        Leer = JOptionPane.showInputDialog(null, "*** Bienvenido ***\n"
                + "A.-> Mostrar en Pantalla.\n"
                + "B.-> Exportar a Excel.\n"
                + "C.-> Agregar Vehiculo(s).\n"
                + "D.-> Modificar un Vehiculo.\n"
                + "E.-> Eliminar un Vehiculo.\n"
                + "F.-> Salir.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; Menú Principal ;-)", 0);
        char Op = Leer.toUpperCase().charAt(0);

        if (Op < 'A' || Op > 'F') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = Menu(); //Llamado Recursivo
        }
        return Op;
    }

    public static void main(String[] args) throws IOException {
        char Op = ' ';
        Predefinido();

        do {
            Op = Menu();
            switch (Op) {
                case 'A':
                    ImprimirCLI();
                    break;
                case 'B':
                    ExportarXls();
                    break;
                case 'C':
                    Agregar();
                    break;
                case 'D':

                    break;
                case 'E':
                    Eliminar();
                    break;
                case 'F':
                    JOptionPane.showMessageDialog(null, "Estimado Usurio!!!\n"
                            + "Agradecemos mucho su preferencia!!!\n"
                            + "Le Esperamos Pronto!!!\n"
                            + "Que tenga un buen y bendecido día!!!");
                    break;
            }
        } while (Op != 'F');

    }

}
