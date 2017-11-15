package Drivers;

import java.util.Scanner;
import Domini.Fabrica;

public class DriverFabrica {
    private static Fabrica fabrica = null;
    public static void main (String[] args){
        boolean bucle = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Aquest és el driver de la classe Fabrica. \nPrimer cal definir les característiques de la partida. \nSi vols seleccionar una dificultat predeterminada introdueix 1. Si vols fer una selecció manual introdueix 2");
        while (bucle) {
            String i = sc.next();
            switch (i) {
                case "1":
                    bucle = false;
                    System.out.println("Si vols una dificultat fàcil , introdueix 1. \nSi vols una dificultat mitjana, introdueix 2. \nSi vols una dificultat difícil, introdueix 3.");
                    boolean bucle1 = true;
                    while (bucle1) {
                        String j = sc.next();
                        String k;
                        boolean bucle2;
                        switch (j) {
                            case "1": //dificultat facil
                                bucle1 = false;
                                System.out.println("Aquesta opció implica 2 peces per codi, 3 colors, 6 rondes i colors no repetibles. \nSi et sembla bé i vols continuar introdueix 1. En cas contrari introdueix 2");
                                bucle2 = true;
                                while (bucle2) {
                                    k = sc.next();
                                    switch (k) {
                                        case "1":
                                            fabrica = new Fabrica(2, 3, 6, false);
                                            bucle2 = false;
                                            break;
                                        case "2":
                                            System.out.println("Has decidit tornar a definir les característiques. Si vols seleccionar una opció predeterminada introdueix 1 i 2 en cas contrari");
                                            bucle2 = false;
                                            bucle = true;
                                            break;
                                        default:
                                            System.out.println("El nombre no correspon a cap opció. Siusplau torna a introduir el nombre. Introdueix 1 si vols continuar i 2 en cas contrari");
                                            break;
                                    }
                                }
                                break;
                            case "2": //dificultat mitjana
                                bucle1 = false;
                                System.out.println("Aquesta opció implica 3 peces per codi, 4 colors, 8 rondes i colors repetibles. \nSi et sembla bé i vols continuar introdueix 1. En cas contrari introdueix 2");
                                bucle2 = true;
                                while (bucle2) {
                                    k = sc.next();
                                    switch (k) {
                                        case "1":
                                            fabrica = new Fabrica(3, 4, 8, true);
                                            bucle2 = false;
                                            break;
                                        case "2":
                                            System.out.println("Has decidit tornar a definir les característiques. Si vols seleccionar una opció predeterminada introdueix 1 i 2 en cas contrari");
                                            bucle2 = false;
                                            bucle = true;
                                            break;
                                        default:
                                            System.out.println("El nombre no correspon a cap opció. Siusplau torna a introduir el nombre. Introdueix 1 si vols continuar i 2 en cas contrari");
                                            break;
                                    }
                                }
                                break;
                            case "3": //dificultat dificil
                                bucle1 = false;
                                System.out.println("Aquesta opció implica 4 peces per codi, 6 colors, 10 rondes i colors repetibles. \nSi et sembla bé i vols continuar introdueix 1. En cas contrari introdueix 2");
                                bucle2 = true;
                                while (bucle2) {
                                    k = sc.next();
                                    switch (k) {
                                        case "1":
                                            fabrica = new Fabrica(4, 6, 10, true);
                                            bucle2 = false;
                                            break;
                                        case "2":
                                            System.out.println("Has decidit tornar a definir les característiques. Si vols seleccionar una opció predeterminada introdueix 1 i 2 en cas contrari");
                                            bucle = true;
                                            bucle2 = false;
                                            break;
                                        default:
                                            System.out.println("El nombre no correspon a cap opció. Siusplau torna a introduir el nombre. Introdueix 1 si vols continuar i 2 en cas contrari");
                                            break;
                                    }
                                }
                                break;
                            default:
                                System.out.println("El nombre no correspon a cap opció. \nSi vols una dificultat fàcil , introdueix 1. \nSi vols una dificultat mitjana, introdueix 2. \nSi vols una dificultat difícil, introdueix 3.");
                                break;
                        }
                    }
                    break;
                case "2": //cal arreglar que no accepti res que no sigui enter
                    bucle = false;
                    System.out.println("Has decidit fer una selecció manual de les característiques. \nIntrodueix el nombre de peces del codi.");
                    int pecesCodi = 0;
                    boolean bucle2 = true;
                    while(bucle2) {
                        if (sc.hasNextInt()) {
                            bucle2 = false;
                            pecesCodi = sc.nextInt();
                        }
                        else sc.nextLine();
                    }
                    bucle2 = true;
                    System.out.println("Ara introdueix el nombre de colors diferents que tindrà la partida.");
                    int colors = 0;
                    while(bucle2) {
                        if (sc.hasNextInt()) {
                            bucle2 = false;
                            colors = sc.nextInt();
                        }
                        else sc.nextLine();
                    }
                    bucle2 = true;
                    System.out.println("Ara introdueix el nombre de rondes que tindrà la partida.");
                    int rondes = 0;
                    while(bucle2) {
                        if (sc.hasNextInt()) {
                            bucle2 = false;
                            rondes = sc.nextInt();
                        }
                        else sc.nextLine();
                    }
                    System.out.println("Finalment introdueix 1 si vols que els colors es puguin repetir i 2 en cas contrari");
                    boolean repetir = true;
                    boolean bucle3 = true;
                    while (bucle3) {
                        String k = sc.next();
                        switch (k) {
                            case "1":
                                bucle3 = false;
                                break;
                            case "2":
                                repetir = false;
                                bucle3 = false;
                                break;
                            default:
                                System.out.println("El nombre no correspon a cap opció. Siusplau torna a introduir el nombre. Introdueix 1 si vols que els colors es puguin repetir i 2 en cas contrari");
                                break;
                        }
                    }
                    fabrica = new Fabrica(pecesCodi, colors, rondes, repetir);
                    bucle = false;
                    break;
                default:
                    System.out.println("El nombre no correspon a cap opció. Siusplau torna a introduir el nombre. Introdueix 1 si vols seleccionar una opció predeterminada i 2 en cas contrari");
                    break;
            }
        }
        System.out.println("Si vols mostrar les característiques de la partida prem 1. En cas contrari prem 2.");
        boolean bucle4 = true;
        while (bucle4){
            String i = sc.next();
            switch(i){
                case "1":
                    fabrica.mostrarCaracteristiquesPartida();
                    bucle4 = false;
                    break;
                case "2":
                    System.out.println("Has decidit no mostrar les característiques");
                    bucle4 = false;
                    break;
                default:
                    System.out.println("El nombre no correspon a cap opció. Siusplau torna a introduir el nombre. Introdueix 1 si vols mostrar les característiques de la partida i 2 en cas contrari");
                    break;
            }
        }
    }
}
