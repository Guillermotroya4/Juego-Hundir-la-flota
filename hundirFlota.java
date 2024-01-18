/***
 * En este proyecto he hecho el mitico juego de hundir la flota. En este caso lo único que hara es la colocación de los barcos aleatoriamente.
 * @author Guillermo Troya Albarrán
 */
import java.util.Random;

public class hundirFlota {

    static final String ROJO = "\u001B[31m";  //Color rojo para el índice de los números
    static final String AZUL = "\u001B[34m"; // color azul para el agua
    static final String AMARILLO = "\u001B[33m"; // color amarillo para los barcos
    static final String RESET = "\033[0m";      //Esto hara que se reinicie el color anteri8or y lo ponga de nuevo en su color original

    public static void main(String[] args) {
        char tablero[][] = new char[8][8];

        System.out.println("Vamos a dar comienzo al juego de hundir la flota");
        System.out.println("Vamos a explicar el sistema de juego");
        System.out.println("Se colocarán aleatoriamente los siguientes barcos que se verán según el número de la dimensión del barco");
        System.out.println("~: Agua");
        System.out.println("1: Proximidad de un barco");
        System.out.println("#: Barco de 2 espacios" );
        System.out.println("#: Barco de 3 espacios, que habrá dos barcos");
        System.out.println("#: Barco de 4 espacios");
        System.out.println("Estos barcos se colocarán de forma aleatoria");

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '0'; // Aqui lo que vamos hacer es comenzar y pintar el tablero entero de agua para poder colocar los barcos
            }
        }

        colocarBarcos(tablero);
        imprimirTablero(tablero);
    }

    /**
     * Este es la funcion de imprimir el tablero, que primero sera todo agua y ya recorrera el codigo opara colocarlos barcos
     * @param tablero
     */
    public static void imprimirTablero(char[][] tablero) {
        System.out.print(ROJO + "   1 2 3 4 5 6 7 8" + RESET);              //Esta es la fila de arriba donde estan los números en rojo, que es el indice 
        System.out.println();
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(ROJO + (i + 1) + RESET + " ");                 // Esta es la columna de los indices donde estan los numeros de rojo
            System.out.print(" ");
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == '0') {
                    System.out.print(AZUL + "~" + RESET + " ");         //Aqui pinta el agua
                } else if (tablero[i][j] == '1') {
                    System.out.print("1 ");
                } else {
                    System.out.print(AMARILLO + "#" + RESET + " ");     //Aquí pinta los barcos
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void colocarBarcos(char[][] tablero) {
        colocarBarco(tablero, 2); // Barco de 2 espacios
        colocarBarco(tablero, 3); // Barco de 3 espacios
        colocarBarco(tablero, 3); // Segundo barco de 3 espacios
        colocarBarco(tablero, 4); // Barco de 4 espacios
    }

    /**
     * Esta es la funciónj más importante del proyecto ya que es la que coloca bacos de forma aleatoria
     * @param tablero
     * @param longitud que sera lo que ocupa el barco que queremos colocar
     */
    public static void colocarBarco(char[][] tablero, int longitud) {
        Random rand = new Random();

        boolean colocado = false;
        int orientacion = rand.nextInt(2); // Para colocarlos haremos lo siguiente: 0 para horizontal, 1 para vertical

        while (!colocado) {
            int fila = rand.nextInt(tablero.length);
            int columna = rand.nextInt(tablero[0].length);

            if (orientacion == 0 && puedeColocarBarcoHorizontal(tablero, fila, columna, longitud)) {
                for (int i = 0; i < longitud; i++) {                
                    tablero[fila][columna + i] = 'X';
                }
                colocado = true;
            } else if (orientacion == 1 && puedeColocarBarcoVertical(tablero, fila, columna, longitud)) {
                for (int i = 0; i < longitud; i++) {        
                    tablero[fila + i][columna] = 'X'; 
                }
                colocado = true;
            }
        }
    }

    /**
     * 
     * @param tablero
     * @param fila
     * @param columna
     * @param longitud que sera lo que ocupa el barco que queremos colocar
     * @return
     */
    public static boolean puedeColocarBarcoHorizontal(char[][] tablero, int fila, int columna, int longitud) {
        if (columna + longitud > tablero[0].length) {
            return false;
        }                               //Aqui comprobaremos si se puede colocar horizontalmente

        for (int i = 0; i < longitud; i++) {
            if (tablero[fila][columna + i] != '0') {
                return false;
            }
        }

        return true;
    }

    /**
     * 
     * @param tablero
     * @param fila
     * @param columna
     * @param longitud  que sera lo que ocupa el barco que queremos colocar
     * @return
     */
    public static boolean puedeColocarBarcoVertical(char[][] tablero, int fila, int columna, int longitud) {
        if (fila + longitud > tablero.length) {
            return false;                   //Aqui comprobaremos si se puede colocar verticalmente
        }

        for (int i = 0; i < longitud; i++) {
            if (tablero[fila + i][columna] != '0') {
                return false;
            }
        }

        return true;
    }
}
