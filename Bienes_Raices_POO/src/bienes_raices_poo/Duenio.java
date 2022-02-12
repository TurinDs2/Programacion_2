package bienes_raices_poo;

import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Duenio extends Cliente {
    //Atributos (NO Tiene)
    
    //Constructores

    public Duenio() {
        super();
    }

    public Duenio(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, Bienes_Raices Bien, OficialNegocio Vendedor) {
        super(Identidad, nombre, Genero, Edad, Celular, Bien, Vendedor);
    }
    
    //Procedimientos (void) Setter (NO Tiene)
    
    //Funciones (return) Getter (NO Tiene)
    
    //Otros Métodos

    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);        
    }
    
    public void Borde(){
        super.Borde();
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
    }
    
    //Método Abstracto
    
    public void Soy(){
        JOptionPane.showMessageDialog(null, "Hola Soy Dueño de Casa!!!");
    }
    
    
}
