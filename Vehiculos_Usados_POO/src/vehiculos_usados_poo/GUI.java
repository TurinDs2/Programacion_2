package vehiculos_usados_poo;

import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileReader;
import java.util.Scanner;

public class GUI extends javax.swing.JFrame {

    private ButtonGroup Menu = new ButtonGroup();
    private ButtonGroup SubMenu = new ButtonGroup();
    private DefaultTableModel Modelo = new DefaultTableModel();
    private Agencia A[] = new Agencia[0];
    private char OpM, OpSm;
    private Programa P = new Programa();
    private String Consulta;
    private Connection Con;
    private ResultSet Resultado;

    public GUI() {
        initComponents();
        Menu.add(this.RB_Mostrar);
        Menu.add(this.RB_Exportar);
        Menu.add(this.RB_Agregar);
        Menu.add(this.RB_Modificar);
        Menu.add(this.RB_Eliminar);
        Menu.add(this.RB_InsertarBD);
        Menu.add(this.RB_SeleccionarBD);
        Menu.add(this.RB_ImportarArchivo);

        SubMenu.add(this.RB_Cliente);
        SubMenu.add(this.RB_Vehiculo);
        SubMenu.add(this.RB_Empleado);
        SubMenu.add(this.RB_Venta);

        Habilitar(false, '#');

        A = P.Predefinido();
        
        Conexion();
        
    }

    public void Habilitar(boolean B, char Op) {
        if ( Op == '#' ) {
            this.RB_Cliente.setEnabled(B);
            this.RB_Vehiculo.setEnabled(B);
            this.RB_Empleado.setEnabled(B);
            this.RB_Venta.setEnabled(B);

            this.Btn_Aceptar.setEnabled(B);
        }
        
        if ( Op >= 'A' && Op <= 'H' ) {
            this.RB_Cliente.setEnabled(B);
            this.RB_Vehiculo.setEnabled(B);
            this.RB_Empleado.setEnabled(B);
            this.RB_Venta.setEnabled(B);
        }
        
        if (Op >= 'a' && Op <= 'd') {
            this.Btn_Aceptar.setEnabled(B);
        }
    }

    public void HabilitarSM() {
        this.RB_Cliente.setEnabled(false);
        this.RB_Vehiculo.setEnabled(false);
        this.RB_Empleado.setEnabled(false);
        this.RB_Venta.setEnabled(false);

        this.Btn_Aceptar.setEnabled(false);
    }
    
    /************************************************************************************SQL************************************/
    /*
    INSERT INTO www_Carlos (Identidad, Nombre, Edad, Fecha_Dosis_1, Fecha_Dosis_2, Fecha_Dosis_3) VALUES ('1003-2000-19872', 'Jose Francisco Sánchez Beltran', '21', '25 Junio 2021', '25 Septiembre 2021', '25 Diciembre 2021')
    
    mysql -h remotemysql.com -u OjobZcLXLL -p
    NugW9RiI7I
    
    show databases;
    use OjobZcLXLL;
    show tables;
    
    create table Cliente(Identidad varchar(15),Nombre varchar(50),Genero varchar(1),Edad int, Celular varchar(15),Salario float);
    insert into Cliente(Identidad,Nombre,Genero,Edad,Celular,Salario)values('0801-1994-00415','Doris Gutierrez','F',27,'+504-7214-2833',15000);
    select * from Cliente;
    
    create table Vehiculo(Codigo varchar(8), Marca varchar(11), Modelo varchar(16), Color varchar(11), Anio int, Recorrido int, Motor varchar(15), Traccion varchar(14), Precio float);
    insert into Vehiculo(Codigo, Marca, Modelo, Color, Anio, Recorrido, Motor, Traccion, Precio)values('Veh-001','Lamborguini','Urus','Rojo Metal',2018,50000,'V8 biturbo 4lts','4x4',1000000);
    select *from Vehiculo;
    
    create table Empleado(Identidad varchar(15), Nombre varchar(50), Genero char(1), Edad int, Celular varchar(15), Talento varchar(5), Correo varchar(25), Puesto varchar(25), Sueldo float);
    insert into Empleado(Identidad, Nombre, Genero, Edad, Celular, Talento, Correo, Puesto, Sueldo)values('0801-1999-00142','Francisco Pérez López','M',22,'31711262','12345','chichico@unitec.edu','Gerente de Ventas',24000);
    select *from Empleado;
    
    */
    
    public void Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/OjobZcLXLL","OjobZcLXLL","NugW9RiI7I");
            //JOptionPane.showMessageDialog(null,"Conexión Exitosa!!!");
        }catch (java.lang.ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Falta el Driver de Conexión!!!");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO es posible establecer conexión!!!\nFavor Verificar BD, Usuario y Contraseña!!!");
        }
    }
    
    public boolean InsertarBD(char Op){
        try {
            Conexion();
            Statement st = Con.createStatement();
            
            for (int i = 0; i < A.length; i++) {
                if (Op == 'a' && A[i] instanceof Cliente){
                    Consulta = "insert into Cliente(Identidad,Nombre,Genero,Edad,Celular,Salario)values('"+
                            String.valueOf( ((Cliente)A[i]).getIdentidad() )+"','"+
                            ((Cliente)A[i]).getNombre()+"','"+
                            ((Cliente)A[i]).getGenero()+"',"+
                            ((Cliente)A[i]).getEdad()+",'"+
                            String.valueOf( ((Cliente)A[i]).getCelular() )+"',"+
                            ((Cliente)A[i]).getIngreso()+");";
                    st.execute(Consulta);
                }else if (Op == 'b' && A[i] instanceof Vehiculo){//Laboratorio 8
                    
                }else if (Op == 'c' && A[i] instanceof Empleado){//Laboratorio 8
                    
                }else if (Op == 'd' && A[i] instanceof Venta){
                    Consulta = "insert into Cliente(Identidad,Nombre,Genero,Edad,Celular,Salario)values('"+
                            String.valueOf( ((Venta)A[i]).getCliente().getIdentidad() )+"','"+
                            ((Venta)A[i]).getCliente().getNombre()+"','"+
                            ((Venta)A[i]).getCliente().getGenero()+"',"+
                            ((Venta)A[i]).getCliente().getEdad()+",'"+
                            String.valueOf( ((Venta)A[i]).getCliente().getCelular() )+"',"+
                            ((Venta)A[i]).getCliente().getIngreso()+");";
                    st.execute(Consulta);
                    
                    for (int j = 0; j < ((Venta)A[i]).getVehiculo().length ; j++) {
                        Consulta = "insert into Vehiculo(Codigo, Marca, Modelo, Color, Anio, Recorrido, Motor, Traccion, Precio)values('"+
                            String.valueOf( ((Venta)A[i]).getVehiculo()[j].getCodigo() )+"','"+
                            ((Venta)A[i]).getVehiculo()[j].getMarca()+"','"+
                            ((Venta)A[i]).getVehiculo()[j].getModelo()+"','"+
                            ((Venta)A[i]).getVehiculo()[j].getColor()+"',"+
                            ((Venta)A[i]).getVehiculo()[j].getAnio()+","+
                            ((Venta)A[i]).getVehiculo()[j].getRecorrido()+",'"+
                            ((Venta)A[i]).getVehiculo()[j].getMotor()+"','"+
                            ((Venta)A[i]).getVehiculo()[j].getTraccion()+"',"+
                            ((Venta)A[i]).getVehiculo()[j].getPrecio()+");";
                        st.execute(Consulta);
                    }
                    
                    Consulta = "insert into Empleado(Identidad, Nombre, Genero, Edad, Celular, Talento, Correo, Puesto, Sueldo)values('"+
                            String.valueOf( ((Venta)A[i]).getVendedor().getIdentidad() )+"','"+
                            ((Venta)A[i]).getVendedor().getNombre()+"','"+
                            ((Venta)A[i]).getVendedor().getGenero()+"',"+
                            ((Venta)A[i]).getVendedor().getEdad()+",'"+
                            String.valueOf( ((Venta)A[i]).getVendedor().getCelular() )+"','"+
                            String.valueOf( ((Venta)A[i]).getVendedor().getTalento() )+"','"+
                            ((Venta)A[i]).getVendedor().getCorreo()+"','"+
                            ((Venta)A[i]).getVendedor().getPuesto()+"',"+
                            ((Venta)A[i]).getVendedor().getSueldo()+");";
                    st.execute(Consulta);                    
                }
            }
            JOptionPane.showMessageDialog(null,"La Inserción en la Base de Datos se Realizó Exitosamente!!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO fue posible realizar la Inserción en la Base de Datos!!!");
            return false;
        }finally{
            CerrarConexion();
        }
        return true;
    }
    
    public boolean SeleccionarBD(char Op){
        Agencia Var;
        try {
            Conexion();
            Statement st = Con.createStatement();
            switch (Op) {
                case 'a':
                    Consulta = "select * from Cliente;";
                    Resultado = st.executeQuery(Consulta);
                    
                    for (; Resultado.next();) {
                        //Cliente(char[] Identidad, String Nombre, char Genero, int Edad, char[] Celular, float Ingreso)
                        Var = new Cliente(Resultado.getString("Identidad").toCharArray(),
                                Resultado.getString("Nombre"),
                                Resultado.getString("Genero").charAt(0),
                                Resultado.getInt("Edad"),
                                Resultado.getString("Celular").toCharArray(),
                                Resultado.getFloat("Salario")
                        );
                        A = P.Agregar(A,Var);
                    }
                    break;
                case 'b'://Laboratorio 8

                    break;
                case 'c'://Laboratorio 8
                    
                    break;
                case 'd':
                    
                    break;
            }
            JOptionPane.showMessageDialog(null,"La Selección desde la Base de Datos se Realizó Exitosamente!!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO fue posible realizar la Selección desde la Base de Datos!!!");
            return false;
        }
        return true;
    }
    
    public void CerrarConexion(){
        try {
            Con.close();
            //JOptionPane.showMessageDialog(null,"Conexión Cerrada Exitosamente!!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO es posible cerrar conexión!!!\nFavor espere un momento y vuelva a intentarlo!!!");
        }
    }
    
    /************************************************************************************SQL************************************/

    public String[] EtiquetasCliente() {
        String Etiquetas[] = {"Posición", "Identidad", "Nombre Completo", "Género", "Edad", "Número Celular", "Ingreso Mensual"};
        return Etiquetas;
    }

    public String[] EtiquetasVehiculo() {
        String Etiquetas[] = {"Posición", "Código", "Marca", "Modelo", "Color", "Año", "Recorrido", "Motor", "Tracción", "Precio"};
        return Etiquetas;
    }

    public String[] EtiquetasEmpleado() {
        String Etiquetas[] = {"Posición", "Identidad", "Nombre Completo", "Género", "Edad", "Número Celular", "RRHH", "Correo", "Puesto", "Salario Base"};
        return Etiquetas;
    }

    public void ImprimirGUI(Agencia A[], char Op) {
        String Etiquetas[] = {}, Datos[][] = {};

        switch (Op) {
            case 'a':
                Etiquetas = EtiquetasCliente();
                break;
            case 'b':
                Etiquetas = EtiquetasVehiculo();
                break;
            case 'c':
                Etiquetas = EtiquetasEmpleado();
                break;
            case 'd':
                MostraVentas Aplicacion = new MostraVentas(EtiquetasCliente(), EtiquetasVehiculo(), EtiquetasEmpleado(), A );
                Aplicacion.setDefaultCloseOperation(1);
                Aplicacion.setVisible(true);
                break;
        }

        Modelo = new DefaultTableModel(Datos, Etiquetas);
        this.Tbl_Mostrar.setModel(Modelo);

        for (int i = 0; i < A.length; i++) {
            if (Op == 'a' && A[i] instanceof Cliente) {
                Object Linea[] = {i, String.valueOf(((Cliente) A[i]).getIdentidad()), ((Cliente) A[i]).getNombre(), ((Cliente) A[i]).getGenero(), ((Cliente) A[i]).getEdad(), String.valueOf(((Cliente) A[i]).getCelular()), ((Cliente) A[i]).getIngreso()};
                Modelo.addRow(Linea);
            } else if (Op == 'b' && A[i] instanceof Vehiculo) {
                Object Linea[] = {i, String.valueOf(((Vehiculo) A[i]).getCodigo()), ((Vehiculo) A[i]).getMarca(), ((Vehiculo) A[i]).getModelo(), ((Vehiculo) A[i]).getColor(), ((Vehiculo) A[i]).getAnio(), ((Vehiculo) A[i]).getRecorrido(), ((Vehiculo) A[i]).getMotor(), ((Vehiculo) A[i]).getTraccion(), ((Vehiculo) A[i]).getPrecio()};
                Modelo.addRow(Linea);
            } else if (Op == 'c' && A[i] instanceof Empleado) {
                Object Linea[] = {i, String.valueOf(((Empleado) A[i]).getIdentidad()), ((Empleado) A[i]).getNombre(), ((Empleado) A[i]).getGenero(), ((Empleado) A[i]).getEdad(), String.valueOf(((Empleado) A[i]).getCelular()), String.valueOf(((Empleado) A[i]).getTalento() ), ((Empleado) A[i]).getCorreo(), ((Empleado) A[i]).getPuesto(), ((Empleado) A[i]).getSueldo()};
                Modelo.addRow(Linea);
            }
        }
    }
    
    public void ImportarArchivo(char Op)throws java.io.IOException{
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
        }
        
        FileReader Archivo = new FileReader(Nombre);
        Scanner Leer = new Scanner(Archivo);
        
        for ( ; Leer.hasNext(); ) {//Completar Alumnos            
            System.out.println( Leer.next() );
        }//Hasta Aquí
        
        Archivo.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Btn_Aceptar = new javax.swing.JButton();
        RB_Mostrar = new javax.swing.JRadioButton();
        RB_Exportar = new javax.swing.JRadioButton();
        RB_Agregar = new javax.swing.JRadioButton();
        RB_Modificar = new javax.swing.JRadioButton();
        RB_Eliminar = new javax.swing.JRadioButton();
        RB_Cliente = new javax.swing.JRadioButton();
        RB_Vehiculo = new javax.swing.JRadioButton();
        RB_Empleado = new javax.swing.JRadioButton();
        RB_Venta = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Mostrar = new javax.swing.JTable();
        Lbl_Titulo = new javax.swing.JLabel();
        RB_InsertarBD = new javax.swing.JRadioButton();
        RB_SeleccionarBD = new javax.swing.JRadioButton();
        RB_ImportarArchivo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_Aceptar.setText("Aceptar");
        Btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AceptarActionPerformed(evt);
            }
        });

        RB_Mostrar.setText("Mostrar");
        RB_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_MostrarActionPerformed(evt);
            }
        });

        RB_Exportar.setText("Exportar");
        RB_Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_ExportarActionPerformed(evt);
            }
        });

        RB_Agregar.setText("Agregar");
        RB_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_AgregarActionPerformed(evt);
            }
        });

        RB_Modificar.setText("Modificar");
        RB_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_ModificarActionPerformed(evt);
            }
        });

        RB_Eliminar.setText("Eliminar");
        RB_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_EliminarActionPerformed(evt);
            }
        });

        RB_Cliente.setText("Cliente(s)");
        RB_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_ClienteActionPerformed(evt);
            }
        });

        RB_Vehiculo.setText("Vehiculo(s)");
        RB_Vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_VehiculoActionPerformed(evt);
            }
        });

        RB_Empleado.setText("Empleado(s)");
        RB_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_EmpleadoActionPerformed(evt);
            }
        });

        RB_Venta.setText("Venta(s)");
        RB_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_VentaActionPerformed(evt);
            }
        });

        Tbl_Mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tbl_Mostrar);

        Lbl_Titulo.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        Lbl_Titulo.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_Titulo.setText("Autolote \"El Tijuilote\"");

        RB_InsertarBD.setText("Insertar en BD");
        RB_InsertarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_InsertarBDActionPerformed(evt);
            }
        });

        RB_SeleccionarBD.setText("Seleccionar de BD");
        RB_SeleccionarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_SeleccionarBDActionPerformed(evt);
            }
        });

        RB_ImportarArchivo.setText("Importar desde Archivo");
        RB_ImportarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_ImportarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(Lbl_Titulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RB_Modificar)
                            .addComponent(RB_Agregar)
                            .addComponent(RB_Exportar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RB_Empleado)
                            .addComponent(RB_Venta)
                            .addComponent(RB_Vehiculo))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RB_Eliminar)
                                .addGap(339, 339, 339)
                                .addComponent(Btn_Aceptar))
                            .addComponent(RB_Mostrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RB_Cliente)
                        .addGap(87, 87, 87))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RB_ImportarArchivo)
                            .addComponent(RB_SeleccionarBD)
                            .addComponent(RB_InsertarBD))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lbl_Titulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RB_Mostrar)
                    .addComponent(RB_Cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RB_Exportar)
                    .addComponent(RB_Vehiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RB_Agregar)
                    .addComponent(RB_Empleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RB_Modificar)
                    .addComponent(RB_Venta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RB_Eliminar)
                    .addComponent(Btn_Aceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RB_InsertarBD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RB_SeleccionarBD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RB_ImportarArchivo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AceptarActionPerformed
            switch (OpM) {
                case 'A':
                    ImprimirGUI( A, OpSm );
                    break;
                case 'B':
                    try{
                        P.ExportarXls( A, OpSm );
                    }catch(java.io.IOException e){
                        JOptionPane.showMessageDialog(this, ".:.Error.:.", "NO fue posible Exportar debido a un Error!!!\n"
                                + "Favor vuelva a Intentarlo!!!",0);
                    }
                    break;
                case 'C':
                    A = P.Agregar( A, OpSm );
                    ImprimirGUI( A, OpSm );
                    break;
                case 'D':
                    ImprimirGUI( A, OpSm );
                    A = P.Modificar( A, OpSm );
                    ImprimirGUI( A, OpSm );
                    break;
                case 'E':
                    ImprimirGUI( A, OpSm );
                    A = P.Eliminar( A, OpSm);
                    ImprimirGUI( A, OpSm );
                    break;
                case 'F':
                    InsertarBD(OpSm);
                    ImprimirGUI( A, OpSm );
                    break;
                case 'G':
                    ImprimirGUI( A, OpSm );
                    SeleccionarBD(OpSm);
                    ImprimirGUI( A, OpSm );
                    break;
                case 'H':
                    //ImprimirGUI( A, OpSm );
                    try {
                        ImportarArchivo(OpSm);
                    } catch (java.io.IOException e) {
                        JOptionPane.showMessageDialog(this, ".:.Error.:.", "NO fue posible Abrir el Archivo debido a un Error!!!\n"
                                + "Favor vuelva a Intentarlo o Consulte al Administrador del Sistema!!!", 0);
                    }
                    //ImprimirGUI( A, OpSm );
                    break;
            }
    }//GEN-LAST:event_Btn_AceptarActionPerformed

    private void RB_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_MostrarActionPerformed
        OpM = 'A';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_MostrarActionPerformed

    private void RB_ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_ExportarActionPerformed
        OpM = 'B';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_ExportarActionPerformed

    private void RB_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_AgregarActionPerformed
        OpM = 'C';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_AgregarActionPerformed

    private void RB_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_ModificarActionPerformed
        OpM = 'D';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_ModificarActionPerformed

    private void RB_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_EliminarActionPerformed
        OpM = 'E';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_EliminarActionPerformed

    private void RB_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_ClienteActionPerformed
        OpSm = 'a';
        Habilitar(true,OpSm);
    }//GEN-LAST:event_RB_ClienteActionPerformed

    private void RB_VehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_VehiculoActionPerformed
        OpSm = 'b';
        Habilitar(true,OpSm);
    }//GEN-LAST:event_RB_VehiculoActionPerformed

    private void RB_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_EmpleadoActionPerformed
        OpSm = 'c';
        Habilitar(true,OpSm);
    }//GEN-LAST:event_RB_EmpleadoActionPerformed

    private void RB_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_VentaActionPerformed
        OpSm = 'd';
        Habilitar(true,OpSm);
    }//GEN-LAST:event_RB_VentaActionPerformed

    private void RB_InsertarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_InsertarBDActionPerformed
        OpM = 'F';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_InsertarBDActionPerformed

    private void RB_SeleccionarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_SeleccionarBDActionPerformed
        OpM = 'G';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_SeleccionarBDActionPerformed

    private void RB_ImportarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_ImportarArchivoActionPerformed
        OpM = 'H';
        Habilitar(true,OpM);
    }//GEN-LAST:event_RB_ImportarArchivoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Aceptar;
    private javax.swing.JLabel Lbl_Titulo;
    private javax.swing.JRadioButton RB_Agregar;
    private javax.swing.JRadioButton RB_Cliente;
    private javax.swing.JRadioButton RB_Eliminar;
    private javax.swing.JRadioButton RB_Empleado;
    private javax.swing.JRadioButton RB_Exportar;
    private javax.swing.JRadioButton RB_ImportarArchivo;
    private javax.swing.JRadioButton RB_InsertarBD;
    private javax.swing.JRadioButton RB_Modificar;
    private javax.swing.JRadioButton RB_Mostrar;
    private javax.swing.JRadioButton RB_SeleccionarBD;
    private javax.swing.JRadioButton RB_Vehiculo;
    private javax.swing.JRadioButton RB_Venta;
    private javax.swing.JTable Tbl_Mostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
