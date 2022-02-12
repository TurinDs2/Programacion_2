package bienes_raices_poo;
import java.io.PrintWriter;

public abstract class Persona {
    //Atributos
    private char Identidad[] = new char[15];
    private String nombre;
    private char Genero;
    private short Edad;
    private char Celular[] = new char [14];

    //Constructores
    public Persona() {
        this.Identidad = "".toCharArray();
        this.nombre = "";
        this.Genero = ' ';
        this.Edad = 0;
        this.Celular = "".toCharArray();
    }
    
    public Persona(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular) {
        this.Identidad = Identidad;
        this.nombre = nombre;
        this.Genero = Genero;
        this.Edad = Edad;
        this.Celular = Celular;
    }
    
    //Procedimientos (void) Setter

    public void setIdentidad(char[] Identidad) {
        this.Identidad = Identidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public void setEdad(short Edad) {
        this.Edad = Edad;
    }

    public void setCelular(char[] Celular) {
        this.Celular = Celular;
    }
    
    //Funciones Getter

    public char[] getIdentidad() {
        return Identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return Genero;
    }

    public short getEdad() {
        return Edad;
    }

    public char[] getCelular() {
        return Celular;
    }
    
    //Otros Métodos...
    public void ImprimirCLI(int i){
        System.out.printf("|%8d|%15s|%45s|%6s|%4d|%15s|", i, String.valueOf( getIdentidad() ), getNombre(), getGenero(), getEdad(), String.valueOf( getCelular() ) );
    }
    
    public void Borde(){
        System.out.print("+--------+---------------+---------------------------------------------+------+----+---------------+");
    }
    
    public void Exportar(PrintWriter Fila){
        Fila.print( String.valueOf( getIdentidad() ) +"\t"+ getNombre() +"\t"+ getGenero() +"\t"+ getEdad() +"\t"+ String.valueOf( getCelular() ) );
    }
    
    //Método Abstracto
    public abstract void Soy();    
}
