package Domini;

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

    public void moure(){
        if(rolN) {
            if(primeraRonda){
                ((CodeB) rol).enviarIntent(algo.jugada());
                primeraRonda = false;
            }else {
                Vector<Peca> ultimaCon = rol.getContingutUltimaFila();
                Vector<Peca> ultimaRes = rol.getSolucioUltimaFila(); //blanques negres
                ((CodeB) rol).enviarIntent(algo.jugada(ultimaRes,ultimaCon)); //el que retorni l'algoritme
            }
        }else {
            System.out.println("Error. Un code maker no pot e  nviar intent.");
        }

    }
    public void crearCodi(){
        if(rolN) {
            System.out.println("Error. Un code breaker no pot crear un codi");
        } else {
            //selecció aleatoria de codi base
        }
    }
}

