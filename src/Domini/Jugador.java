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
            rol = new CodeB();
        }else{
            rol = new CodeM();
        }
        rol.setP(P);
    }
    public void moure(){
        ((CodeB) rol).enviarIntent(introduirComb());
    }
    public void crearCodi(){
        ((CodeM) rol).enviarCodi(introduirComb());//vector de colors
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
    private Vector<Peca> introduirComb(){ //caldria fer que aquesta funció estigués al CodeB
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix els números del codi d'un en un");
        Vector<Peca> comb = new Vector<Peca>(P.getPecesCodi()); //recent editat al fer la fàbrica
        int t = comb.capacity();
        for(int i = 0; i < t; ++i) {
            comb.add(new Peca(sc.nextInt()));
        }
        System.out.println("Has introduit el codi: " + getColors(comb));
        return comb;
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