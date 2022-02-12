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

    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);
        System.out.printf("|L%6.2f|\n", String.valueOf( getTalento() ), getSalario() );
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+----------+\n");
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
        Fila.print( String.valueOf( getTalento() ) +"\t"+ getSalario() +"\n" );
    }
    
    //Método Abstracto
    
    public void Soy(){
        JOptionPane.showMessageDialog(null, "Hola Soy Oficial de Negocios!!!");
    }
    
    
}
