package Domini;

import java.util.Vector;

public class Rol {
    protected Partida P;
    public Rol(){
        
    }
    public void setP(Partida P){
        this.P = P;
    }

    public Vector<Peca> getContingutUltimaFila() {
        return P.getContingutUltimaFila();
    }

    public Vector<Peca> getSolucioUltimaFila() {
        return P.getSolucioUltimaFila();
    }
}