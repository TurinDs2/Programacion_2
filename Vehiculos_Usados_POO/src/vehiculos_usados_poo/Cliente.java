package vehiculos_usados_poo;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

public class Cliente extends Persona{
    private float Ingreso;

    public Cliente() {
        super();
        this.Ingreso = 0;
    }
    
    public Cliente(char[] Identidad, String Nombre, char Genero, int Edad, char[] Celular, float Ingreso) {
        super(Identidad, Nombre, Genero, Edad, Celular);
        this.Ingreso = Ingreso;
    }

    public void setIngreso(float Ingreso) {
        this.Ingreso = Ingreso;
    }
    
    public void setDatos(int i){
        super.setDatos(i);
        this.Ingreso = Float.parseFloat(JOptionPane.showInputDialog("Digite el Ingreso Mensual de "+super.getNombre()+"; "));
    }

    public float getIngreso() {
        return Ingreso;
    }
    
    public void ImprimirCLI(char Op){
        super.ImprimirCLI(Op);
        System.out.printf("|L.%10.2f|\n", Ingreso );
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+------------+\n");
    }
    
    public void Exportar(PrintWriter Linea){
        super.Exportar(Linea);
        Linea.printf("L.%.2f\n", Ingreso );
    }
}
