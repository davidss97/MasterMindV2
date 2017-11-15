package Domini;

import java.util.Vector;

public class CodeB extends Rol{
    public void enviarIntent(Vector<Peca> comb) {
        System.out.println("Enviant intent...");
        if (! P.codiExisteix()) System.out.println("No hi ha cap codi introduit");
        else{
            P.comprobarCodi(comb);
        }
    }
}