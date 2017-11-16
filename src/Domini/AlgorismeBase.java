package Domini;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class AlgorismeBase {
    private Vector<Integer> S;
    private Vector<Boolean> llistaPossibles;
    private int forats, colors, tamanySet;
    public AlgorismeBase(int forats, int colors) {
        this.forats = forats;
        this.colors = colors;
        tamanySet = (int)Math.pow(colors,forats);
        S = createSet(forats,colors);
        llistaPossibles = createSetBools(true); //if true, S[index] is still a possible solution (all true at start)
    }

    public int jugada() {
        int x;
        while (true) {
            x = (int) (Math.random() * S.size());
            if (llistaPossibles.get(x)){
                return x;
            }
        }
    }
    private void netejarVector(int combinacio, int response){
        for (int i = 0; i < S.size(); i++){
            if(llistaPossibles.get(i) == true){//encara possible
                int prop = S.get(i);
                if(!obtenirRes(combinacio, prop, response)){
                    if(prop == 65432)System.out.println("Elimina 65432");

                    llistaPossibles.set(i,false);  // modificar sobre la variable (vector) del constructor, (conve fer-la global ???)?????????
                }
            }
        }
    }
    private Vector<Integer> convertAVector(int enter){
        Vector<Integer> vector = new Vector<Integer> (forats, 0);
        int poten = 1 * (int)Math.pow(10,forats-1);

        for(int i = 0; i < forats; i++) {
            vector.add(enter / poten);
            enter -= (enter / poten) * poten;
            poten /= 10;

        }

        return vector;
    }
    private boolean obtenirRes(int combinacio, int proposta, int resposta){ //if false, not a valid option anymore (descartar)


        int propostasave = proposta;
        int combinaciosave = combinacio;
        /*proposta fara de combinacio amagada*/

        /*calcular resposta de combinacio amb proposta(que faria de codi amagat) (negres blancs ..) i comparar amb resposta*/

		/* convertir comb i proposta a vector-int  */
        Vector<Integer> combvect = convertAVector(combinacio);
        Vector<Integer> propvect = convertAVector(proposta);
        Vector<Integer> resvect = convertAVector(resposta);


        Vector<Integer> resposta2 = new Vector<Integer> (forats, 0);

        Vector<Boolean> pecaMarcada = new Vector<Boolean> (forats, 0);
        Vector<Boolean> pecaMarcadaJ = new Vector<Boolean> (forats, 0);
        for (int i = 0; i < resposta2.capacity(); ++i){ //marcar negres
            pecaMarcada.add(false);
            pecaMarcadaJ.add(false);
            if (propvect.get(i) == combvect.get(i)){
                resposta2.add(2);
                pecaMarcadaJ.set(i,true);
                pecaMarcada.set(i, true);
            }
        }
        for (int i = 0; i < resposta2.capacity(); ++i){ //marcar blanques     i < codiBase...!
            for (int j = 0; j < resposta2.capacity(); ++j){   //               j < codiBase...!
                if (i != j) {
                    if (propvect.get(i) == combvect.get(j) && !pecaMarcada.get(i) && !pecaMarcadaJ.get(j)) {//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        resposta2.add(1);//new Peca(1));
                        pecaMarcadaJ.set(j,true);
                        pecaMarcada.set(i, true);
                    }
                }

            }
        }


        while(resposta2.size()<resposta2.capacity()) {
            resposta2.add(0);
        }

        if(resposta2.equals(resvect))
        //if(resposta2.get(0) == resvect.get(0) && resposta2.get(1) == resvect.get(1) && resposta2.get(2) == resvect.get(2) && resposta2.get(3) == resvect.get(3))
        {
            return true;
        }
        else{
            //elimina
            //if(propostasave == 65432)
            //    System.out.println("resposta per " +propostasave+ " amb comb " + combinaciosave +" = " + resposta2 +" i resvect = " + resvect + " i resposta = "+ resposta);
            return false;
        }


    }
    private Vector<Boolean> createSetBools(Boolean defaul){
        Vector<Boolean> sampleSet=new Vector<Boolean>(tamanySet, 5);
        for (int i = 0; i < tamanySet; i++){
            sampleSet.add(defaul);
        }
        return sampleSet;
    }

    private Vector<Integer> createSet(int forats, int colors){
        int tam = tamanySet;
        Vector<Integer> sampleSet=new Vector<Integer>(tam,5);
        if(colors > 9) System.out.println("Maxim numero de colors es 9");
        int[] input = new int[colors];
        for(int i = 0; i < colors ; i++){
            input[i] = i+1;
        }
        int lengthOfSinglePermutation = forats;

        // we need to check number of unique values in array
        Set<Integer> arrValues = new HashSet<Integer>();
        for (int i : input) {
            arrValues.add(i);
        }
        int noOfUniqueValues = arrValues.size();

        int[] indexes = new int[lengthOfSinglePermutation];
        int totalPermutations = (int) Math.pow(noOfUniqueValues, lengthOfSinglePermutation);

        for (int i = 0; i < totalPermutations; i++) {
            int valor = 0;
            for (int j = lengthOfSinglePermutation-1; j >= 0; j--) {
                valor+=input[indexes[j]];
                valor*=10;
            }
            valor/=10;
            //System.out.println(valor);
            sampleSet.add(valor);

            for (int j = 0; j < lengthOfSinglePermutation; j++) {
                if (indexes[j] >= noOfUniqueValues - 1) {
                    indexes[j] = 0;
                }
                else {
                    indexes[j]++;
                    break;
                }
            }
        }
        return sampleSet;
    }
}
