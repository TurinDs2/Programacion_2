package Interfaz_2;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ventana extends JFrame {
    private JSlider Tam;
    private Lienzo Pintura;

    public Ventana() {
        super("Programación II - GUI Codificada");
        
        Pintura = new Lienzo();
        Pintura.setBackground(Color.decode("#d8a5f3"));

        Tam = new JSlider(SwingConstants.HORIZONTAL, 0, 800, 10);
        Tam.setMajorTickSpacing(10); 
        Tam.setPaintTicks(true); 
        
        Tam.addChangeListener( new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                Pintura.setTam( Tam.getValue() );
            }
        } );

        add(Tam, BorderLayout.NORTH); // agrega el control deslizable al marco 
        add(Pintura, BorderLayout.CENTER); // agrega el panel al marco
    } // fin del constructor de MarcoSlider
}
