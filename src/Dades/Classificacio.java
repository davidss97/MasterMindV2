package Dades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


//test
public class Classificacio {

    private String nomJugador;
    private int rondesFinals;
    private String rond;

    //Constructora
    public Classificacio(String nomJugador,int rondesFinals) {
        this.nomJugador = nomJugador;
        this.rondesFinals = rondesFinals;
        this.rond = String.valueOf(rondesFinals);
    }

    //Funcions entrants:
    public void guardarPartidaFacil(){
        guardarPartida("Facil.txt");
    }
    public void guardarPartidaMitjana(){
        guardarPartida("Mitjana.txt");
    }
    public void guardarPartidaDificil(){
        guardarPartida("Dificil.txt");
    }
    private void guardarPartida(String path){
        try {
            File archivo = new File(path);
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(rond + " " + nomJugador + "\n");
            escribir.close();
        }
        catch (Exception e){
            System.out.println("Error a l'escriure");
        }
    }

    public void veureClassificacioFacil (){ veureClassificacio("Facil.txt"); }
    public void veureClassificacioMitjana (){ veureClassificacio("Mitjana.txt"); }
    public void veureClassificacioDificil (){ veureClassificacio("Dificil.txt"); }
    private void veureClassificacio (String path){
        //PART 2 PER ORDENAR I MOSTRAR PER PANTALLA
        BufferedReader br = null;
        LinkedList<String> llista = new LinkedList<String>();
        try {

            br = new BufferedReader(new FileReader(path));
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            String linea = null;
            while ((linea = br.readLine()) != null){
                llista.add(linea);
            }
            Collections.sort(llista);
            Iterator iter = llista.iterator();
            String cadena;
            while (iter.hasNext())
            {
                cadena = (String) iter.next();
                pw.println(cadena);
                //MOSTRAR PER PANTALLA
                System.out.println(cadena);
            }
            br.close();
            pw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            System.err.println("No s'ha trobat el fitxer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

