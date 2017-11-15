package Domini;
import Dades.Classificacio;

public class MasterMind {
    private int pecesCodi;
    private int colors;
    private int rondes;
    private boolean repetirColors;
    private Partida partida;
    private Classificacio classificacio = null;
    public MasterMind(int pecesCodi, int colors, int rondes, boolean repetirColors){
        this.pecesCodi = pecesCodi;
        this.colors = colors;
        this.rondes = rondes;
        this.repetirColors = repetirColors;
        crearPartida();
    }
    public void mostrarCaracteristiquesPartida(){
        partida.mostrarCaracteristiques();
    }

    public void guardarPartida(String nomJugador, int rondesFinals){
        classificacio = new Classificacio(nomJugador, rondesFinals);
        if (pecesCodi == 2 && colors == 3 && rondes == 6 && !repetirColors) classificacio.guardarPartidaFacil();
        else if (pecesCodi == 3 && colors == 4 && rondes == 8 && repetirColors) classificacio.guardarPartidaMitjana();
        else if (pecesCodi == 4 && colors == 6 && rondes == 10 && repetirColors) classificacio.guardarPartidaDificil();
        else System.out.println("Aquesta partida no correspon a cap dificultat estandaritzada i per tant no es pot guardar");
    }
    public void veureClassificacio(String dificultat){
        switch(dificultat){
            case "facil":
                classificacio.veureClassificacioFacil();
                break;
            case "mitjana":
                classificacio.veureClassificacioMitjana();
                break;
            case "dificil":
                classificacio.veureClassificacioDificil();
                break;
            default:
                System.out.println("No existeix cap classificació per la dificultat donada");
                break;
        }
    }
    private void crearPartida(){
        partida = new Partida(this.pecesCodi, this.colors, this.rondes, this.repetirColors);
    }
}
