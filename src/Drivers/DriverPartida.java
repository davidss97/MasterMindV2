package Drivers;

import Domini.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class DriverPartida {
    public static void main(String[] args){
        int pecesCodi = 0;
        int colors = 0;
        int rondes = 0;
        boolean repetirColors = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Aquest és el driver de la classe Partida. Primer cal crear una nova Partida. Introdueix els paràmetres a continuació:");
        System.out.println("Primer introdueix el nombre de peces que tindrà el codi (màxim 9, a partir de 6 comença a ralentitzar-se)");
        boolean bucle = true;
        while (bucle) {
            try {
                pecesCodi = sc.nextInt();
                if (pecesCodi <= 0 || pecesCodi > 9) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix un enter positiu");
            }
        }
        bucle = true;
        System.out.println("Ara introdueix el nombre de colors diferents possibles (a partir de 10 l'algorisme comença a ralentitzar-se)");
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
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix 1 o 2");
            }
            if (i == 1) repetirColors = true;
            else repetirColors = false;
        }
        bucle = true;
        Partida p = new Partida(pecesCodi, colors, rondes, repetirColors);
        System.out.println("La partida s'ha creat. Vols veure'n les característiques?\n" +
                "Introdueix 1 en cas afirmatiu i introdueix 2 en cas contrari");
        i = 0;
        while (bucle) {
            try {
                i = sc.nextInt();
                if (i != 1 && i != 2) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix 1 o 2");
            }
            if (i == 1){
                p.mostrarCaracteristiques();
            }
        }
        i = 0;
        System.out.println();
        System.out.println("Premi 1 per fer de CodeMaker o 2 per fer de CodeBreaker\n");
        bucle = true;
        while (bucle) {
            try {
                i = sc.nextInt();
                if (i != 1 && i != 2) throw new IllegalArgumentException();
                bucle = false;
            } catch (InputMismatchException e) {
                System.out.println("El paràmetre introduït no és un nombre");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("El nombre introduït no és vàlid, siusplau introdueix 1 o 2");
            }
        }
        if(i == 1) { //La maquina fa de codebreaker
            p.setCodeB(new Maquina(true, p));
            p.setCodeM(new Jugador(false, p));

            System.out.println("Introdueix el codi secret en format consecutiu (1234), on cada dígit representa un color:");
            int comb = sc.nextInt();

            p.getCodeM().crearCodi(intApeca(comb, pecesCodi));

            boolean segueix = true;
            int rounds = 0;
            while (segueix && rounds<rondes) {
                rounds++;

                System.out.println("Ronda: " + rounds);

                ((Maquina) p.getCodeB()).moure();

                System.out.println("Combinació a última proposta = " + pecaAint(p.getContingutUltimaFila(), pecesCodi));
                System.out.println("Resposta a última proposta = " + pecaAint(p.getSolucioUltimaFila(), pecesCodi));
                System.out.println("------------------------------------------------------");
                segueix = false;
                for (int xx = 0; xx < p.getPecesCodi(); xx++) {
                    if (p.getSolucioUltimaFila().get(xx).getColor() != 2) segueix = true;

                }
            }
            if(rounds==rondes && segueix) System.out.println("Has arribat al límit de rondes....");
            else System.out.println("SUCCESS!!! La solució es: " + pecaAint(p.getContingutUltimaFila(), pecesCodi));
        }else { //no mirem que sc.nextInt() == 2
            System.out.println("La màquina està entrant la combinació secreta...");
            p.setCodeM(new Maquina(false, p));
            p.setCodeB(new Jugador(true, p));
            ((Maquina) p.getCodeM()).crearCodi(pecesCodi, colors, repetirColors);

            boolean segueix = true;
            int rounds = 0;
            while (segueix && rounds < rondes) {
                rounds++;

                System.out.println("Ronda: " + rounds);
                System.out.println("Entri el seu intent....:");
                int com = sc.nextInt();
                Vector<Peca> comV = intApeca(com, pecesCodi);
                ((Jugador) p.getCodeB()).moure(comV);//

                //System.out.println(p.getSolucioUltimaFila());

                System.out.println("Combinació a última proposta =" + pecaAint(p.getContingutUltimaFila(), pecesCodi));
                System.out.println("Resposta a última proposta (2 = negra, 1 = blanca, 0 = buit)=" + pecaAint(p.getSolucioUltimaFila(), pecesCodi));
                System.out.println("------------------------------------------------------");
                // /System.out.println("peces codi = " + p.getPecesCodi());
                segueix = false;
                for (int xx = 0; xx < p.getPecesCodi(); xx++) {
                    if (p.getSolucioUltimaFila().get(xx).getColor() != 2) segueix = true;

                }
            }
            if (rounds == rondes && segueix) System.out.println("Has arribat al límit de rondes....");
            else System.out.println("SUCCESS!!! La solució és: " + pecaAint(p.getContingutUltimaFila(), pecesCodi));
        }
        //modificar el tauler
    }
    private static int pecaAint(Vector<Peca> vec, int forats){
        int res=0;
        int mul = (int)Math.pow(10,forats-1);
        for(int i = 0; i<vec.size(); i++){
            res += vec.get(vec.size()-1-i).getColor()*mul;
            mul/= 10;
        }
        return res;
    }

    private static Vector<Peca> intApeca(int vec, int forats){
        Vector<Peca> res= new Vector<>(forats,1);
        int mul = (int)Math.pow(10,forats-1);

        String number = Integer.toString(vec);
        String output = "";
        for(int i = number.length()-1; i >= 0; i--)
            res.add( new Peca(Character.getNumericValue(number.charAt(i))) );

        return res;
    }
}
