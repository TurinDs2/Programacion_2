package Interfaz_3;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Interfaz_3 {

    public static void main(String[] args) {
        // obtiene la opción del usuario
        String entrada = JOptionPane.showInputDialog(
                "Escriba 1 para dibujar rectangulos\n" +
                "Escriba 2 para dibujar ovalos" );

        int opcion = Integer.parseInt( entrada ); // convierte entrada en int

        // crea el panel con la entrada del usuario
        Figuras panel = new Figuras( opcion );

        JFrame aplicacion = new JFrame(); // crea un nuevo objeto JFrame

        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.add( panel ); // agrega el panel al marco
        aplicacion.setSize( 300, 300 ); // establece el tamaño deseado
        aplicacion.setVisible( true ); // muestra el marco
    }
    
}
