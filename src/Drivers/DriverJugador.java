package Drivers;

import java.util.Scanner;
import java.util.Vector;
import Domini.Partida;
import Domini.Jugador;

public class DriverJugador {
    private static Partida P = new Partida(4, 6,10, true); //això és molt lleig
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jugador J = null;
        boolean bucle = true;
        Vector<Integer> codiBase = new Vector<Integer>();
        while (bucle) { //els bucles són necessaris per quan entrem un número que no vol dir res
            //aquest bucle controla la creació del primer jugador, que serà el que portarà l'usuari
            System.out.println("Aquest és el driver de la classe Jugador. Primer cal crear un nou Jugador. Introdueix 1 si vols crear un code maker i 2 si vols crear un code breaker");
            String i = sc.next();
            switch (i) {
                case "1":
                    J = new Jugador(false, P);
                    bucle = false;
                    break;
                case "2":
                    J = new Jugador(true, P);
                    bucle = false;
                    break;
                default:
                    System.out.println("El paràmetre introduit no identifica cap mètode, torna a escollir");
                    break;
            }
        }
        while(true){
            bucle = true;
            while (bucle) {
                bucle = false;
                System.out.println("\nSi vols crear un nou Jugador introdueix un 1\n" +
                        "Si vols enviar una jugada introdueix 2\n" +
                        "Si vols obtenir el rol del jugador actual introdueix 3\n" +
                        "Si vols crear un codi introdueix 4\n" +
                        "Si vols obtenir el codi base introdueix 5");
                String i = sc.next();
                switch (i) {
                    case "1":
                        System.out.println("Estàs creant un nou Jugador. Introdueix 1 si vols crear un code maker i 2 si vols crear un code breaker");
                        String j = sc.next();
                        switch (j) {
                            case "1":
                                J = new Jugador(false, P);
                                break;
                            case "2":
                                J = new Jugador(true, P);
                                break;
                            default:
                                System.out.println("El paràmetre introduit no identifica cap mètode, torna a escollir");
                                break;
                        }
                        break;
                    case "2":
                        J.moure();
                        break;
                    case "3":
                        System.out.println(J.getRol());
                        break;
                    case "4":
                        J.crearCodi();
                        break;
                    case "5":
                        Vector<Integer> comb;
                        comb = J.getColorsCodiBase();
                        if (!comb.isEmpty()) System.out.println(comb);
                        break;
                    default:
                        bucle = true;
                        System.out.println("El paràmetre introduit no identifica cap mètode, torna a escollir");
                        break;
                }
            }
        }
    }

    /*private static boolean verificarCodi(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("És correcte? (introdueix 1 en cas afirmatiu o 2 en cas negatiu)");
            int x;
            x = sc.nextInt();
            if (x == 1){
                System.out.println("El codi és correcte");
                return true;
            }
            else if(x == 2){
                System.out.println("El codi no és correcte");
                return false;
            } else System.out.println("El número introduit no identifica cap mètode, torna a escollir");
        }
    }*/
}
