package bienes_raices_poo;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Bienes_Raices_POO {
    static String Leer;
        
    public static char Menu(){
        char Op;
        try {
            Op = JOptionPane.showInputDialog("***Menú Principal***\n"
                    + "A.-> Imprimir.\n"
                    + "B.-> Exportar.\n"
                    + "C.-> Agregar.\n"
                    + "D.-> Modificar.\n"
                    + "E.-> Eliminar.\n"
                    + "F.-> Salir.\n"
                    + "Su Elección es: ").toUpperCase().charAt(0);
        } catch (java.lang.NullPointerException e) {
            Op = 'F';
        } catch (java.lang.StringIndexOutOfBoundsException e){
            Op = '.';
        }
        
        if( Op<'A' || Op>'F' ){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\nFavor vuelva a Intentarlo!!!");
            Op = Menu();//LLamado Recursivo
        }
        
        return Op;
    }
    
    public static char SubMenu(){
        char Op;
        
        Op = JOptionPane.showInputDialog("***SubMenú***\n"
                + "a.-> Bienes Raices.\n"
                + "b.-> Duenio.\n"
                + "c.-> Comprador.\n"
                + "d.-> Oficial de Ventas.\n"
                + "e.-> Administrativo.\n"
                + "f.-> Regresar al Menu Principal.\n"
                + "Su Elección es: ").toLowerCase().charAt(0);
        
        if( Op<'a' || Op>'f' ){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\nFavor vuelva a Intentarlo!!!");
            Op = SubMenu();//LLamado Recursivo
        }
        
        return Op;
    }
    
    public static char MenuModificarBien(){
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
            Op = MenuModificarBien();//LLamado Recursivo
        }
        
        return Op;
    }
    
    public static void Predefinido(Agencia A[]){
        //public Bienes_Raices(String Direccion, String Color, short Nivel, short Habitacion, short Banio, short Parqueo, float Precio) {
        A[0] = new Bienes_Raices("Col. Miraflores", "Violeta", (short)(2), (short)(4), (short)(3), (short)(1), (float)(1950000));
        A[1] = new Bienes_Raices("Col. Kennedy", "Verde", (short)(1), (short)(1), (short)(2), (short)(0), (float)(925000));
        //public OficialNegocio(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, char[] Talento, float Salario, float Comision)
        A[2] = new OficialNegocio("0801-1963-12460".toCharArray(),"Antonio Pacheco",'M',(short)58,"8915-6210".toCharArray(),"HN500".toCharArray(),(float)12000,(float)(0.010) );
        A[3] = new OficialNegocio("0605-1984-00531".toCharArray(),"Rodrigo Gonzalez",'M',(short)38,"3290-1415".toCharArray(),"HN102".toCharArray(),(float)9600,(float)(0.017) );
        //public Comprador(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, Bienes_Raices Bien, OficialNegocio Vendedor, String Cita, float Ingreso)
        A[4] = new Comprador("0801-1994-20926".toCharArray(),"Carmen Cruz",'F',(short)28,"3689-2022".toCharArray(),(Bienes_Raices)A[0],(OficialNegocio)A[3],"Sabado 05 Febrero de 2022 2:00.p.m.",(float)34000);
        A[5] = new Comprador("0801-1990-00531".toCharArray(),"Javier Andino",'M',(short)32,"3395-8943".toCharArray(),(Bienes_Raices)A[0],(OficialNegocio)A[3],"Viernes 04 Febrero de 2022 4:00.p.m.",(float)34000);
        //public Duenio(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, Bienes_Raices Bien, OficialNegocio Vendedor)
        A[6] = new Duenio("0801-2000-00482".toCharArray(),"Luis Gonzalez",'M',(short)22,"9574-0831".toCharArray(),(Bienes_Raices)A[0],(OficialNegocio)A[3]);
        A[7] = new Duenio("0801-1995-01023".toCharArray(),"Javier Bernítez",'M',(short)27,"9835-2322".toCharArray(),(Bienes_Raices)A[1],(OficialNegocio)A[2]);
        // public Administrativo( char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, char[] Talento, float Salario, String Cargo )
        A[8] = new Administrativo("0801-1993-19007".toCharArray(),"Julio Chacón",'M',(short)29,"9527-2047".toCharArray(),"HN067".toCharArray(),(float)30000,"Gerente");
        A[9] = new Administrativo("0801-1998-01023".toCharArray(),"María Gonzalez",'F',(short)24,"8832-1523".toCharArray(),"HN055".toCharArray(),(float)15000,"Secretario");        
    }
    
    public static Agencia[] Ingreso( Agencia A[], char Op, int Tam ){
        Agencia tmpA[] = new Agencia [ Tam ];
                
        for (int i = 0; i < Tam; i++) {
            if( i < A.length ){
                tmpA[i] = A[i];
            }else{
                switch (Op) {
                    case 'a':
                        tmpA[i] = new Bienes_Raices();
                        break;
                    case 'b':
                        tmpA[i] = new Duenio();
                        break;
                    case 'c':
                        tmpA[i] = new Comprador();
                        break;
                    case 'd':
                        tmpA[i] = new OficialNegocio();
                        break;
                    case 'e':
                        tmpA[i] = new Administrativo();
                        break;
                }
                tmpA[i].Leer(i);
            }
        }        
        return tmpA;
    }
    
    public static void Imprimir(Agencia A[], char Op){
        switch (Op) {
            case 'a':
                System.out.print("+--------+-----------------------------+---------------+-------+------------+-----+--------+-------------+\n"
                                +"|Posición|          Direccion          |     Color     |Niveles|Habitaciones|Baños|Parqueos|    Precio   |\n"
                                +"+--------+-----------------------------+---------------+-------+------------+-----+--------+-------------+\n");
                break;
            case 'b':
                System.out.print("+--------+---------------+---------------------------------------------+------+----+---------------++-----------------------------+-------------++---------------------------------------------+---------------+-------+\n"
                                +"|Posición|   Identidad   |                     Nombre                  |Genero|Edad|     Celular   ||  Dirección de Casa en Venta |   Precio    ||    Nombre del Oficial de Ventas Asignado    |    Celular    |Código |\n"
                                +"+--------+---------------+---------------------------------------------+------+----+---------------++-----------------------------+-------------++---------------------------------------------+---------------+-------+\n");
                break;
            case 'c':
                System.out.print("+--------+---------------+---------------------------------------------+------+----+---------------++-----------------------------+-------------++---------------------------------------------+---------------+-------++----------------------------------------+----------+\n"
                                +"|Posición|   Identidad   |                     Nombre                  |Genero|Edad|     Celular   ||  Dirección de Casa en Venta |   Precio    ||    Nombre del Oficial de Ventas Asignado    |    Celular    |Código ||                 Cita                   | Ingreso  |\n"
                                +"+--------+---------------+---------------------------------------------+------+----+---------------++-----------------------------+-------------++---------------------------------------------+---------------+-------++----------------------------------------+----------+\n");
                break;
            case 'd':
                System.out.print("+--------+---------------+---------------------------------------------+------+----+---------------++-------+----------++----------+\n"
                                +"|Posición|   Identidad   |                     Nombre                  |Genero|Edad|     Celular   ||Talento|  salario || Comision |\n"
                                +"+--------+---------------+---------------------------------------------+------+----+---------------++-------+----------++----------+\n");
                break;
            case 'e':
                System.out.print("+--------+---------------+---------------------------------------------+------+----+---------------++-------+----------++--------------------+\n"
                                +"|Posición|   Identidad   |                     Nombre                  |Genero|Edad|     Celular   ||Talento|  Salario ||        Cargo       |\n"
                                +"+--------+---------------+---------------------------------------------+------+----+---------------++-------+----------++--------------------+\n");
                break;
        }
        
        for (int i = 0; i < A.length; i++) {
            if ( Op=='a' && A[i] instanceof Bienes_Raices ||
                 Op=='b' && A[i] instanceof Duenio ||
                 Op=='c' && A[i] instanceof Comprador ||
                 Op=='d' && A[i] instanceof OficialNegocio ||
                 Op=='e' && A[i] instanceof Administrativo ){
                A[i].ImprimirCLI(i);
                A[i].Borde();
            }            
        }
    }

    public static void Exportar(Agencia A[], char Op)throws IOException{
        FileWriter Archivo = new FileWriter("Agencia.xls");
        PrintWriter Fila = new PrintWriter(Archivo);
        switch (Op) {
            case 'a':
                Archivo = new FileWriter("Casas.xls");
                Fila = new PrintWriter(Archivo);
                Fila.print("Direccion\tColor\tNiveles\tHabitaciones\tBaños\tParqueos\tPrecio\n");
                break;
            case 'b':
                Archivo = new FileWriter("Duenios.xls");
                Fila = new PrintWriter(Archivo);
                Fila.print("Identidad\tNombre\tGenero\tEdad\tCelular\tDirección de Casa en Venta\tPrecio\tNombre del Oficial de Ventas Asignado\tCelular\tCódigo\n");
                break;
            case 'c':
                Archivo = new FileWriter("Compradores.xls");
                Fila = new PrintWriter(Archivo);
                Fila.print("Identidad\tNombre\tGenero\tEdad\tCelular\tDirección de Casa en Venta\tPrecio\tNombre del Oficial de Ventas Asignado\tCelular\tCódigo\tCita\tIngreso\n");
                break;
            case 'd':
                Archivo = new FileWriter("Vendedores.xls");
                Fila = new PrintWriter(Archivo);
                Fila.print("Identidad\tNombre\tGenero\tEdad\tCelular\tTalento\tsalario\tComision\n");
                break;
            case 'e':
                Archivo = new FileWriter("Administrativos.xls");
                Fila = new PrintWriter(Archivo);
                Fila.print("Identidad\tNombre\tGenero\tEdad\tCelular\tTalento\tSalario\tCargo\n");
                break;
        }
        for (int i = 0; i < A.length; i++) {
            if( Op=='a' && A[i] instanceof Bienes_Raices ||
                Op=='b' && A[i] instanceof Duenio ||
                Op=='c' && A[i] instanceof Comprador ||
                Op=='d' && A[i] instanceof OficialNegocio ||
                Op=='e' && A[i] instanceof Administrativo ){
                A[i].Exportar(Fila);
            }
        }
        
        Archivo.close();
    }
    
    public static Agencia[] Eliminar( Agencia A[], char Op, int Pos ){
        if( Op=='a' && A[Pos] instanceof Bienes_Raices ||
            Op=='b' && A[Pos] instanceof Duenio ||
            Op=='c' && A[Pos] instanceof Comprador ||
            Op=='d' && A[Pos] instanceof OficialNegocio ||
            Op=='e' && A[Pos] instanceof Administrativo ){
            Agencia tmpA[] = new Agencia [ A.length-1 ];
        
            for (int i = 0; i < A.length; i++) {
                if( i<Pos ){
                    tmpA[i] = A[i];
                }else if( i>Pos ){
                    tmpA[i-1] = A[i];
                }
            }
            System.out.println("La Eliminación se Realizó Exitosamente!!!");
            return tmpA;
        }else{
            JOptionPane.showMessageDialog(null,"La posición Ingresada NO coincide con el Tipo a Eliminar!!!");
            return A;
        }    
    }
    
    public static Agencia Modificar( Agencia BR, char Op ){
        if( Op=='a' && BR instanceof Bienes_Raices ){
            char OpMod = MenuModificarBien();

            switch (OpMod) {
                case 'a':
                    ((Bienes_Raices)BR).setDireccion( JOptionPane.showInputDialog("Ingrese la nueva dirección:") );
                    break;
                case 'b':

                    break;
                case 'c':
                    Leer = JOptionPane.showInputDialog("Ingrese la nueva cantidad de niveles:");
                    ((Bienes_Raices)BR).setNivel( Short.parseShort(Leer) );
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
            
        }else if( Op=='b' && BR instanceof Duenio ){
            
        }else if( Op=='c' && BR instanceof Comprador ){
            
        }else if( Op=='d' && BR instanceof OficialNegocio ){
            
        }else if( Op=='e' && BR instanceof Administrativo ){
                    
        }else{
            JOptionPane.showMessageDialog(null,"La posición Ingresada NO coincide con el Tipo a Modificar!!!");
        } 
        return BR;
    }
    
    public static void main(String[] args)throws IOException {
        char OpMenu, SM;
        int Pos;
        short Tam = 10;
        
        //Creación de Arreglos
        Agencia A[] = new Agencia [Tam];

        Predefinido(A);
        
        do{
            OpMenu = Menu();
            
            switch (OpMenu) {
                case 'A':
                    Imprimir( A, SubMenu() );
                    break;
                case 'B':
                    SM = SubMenu();
                    Exportar( A, SM );
                    System.out.println("Se Realizó Exportación a Excel de los Siguientes Elementos:");
                    Imprimir( A, SM );
                    break;
                case 'C':
                    SM = SubMenu();
                    
                    Leer = JOptionPane.showInputDialog("Cantidad de Registros a Ingresar:");
                    Tam += Short.parseShort( Leer );

                    A = Ingreso( A, SM, Tam);                    
                    break;
                case 'D'://Modificar\
                    SM = SubMenu();
                    
                    Imprimir( A, SM );
                    Leer = JOptionPane.showInputDialog("Ingrese la Posición a Modificar: ");
                    Pos = Integer.parseInt(Leer);
                    A[Pos] = Modificar( A[Pos], SM );
                    System.out.println("La Modificación se Realizó Exitosamente!!!");
                    Imprimir( A,SM );
                    break;    
                case 'E':
                    SM = SubMenu();
                    Imprimir( A, SM );
                    Leer = JOptionPane.showInputDialog("Ingrese la Posición a Eliminar: ");
                    Pos = Integer.parseInt(Leer);
                    A = Eliminar( A, SM , Pos );
                    Imprimir( A, SM );
                    break;
                case 'F':
                    JOptionPane.showMessageDialog(null, "Gracias por su Visita!!!\nLe esperamos pronto!!!");
                    break;
            }
            
        }while( OpMenu != 'F' );      
        
    }
    
}
