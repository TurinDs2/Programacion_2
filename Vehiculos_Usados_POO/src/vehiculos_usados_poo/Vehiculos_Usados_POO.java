package vehiculos_usados_poo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Vehiculos_Usados_POO {
    private static String Leer;

    public static Vehiculo[] Predefinido() {
        int Cant = 4;
        Vehiculo A[] = new Vehiculo[Cant];
        
        //Vehiculo(char[] Codigo, String Marca, String Modelo, String Color, int Anio, int Recorrido, String Motor, String Traccion, float Precio)
        A[0] = new Vehiculo("Veh-001".toCharArray(), "Mitsubishi", "Montero Sport", "Negro", 2018, 75000, "2.5cc Diesel", "4x2", 750000);
        A[1] = new Vehiculo("Veh-002".toCharArray(), "Nissan", "Patrol", "Verde", 2006, 48000, "3.0cc Diesel", "4x4", 220000);
        A[2] = new Vehiculo("Veh-003".toCharArray(), "Suzuki", "Jimny", "Plata", 2018, 11000, "1.5cc Gasolina", "4x4", (float) (20000 * 24.25));
        A[3] = new Vehiculo("Veh-004".toCharArray(), "Toyota", "Hilux 2.4", "Gris", 2018, 110000, "2.4cc Diesel", "4x4", 790000);

        return A;
    }
    
    public static void ImprimirCLI(Vehiculo A[]) {
        System.out.print("+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n"
                + "|Posición|   Marca   |     Modelo     |   Color   |   Año   |   Recorrido   |     Motor     |   Tracción   |   Precio   |\n"
                + "+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n");
        for (int i = 0; i < A.length; i++) {
            A[i].ImprimirCLI();
            A[i].Borde();
        }
    }

    public static void ExportarXls(Vehiculo A[]) throws IOException {
        FileWriter Archivo = new FileWriter("Vehiculos Usados.xls");
        PrintWriter Linea = new PrintWriter(Archivo);

        Linea.print("Posición\tMarca\tModelo\tColor\tAño\tRecorrido\tMotor\tTracción\tPrecio\n");
        for (int i = 0; i < A.length; i++) {
            A[i].Exportar(Linea);
        }
        Archivo.close();
        JOptionPane.showMessageDialog(null, "La Exportación a Excel se realizó exitosamente!!!");
    }
    
    public static Vehiculo[] Agregar(Vehiculo A[]) {
        Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Vehiculos Usados a Registrar:");
        int Cant = Integer.parseInt(Leer);

        Vehiculo tmpA[] = new Vehiculo[A.length + Cant];        

        for (int i = 0; i < tmpA.length; i++) {
            if (i < A.length) {
                tmpA[i] = A[i];
            } else {
                tmpA[i] = new Vehiculo();
                tmpA[i].setDatos(i);
            }
        }
        return tmpA;
    }
    
    public static Vehiculo[] Eliminar(Vehiculo A[]) {
        Leer = JOptionPane.showInputDialog("Ingrese la Posición del Vehiculo a Eliminar:");
        int Pos = Integer.parseInt(Leer);

        Vehiculo tmpA[] = new Vehiculo[A.length - 1];

        for (int i = 0; i < A.length; i++) {
            if (i < Pos) {
                tmpA[i] = A[i];
            } else if (i > Pos) {
                tmpA[i - 1] = A[i];
            }
        }
        JOptionPane.showMessageDialog(null, "La Eliminación se realizó exitosamente!!!");
        return tmpA;
    }
    
    public static char Menu() {
        Leer = JOptionPane.showInputDialog(null, "*** Bienvenido ***\n"
                + "A.-> Mostrar en Pantalla.\n"
                + "B.-> Exportar a Excel.\n"
                + "C.-> Agregar Vehiculo(s).\n"
                + "D.-> Modificar un Vehiculo.\n"
                + "E.-> Eliminar un Vehiculo.\n"
                + "F.-> Salir.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; Menú Principal ;-)", 3);
        char Op = Leer.toUpperCase().charAt(0);

        if (Op < 'A' || Op > 'F') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = Menu(); //Llamado Recursivo
        }
        return Op;
    }
    
    public static void main(String[] args)throws IOException {
        char Op = ' ';
        Vehiculo A[];
        
        A = Predefinido();

        do {
            Op = Menu();
            switch (Op) {
                case 'A':
                    ImprimirCLI(A);
                    break;
                case 'B':
                    ExportarXls(A);
                    break;
                case 'C':
                    A = Agregar(A);
                    break;
                case 'D':

                    break;
                case 'E':
                    A = Eliminar(A);
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
