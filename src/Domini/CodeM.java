package Domini;

import java.util.Vector;

public class CodeM extends Rol{
    protected Partida P;
    Jugador code;
    public CodeM( Partida partida){
        //code = j;
        P = partida;
    }

    public void enviarCodi(Vector<Peca> comb){
        System.out.println("Enviant codi...");
        P.setCodiBase(comb);
    }

    public Vector<Peca> getContingutUltimaFila() {
        return P.getContingutUltimaFila();
    }

    public Vector<Peca> getSolucioUltimaFila() {
        return P.getSolucioUltimaFila();
    }
}