package bienes_raices_poo;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class OficialNegocio extends Empleado {
    //Atributos
    private float Comision;
    
    //Constructores

    public OficialNegocio() {
        super();
        this.Comision = 0;
    }

    public OficialNegocio(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, char[] Talento, float Salario, float Comision) {
        super(Identidad, nombre, Genero, Edad, Celular, Talento, Salario);
        this.Comision = Comision;
    }
    
    //Procedimientos (void) Setter

    public void setComision(float Comision) {
        this.Comision = Comision;
    }
    
    //Funciones (return) Getter

    public float getComision() {
        return Comision;
    }
    
    //Otros Métodos
    public void Leer(int i) {
        String Leer = "";
        super.Leer(i);

        Leer = JOptionPane.showInputDialog("Ingrese la Comisión de " + super.getNombre() + ":");
        setComision( Float.parseFloat(Leer) );
    }

    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);
        System.out.printf("|%10.2f|\n", getComision() );
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+----------+\n");
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
        Fila.print( getComision() +"\n" );
    }
    
    //Método Abstracto
    
    public void Soy(){
        JOptionPane.showMessageDialog(null, "Hola Soy Oficial de Negocios!!!");
    }
    
    
}
