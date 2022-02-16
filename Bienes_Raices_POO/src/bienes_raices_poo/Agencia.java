package bienes_raices_poo;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public abstract class Agencia {
    //Atributos (NO Tiene)
    
    //Constructores (NO Tiene)

    //Procedimientos (void) Setter (NO Tiene)
    
    //Funciones (return) Getter (NO Tiene)
    
    //Otros Métodos
    public abstract void Leer(int i);
    
    public abstract void ImprimirCLI(int i);
      
    public abstract void Borde();
    
    public abstract void Exportar(PrintWriter Fila);
    
    //Método Abstracto
    
    public abstract void Soy();
}
