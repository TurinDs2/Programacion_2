package bienes_raices_poo;

import java.io.PrintWriter;

public abstract class Cliente extends Persona{
    //Atributos
    private Bienes_Raices Bien;
    private OficialNegocio Vendedor;
    
    //Constructores

    public Cliente() {
        super();
        this.Bien = new Bienes_Raices();
        this.Vendedor = new OficialNegocio();
    }

    public Cliente(char[] Identidad, String nombre, char Genero, short Edad, char[] Celular, Bienes_Raices Bien, OficialNegocio Vendedor) {
        super(Identidad, nombre, Genero, Edad, Celular);
        this.Bien = Bien;
        this.Vendedor = Vendedor;
    }
    
    //Procedimientos (void) Setter

    public void setBien(Bienes_Raices Bien) {
        this.Bien = Bien;
    }

    public void setVendedor(OficialNegocio Vendedor) {
        this.Vendedor = Vendedor;
    }
    
    //Funciones (return) Getter

    public Bienes_Raices getBien() {
        return Bien;
    }

    public OficialNegocio getVendedor() {
        return Vendedor;
    }
    
    //Otros Métodos
    public void Leer(int i) {
        super.Leer(i);
        this.Bien.Leer(i);//Personalizable a Seleccionar del Arreglo
        this.Vendedor.Leer(i);//Personalizable a Seleccionar del Arregr del Arreglolo
    }
    
    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);        
        System.out.printf("|%29s|L%12.2f|", this.Bien.getDireccion(), this.Bien.getPrecio() );        
        System.out.printf("|%45s|%15s|%7s|", this.Vendedor.getNombre(), String.valueOf( this.Vendedor.getCelular() ), String.valueOf( this.Vendedor.getTalento() ) );
    }
    
    public void Borde(){
        super.Borde();
        System.out.print("+-----------------------------+-------------++---------------------------------------------+---------------+-------+");
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
        Fila.print( this.Bien.getDireccion() + "\t" + this.Bien.getPrecio() + "\t");
        Fila.print( this.Vendedor.getNombre() + "\t" + String.valueOf( this.Vendedor.getCelular() ) + "\t" + String.valueOf( this.Vendedor.getTalento() ) + "\t" );
    }
    
    //Método Abstracto
    
    public abstract void Soy();
    
}
