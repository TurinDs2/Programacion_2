package vehiculos_usados_poo;
import java.io.PrintWriter;

public abstract class Agencia {
    public abstract void setDatos(int i);
    public abstract void ImprimirCLI(char Op);
    public abstract void Borde();
    public abstract void Exportar(PrintWriter Linea);
}
