
class Principal{
    
    static void AgregarProducto(Producto[] listaP, 
                                Producto nuevo, int posicion){
          listaP[posicion] = nuevo;         
    }
    
    /**
     * @param listaP lista a recorrer 
     * @param codigo codigo a buscar
     * @return el nombre encontrado, null si no se encontró
     */
    static String getNombreByCodigo(Producto[] listaP, int codigo){
        for(Producto p : listaP){
            if(p != null){
                if(p.codigo == codigo){
                    return p.nombre;
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args){
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        Producto[] listaP = new Producto[10];
        
        int codigoProducto = 1;
        Producto p1 = new Producto(codigoProducto, "Naranja", 10);
        codigoProducto++;
        Producto p2 = new Producto(codigoProducto, "Tomate", 20);
        codigoProducto++;
        
        listaP[0] = p1;
        listaP[1] = p2;
        listaP[2] = new Producto(codigoProducto, "Jugo", 5);
        codigoProducto++;
               
        Ventas v = new Ventas();
        
        while (true){
            System.out.println("Menú");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Comprar un producto");
            System.out.println("3. Ver ventas");
            System.out.println("4. Salir");
            
            String opcion = scanner.nextLine();
            
            if(opcion.equals("4")){
                break;
            }
            else if(opcion.equals("1")){
                Producto n = new Producto();

                System.out.println("Digite el nombre");
                n.nombre = scanner.nextLine();

                System.out.println("Digite la cantidad");
                String e = scanner.nextLine();
                n.cantidad = Integer.parseInt(e);

                n.codigo = codigoProducto;

                AgregarProducto(listaP, n, codigoProducto++);
                
            }
            else if(opcion.equals("2")){

                System.out.println("Productos:");
                for(int i = 0; i < listaP.length; i++){
                    Producto p = listaP[i];
                    if(p == null){
                        continue;
                    }
                    String linea = p.codigo + 
                                    " - " + p.nombre + 
                                    " - " + p.cantidad;
                    System.out.println(linea);
                }

                System.out.println("Elija el código de un producto");
                String e = scanner.nextLine();
                int codigo = Integer.parseInt(e);
                
                System.out.println("Elija la cantidad a comprar");
                e = scanner.nextLine();
                int cantidad = Integer.parseInt(e);
                
                String nombreProducto = getNombreByCodigo(listaP, codigo);
                
                v.RegistrarVenta(String.valueOf(codigo), nombreProducto, cantidad);
                System.out.println(nombreProducto);

                listaP[codigo-1].Descontar(cantidad);
                


            }
            else if (opcion.equals("3")){

                for(int i; i <= v.ventas.length; i++){
                    
                }

            }
        }
        
        
        
        
        
        
        
        
        
        /*Matrix m = new Matrix();
        m.LlenarMatriz();
        m.MostrarMatriz();
        
        m.MarcarCasilla(0, 0, 'X');
        m.MostrarMatriz();
        
        m.MarcarCasilla(1, 1, '0');
        m.MostrarMatriz();
        
        m.MarcarCasilla(2, 0, 'X');
        m.MostrarMatriz();
        
        
        m.MarcarCasilla(1, 0, '0');
        m.MostrarMatriz();*/        
        
        
        
        
        
        
        
        
        
        
        
        /*Atleta atleta1 = new Atleta();
        Atleta atleta2 = new Atleta("Enr", "Muñoz");
        Atleta atleta3 = new Atleta("Pepe", "Pereira");
        
        atleta1.setNombre("María");
        
        String apellido2 = atleta2.getNombre();
        
        
        int ba = 2;
        int exp = 3;
        
        int potencia = MisMates.CalcularPotencia(ba, exp);
        
        System.out.println( atleta1.getNombre() );
        System.out.println( atleta3.getNombre() );
        
        
        System.out.println( potencia );*/
        
    }
}