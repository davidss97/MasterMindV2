package Drivers;

import Domini.MasterMind;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverMasterMind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Aquest és el driver de la classe MasterMind. Primer cal crear un nou MasterMind. Introdueix els paràmetres a continuació:");
        System.out.println("Primer introdueix el nombre de peces que tindrà el codi");
        int i = 0;
        boolean bucle = true;
        while (bucle) {
            try {
                i = sc.nextInt();
                if (i <= 0) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
            }
            System.out.println(i);
        }
        System.out.println("El nombre és: " + i);
    }
}
