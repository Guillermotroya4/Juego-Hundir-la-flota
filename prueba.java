public class prueba {

    static final String ROJO = "\u001B[31m";
    static final String RESET = "\033[0m";

    public static void main(String[] args) {
        int tablero[][]= new int[8][8];       


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
            tablero[i][j]=0;
            }
        }



        System.out.print(ROJO + " " + "1 2 3 4 5 6 7 8" + RESET );
        System.out.println();
        System.out.println(" ");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(" " + tablero[i][j] + "");
            }
            System.out.println();
            
        }




     









}
public static boolean barcos(int longitud){
    int longitud2= (int)(Math.random()*10);
    Integer.parseInt(System.console().readLine());
    boolean pequeño = false;
    int lon_pequeño = 2;
    boolean mediano = false;
    int lon_mediano = 3;
    boolean grande = false;
    int lon_grande = 4;

    if (longitud2==2){
        pequeño=true;
        return pequeño;
    } if (longitud2==3) {
        mediano=true;
        return mediano;
    }if (longitud2==4) {
        grande= true;
        return grande;
    }
    
    return barcos(longitud2);
}
}
