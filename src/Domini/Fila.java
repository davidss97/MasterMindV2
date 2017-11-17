package Domini;

import java.util.Vector;

public class Fila {
    private Vector<Peca> contingutFila;
    private Vector<Peca> solucio;
    private Tauler tauler;
    public Fila(Vector<Peca> comb, Tauler tauler){
        this.contingutFila = comb;
        this.tauler = tauler;
    }
    public Vector<Peca> getContingutFila(){
        return this.contingutFila;
    }
    public Vector<Peca> getSolucioFila(){
        return solucio;
    }
    public Peca getPecaAPosicio(int i){
        return contingutFila.get(i);
    }
    public void setSolucio(Vector<Peca> comb){
        this.solucio = comb;
    }
}
