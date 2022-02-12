package vehiculos_usados_poo;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

public abstract class Persona extends Agencia{
    private char Identidad[] = new char[15];
    private String Nombre;
    private char Genero;
    private int Edad;
    private char Celular[] = new char[15];

    public Persona() {
        this.Identidad = "".toCharArray();
        this.Nombre = "";
        this.Genero = ' ';
        this.Edad = 0;
        this.Celular = "".toCharArray();
    }
    
    public Persona(char[] Identidad, String Nombre, char Genero, int Edad, char[] Celular) {
        this.Identidad = Identidad;
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Edad = Edad;
        this.Celular = Celular;
    }

    public void setIdentidad(char[] Identidad) {
        this.Identidad = Identidad;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void setCelular(char[] Celular) {
        this.Celular = Celular;
    }
    
    public void setDatos(int i){
        this.Identidad = JOptionPane.showInputDialog("Ingrese el Número de Identidad #"+i+":").toCharArray();
        this.Nombre = JOptionPane.showInputDialog("Ingrese el Nombre #"+i+":");
        this.Genero = JOptionPane.showInputDialog("Ingrese el Género de "+Nombre+":").toUpperCase().charAt(0);
        this.Edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Edad de #"+Nombre+":"));
        this.Celular = JOptionPane.showInputDialog("Ingrese el Número de Celular de "+Nombre+":").toCharArray();
    }

    public char[] getIdentidad() {
        return Identidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public char getGenero() {
        return Genero;
    }

    public int getEdad() {
        return Edad;
    }

    public char[] getCelular() {
        return Celular;
    }
    
    public void ImprimirCLI(char Op){
        if( Op != 'd' ){
            System.out.printf("|%15s|%50s|%6s|%4d|%15s|", String.valueOf(Identidad), Nombre, Genero, Edad, String.valueOf(Celular) );
        }else{
            System.out.printf("|%15s|%50s|%15s|", String.valueOf(Identidad), Nombre, String.valueOf(Celular) );    
        }
    }
    
    public void Borde(){
        System.out.print("+---------------+--------------------------------------------------+------+----+---------------+");
    }
    
    public void Exportar(PrintWriter Linea){
        Linea.printf("%s\t%s\t%s\t%d\t%s\t", String.valueOf(Identidad), Nombre, Genero, Edad, String.valueOf(Celular) );
    }    
    
}
