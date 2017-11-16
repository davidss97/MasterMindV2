package Drivers;

import Domini.Partida;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverPartida {
    public static void main(String[] args){
        int pecesCodi = 0;
        int colors = 0;
        int rondes = 0;
        boolean repetirColors = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Aquest és el driver de la classe MasterMind. Primer cal crear un nou MasterMind. Introdueix els paràmetres a continuació:");
        System.out.println("Primer introdueix el nombre de peces que tindrà el codi");
        boolean bucle = true;
        while (bucle) {
            try {
                pecesCodi = sc.nextInt();
                if (pecesCodi <= 0) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
            }
        }
        bucle = true;
        System.out.println("Ara introdueix el nombre de colors diferents possibles");
        while (bucle){
            try {
                colors = sc.nextInt();
                if (colors <= 0) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
            }
        }
        bucle = true;
        System.out.println("Ara introdueix el nombre de rondes màxim");
        while (bucle) {
            try {
                rondes = sc.nextInt();
                if (rondes <= 0) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
            }
        }
        bucle = true;
        System.out.println("Finalment introdueix 1 si vols poder repetir colors i 2 en cas contrari");
        int i = 0;
        while (bucle) {
            try {
                i = sc.nextInt();
                if (i != 1 && i != 2) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
            }
            if (i == 1) repetirColors = true;
            else repetirColors = false;
        }
        bucle = true;
        Partida p = new Partida(pecesCodi, colors, rondes, repetirColors);

    }
}
