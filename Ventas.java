public class Ventas
{
    String[] ventas;
    int contadorVentas = 0;
    
    public Ventas(){
        ventas = new String[100];
    }
    
    public boolean RegistrarVenta(String cP, String nP, int ca){
        
        String lineaVenta = cP + " - " + nP + " - " + ca;
        ventas[contadorVentas] = lineaVenta;
        contadorVentas++;
        
        return true;
    }
}
