public class hundirFlota {
    public static void main(String[] args) {
        int contador=-90;
        int contador2=-19;
        
        System.out.println("Vamos a dar comienzo al juego de hundir la flota");
        System.out.println("Vamos a explicar el sistema de juego");
        System.out.println("Se colocaran aleatoriamente los siguientes barcos que se veran segun el número de la dimension del barco");
        System.out.println("0: Agua");
        System.out.println("1: Proximidad de un barco");
        System.out.println("2: Barco de 2 espacios");
        System.out.println("3: Barco de 3 espacios, que habrá dos barcos");
        System.out.println("4: Barco de 4 espacios");
        System.out.println("Estos barcos se colocarán de forma aleatoria");
        int num[][]= new int[10][10];

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                num[0][j] = contador;               //Esto es la fila de los números
                contador+=1;
                num[i][0] = contador2;              //Esto es la columna de los números
                contador2+=1;
               
            }
            
        }




        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[i][j] + "\t");
                
            }
            System.out.println();
        }
    }
}
