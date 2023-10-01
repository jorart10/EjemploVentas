
class Principal{
    
    static void AgregarProducto(Producto[] listaP, 
                                Producto nuevo, int posicion){
        try {
            listaP[posicion-1] = nuevo;         
        } catch (Exception e) {
            System.out.println("Valor de arreglo no valido");

        }
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
            System.out.println();
            System.out.println("-------------------------");
            System.out.println("         Menú");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Comprar un producto");
            System.out.println("3. Ver ventas");
            System.out.println("4. Salir");
            System.out.println("-------------------------");
            
            String opcion = scanner.nextLine();
            
            if(opcion.equals("4")){
                break;
            }
            else if(opcion.equals("1")){
                try{
                    Producto n = new Producto();

                    System.out.println("Digite el nombre:");
                    n.nombre = scanner.nextLine();

                    System.out.println("Digite la cantidad:");
                    String e = scanner.nextLine();
                    n.cantidad = Integer.parseInt(e);

                    n.codigo = codigoProducto;

                    AgregarProducto(listaP, n, codigoProducto++);
                } catch(Exception NumberFormatException){
                    System.out.println("ERROR: Formato no valido");
                }
                
            }
            else if(opcion.equals("2")){

                System.out.println("-------------------------");
                System.out.println("       Productos:");
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
                System.out.println("-------------------------");

                try {
                    System.out.println("Elija el código de un producto");
                    String e = scanner.nextLine();
                    int codigo = Integer.parseInt(e);
                    
                    System.out.println("Elija la cantidad a comprar");
                    e = scanner.nextLine();
                    int cantidad = Integer.parseInt(e);
                    if (cantidad < 0) {
                        System.out.println("Valor no valido");
                    }else{
                        
                        String nombreProducto = getNombreByCodigo(listaP, codigo);
                        
                        if(listaP[codigo-1].Descontar(cantidad) == true){
                            //listaP[codigo-1].Descontar(cantidad);
                            System.out.println(cantidad +" "+ nombreProducto +" "+ "comprados");
                            v.RegistrarVenta(String.valueOf(codigo), nombreProducto, cantidad);
                        }
                        else{System.out.println("No se pueden comprar mas elementos de los que hay en inventario");}
                    }
                } catch (Exception NumberFormatException) {
                    System.out.println("Valores no validos");
                }
                


            }
            else if (opcion.equals("3")){

                System.out.println("-------------------------");
                for(int i = 0; i < v.ventas.length; i++){
                    if(v.ventas[i] != null){
                        System.out.println(v.ventas[i]);
                    }
                }
                System.out.println("-------------------------");

            }
            else{System.out.println("Opcion no valida");}
        }
        
        
        
    }
}