package Drivers;

import java.util.Scanner;
import Domini.Algorisme;

/**
 * Created by david.sanchez.soles on 14/11/2017.
 */
public class DriverAlgorisme {
    public static void main(String[] args){
        System.out.println("Entri la combinacio secreta: ");
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        //System.out.println("Minimax = 1122");
        //System.out.println("Entri el resultat (B/W)(en format 2210): ");
       // int resposta = sc.nextInt();
        //int resposta = -1;
        Algorisme algo = new Algorisme();
        int n = 1122;
        System.out.println("Minimax: " + n);
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
