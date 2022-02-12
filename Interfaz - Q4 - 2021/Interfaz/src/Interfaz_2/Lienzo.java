package Interfaz_2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Lienzo extends JPanel{

    private int Tam = 10;
    
    public void paintComponent( Graphics g ){
        super.paintComponent( g );
        int X = getWidth();//Obtiene Anchura
        int Y = getHeight();//Obtiene Altura
        
        //.fillOval(10, 10, diametro, diametro);
        
        g.setColor( Color.decode("#33FCFF") );
        g.fillRect( 200 , 100 , (int)(Tam*0.7) , (int)(Tam*0.61) );
        //g.fillRect( 590 , 90 , 10 , 10 );
        //g.fillRect( 600-(int)(Tam*0.7) , 10+(int)(Tam*0.61) , 10+(int)(Tam*0.7) , 10+(int)(Tam*0.61) );
        g.fillRect( 600-(int)(Tam*0.7) , 100 , 10+(int)(Tam*0.7) , 10+(int)(Tam*0.61) );
        g.fillRect( 200 , 500 , 10 , 10 );//Alumnos
        g.fillRect( 600 , 500 , 10, 10 );//Alumno

        
        g.setColor( Color.decode("#FF8D33") );
        g.fillOval( 200 , 100 , 5, 5);
        g.fillOval( 210 , 100 , 5, 5);
        g.fillOval( 204 , 108 , 6, 5);
        
        
        g.setColor( Color.RED );  
        g.drawLine( 0 , 0 , X , Y );
      //g.drawLine( X1 , Y1 , X2 , Y2);
        
        g.setColor( Color.BLACK );
        g.drawLine( 0 , Y , X , 0 );
        
        g.setColor( Color.decode("#DA33FF"));
        g.drawLine( X/2 , 0, X/2 , Y);
        
        g.setColor( Color.decode("#33FF46"));
        g.drawLine( 0 , Y/2 , X , Y/2 );
        
        
    }
    
    public void setTam(int Tam) {
        this.Tam = (Tam >= 0 ? Tam : 10);
        repaint(); // vuelve a pintar el panel
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    } 
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}