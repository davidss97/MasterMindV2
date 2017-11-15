package Domini;

import java.util.Vector;

public class CodeM extends Rol{
    public void enviarCodi(Vector<Peca> comb){
        System.out.println("Enviant codi...");
        P.setCodiBase(comb);
    }
}