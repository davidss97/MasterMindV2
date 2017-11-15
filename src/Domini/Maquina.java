package Domini;

public class Maquina extends Jugador {
    public Maquina(boolean rolN, Partida P) {
        super(rolN, P);
    }
    //private Algoritme algoritme = new Algoritme (this);
    public void moure(){
        if(rolN) {
            //((CodeB) rol).enviarIntent(executarAlgoritme()); //el que retorni l'algoritme
        }else {
            System.out.println("Error. Un code maker no pot e  nviar intent.");
        }

    }
    public void crearCodi(){
        if(rolN) {
            System.out.println("Error. Un code breaker no pot crear un codi");
        } else {
            //selecció aleatoria de codi base
        }
    }
}

