package vehiculos_usados_poo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Programa {
    private String Leer;

    public Agencia[] Predefinido() {
        int Cant = 8;
        Agencia A[] = new Agencia[Cant];
        Vehiculo V[] = new Vehiculo[2];
        
        //Vehiculo(char[] Codigo, String Marca, String Modelo, String Color, int Anio, int Recorrido, String Motor, String Traccion, float Precio)
        A[0] = new Vehiculo("Veh-001".toCharArray(), "Mitsubishi", "Montero Sport", "Negro", 2018, 75000, "2.5cc Diesel", "4x2", 750000);
        A[1] = new Vehiculo("Veh-002".toCharArray(), "Nissan", "Patrol", "Verde", 2006, 48000, "3.0cc Diesel", "4x4", 220000);
        A[2] = new Vehiculo("Veh-003".toCharArray(), "Suzuki", "Jimny", "Plata", 2018, 11000, "1.5cc Gasolina", "4x4", (float) (20000 * 24.25));
        A[3] = new Vehiculo("Veh-004".toCharArray(), "Toyota", "Hilux 2.4", "Gris", 2018, 110000, "2.4cc Diesel", "4x4", 790000);
        //Cliente(char[] Identidad, String Nombre, char Genero, int Edad, char[] Celular, float Ingreso)
        A[4] = new Cliente("0801-1989-00414".toCharArray(),"Denia López",'F',32,"+504 3391 2826".toCharArray(),15000);
        A[5] = new Cliente("0801-1991-00123".toCharArray(),"Allan Brito",'M',30,"+504 3265 0981".toCharArray(),21160);
        //Empleado(char[] Identidad, String Nombre, char Genero, int Edad, char[] Celular, char[] Talento, String Correo, String Puesto, float Sueldo)
        A[6] = new Empleado("0401-1994-09875".toCharArray(),"Alfredo Caballero",'M',28,"+504 3332 9466".toCharArray(),"12345".toCharArray(),"alfredoc@unitec.edu","Gerente de Ventas",24000);
        
        V[0] = (Vehiculo)A[0];
        V[1] = (Vehiculo)A[1];
        
        //Venta(Cliente cliente, Vehiculo[] vehiculo, Empleado vendedor) 
        A[7] = new Venta((Cliente)A[4],V,(Empleado)A[6]);
        
        return A;
    }
    
    public void ImprimirCLI(Agencia A[], char Op) {
        switch (Op) {
            case 'a'://Cliente
                System.out.print("+--------+---------------+--------------------------------------------------+------+----+---------------++------------+\n"
                                +"|Posición|   Identidad   |                 Nombre Completo                  |Género|Edad|Número Celular:||Ingreso Men.|\n"
                                +"+--------+---------------+--------------------------------------------------+------+----+---------------++------------+\n");
                break;
            case 'b'://Vehiculo
                System.out.print("+--------+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n"
                               + "|Posición| Código |    Marca  |     Modelo     |   Color   |   Año   |   Recorrido   |     Motor     |   Tracción   |   Precio   |\n"
                               + "+--------+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n");
                break;
            case 'c'://Empleado
                System.out.print("+--------+---------------+--------------------------------------------------+------+----+---------------++-----+-------------------------+-------------------------+------------+\n"
                                +"|Posición|   Identidad   |                 Nombre Completo                  |Género|Edad|Número Celular:|| RRHH|          Correo         |          Puesto         |Salario Base|\n"
                                +"+--------+---------------+--------------------------------------------------+------+----+---------------++-----+-------------------------+-------------------------+------------+\n");
                break;
            case 'd'://Venta
                System.out.print("+--------+\n"
                                +"|Posición|\n"
                                +"+--------+\n");
                break;
        }
        
        for (int i = 0; i < A.length; i++) {
            if( Op=='a' && A[i] instanceof Cliente ||
                Op=='b' && A[i] instanceof Vehiculo ||
                Op=='c' && A[i] instanceof Empleado){
                System.out.printf("|%8d",i);
                A[i].ImprimirCLI(Op);
                System.out.print("+--------");
                A[i].Borde();
            }else if( Op=='d' && A[i] instanceof Venta ){
                System.out.printf("|%8d|\n",i);
                System.out.print("+--------+\n");
                A[i].ImprimirCLI(Op);
            }
        }
    }

    public void ExportarXls(Agencia A[], char Op) throws IOException {
       String Nombre = "";
        switch (Op) {
            case 'a'://Cliente
                Nombre = "Clientes.xls";
                break;
            case 'b'://Vehiculo
                Nombre = "Vehiculos.xls";
                break;
            case 'c'://Empleado
                Nombre = "Empleados.xls";
                break;
            case 'd'://Venta
                Nombre = "Ventas.xls";
                break;
            default:
                Nombre = "Autolote el Tijuilote.xls";
        }
        
        FileWriter Archivo = new FileWriter(Nombre);
        PrintWriter Linea = new PrintWriter(Archivo);

        switch (Op) {
            case 'a'://Cliente
                Linea.print("Identidad\tNombre Completo\tGénero\tEdad\tNúmero Celular:\tIngreso Men.\n");
                break;
            case 'b'://Vehiculo
                Linea.print("Código\tMarca\tModelo\tColor\tAño\tRecorrido\tMotor\tTracción\tPrecio\n");
                break;
            case 'c'://Empleado
                Linea.print("Identidad\tNombre Completo\tGénero\tEdad\tNúmero Celular:\tRRHH\tCorreo\tPuest\tSalario Base\n");
                break;
         }
        
        for (int i = 0; i < A.length; i++) {
             if( Op=='a' && A[i] instanceof Cliente ||
                Op=='b' && A[i] instanceof Vehiculo ||
                Op=='c' && A[i] instanceof Empleado ||
                Op=='d' && A[i] instanceof Venta ){
                    A[i].Exportar(Linea);
             }
        }
        Archivo.close();
        JOptionPane.showMessageDialog(null, "La Exportación a Excel se realizó exitosamente!!!");
    }
    
    public  Agencia[] Agregar(Agencia A[], char Op) {
        int Cant;
        if (Op != 'e') {
            do{
                Leer = JOptionPane.showInputDialog("Ingrese la Cantidad a Registrar:");
                try{
                    Cant = Integer.parseInt(Leer);                    
                }catch( java.lang.NumberFormatException e){
                    Cant = -1;
                }
                if( Cant<0 ){
                    JOptionPane.showMessageDialog(null, "La Cantidad Ingresada es Incorrecta!!!\nFavor Vuelva a Intentarlo!!!");
                }
            }while( Cant<0 );
            Agencia tmpA[] = new Agencia[A.length + Cant];

            for (int i = 0; i < tmpA.length; i++) {
                if (i < A.length) {
                    tmpA[i] = A[i];
                } else {
                    switch (Op) {
                        case 'a':
                            tmpA[i] = new Cliente();
                            break;
                        case 'b':
                            tmpA[i] = new Vehiculo();
                            break;
                        case 'c':
                            tmpA[i] = new Empleado();
                            break;
                        case 'd':
                            tmpA[i] = new Venta();
                            break;
                    }
                    tmpA[i].setDatos(i);
                }
            }
            return tmpA;
        } else {
            return A;
        }
    }

    public Agencia[] Agregar(Agencia A[], Agencia Var) {
        //int Cant;
        Agencia tmpA[] = new Agencia[A.length + 1];

        for (int i = 0; i < tmpA.length; i++) {
            if (i < A.length) {
                tmpA[i] = A[i];
            } else {
                tmpA[i] = Var;
            }
        }
        return tmpA;
    }
    
    public Agencia[] Eliminar(Agencia A[], char Op) {
        ImprimirCLI( A,Op );
        Leer = JOptionPane.showInputDialog("Ingrese la Posición a Eliminar:");
        int Pos = Integer.parseInt(Leer);

        Agencia tmpA[] = new Agencia[A.length - 1];

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
    
    public Cliente Modificar(Cliente C, char Acc) {
        switch (Acc) {
            case '1':
                C.setIdentidad( JOptionPane.showInputDialog("Ingrese la Actualización del Número de Identidad:").toCharArray() );
                break;
            case '2':
                C.setNombre( JOptionPane.showInputDialog("Ingrese la Actualización del Nombre:") );
                break;
            case '3':
                C.setGenero( JOptionPane.showInputDialog("Ingrese la Actualización del Género de "+C.getNombre()+": ").charAt(0) );
                break;
            case '4':
                C.setEdad( Integer.parseInt( JOptionPane.showInputDialog("Ingrese la Actualización de la Edad de "+C.getNombre()+": ") ) );
                break;
            case '5':
                C.setCelular( JOptionPane.showInputDialog("Ingrese la Actualización del Número de Celular de "+C.getNombre()+": ").toCharArray() );
                break;
            case '6':
                C.setIngreso( Float.parseFloat( JOptionPane.showInputDialog("Digite la Actualización del Ingreso Mensual de "+C.getNombre()+": ") ) );
                break;
        }
        return C;
    }
    
    public Vehiculo Modificar( Vehiculo V, char Acc ){
        switch (Acc) {
            case '1':
                V.setCodigo( JOptionPane.showInputDialog("Ingrese la Actualización del Código: ").toCharArray() );
                break;
            case '2':
                V.setMarca( JOptionPane.showInputDialog("Ingrese la Actualización de la Marca: ") );
                break;
            case '3':
                V.setModelo( JOptionPane.showInputDialog("Ingrese la Actualización del Modelo: ") );
                break;
            case '4':
                V.setColor( JOptionPane.showInputDialog("Ingrese la Actualización del Color: ") );
                break;
            case '5':
                V.setAnio( Integer.parseInt( JOptionPane.showInputDialog("Ingrese la Actualización del Año: ") ) );
                break;
            case '6':
                V.setRecorrido( Integer.parseInt( JOptionPane.showInputDialog("Ingrese la Actualización del Recorrido: ") ) );
                break;
            case '7':
                V.setMotor( JOptionPane.showInputDialog("Ingrese la Actualización del Motor: ") );
                break;
            case '8':
                V.setTraccion( JOptionPane.showInputDialog("Ingrese la Actualización de la Tracción: ") );
                break;
            case '9':
                V.setPrecio( Float.parseFloat( JOptionPane.showInputDialog("Ingrese la Actualización del Precio: ") ) );
                break;
        }
        return V;
    }
    
    public Empleado Modificar(Empleado E, char Acc) {
        switch (Acc) {
            case '1':
                E.setIdentidad(JOptionPane.showInputDialog("Ingrese la Actualización de la Identidad:").toCharArray());
                break;
            case '2':
                E.setNombre(JOptionPane.showInputDialog("Ingrese la Actualización del Nombre:"));
                break;
            case '3':
                E.setGenero(JOptionPane.showInputDialog("Ingrese la Actualización del Género:").charAt(0));
                break;
            case '4':
                E.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Actualización de la Edad:")));
                break;
            case '5':
                E.setCelular(JOptionPane.showInputDialog("Ingrese la Actualización del Número de Celular:").toCharArray());
                break;
            case '6':
                E.setTalento(JOptionPane.showInputDialog("Ingrese la Actualización del Talento Humano:").toCharArray());
                break;
            case '7':
                E.setCorreo(JOptionPane.showInputDialog("Ingrese la Actualización del Correo:"));
                break;
            case '8':
                E.setPuesto(JOptionPane.showInputDialog("Ingrese la Actualización del Puesto:"));
                break;
            case '9':
                E.setSueldo(Float.parseFloat(JOptionPane.showInputDialog("Ingrese la Actualización del Sueldo:")));
                break;
        }
        return E;
    }
    
    public Venta Modificar(Venta V, char Acc) {
        switch (Acc) {
            case '1'://Cliente
                V.setCliente( Modificar( V.getCliente(), MenuModCliente() ) );
                break;
            case '2'://Vehiculos

                break;
            case '3'://Empleado
                V.setVendedor( Modificar(V.getVendedor(), MenuModEmpleado() ) );
                break;
        }
        return V;
    }
    
    public Agencia[] Modificar( Agencia A[], char Op ){
        char Acc = ' ';
        int Pos = -1;
        boolean Modifico = false;
        
        ImprimirCLI( A,Op );
        Pos = Integer.parseInt( JOptionPane.showInputDialog("Ingrese la Posición a Modificar:") );
        
        switch (Op) {
            case 'a':
                if (A[Pos] instanceof Cliente) {
                    Acc = MenuModCliente();
                    A[Pos] = Modificar((Cliente) A[Pos], Acc);
                    Modifico = true;
                } else {
                    Modifico = false;
                }
                break;
            case 'b':
                if (A[Pos] instanceof Vehiculo) {
                    Acc = MenuModVehiculo();
                    A[Pos] = Modificar((Vehiculo) A[Pos], Acc);
                    Modifico = true;
                } else {
                    Modifico = false;
                }
                break;
            case 'c':
                if (A[Pos] instanceof Empleado) {
                    Acc = MenuModEmpleado();
                    A[Pos] = Modificar((Empleado) A[Pos], Acc);
                    Modifico = true;
                } else {
                    Modifico = false;
                }
                break;
            case 'd':
                if (A[Pos] instanceof Venta) {
                    Acc = MenuModVenta();
                    A[Pos] = Modificar( (Venta)A[Pos], Acc );
                    Modifico = true;
                } else {
                    Modifico = false;
                }
                break;
        }
        if( Modifico ){
            JOptionPane.showMessageDialog(null,"La modificación se realizó Exitosamente!!!");            
        }else{
            JOptionPane.showMessageDialog(null,"NO fue posible realizar la modificación debido a un Error!!!\nFavor vuelva a intentarlo!!!\nSi el Prroblema Persiste contactese con el Administrador!!!");   
        }
        return A;
    }
    
    public char Menu() {
        char Op;
        
        Leer = JOptionPane.showInputDialog(null, "*** Bienvenido ***\n"
                + "A.-> Mostrar en Pantalla.\n"
                + "B.-> Exportar a Excel.\n"
                + "C.-> Agregar.\n"
                + "D.-> Modificar.\n"
                + "E.-> Eliminar.\n"
                + "F.-> Salir.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; Menú Principal ;-)", 3);
        try{
            Op = Leer.toUpperCase().charAt(0);            
        }catch ( java.lang.StringIndexOutOfBoundsException e ){
            Op = ' ';
        }catch ( java.lang.NullPointerException e ){
            Op = 'F';
        }

        if (Op < 'A' || Op > 'F') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = Menu(); //Llamado Recursivo
        }
        return Op;
    }
    
    public char SubMenu() {
        char Op;
        
        Leer = JOptionPane.showInputDialog(null, "*** SubMenu ***\n"
                + "a.-> Cliente(s).\n"
                + "b.-> Vehiculo(s).\n"
                + "c.-> Empleado(s).\n"
                + "d.-> Venta(s).\n"
                + "e.-> Regresar al Menu Principal.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; Menú Principal ;-)", 3);
        try{
            Op = Leer.toLowerCase().charAt(0);
        }catch ( java.lang.StringIndexOutOfBoundsException e ){
            Op = ' ';
        }catch ( java.lang.NullPointerException e ){
            Op = 'e';
        }

        if (Op < 'a' || Op > 'e') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = SubMenu(); //Llamado Recursivo
        }
        return Op;
    }
    
    public char MenuModCliente() {
        Leer = JOptionPane.showInputDialog(null, "*** Modificar Cliente ***\n"
                + "1.-> Identidad.\n"
                + "2.-> Nombre.\n"
                + "3.-> Género.\n"
                + "4.-> Edad.\n"
                + "5.-> Celular.\n"
                + "6.-> Ingreso Mensual.\n"
                + "0.-> Regresar al SubMenu.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; SubMenú ;-)", 3);
        char Op = Leer.charAt(0);

        if (Op < '0' || Op > '6') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = MenuModCliente(); //Llamado Recursivo
        }
        return Op;
    }
    
    public char MenuModVehiculo() {
        Leer = JOptionPane.showInputDialog(null, "*** Modificar Vehiculo ***\n"
                + "1.-> Código.\n"
                + "2.-> Marca.\n"
                + "3.-> Modelo.\n"
                + "4.-> Color.\n"
                + "5.-> Año.\n"
                + "6.-> Recorrido.\n"
                + "7.-> Motor.\n"
                + "8.-> Tracción.\n"
                + "9.-> Precio.\n"
                + "0.-> Regresar al SubMenu.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; SubMenú ;-)", 3);
        char Op = Leer.charAt(0);

        if (Op < '0' || Op > '9') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = MenuModVehiculo(); //Llamado Recursivo
        }
        return Op;
    }
    
    public char MenuModEmpleado() {
        Leer = JOptionPane.showInputDialog(null, "*** Modificar Empleado ***\n"
                + "1.-> Identidad.\n"
                + "2.-> Nombre.\n"
                + "3.-> Género.\n"
                + "4.-> Edad.\n"
                + "5.-> Celular.\n"
                + "6.-> Talento Humano.\n"
                + "7.-> Correo.\n"
                + "8.-> Puesto.\n"
                + "9.-> Salario Mensual.\n"
                + "0.-> Regresar al SubMenu.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; SubMenú ;-)", 3);
        char Op = Leer.charAt(0);

        if (Op < '0' || Op > '9') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = MenuModEmpleado(); //Llamado Recursivo
        }
        return Op;
    }
    
    public char MenuModVenta() {
        char Op;
        
        Leer = JOptionPane.showInputDialog(null, "*** Modificar Venta ***\n"
                + "1.-> Cliente(s).\n"
                + "2.-> Vehiculo(s).\n"
                + "3.-> Empleado(s).\n"
                + "0.-> Regresar al Menu Principal.\n"
                + "Ingrese la Letra Correspondiente a la Acción que Desea Realizar:", "(-; SubMenu ;-)", 3);
        try{
            Op = Leer.charAt(0);
        }catch ( java.lang.StringIndexOutOfBoundsException e ){
            Op = ' ';
        }catch ( java.lang.NullPointerException e ){
            Op = '0';
        }

        if (Op < '0' || Op > '3') {
            JOptionPane.showMessageDialog(null, "Estimado Usuario:\n"
                    + "La Opción que ingresó es Incorrecta!!!\n"
                    + "Favor vuelva a Intentarlo!!!");
            Op = MenuModVenta(); //Llamado Recursivo
        }
        return Op;
    }
}
