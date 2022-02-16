package bienes_raices_poo;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Administrativo extends Empleado{
    //Atributo
    private String Cargo;
    
    //Constructores

    public Administrativo() {
        super();
        this.Cargo = "";
    }

    public Administrativo( char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, char[] Talento, float Salario, String Cargo ) {
        super(Identidad, nombre, Genero, Edad, Celular, Talento, Salario);
        this.Cargo = Cargo;
    }
    
    //Procedimientos (void) Setter

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    //Funciones (return) Getter

    public String getCargo() {
        return Cargo;
    }
    
    //Otros Métodos
    public void Leer(int i) {
        String Leer = "";
        super.Leer(i);

        setCargo( JOptionPane.showInputDialog("Ingrese el Cargo de " + super.getNombre() + ":") );
    }

    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);
        System.out.printf("|%20s|\n", getCargo() );
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+--------------------+\n");
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
        Fila.print( getCargo() +"\n" );
    }
    
    //Método Abstracto
    
    public void Soy(){
        JOptionPane.showMessageDialog(null, "Hola, Soy Administrativo, con Cargo " + getCargo() + "!!!");
    }
    
}
