package Drivers;
import Domini.Algorisme;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by david.sanchez.soles on 14/11/2017.
 */
public class DriverAlgorisme {
    public static void main(String[] args){
        System.out.println("Nombre de forats? ");
        Scanner sc = new Scanner(System.in);
        int forats = sc.nextInt();
        System.out.println("Nombre de colors? ");
        int colors = sc.nextInt();
        Algorisme algo = new Algorisme(forats, colors);

        System.out.println("Entri la combinacio secreta: ");
        boolean bucle = true;
        int j = 0;
        while (bucle) {
            try {
                j = sc.nextInt();
                if (j < 0 || j/Math.pow(10,forats-1) < 1) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid");
            }
        }
        //System.out.println("Minimax = 1122");
        //System.out.println("Entri el resultat (B/W)(en format 2210): ");
        // int resposta = sc.nextInt();
        //int resposta = -1;
        //System.out.println(algo.jugada());
        int n = algo.jugada(false);
        System.out.println("Entri el resultat (B/W)(en format 2210): ");
        int resposta = sc.nextInt();
        int validador = 0;
        for (int i = 0; i < forats; ++i){
            validador = validador * 10 + 2;
        }
        while(resposta != validador) {
            n = algo.jugada(resposta,n);
            System.out.println("Minimax: " + n);
            System.out.println("Entri el resultat (B/W)(en format 2210): ");
            resposta = sc.nextInt();
        }
        System.out.println("SUCCESS");


    }
}
