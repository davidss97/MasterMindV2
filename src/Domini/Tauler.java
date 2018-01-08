package Domini;

import java.util.Collections;
import java.util.Vector;

public class Tauler {
    private Vector<Fila> tauler;
    private Vector<Peca> codiBase = new Vector<>();
    public Tauler(int rondes){
        tauler = new Vector<>(rondes);
    }
    public void setCodiBase(Vector<Peca> codiBase){
        this.codiBase = codiBase;
    }
    public void afegirFila(Fila f){
        tauler.add(f);
    }
    public Fila obtenirFila(int f){
        return tauler.get(f);
    }
    public boolean existeixCodiBase(){
        if (codiBase.isEmpty()) return false;
        else return true;
    }
    public Vector<Peca> getCodiBase(){
        return codiBase;
    }
    public Vector<Peca> solucionarFila(Fila f){ //retorna la combinació de blancs i negres de resposta
        Vector<Peca> resposta = new Vector<> (codiBase.size(), 0);
        Vector<Boolean> pecaMarcadaCodiBase = new Vector<Boolean> (codiBase.size(), 0); //vector de peces que ja han estat marcades com a negra o blanca
        Vector<Boolean> pecaMarcadaCodiEnviat = new Vector<> (codiBase.size(), 0);
        for (int i = 0; i < codiBase.size(); ++i){
            pecaMarcadaCodiBase.add(false);
            pecaMarcadaCodiEnviat.add(false);
            if (codiBase.get(i).getColor() == f.getPecaAPosicio(i).getColor()){
                resposta.add(new Peca(2));
                pecaMarcadaCodiBase.set(i, true);
                pecaMarcadaCodiEnviat.set(i, true);
            }
        }
        for (int i = 0; i < codiBase.size(); ++i){ //no funciona, si posem codi 1122 i enviem 6562 torna 10
            for (int j = 0; j < codiBase.size(); ++j){ //primer cal comprobar els i == j per posar negres abans que blanques
                if (i != j) {
                    if (codiBase.get(i).getColor() == f.getPecaAPosicio(j).getColor() && !pecaMarcadaCodiBase.get(i) &&!pecaMarcadaCodiEnviat.get(j)) {
                        resposta.add(new Peca(1));
                        pecaMarcadaCodiBase.set(i, true);
                        pecaMarcadaCodiEnviat.set(j, true);
                    }
                }
            }
        }
        while(resposta.size()<resposta.capacity()) {
            resposta.add(new Peca(0));
        }

        //System.out.println("RESPOSTA DESDE TAULER = " + resposta);
        Collections.reverse(resposta);
        return resposta;
    }

    public Vector<Peca> getSolucioUltimaFila() {
        //System.out.println("Tamany = " + tauler.size());
        return tauler.get(tauler.size()-1).getSolucioFila();
    }

    public Vector<Peca> getContingutUltimaFila() {
        return tauler.get(tauler.size()-1).getContingutFila();
    }

    public void guardarTauler(){

    }
}
