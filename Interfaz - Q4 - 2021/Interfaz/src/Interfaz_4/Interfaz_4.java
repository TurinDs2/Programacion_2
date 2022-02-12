package Interfaz_4;
import javax.swing.JFrame;
public class Interfaz_4 {
    public static void main(String[] args) {
        DibujarCaraSonriente panel = new DibujarCaraSonriente();
        JFrame aplicacion = new JFrame();

        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.add( panel );
        aplicacion.setSize( 530, 550 );
        aplicacion.setVisible( true );
    }
    
}
