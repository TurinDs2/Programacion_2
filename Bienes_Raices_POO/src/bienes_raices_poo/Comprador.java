package bienes_raices_poo;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Comprador extends Cliente{
    //Atributos
    private String Cita;
    private float Ingreso;
    
    //Constructores

    public Comprador() {
        super();
        this.Cita = "";
        this.Ingreso = 0;
    }

    public Comprador(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, Bienes_Raices Bien, OficialNegocio Vendedor, String Cita, float Ingreso) {
        super(Identidad, nombre, Genero, Edad, Celular, Bien, Vendedor);
        this.Cita = Cita;
        this.Ingreso = Ingreso;
    }
    
    //Procedimientos (void) Setter

    public void setCita(String Cita) {
        this.Cita = Cita;
    }

    public void setIngreso(float Ingreso) {
        this.Ingreso = Ingreso;
    }
    
    //Funciones (return) Getter

    public String getCita() {
        return Cita;
    }

    public float getIngreso() {
        return Ingreso;
    }
    
    //Otros Métodos
    public void Leer(int i) {
        String Leer = "";
        super.Leer(i);

        setCita( JOptionPane.showInputDialog("Ingrese la Hora y Fecha de la Cita de " + super.getNombre() + ":") );
        Leer = JOptionPane.showInputDialog("Digite el Ingreso Promedio Mensual de " + super.getNombre() + ":");
        setIngreso(Float.parseFloat(Leer));
    }
    
    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);        
        System.out.printf("|%40s|L%9.2f|\n", getCita(), getIngreso() );
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+----------------------------------------+----------+\n");
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
        Fila.print( getCita() +"\t"+ getIngreso() + "\n" );
    }
    
    //Método Abstracto
    
    public void Soy(){
        JOptionPane.showMessageDialog(null, "Hola, Soy Comprador!!!");
    }
    
    
}
