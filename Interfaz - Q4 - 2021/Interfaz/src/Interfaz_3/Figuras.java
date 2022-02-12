package Interfaz_3;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Figuras extends JPanel{
    private int opcion; // opción del usuario acerca de cuál figura dibujar

    // el constructor establece la opción del usuario
    public Figuras( int opcionUsuario ){
        opcion = opcionUsuario;
    } // fin del constructor de Figuras

    // dibuja una cascada de figuras, empezando desde la esquina superior izquierda
    public void paintComponent( Graphics g ){
        super.paintComponent( g );

        for ( int i = 0; i < 10; i++ ){
            // elije la figura con base en la opción del usuario
            switch ( opcion ){
                case 1: // dibuja rectángulos
                    g.drawRect( 10 + i * 10, 10 + i * 10,
                        50 + i * 10, 50 + i * 10 );
                break;
                case 2: // dibuja óvalos
                    g.drawOval( 10 + i * 10, 10 + i * 10,
                        50 + i * 10, 50 + i * 10 );
                break;
            } // fin del switch
        } // fin del for
    } // fin del método paintComponent
}
