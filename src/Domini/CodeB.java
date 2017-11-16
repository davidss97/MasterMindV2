package Domini;

import java.util.Vector;

public class CodeB extends Rol{
    protected Partida P;
    Jugador code;
    public CodeB( Partida partida){
        //code = j;
        P = partida;
    }
    public void enviarIntent(Vector<Peca> comb) {
        System.out.println("Enviant intent...");
        if (! P.existeixCodi()) System.out.println("No hi ha cap codi introduit");
        else{
            P.comprobarCodi(comb);
        }
    }

    public Vector<Peca> getContingutUltimaFila() {
        return P.getContingutUltimaFila();
    }

    public Vector<Peca> getSolucioUltimaFila() {
        return P.getSolucioUltimaFila();
    }
}