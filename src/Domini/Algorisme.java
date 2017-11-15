package Domini;/*
1-Create the set S of 1296 possible codes (1111, 1112 ... 6665, 6666)
2-Start with initial guess 1122 (Knuth gives examples showing that other first guesses such as 1123, 1234 do not win in five tries on every code)
3-Play the guess to get a response of colored and white pegs.
4-If the response is four colored pegs, the game is won, the algorithm terminates.
5-Otherwise, remove from S any code that would not give the same response if it (the guess) were the code.
6-Apply minimax technique to find a next guess as follows: For each possible guess, that is, any unused code of the 1296 not just those in S, calculate 
	how many possibilities in S would be eliminated for each possible colored/white peg score. The score of a guess is the minimum number of possibilities 
	it might eliminate from S. A single pass through S for each unused code of the 1296 will provide a hit count for each colored/white peg score found; 
	the colored/white peg score with the highest hit count will eliminate the fewest possibilities; calculate the score of a guess by using "minimum eliminated" 
	= "count of elements in S" - (minus) "highest hit count". From the set of guesses with the maximum score, select one as the next guess, choosing a member of
	S whenever possible. (Knuth follows the convention of choosing the guess with the least numeric value e.g. 2345 is lower than 3456. Knuth also gives an example 
	showing that in some cases no member of S will be among the highest scoring guesses and thus the guess cannot win on the next turn, yet will be necessary to assure a win in five.)
7-Repeat from step 3.  */

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Algorisme {

    Vector<Integer> S;
    Vector<Boolean> llistaPossibles;
    Vector<Boolean> used;
    int forats, colors, tamanySet;

    public Algorisme(int forats, int colors) {
        this.forats = forats;
        this.colors = colors;
        tamanySet = (int)Math.pow(colors,forats);
        S = createSet(forats,colors);
        llistaPossibles = createSetBools(true); //if true, S[index] is still a possible solution (all true at start)
        used = createSetBools(false);//used indexes

    }

    public int jugada() {//retorna 1122 o 11122 ....
        int n = 0;
        for(int i = 0; i < forats;i++){
            if(i<forats-2) n += 1;
            else n+=2;
            n*=10;
        }
        n/=10;
        System.out.println("Minimax: " + n);
        return n;
    }

    public int jugada(int response,int combinacio){

        if (response == 2222) {
            //end
        } else {
            //eliminar combs
            netejarVector(combinacio, response);
        }
        return minimax();
    }

    public Vector<Peca> jugada(Vector<Peca> respon,Vector<Peca> com){
        int combinacio = pecaAint(com);
        int response = pecaAint(respon);
        if (response == 2222) {
            //end
        } else {
            //eliminar combs
            netejarVector(combinacio, response);
        }
        int ret =  minimax();
        return intApeca(ret);
    }

    private Vector<Peca> intApeca(int vec){
        Vector<Peca> res= new Vector<>(forats,1);
        int mul = (int)Math.pow(10,forats-1);

        String number = Integer.toString(vec);
        String output = "";
        for(int i = number.length()-1; i >= 0; i--)
            res.add( new Peca(Character.getNumericValue(number.charAt(i))) );

        return res;
    }

    private int pecaAint(Vector<Peca> vec){
        int res=0;
        int mul = (int)Math.pow(10,forats-1);
        for(int i = 0; i<vec.size(); i++){
            res += vec.get(vec.size()-1-i).getColor()*mul;
            mul/= 10;
        }
        return res;
    }

    int sumatori(int fins){
        int ret = 0;
        for(int i = 0 ; i <= fins; i++){
            ret+=i;
        }
        return ret;
    }
    private Vector<Integer> combinacionsResposta(int tamany){
        Vector<Integer> combinations = new Vector<Integer>(sumatori(forats+1),4);

        for (int checkpoint = 0;  checkpoint < forats+1 /* 5 */; checkpoint++){     /// GENERACIO DE COMBINACIONS DE RESPOSTA (per a dimensio 4, modificar per a dimensio variable)
            if(checkpoint==0){
                combinations.add(0);
                int inicial = 2*(int)Math.pow(10,forats-1);
                int valor = 0;
                for(int i = 0; i < forats;i++){
                    valor += inicial;
                    combinations.add(valor);
                    inicial/=10;
                }
                /*
                combinations.add(0000);
                combinations.add(2000);
                combinations.add(2200);
                combinations.add(2220);
                combinations.add(2222);*/
            }else if(checkpoint==1){
                int inicial = 1*(int)Math.pow(10,forats-1);
                int valor = 0;
                for(int i = 0; i < forats;i++){
                    valor += inicial;
                    combinations.add(valor);
                    inicial/=10;
                }
                /*
                combinations.add(1000);
                combinations.add(1100);
                combinations.add(1110);
                combinations.add(1111);*/
            }else{
                int com = 0;
                int negras = checkpoint-1;
                for(int m = 1; m <= negras ; m++) {//añadir negras
                    com += 2;
                    com *= 10;
                } for(int n = 1; n <= forats/*4*/-negras ; n++){//añadir blancas  CAMBIAR n < total-negras
                    com += 1;
                    for(int x=0; x+n+negras < forats/*4*/ ;x++){
                        com*=10;
                    }
                    combinations.add(com);
                    while(com%10==0){
                        com/=10;
                    }com*=10;
                }
            }

        }
        return combinations;
    }

    public int minimax(){

        Vector<Integer> combinations = combinacionsResposta(forats);
        Vector<Integer> prox = new Vector<Integer>(2,0); //prox[0]=puntuacio  prox[1]=index
        prox.add(-1);
        prox.add(-1);
        //////////////////
        boolean algunpossible = false;
        for(int i=0; i<tamanySet; i++){

            if(llistaPossibles.get(i) && !used.get(i)){ //precondition check: not used !llista    ????? !llistaPossibles.get(i) ????
                algunpossible = true;
                int score = 10000000; //es sobreescriura
                for(int x = 0; x < sumatori(forats+1); x++){//   (int)Math.pow(3,forats)
                    int resultat = combinations.get(x);
                    int combNoUsada = S.get(i);
                    int sc;
                    if(x == 0) {
                        score = calculaEliminacionsDeSnoDescartades( combNoUsada,resultat);
                        //System.out.println("SCORE: " +score);
                    }
                    else{
                        sc = calculaEliminacionsDeSnoDescartades( combNoUsada,resultat);
                        if(sc < score)score=sc;
                       // System.out.println("SCORE: "+score);
                    }
                }
                if(score > prox.get(0)){
                    prox.set(0, score);
                    prox.set(1, i);
                }
            }
        }
        if(!algunpossible) System.out.println("Ninguna combinacio possible no usada");

        used.set(prox.get(1), true);
        llistaPossibles.set(prox.get(1), false);
        return S.get(prox.get(1));//valor
    }

    private int calculaEliminacionsDeSnoDescartades(int combNoUsada,int resultat){
        int eliminations = 0;
        for(int i = 0; i < tamanySet;i++){
            if( llistaPossibles.get(i) == true){ //no descartada, encara en S  ////////////////////////////////////7777777777777777777777777777777777777777777777777777777
                //System.out.println("DEBUG: tamany="+ S.size()+ ", i="+ i);
                if(obtenirRes(combNoUsada, S.get(i), resultat) == false) {
                    eliminations++; //not sure si ordre correcte
                    //System.out.println("ELIMINACIO");
                }
            }
            //System.out.println("ELIMINACIONS per " + i + " :"+eliminations);
        }

        return eliminations;
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

    public Vector<Integer> createSet(int forats, int colors){
        int tam = tamanySet;
        Vector<Integer> sampleSet=new Vector<Integer>(tam,5);
        if(colors >= 9) System.out.println("Maxim numero de colors es 91");
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