package bienes_raices_poo;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public abstract class Empleado extends Persona{
    //Atributos
    private char Talento[];
    private float Salario;
    
    //Constructores

    public Empleado() {
        super();
        this.Talento = "".toCharArray();
        this.Salario = 0;
    }

    public Empleado(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, char[] Talento, float Salario) {
        super(Identidad, nombre, Genero, Edad, Celular);
        this.Talento = Talento;
        this.Salario = Salario;
    }
    
    //Procedimientos (void) Setter

    public void setTalento(char[] Talento) {
        this.Talento = Talento;
    }

    public void setSalario(float Salario) {
        this.Salario = Salario;
    }
    
    //Funciones (return) Getter

    public char[] getTalento() {
        return Talento;
    }

    public float getSalario() {
        return Salario;
    }
    
    //Otros Métodos
    public void Leer(int i) {
        String Leer = "";
        super.Leer(i);

        setTalento( JOptionPane.showInputDialog("Ingrese el Talento de " + super.getNombre() + ":").toCharArray() );
        Leer = JOptionPane.showInputDialog("Ingrese el Salario de " + super.getNombre() + ":");
        setSalario( Float.parseFloat(Leer) );
    }
    
    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);
        System.out.printf("|%7s|L%9.2f|", String.valueOf( getTalento() ), getSalario() );
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+-------+----------+");
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
        Fila.print( String.valueOf( getTalento() ) +"\t"+ getSalario() +"\t" );
    }
    
    //Método Abstracto
    
    public abstract void Soy();
    
}
