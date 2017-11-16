package Domini;

import java.util.Random;
import java.util.Vector;

public class Maquina extends Jugador {
    Algorisme algo;
    boolean primeraRonda;
    Rol rol;
    public Maquina(boolean rolN, Partida P) {
        super(rolN, P);
        rol = super.getRol();
        primeraRonda =true;
        algo = new Algorisme(P.getPecesCodi(), P.getColors());
    }
    //private Algoritme algoritme = new Algoritme (this);
    /*public void corregir(){
        if(!rolN) {
            ((CodeM) rol).corregir();
        }else{
            System.out.println("Nomes pot corregir un codemaker");
        }
    }*/
    public void moure(){
        if(rolN) {
            if(primeraRonda){
                ((CodeB) rol).enviarIntent(algo.jugada());
                primeraRonda = false;
            }else {
                Vector<Peca> ultimaCon = ((CodeB) rol).getContingutUltimaFila();
                Vector<Peca> ultimaRes = ((CodeB) rol).getSolucioUltimaFila(); //blanques negres

                ((CodeB) rol).enviarIntent(algo.jugada(ultimaRes,ultimaCon)); //el que retorni l'algoritme
            }
        }else {
            System.out.println("Error. Un code maker no pot e  nviar intent.");
        }

    }

    public void crearCodi(int forats, int colors){
        if(rolN) {
            System.out.println("Error. Un code breaker no pot crear un codi");
        } else {
            //selecció aleatoria de codi base
            int n = 0;
            for(int i = 0; i < forats; i++){
                Random rand = new Random();
                n += rand.nextInt((colors - 1) + 1) + 1;//((max - min) + 1) + min;
                n*=10;
            }n/=10;

            super.P.setCodiBase(intApeca(n,forats));
            //System.out.println("setejat codi base: " + n + " a peces " + intApeca(n,forats));
            // n es el codi

        }
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
