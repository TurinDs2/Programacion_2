package vehiculos_usados_poo;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

public class Vehiculo extends Agencia{
    private char Codigo[] = new char[7];
    private String Marca, Modelo, Color;
    private int Anio, Recorrido;
    private String Motor, Traccion;
    private float Precio;

    public Vehiculo() {
        this.Codigo = "".toCharArray();
        this.Marca = "";
        this.Modelo = "";
        this.Color = "";
        this.Anio = 0;
        this.Recorrido = 0;
        this.Motor = "";
        this.Traccion = "";
        this.Precio = 0;
    }
    
    public Vehiculo(char[] Codigo, String Marca, String Modelo, String Color, int Anio, int Recorrido, String Motor, String Traccion, float Precio) {
        this.Codigo = Codigo;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.Anio = Anio;
        this.Recorrido = Recorrido;
        this.Motor = Motor;
        this.Traccion = Traccion;
        this.Precio = Precio;
    }

    public void setCodigo(char[] Codigo) {
        this.Codigo = Codigo;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public void setRecorrido(int Recorrido) {
        this.Recorrido = Recorrido;
    }

    public void setMotor(String Motor) {
        this.Motor = Motor;
    }

    public void setTraccion(String Traccion) {
        this.Traccion = Traccion;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    
    public void setDatos(int i){
        this.Codigo = JOptionPane.showInputDialog("Ingrese el Código del Vehículo #"+i+":").toCharArray();
        this.Marca = JOptionPane.showInputDialog("Ingresela Marca del Vehículo #"+i+":");
        this.Modelo = JOptionPane.showInputDialog("Ingrese el Modelo del "+ Marca +":");
        this.Color = JOptionPane.showInputDialog("Ingrese el Color del "+ Marca + " " + Modelo +":");
        this.Anio = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el Año del "+ Marca + " " + Modelo +":") );
        this.Recorrido = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el Recorrido en Kilometros del "+ Marca + " " + Modelo +":") );
        this.Motor = JOptionPane.showInputDialog("Ingrese Descripción del Motor del "+ Marca + " " + Modelo +":");
        this.Traccion = JOptionPane.showInputDialog("Ingrese la Tracción del "+ Marca + " " + Modelo +":");
        this.Precio = Float.parseFloat( JOptionPane.showInputDialog("Ingrese el Precio del "+ Marca + " " + Modelo +":") );
    }

    public char[] getCodigo() {
        return Codigo;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getColor() {
        return Color;
    }

    public int getAnio() {
        return Anio;
    }

    public int getRecorrido() {
        return Recorrido;
    }

    public String getMotor() {
        return Motor;
    }

    public String getTraccion() {
        return Traccion;
    }

    public float getPrecio() {
        return Precio;
    }
    
    public void ImprimirCLI(char Op){
        System.out.printf("|%8s|%11s|%16s|%11s|%9d|%15d|%15s|%14s|L.%10.2f|\n", String.valueOf(Codigo), Marca, Modelo, Color, Anio, Recorrido, Motor, Traccion, Precio);
    }
    public void Borde(){
        System.out.print("+--------+-----------+----------------+-----------+---------+---------------+---------------+--------------+------------+\n");
    }
    public void Exportar(PrintWriter Linea){
        Linea.printf("%s\t%s\t%s\t%s\t%d\t%d\t%s\t%s\tL.%.2f\n", String.valueOf(Codigo), Marca, Modelo, Color, Anio, Recorrido, Motor, Traccion, Precio);
    }
    
}
