package vehiculos_usados_poo;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

public class Empleado extends Persona{
    private char Talento[];
    private String Correo, Puesto;
    private float Sueldo;

    public Empleado( ) {
        super( );
        this.Talento = "".toCharArray();
        this.Correo = "";
        this.Puesto = "";
        this.Sueldo = 0;
    }
    
    public Empleado(char[] Identidad, String Nombre, char Genero, int Edad, char[] Celular, char[] Talento, String Correo, String Puesto, float Sueldo) {
        super(Identidad, Nombre, Genero, Edad, Celular);
        this.Talento = Talento;
        this.Correo = Correo;
        this.Puesto = Puesto;
        this.Sueldo = Sueldo;
    }

    public void setTalento(char[] Talento) {
        this.Talento = Talento;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public void setSueldo(float Sueldo) {
        this.Sueldo = Sueldo;
    }
    
    public void setDatos(int i){
        super.setDatos(i);
        this.Talento = JOptionPane.showInputDialog("Ingrese el Número de Talento de " + super.getNombre() + ":").toCharArray();
        this.Correo = JOptionPane.showInputDialog("Ingrese el Correo Electrónico de " + super.getNombre() + ":");
        this.Puesto = JOptionPane.showInputDialog("Ingrese el Puesto de " + super.getNombre() + ":");
        this.Sueldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el Salario de " + super.getNombre() + ":"));
    }

    public char[] getTalento() {
        return Talento;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getPuesto() {
        return Puesto;
    }

    public float getSueldo() {
        return Sueldo;
    }
    
    public void ImprimirCLI(char Op){
        super.ImprimirCLI(Op);
        if( Op != 'd'){
            System.out.printf("|%5s|%25s|%25s|L.%10.2f|\n", String.valueOf(Talento), Correo, Puesto, Sueldo );
        }else{
            System.out.printf("|%25s|%25s|\n", Correo, Puesto );
        }
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+-----+-------------------------+-------------------------+------------+\n");
    }
    
    public void Exportar(PrintWriter Linea){
        super.Exportar(Linea);
        Linea.printf("%s\t%s\t%s\tL.%.2f\n", String.valueOf(Talento), Correo, Puesto, Sueldo );
    }    
    
}
