public class Producto
{
    int codigo;
    String nombre;
    int cantidad; // inventario
    
    public Producto(){
        
    }
    
    public Producto(int co, String no, int ca){
        codigo = co;
        nombre = no;
        cantidad = ca;
    }
    
    public boolean Descontar(int cantidadComprada){
        if(cantidad - cantidadComprada >= 0){
            cantidad = cantidad - cantidadComprada;
            return true;
        } else{
            return false;
        }
    }
    
}





