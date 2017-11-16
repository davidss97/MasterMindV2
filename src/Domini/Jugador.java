package Domini;

import java.util.Scanner;
import java.util.Vector;

public class Jugador {
    protected Partida P;
    private Rol rol;
    protected boolean rolN;
    public Jugador(boolean rolN, Partida P){
        this.P = P;
        this.rolN = rolN;
        if(rolN){//isBreaker
            rol = new CodeB(P);//maquina codem
        }else{
            rol = new CodeM(P);
        }
        //rol.setP(P);
    }
    public void moure(Vector<Peca> comb){
        ((CodeB) rol).enviarIntent(comb);
    }
    public void crearCodi(Vector<Peca> comb){
        ((CodeM) rol).enviarCodi(comb);//vector de colors
    }
    public boolean getRolN(){
        return rolN;
    }
    protected Rol getRol(){
        return rol;
    }
    public Vector<Integer> getColorsCodiBase(){
        return getColors(P.getCodiBase());
    }
    public int getNombreColors(){
        return P.getColors();
    }
    public int getPecesCodi(){
        return P.getPecesCodi();
    }
    private Vector<Integer> getColors(Vector<Peca> peces){
        Vector<Integer> colorsCodi = new Vector<Integer> (peces.size());
        for (int i = 0; i < peces.size(); ++i){
            colorsCodi.add(peces.get(i).getColor());
        }
        return colorsCodi;
    }
}