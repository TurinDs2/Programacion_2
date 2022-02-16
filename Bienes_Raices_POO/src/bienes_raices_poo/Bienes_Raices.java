package bienes_raices_poo;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Bienes_Raices extends Agencia {
    //Atributos
    private String Direccion, Color;
    private short Nivel,Habitacion,Banio,Parqueo;
    private float Precio;

    //Constructores
    public Bienes_Raices() {
        this.Direccion = "";
        this.Color = "";
        this.Nivel = 0;
        this.Habitacion = 0;
        this.Banio = 0;
        this.Parqueo = 0;
        this.Precio = 0;
    }
    
    public Bienes_Raices(String Direccion, String Color, short Nivel, short Habitacion, short Banio, short Parqueo, float Precio) {
        this.Direccion = Direccion;
        this.Color = Color;
        this.Nivel = Nivel;
        this.Habitacion = Habitacion;
        this.Banio = Banio;
        this.Parqueo = Parqueo;
        this.Precio = Precio;
    }
    
    //Procedimientos(void) Setter's
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setNivel(short Nivel) {
        this.Nivel = Nivel;
    }

    public void setHabitacion(short Habitacion) {
        this.Habitacion = Habitacion;
    }

    public void setBanio(short Banio) {
        this.Banio = Banio;
    }

    public void setParqueo(short Parqueo) {
        this.Parqueo = Parqueo;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    
    //Funciones(return) Getter's

    public String getDireccion() {
        return Direccion;
    }

    public String getColor() {
        return Color;
    }

    public short getNivel() {
        return Nivel;
    }

    public short getHabitacion() {
        return Habitacion;
    }

    public short getBanio() {
        return Banio;
    }

    public short getParqueo() {
        return Parqueo;
    }

    public float getPrecio() {
        return Precio;
    }
    
    public void Leer(int i) {
        String Leer = "";
        do{
            try{
                Leer = JOptionPane.showInputDialog("Ingrese la Dirección de la Casa #" + (i + 1) + ":");
                setDireccion(Leer);
            }catch(java.lang.NullPointerException e){
                Leer = " ";
            }
        }while( Leer.length()<=0 );
        setColor(JOptionPane.showInputDialog("Ingrese el Color de la Casa #" + (i + 1) + ":"));
        Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Niveles de la Casa #" + (i + 1) + ":");
        setNivel(Short.parseShort(Leer));
        Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Habitaciones de la Casa #" + (i + 1) + ":");
        setHabitacion(Short.parseShort(Leer));
        Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Baños de la Casa #" + (i + 1) + ":");
        setBanio(Short.parseShort(Leer));
        Leer = JOptionPane.showInputDialog("Ingrese la Cantidad de Parqueos de la Casa #" + (i + 1) + ":");
        setParqueo(Short.parseShort(Leer));
        Leer = JOptionPane.showInputDialog("Ingrese el Precio de la Casa #" + (i + 1) + ":");
        setPrecio(Float.parseFloat(Leer));
    }

    public void ImprimirCLI(int i){
        System.out.printf("|%8d|%29s|%15s|%7d|%12d|%5d|%8d|L%12.2f|\n"
                    ,i,Direccion,Color,Nivel,Habitacion,Banio,Parqueo,Precio);
    }
    
    public void Borde(){
        System.out.print("+--------+-----------------------------+---------------+-------+------------+-----+--------+-------------+\n");
    }
    
    public void Exportar(PrintWriter Fila){
        Fila.print(Direccion +"\t"+ Color +"\t"+ Nivel +"\t"+ Habitacion +"\t"+ Banio +"\t"+ Parqueo +"\t"+ Precio +"\n");
    }
    
    //Metodo Abstracto
    public void Soy(){
        JOptionPane.showMessageDialog(null, "Hola, Soy Bien Raiz!!!");
    }
}
