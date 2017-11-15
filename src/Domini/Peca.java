package Domini;

public class Peca {
    private int color;
    public Peca (int p){
        color = p; // si el color és 0 es blanc si és 1 és negre
    }
    public void setColor(int col){
        color = col;
    }
    public int getColor(){
        return color;
    }
}