package bienes_raices_poo;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Bienes_Raices_POO {
    static String Leer;
        
    public static char Menu(){
        char Op;
        
        Op = JOptionPane.showInputDialog("***Menú Principal***\n"
                + "A.-> Imprimir.\n"
                + "B.-> Exportar.\n"
                + "C.-> Agregar.\n"
                + "D.-> Modificar.\n"
                + "E.-> Eliminar.\n"
                + "F.-> Salir.\n"
                + "Su Elección es: ").toUpperCase().charAt(0);
        
        if( Op<'A' || Op>'F' ){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\nFavor vuelva a Intentarlo!!!");
            Op = Menu();//LLamado Recursivo
        }
        
        return Op;
    }
    
    public static char MenuModificar(){
        char Op;
        
        Op = JOptionPane.showInputDialog("***Menú Modificar***\n"
                + "a.-> Direccón.\n"
                + "b.-> Color.\n"
                + "c.-> Nivel.\n"
                + "d.-> Habitación.\n"
                + "e.-> Baño.\n"
                + "f.-> Parqueo.\n"
                + "g.-> Precio.\n"
                + "h.-> Regresar al Manu Pricipal"
                + "Su Elección es: ").toLowerCase().charAt(0);
        
        if( Op<'a' || Op>'h' ){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\nFavor vuelva a Intentarlo!!!");
            Op = MenuModificar();//LLamado Recursivo
        }
        
        return Op;
    }
    
    public static void Predefinido(Bienes_Raices A[]){
        //public Bienes_Raices(String Direccion, String Color, short Nivel, short Habitacion, short Banio, short Parqueo, float Precio) {
        A[0] = new Bienes_Raices("Col. Miraflores", "Violeta", (short)(2), (short)(4), (short)(3), (short)(1), (float)(1950000));
        A[1] = new Bienes_Raices("Col. Kennedy", "Verde", (short)(1), (short)(1), (short)(2), (short)(0), (float)(925000));
    }
    
    public static Bienes_Raices[] Ingreso(Bienes_Raices A[], int Tam){
        Bienes_Raices tmpA[] = new Bienes_Raices [ Tam ];
                
        for (int i = 0; i < Tam; i++) {
            if( i < A.length ){
                tmpA[i] = A[i];
            }else{
                tmpA[i] = new Bienes_Raices();
                tmpA[i].setDireccion( JOptionPane.showInputDialog("Ingrese la Dirección de la Casa #"+(i+1)+":") );
                tmpA[i].setColor( JOptionPane.showInputDialog("Ingrese el Color de la Casa #"+(i+1)+":") );
                Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Niveles de la Casa #"+(i+1)+":");
                tmpA[i].setNivel( Short.parseShort(Leer) );
                Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Habitaciones de la Casa #"+(i+1)+":");
                tmpA[i].setHabitacion( Short.parseShort(Leer) );
                Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Baños de la Casa #"+(i+1)+":");
                tmpA[i].setBanio( Short.parseShort(Leer) );
                Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Parqueos de la Casa #"+(i+1)+":");
                tmpA[i].setParqueo( Short.parseShort(Leer) );
                Leer = JOptionPane.showInputDialog("Ingrese el Precio de la Casa #"+(i+1)+":");
                tmpA[i].setPrecio( Float.parseFloat(Leer) );
            }
        }
        
        return tmpA;
    }
    
    public static void Imprimir(Bienes_Raices A[]){
        System.out.print("+--------+-----------------------------+---------------+-------+------------+-----+--------+-------------+\n"
                        +"|Posición|          Direccion          |     Color     |Niveles|Habitaciones|Baños|Parqueos|    Precio   |\n"
                        +"+--------+-----------------------------+---------------+-------+------------+-----+--------+-------------+\n");
        for (int i = 0; i < A.length; i++) {
            A[i].ImprimirCLI(i);
            A[i].Borde();
        }
    }

    public static void Exportar(Bienes_Raices A[])throws IOException{
        FileWriter Archivo = new FileWriter("Casas.xls");
        PrintWriter Fila = new PrintWriter(Archivo);
        
        Fila.print("Direccion \t Color \t Niveles \t Habitaciones \t Baños \t Parqueos \t Precio \n");
        for (int i = 0; i < A.length; i++) {
            A[i].Exportar(Fila);
        }
        
        Archivo.close();
    }
    
    public static Bienes_Raices[] Eliminar(Bienes_Raices A[],int Pos){
        Bienes_Raices tmpA[] = new Bienes_Raices [ A.length-1 ];
        
        for (int i = 0; i < A.length; i++) {
            if( i<Pos ){
                tmpA[i] = A[i];
            }else if( i>Pos ){
                tmpA[i-1] = A[i];
            }
        }
        
        return tmpA;
    }
    
    public static Bienes_Raices Modificar(Bienes_Raices BR){
        char OpMod = MenuModificar();
        
        switch (OpMod) {
            case 'a':
                BR.setDireccion( JOptionPane.showInputDialog("Ingrese la nueva dirección:") );
                break;
            case 'b':
                
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la nueva cantidad de niveles:");
                BR.setNivel( Short.parseShort(Leer) );
                break;
            case 'd':
                
                break;
            case 'e':
                
                break;
            case 'f':
                
                break;
            case 'g':
                
                break;
        }
        
        return BR;
    }
    
    public static void main(String[] args)throws IOException {
        char OpMenu;
        int Pos;
        short Tam = 2;
        
        //Creación de Arreglos
        Bienes_Raices A[] = new Bienes_Raices [Tam];

        Predefinido(A);
        
        do{
            OpMenu = Menu();
            
            switch (OpMenu) {
                case 'A':
                    Imprimir(A);
                    break;
                case 'B':
                    Exportar(A);
                    System.out.println("Se Realizó Exportación a Excel de los Siguientes Elementos:");
                    Imprimir(A);
                    break;
                case 'C':
                    Leer = JOptionPane.showInputDialog("Cantidad de Casas a Registrar:");
                    Tam += Short.parseShort( Leer );

                    A = Ingreso(A,Tam);                    
                    break;
                case 'D'://Modificar
                    Imprimir(A);
                    Leer = JOptionPane.showInputDialog("Ingrese la Posición a Modificar: ");
                    Pos = Integer.parseInt(Leer);
                    A[Pos] = Modificar( A[Pos] );
                    System.out.println("La Modificación se Realizó Exitosamente!!!");
                    Imprimir(A);
                    break;    
                case 'E':
                    Imprimir(A);
                    Leer = JOptionPane.showInputDialog("Ingrese la Posición a Eliminar: ");
                    Pos = Integer.parseInt(Leer);
                    A = Eliminar( A,Pos );
                    System.out.println("La Eliminación se Realizó Exitosamente!!!");
                    Imprimir(A);
                    break;
                case 'F':
                    JOptionPane.showMessageDialog(null, "Gracias por su Visita!!!\nLe esperamos pronto!!!");
                    break;
            }
            
        }while( OpMenu != 'F' );      
        
    }
    
}
