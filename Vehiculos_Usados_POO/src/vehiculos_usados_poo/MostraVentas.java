package vehiculos_usados_poo;
import javax.swing.table.DefaultTableModel;

public class MostraVentas extends javax.swing.JFrame {
    private DefaultTableModel ModClient, ModVehic, ModEmpl;
    public MostraVentas() {
        initComponents();
    }
    
    public MostraVentas(String E_Cliente[], String E_Vehiculo[], String E_Empleado[], Agencia A[]) {
        initComponents();
        String Datos[][] = {};
        ModClient = new DefaultTableModel(Datos, E_Cliente);
        this.Tbl_Cliente.setModel(ModClient);
        ModVehic = new DefaultTableModel(Datos, E_Vehiculo);
        this.Tbl_Vehiculos.setModel(ModVehic);
        ModEmpl = new DefaultTableModel(Datos, E_Empleado);
        this.Tbl_Empleado.setModel(ModEmpl);
        
        for (int i = 0; i < A.length; i++) {
            if ( A[i] instanceof Venta ) {
                Object LineC[] = {i, String.valueOf(((Venta) A[i]).getCliente().getIdentidad()), ((Venta) A[i]).getCliente().getNombre(), ((Venta) A[i]).getCliente().getGenero(), ((Venta) A[i]).getCliente().getEdad(), String.valueOf(((Venta) A[i]).getCliente().getCelular()), ((Venta) A[i]).getCliente().getIngreso()};
                ModClient.addRow(LineC);
                for (int j = 0; j < ((Venta)A[i]).getVehiculo().length; j++) {
                    Object LineV[] = {i, String.valueOf(((Venta) A[i]).getVehiculo()[j].getCodigo()), ((Venta) A[i]).getVehiculo()[j].getMarca(), ((Venta) A[i]).getVehiculo()[j].getModelo(), ((Venta) A[i]).getVehiculo()[j].getColor(), ((Venta) A[i]).getVehiculo()[j].getAnio(), ((Venta) A[i]).getVehiculo()[j].getRecorrido(), ((Venta) A[i]).getVehiculo()[j].getMotor(), ((Venta) A[i]).getVehiculo()[j].getTraccion(), ((Venta) A[i]).getVehiculo()[j].getPrecio()};
                    ModVehic.addRow(LineV);
                }
                Object LineE[] = {i, String.valueOf(((Venta) A[i]).getVendedor().getIdentidad()), ((Venta) A[i]).getVendedor().getNombre(), ((Venta) A[i]).getVendedor().getGenero(), ((Venta) A[i]).getVendedor().getEdad(), String.valueOf(((Venta) A[i]).getVendedor().getCelular()), String.valueOf(((Venta) A[i]).getVendedor().getTalento() ), ((Venta) A[i]).getVendedor().getCorreo(), ((Venta) A[i]).getVendedor().getPuesto(), ((Venta) A[i]).getVendedor().getSueldo()};
                ModEmpl.addRow(LineE);
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Cliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Vehiculos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Empleado = new javax.swing.JTable();
        Lbl_Empleado = new javax.swing.JLabel();
        Lbl_Cliente = new javax.swing.JLabel();
        Lbl_Vehiculos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tbl_Cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tbl_Cliente);

        Tbl_Vehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Tbl_Vehiculos);

        Tbl_Empleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(Tbl_Empleado);

        Lbl_Empleado.setText("Empleado");

        Lbl_Cliente.setText("Cliente");

        Lbl_Vehiculos.setText("Vehiculos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(449, 449, 449)
                        .addComponent(Lbl_Empleado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(Lbl_Cliente)))
                .addContainerGap(447, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Lbl_Vehiculos)
                .addGap(447, 447, 447))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Lbl_Cliente)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lbl_Vehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lbl_Empleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
            java.util.logging.Logger.getLogger(MostraVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostraVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostraVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostraVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostraVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_Cliente;
    private javax.swing.JLabel Lbl_Empleado;
    private javax.swing.JLabel Lbl_Vehiculos;
    private javax.swing.JTable Tbl_Cliente;
    private javax.swing.JTable Tbl_Empleado;
    private javax.swing.JTable Tbl_Vehiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
