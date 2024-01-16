/***
 * En este programa vamos hacer el juego de hundir la flota, pero solo haremos el tablero y la colocacion de barcos 
 * 
 * 
 * 
 * 
 * 
 * 
 * debemos de poner simbolos en vez de números y eso será # para barcos,~ para el agua y  
 * @author Guillermo Troya Albarrán
 */


import java.util.Random;

public class prueba_hundir {

    static final String ROJO = "\u001B[31m";
    static final String RESET = "\033[0m";

    public static void main(String[] args) {
        int tablero[][] = new int[8][8];

        System.out.println("Vamos a dar comienzo al juego de hundir la flota");
        System.out.println("Vamos a explicar el sistema de juego");
        System.out.println("Se colocaran aleatoriamente los siguientes barcos que se veran segun el número de la dimension del barco");
        System.out.println("0: Agua");
        System.out.println("1: Proximidad de un barco");
        System.out.println("2: Barco de 2 espacios");
        System.out.println("3: Barco de 3 espacios, que habrá dos barcos");
        System.out.println("4: Barco de 4 espacios");
        System.out.println("Estos barcos se colocarán de forma aleatoria");

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = 0;
            }
        }

        imprimirTablero(tablero);
        colocarBarcos(tablero);

        imprimirTablero(tablero);
    }

    public static void imprimirTablero(int[][] tablero) {
        System.out.print(ROJO + "   1 2 3 4 5 6 7 8" + RESET);
        System.out.println();
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(ROJO + (i + 1) + " " + RESET);
            System.out.print(" ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Aqui lo que vamos hacer es la colocacion de barcos segun los espacios y las dimensiones que marcan
     * @param tablero
     */
    public static void colocarBarcos(int[][] tablero) {
        colocarBarco(tablero, 2); // Barco de 2 espacios
        colocarBarco(tablero, 3); // Barco de 3 espacios
        colocarBarco(tablero, 3); // Segundo barco de 3 espacios
        colocarBarco(tablero, 4); // Barco de 4 espacios
    }


    /**
     * 
     * @param tablero
     * @param longitud
     */
    public static void colocarBarco(int[][] tablero, int longitud) {
        Random rand = new Random();

        boolean colocado = false;

        while (!colocado) {
            int fila = rand.nextInt(tablero.length);
            int columna = rand.nextInt(tablero[0].length);

            // Verificar si se puede colocar el barco en esa posición
            if (puedeColocarBarco(tablero, fila, columna, longitud)) {
                // Colocar el barco
                for (int i = 0; i < longitud; i++) {
                    tablero[fila][columna + i] = longitud;
                }
                colocado = true;
            }
        }
    }


    /**
     * Esta es la funcion en la cual nos indicasi se puede colocar un barco o no
     * @param tablero
     * @param fila
     * @param columna
     * @param longitud
     * @return
     */
    public static boolean puedeColocarBarco(int[][] tablero, int fila, int columna, int longitud) {
        // Verificar si hay espacio suficiente en la fila y columna
        if (columna + longitud > tablero[0].length) {
            return false;
        }

        // Verificar si la posición está ocupada
        for (int i = 0; i < longitud; i++) {
            if (tablero[fila][columna + i] != 0) {
                return false;
            }
        }

        return true;
    }
}
