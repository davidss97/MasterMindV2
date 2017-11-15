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
    public Peca getPecaAPosicio(int i){
        return contingutFila.get(i);
    }
    public void setSolucio(Vector<Peca> comb){ //cal acabar-la;
        Vector<Peca> sol = new Vector<Peca>(4); //caldrà modificar-ho quan fem la fàbrica
        this.solucio = sol;
    }
}
