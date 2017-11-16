package Drivers;
import Domini.Algorisme;

import java.util.Scanner;

/**
 * Created by david.sanchez.soles on 14/11/2017.
 */
public class DriverAlgorisme {
    public static void main(String[] args){
        System.out.println("Nombre de forats?: ");
        Scanner sc = new Scanner(System.in);
        int forats = sc.nextInt();
        System.out.println("Nombre de colors?: ");
        int colors = sc.nextInt();
        Algorisme algo = new Algorisme(forats, colors);

        System.out.println("Entri la combinacio secreta: ");
        sc.nextInt();
        //System.out.println("Minimax = 1122");
        //System.out.println("Entri el resultat (B/W)(en format 2210): ");
        // int resposta = sc.nextInt();
        //int resposta = -1;
        //System.out.println(algo.jugada());
        int n = algo.jugada(false);
        System.out.println("Entri el resultat (B/W)(en format 2210): ");
        int resposta = sc.nextInt();
        while(resposta != 2222) {
            n = algo.jugada(resposta,n);
            System.out.println("Minimax: " + n);
            System.out.println("Entri el resultat (B/W)(en format 2210): ");
            resposta = sc.nextInt();
        }
        System.out.println("SUCCESS");


    }
}
