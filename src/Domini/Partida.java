package Domini;

import java.util.Vector;

public class Partida {
    private Tauler tauler;
    private int pecesCodi;
    private int colors;
    private int rondes;
    private boolean repetirColors;
    public Partida(int pecesCodi, int colors, int rondes, boolean repetirColors){
        this.pecesCodi = pecesCodi;
        this.colors = colors;
        this.rondes = rondes;
        this.repetirColors = repetirColors;
        tauler = new Tauler(this.rondes);
    }
    public int getPecesCodi(){
        return this.pecesCodi;
    }
    public int getColors() {
        return this.colors;
    }
    public int getRondes(){
        return this.rondes;
    }
    public boolean getRepetirColors(){
        return this.repetirColors;
    }
    public Vector<Peca> getCodiBase(){
        return tauler.getCodiBase();
    }
    public void setCodiBase(Vector<Peca> comb){
        tauler.setCodiBase(comb);
    }
    public void comprobarCodi(Vector<Peca> comb){
        Vector<Peca> resposta = tauler.solucionarFila(new Fila(comb, tauler));
        for (int i = 0; i < resposta.size(); ++i){
            System.out.println(resposta.get(i).getColor());
        }
    }//
    public boolean codiExisteix(){
        if (tauler.getCodiBase().isEmpty()) return false;
        return true;
    }
    public void mostrarCaracteristiques(){
        System.out.println("El nombre de peces del codi és de: " + this.pecesCodi);
        System.out.println("El nombre de colors d'aquesta partida és de: " + this.colors);
        System.out.println("El nombre de rondes màxim de la partida és de: " + this.rondes);
        if (repetirColors) System.out.println("Els colors són repetibles");
        else System.out.println("Els colors no són repetibles");
    }
    public boolean existeixCodi(){
        return tauler.existeixCodiBase();
    }

    public Vector<Peca> getContingutUltimaFila() {
        return tauler.getContingutUltimaFila();
    }

    public Vector<Peca> getSolucioUltimaFila() {
        return tauler.getSolucioUltimaFila();
    }
}
