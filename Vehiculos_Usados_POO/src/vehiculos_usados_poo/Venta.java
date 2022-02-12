package vehiculos_usados_poo;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Venta extends Agencia{
    private Cliente cliente;
    private Vehiculo vehiculo[] = new Vehiculo[0];
    private Empleado vendedor;

    public Venta() {
        this.cliente = new Cliente();
        this.vehiculo = new Vehiculo[0];
        this.vendedor = new Empleado();
    }
    
    public Venta(Cliente cliente, Vehiculo[] vehiculo, Empleado vendedor) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo[] vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }
    
    public void setDatos(int i){
        JOptionPane.showMessageDialog(null,"Datos del Cliente");
        this.cliente.setDatos(i);
        
        JOptionPane.showMessageDialog(null,"Datos del Vehiculo");//falta que me pida la cantidad de Vehiculos a Comprar
        for (int j = 0; j < vehiculo.length; j++) {
            this.vehiculo[j].setDatos(j);            
        }
        
        JOptionPane.showMessageDialog(null,"Datos del Cliente");
        this.vendedor.setDatos(i);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo[] getVehiculo() {
        return vehiculo;
    }

    public Empleado getVendedor() {
        return vendedor;
    }
    
    public void ImprimirCLI(char Op){
        System.out.print("\n\n+---------------+--------------------------------------------------+---------------++------------+\n"
                            +"|   Identidad   |                 Nombre Completo                  |Número Celular:||Ingreso Men.|\n"
                            +"+---------------+--------------------------------------------------+---------------++------------+\n");
        this.cliente.ImprimirCLI(Op);
        System.out.print("+---------------+--------------------------------------------------+---------------++------------+\n");

        
        System.out.print("\n\n+---------------+--------------------------------------------------+---------------++-------------------------+-------------------------+\n"
                            +"|   Identidad   |                 Nombre Completo                  |Número Celular:||          Correo         |          Puesto         |\n"
                            +"+---------------+--------------------------------------------------+---------------++-------------------------+-------------------------+\n");
        this.vendedor.ImprimirCLI(Op);
        System.out.print("+---------------+--------------------------------------------------+---------------++-------------------------+-------------------------+\n");

        System.out.print("\n\n+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n"
                            +"| Código |    Marca  |     Modelo     |   Color   |   Año   |   Recorrido   |     Motor     |   Tracción   |   Precio   |\n"
                            +"+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n");
        for (int i = 0; i < vehiculo.length; i++) {
            this.vehiculo[i].ImprimirCLI(Op);
            this.vehiculo[i].Borde();
        }     
    }
    
    public void Borde(){}
    
    public void Exportar(PrintWriter Linea){
        Linea.print("Identidad\tNombre Completo\tGénero\tEdad\tNúmero Celular:\tIngreso Men.\n");
        this.cliente.Exportar(Linea);
        Linea.print("\n");
        
        Linea.print("Identidad\tNombre Completo\tGénero\tEdad\tNúmero Celular:\tRRHH\tCorreo\tPuest\tSalario Base\n");
        this.vendedor.Exportar(Linea);
        Linea.print("\n");
        
        Linea.print("Código\tMarca\tModelo\tColor\tAño\tRecorrido\tMotor\tTracción\tPrecio\n");
        for (int i = 0; i < vehiculo.length; i++) {
            this.vehiculo[i].Exportar(Linea);
        }                
    }
}