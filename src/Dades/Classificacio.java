package Dades;

//Se m'ha posat * automàticament
import java.io.*;
import java.util.*;

//test
public class Classificacio {

    //Constructora
    /*public Classificacio(String nomJugador,int rondesFinals) {
        this.nomJugador = nomJugador;
        this.rond = String.valueOf(rondesFinals);
        this.rondInt = rondesFinals;
    }*/

    //Funcions entrants:
    public void guardarPartidaFacil(String nomJugador, int rondesFinals){
        guardarPartida("Facil.txt", nomJugador, rondesFinals);
    }
    public void guardarPartidaMitjana(String nomJugador, int rondesFinals){
        guardarPartida("Mitjana.txt", nomJugador, rondesFinals);
    }
    public void guardarPartidaDificil(String nomJugador, int rondesFinals){
        guardarPartida("Dificil.txt", nomJugador, rondesFinals);
    }
    private void guardarPartida(String path, String nomJugador, int rondesFinals){
        //PART 1 PER GUARDAR ORDENAT
        String rond = String.valueOf(rondesFinals);
        File archivo;
        FileWriter escribir;
        FileReader leer;
        PrintWriter pw;

        BufferedReader br;
        ArrayList<String> llista = new ArrayList<String>();

        String linea, cadena;
        Iterator iter;

        try {
            //crear o obrir .txt de la dificultat corresponent
            archivo = new File(path);
            escribir = new FileWriter(archivo, true);

            leer = new FileReader(path);
            br = new BufferedReader(leer);
            //agafa contingut a la llista
            if (rondesFinals < 10) llista.add("0" + rond + " " + nomJugador);
            else llista.add(rond + " " + nomJugador);

            while ((linea = br.readLine()) != null){ llista.add(linea); }

            //ordena per strings, per tant error perque agafa 10 < 9
            Collections.sort(llista);

            pw = new PrintWriter(escribir);
            //netejar/esborrar fitxer
            new PrintWriter(path).close();

            //escriu ja ordenat de la llista
            iter = llista.iterator();
            while (iter.hasNext())
            {
                cadena = (String) iter.next();
                pw.println(cadena);
            }

            //tanquem
            escribir.close();
            br.close();
            pw.close();
            llista.clear();
        }
        catch (FileNotFoundException e) {
            System.err.println("No s'ha trobat el fitxer");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Error a l'escriure");
        }
    }

    public void veureClassificacioFacil (){ veureClassificacio("Facil.txt"); }
    public void veureClassificacioMitjana (){ veureClassificacio("Mitjana.txt"); }
    public void veureClassificacioDificil (){ veureClassificacio("Dificil.txt"); }
    private void veureClassificacio (String path){
        //PART 2 PER MOSTRAR PER PANTALLA
        BufferedReader br;
        LinkedList<String> llista = new LinkedList<String>();
        String cadena,linea;
        Iterator iter;
        try {

            br = new BufferedReader(new FileReader(path));
            while ((linea = br.readLine()) != null){
                llista.add(linea);
            }
            iter = llista.iterator();
            while (iter.hasNext())
            {
                cadena = (String) iter.next();
                //MOSTRAR PER PANTALLA
                System.out.println(cadena);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("No s'ha trobat el fitxer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Vull passar LinkedList llista de capa Dades a capa Presentació
    public static LinkedList getLlista (String path){
        BufferedReader br;
        LinkedList<String> llista = new LinkedList<String>();
        String linea;
        //String cadena,linea;
        //Iterator iter;
        try {
            br = new BufferedReader(new FileReader(path));
            while ((linea = br.readLine()) != null){
                llista.add(linea);
            }
            /*iter = llista.iterator();
            while (iter.hasNext())
            {
                cadena = (String) iter.next();
                //MOSTRAR PER PANTALLA
                System.out.println(cadena);
            }*/
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("No s'ha trobat el fitxer");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return llista;
    }
}