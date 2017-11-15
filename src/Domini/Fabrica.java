package Domini;

public class Fabrica {
    //nombre posicions codi, colors, nombre de files, repetir colors
    private int pecesCodi;
    private int colors; //de moment no seleccionem els colors exactes, només el límit
    private int rondes;
    private boolean repetirColors;
    private MasterMind MM;
    public Fabrica(int pecesCodi, int colors, int rondes, boolean repetirColors) {
        this.pecesCodi = pecesCodi;
        this.colors = colors;
        this.rondes = rondes;
        this.repetirColors = repetirColors;
        crearMasterMind();
    }
    public void setPecesCodi(int pecesCodi){
        this.pecesCodi = pecesCodi;
    }
    public void setColors(int colors) {
        this.colors = colors;
    }
    public void setRondes(int rondes){
        this.rondes = rondes;
    }
    public void setRepetirColors(boolean repetirColors){
        this.repetirColors = repetirColors;
    }
    private void crearMasterMind(){
        MM = new MasterMind(this.pecesCodi, this.colors, this.rondes, this.repetirColors);
    }
    public void mostrarCaracteristiquesPartida(){
        MM.mostrarCaracteristiquesPartida();
    }
}
