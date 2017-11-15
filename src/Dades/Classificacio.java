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

public class Classificacio {

    private String nomJugador;
    private int rondesFinals;

    //Constructora
    public Classificacio(String nomJugador,int rondesFinals) {
        this.nomJugador = nomJugador;
        this.rondesFinals = rondesFinals;
    }

    //rondes integer --> rond String
    private String rond = String.valueOf(rondesFinals);

    //Funcions entrants:
    public void guardarPartidaFacil(){ guardarPartida("Facil.txt"); }
    public void guardarPartidaMitjana(){ guardarPartida("Mitjana.txt");}
    public void guardarPartidaDificil(){ guardarPartida("Dificil.txt"); }
    private void guardarPartida(String path){
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File(path);
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);
            //Escribimos en el archivo con el metodo write
            escribir.write(rond + " " + nomJugador + "\n");
            //Cerramos la conexion
            escribir.close();
        }
        //Si existe un problema al escribir cae aqui
        catch (Exception e){
            System.out.println("Error al escribir");
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
           /* Creamos un FileReader para leer del fichero en forma de Bytes */
            //FileReader fr = new FileReader("Datos.txt");
           /* Creamos un BufferedReader a partir del FileReader para poder leer caracteres */
            //BufferedReader br = new BufferedReader(fr);

            br = new BufferedReader(new FileReader(path));

           /* Creamos un FileWriter para escribir en el fichero en forma de Bytes */
            FileWriter fw = new FileWriter(path);

           /* Creamos un PrintWriter a partir del FileWriter para poder escribir caracteres */
            PrintWriter pw = new PrintWriter(fw);

           /* Vamos leyendo linea a linea hasta llegar al final del fichero (null) */
            String linea = null;
            while ((linea = br.readLine()) != null){
                llista.add(linea);
            }
           /* Ordenamos la lista con el método sort de la clase Collections */
            Collections.sort(llista);

           /* Escribimos en el fichero de salida */
            Iterator iter = llista.iterator();
            String cadena;
            while (iter.hasNext())
            {
                cadena = (String) iter.next();
                pw.println(cadena);
                //MOSTRAR PER PANTALLA
                System.out.println(cadena);
            }
           /* Cerramos los flujos de los ficheros */
            br.close();
            //fr.close();
            pw.close();
            fw.close();

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

