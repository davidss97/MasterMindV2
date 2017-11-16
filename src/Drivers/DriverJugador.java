package Drivers;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import Domini.Partida;
import Domini.Jugador;
import Domini.Peca;

public class DriverJugador {
    private static Partida P = new Partida(4, 6,10, true);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bucle = true;
        Jugador J = null;
        Vector<Integer> codiBase = new Vector<Integer>();
        while (bucle) { //els bucles són necessaris per quan entrem un número que no vol dir res
            //aquest bucle controla la creació del primer jugador, que serà el que portarà l'usuari
            System.out.println("Aquest és el driver de la classe Jugador. Primer cal crear un nou Jugador. Introdueix 1 si vols crear un code maker i 2 si vols crear un code breaker");
            String i = sc.next();
            switch (i) {
                case "1": //code maker
                    J = new Jugador(false, P);
                    bucle = false;
                    break;
                case "2": //code breaker
                    J = new Jugador(true, P);
                    bucle = false;
                    break;
                default:
                    System.out.println("El paràmetre introduït no identifica cap mètode, torna a escollir");
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
                                System.out.println("El paràmetre introduït no identifica cap mètode, torna a escollir");
                                break;
                        }
                        break;
                    case "2":
                        if(J.getRolN()) {
                            if (!P.existeixCodi()) System.out.println("No existeix cap codi Base");
                            else J.moure(introduirComb());
                        } else {
                            System.out.println("Error. Un code maker no pot enviar intent.");
                        }
                        break;
                    case "3":
                        if (J.getRolN()) System.out.println("Code Breaker");
                        else System.out.println("Code Maker");
                        break;
                    case "4":
                        if(J.getRolN()) {
                            System.out.println("Error. Un code breaker no pot crear un codi");
                        } else {
                            if (P.existeixCodi()) System.out.println("Ja existeix un codi Base.");
                            else {
                                J.crearCodi(introduirComb());
                            }
                        }
                        break;
                    case "5":
                        if (!P.existeixCodi()){
                            System.out.println("No existeix cap codi base");
                        }
                        else System.out.println(J.getColorsCodiBase());
                        break;
                    default:
                        bucle = true;
                        System.out.println("El paràmetre introduït no identifica cap mètode, torna a escollir");
                        break;
                }
            }
        }
    }
    private static Vector<Peca> introduirComb(){ //caldria fer que aquesta funció estigués al CodeB
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix els números del codi d'un en un");
        Vector<Peca> comb = new Vector<Peca>(P.getPecesCodi()); //recent editat al fer la fàbrica
        int t = comb.capacity();
        int k;
        int i = 0;
        while(i < t){
            try {
                k = sc.nextInt();
                if (k <= 0) throw new IllegalArgumentException();
                comb.add(new Peca(k));
                ++i;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
            }
        }
        System.out.println("Has introduit el codi: " + getColors(comb));
        return comb;
    }
    private static Vector<Integer> getColors(Vector<Peca> peces){
        Vector<Integer> colorsCodi = new Vector<Integer> (peces.size());
        for (int i = 0; i < peces.size(); ++i){
            colorsCodi.add(peces.get(i).getColor());
        }
        return colorsCodi;
    }
}
