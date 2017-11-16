package Drivers;

import Domini.MasterMind;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverMasterMind {
    public static void main(String[] args) {
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
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un 1 o un 2");
            }
            if (i == 1) repetirColors = true;
            else repetirColors = false;
        }
        bucle = true;
        System.out.println("Vols crear un MasterMind amb " + pecesCodi + " peces, " + colors + " colors, " + rondes + " rondes, i repetirColors = " + repetirColors + "?");
        System.out.println("Introdueix 1 si vols crear-lo o 2 en cas contrari");
        while (bucle) {
            try {
                i = sc.nextInt();
                if (i != 1 && i != 2) throw new IllegalArgumentException();
                if (i == 1){
                    System.out.println("Has decidit crear el MasterMind");
                    MasterMind masterMind = new MasterMind(pecesCodi, colors, rondes, repetirColors);
                    System.out.println("Vols veure les característiques del MasterMind? \nIntrodueix 1 si vols veure-les i 2 en cas contrari");
                    boolean bucle2 = true;
                    while (bucle2) {
                        try {
                            i = sc.nextInt();
                            if (i != 1 && i != 2) throw new IllegalArgumentException();
                            bucle2 = false;
                        } catch (InputMismatchException e) {
                            System.out.println("El paràmetre introduït no és un nombre");
                            sc.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println("El nombre introduït no és vàlid, siusplau introdueix un 1 o un 2");
                        }
                    }
                    if (i == 1){
                        System.out.println("Has decidit veure les característiques del MasterMind");
                        masterMind.mostrarCaracteristiquesPartida();
                    }
                    else System.out.println("Has decidit no veure les característiques del MasterMind");
                    bucle2 = true;
                    if((masterMind.getPecesCodi() == 2 && masterMind.getColors() == 3 && masterMind.getRondes() == 6 && !masterMind.isRepetirColors()) ||
                            (masterMind.getPecesCodi() == 3 && masterMind.getColors() == 4 && masterMind.getRondes() == 8 && masterMind.isRepetirColors()) ||
                            (masterMind.getPecesCodi() == 4 && masterMind.getColors() == 6 && masterMind.getRondes() == 10 && masterMind.isRepetirColors())) {
                        System.out.println("Si vols guardar una partida d'aquest MasterMind introdueix 1. En cas contrari introdueix 2");
                        while (bucle2) {
                            try {
                                i = sc.nextInt();
                                if (i != 1 && i != 2) throw new IllegalArgumentException();
                                bucle2 = false;
                            } catch (InputMismatchException e) {
                                System.out.println("El paràmetre introduït no és un nombre");
                                sc.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un 1 o un 2");
                            }
                        }
                        if (i == 1) {
                            System.out.println("Has decidit guardar una partida.\nIntrodueix el nom del jugador");
                            String jugador = sc.next();
                            System.out.println("Ara introdueix el nombre de rondes jugades");
                            boolean bucle3 = true;
                            while (bucle3) {
                                try {
                                    i = sc.nextInt();
                                    if (i <= 0 || i > rondes) throw new IllegalArgumentException();
                                    else bucle3 = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("El paràmetre introduït no és un nombre");
                                    sc.nextLine();
                                } catch (IllegalArgumentException e) {
                                    if (i <= 0)
                                        System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
                                    else
                                        System.out.println("El nombre introduït és major que el nombre de rondes màxim de la partida");
                                }
                            }
                            masterMind.guardarPartida(jugador, i);
                        } else System.out.println("Has decidit no guardar cap Partida");
                        bucle2 = true;
                    }
                    System.out.println("Si vols veure la classificació de les partides fàcils introdueix 1.\n" +
                            "Si vols veure la classificació de les partides mitjanes introdueix 2.\n" +
                            "Si vols veure la classificació de les partides difícils introdueix 3.\n" +
                            "Si no vols veure cap classificació introdueix 4");
                    while (bucle2) {
                        try {
                            i = sc.nextInt();
                            if (i != 1 && i != 2 && i != 3 && i != 4) throw new IllegalArgumentException();
                            bucle2 = false;
                        } catch (InputMismatchException e) {
                            System.out.println("El paràmetre introduït no és un nombre");
                            sc.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println("El nombre introduït no és vàlid, siusplau introdueix un 1, un 2, un 3 o un 4");
                        }
                    }
                    switch (i){
                        case 1:
                            masterMind.veureClassificacio("facil");
                            break;
                        case 2:
                            masterMind.veureClassificacio("mitjana");
                            break;
                        case 3:
                            masterMind.veureClassificacio("dificil");
                            break;
                        default:
                            System.out.println("Has decidit no veure cap classificació");
                            break;
                    }
                }
                else System.out.println("Has decidit no crear el MasterMind");
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un 1 o un 2");
            }

        }
    }
}
