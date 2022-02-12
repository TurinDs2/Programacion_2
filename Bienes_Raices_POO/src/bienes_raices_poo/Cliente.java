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

    public void ImprimirCLI(int i){
        super.ImprimirCLI(i);        
        this.Bien.ImprimirCLI(i);        
        this.Vendedor.ImprimirCLI(i);
    }
    
    public void Borde(){
        super.Borde();
        this.Bien.Borde();
        this.Vendedor.Borde();
    }
    
    public void Exportar(PrintWriter Fila){
        super.Exportar(Fila);
        this.Bien.Exportar(Fila);
        this.Vendedor.Exportar(Fila);
    }
    
    //Método Abstracto
    
    public abstract void Soy();
    
}
