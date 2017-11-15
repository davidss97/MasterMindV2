package Domini;

/*
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

import java.util.Vector;

public class Algorisme {

    Vector<Integer> S;
    Vector<Boolean> llistaPossibles;
    Vector<Boolean> used;

    public Algorisme() {

        S = createSet();
        llistaPossibles = createSetBools(true); //if true, S[index] is still a possible solution (all true at start)
        used = createSetBools(false);//used indexes

/*
        //// 2- comb = 1122 = S[7]
        int combinacio = 1122;
        used.set(7, true);

        //// 3- Enviar combinació [....]

        //int response = 2000;   // 2 black 1 white 0 non

        //// 4- Si la resposta son 4 fiches negres, el joc acaba

        //// 5- Else, eliminar tots aquells que no donarian la mateixa resposta si fossin la solució
        //    es a dir, si amb 1122 dona 1 blanca, eliminar totes aquelles combinacions que no donin 1 blanca

        if (response == 2222) {
            //end
        } else {
            //eliminar combs
            netejarVector(combinacio, response);
        }


        //// 6- Fer minimax....
        //tornar a step 3
        //int nextCombIndex = minimax();

*/
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

    private Vector<Integer> combinacionsResposta(int tamany){
        Vector<Integer> combinations = new Vector<Integer>(15,4);
        //int checkpoint = 0; // (a partir de checkpoint 2, n de negras al principio = checkpoint-1)
        for (int checkpoint = 0;  checkpoint < 5; checkpoint++){     /// GENERACIO DE COMBINACIONS DE RESPOSTA (per a dimensio 4, modificar per a dimensio variable)
            if(checkpoint==0){
                combinations.add(0000);
                combinations.add(2000);
                combinations.add(2200);
                combinations.add(2220);
                combinations.add(2222);
            }else if(checkpoint==1){
                combinations.add(1000);
                combinations.add(1100);
                combinations.add(1110);
                combinations.add(1111);
            }else{
                int com = 0;
                int negras = checkpoint-1;
                for(int m = 1; m <= negras ; m++) {//añadir negras
                    com += 2;
                    com *= 10;
                } for(int n = 1; n <= 4-negras ; n++){//añadir blancas  CAMBIAR n < total-negras
                    com += 1;
                    for(int x=0; x+n+negras < 4 ;x++){
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

        Vector<Integer> combinations = combinacionsResposta(4);
        Vector<Integer> prox = new Vector<Integer>(2,0); //prox[0]=puntuacio  prox[1]=index
        prox.add(-1);
        prox.add(-1);
        //////////////////
        for(int i=0; i<1296; i++){
            if(llistaPossibles.get(i) && !used.get(i)){ //precondition check: not used !llista    ????? !llistaPossibles.get(i) ????
                int score = 10000000; //es sobreescriura
                for(int x = 0; x < 15; x++){//15
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


        //////////////////////////
        //return prox.get(1); //index
        used.set(prox.get(1), true);
        llistaPossibles.set(prox.get(1), false);
        return S.get(prox.get(1));//valor
    }

    private int calculaEliminacionsDeSnoDescartades(int combNoUsada,int resultat){
        int eliminations = 0;
        for(int i = 0; i < 1296;i++){
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
            if(llistaPossibles.get(i)){//encara possible
                int prop = S.get(i);
                if(!obtenirRes(combinacio, prop, response)){
                    llistaPossibles.set(i,false);  // modificar sobre la variable (vector) del constructor, (conve fer-la global ???)?????????
                    //System.out.println("Eliminada la possiblitat de = " + S.get(i) + " que tornaria 0000 si el codi fors " + combinacio );
                }
            }
        }
    }

    private boolean obtenirRes(int combinacio, int proposta, int resposta){ //if false, not a valid option anymore (descartar)

        /*proposta fara de combinacio amagada*/

        /*calcular resposta de combinacio amb proposta(que faria de codi amagat) (negres blancs ..) i comparar amb resposta*/
		
		/* convertir comb i proposta a vector-int  */
        Vector<Integer> combvect = new Vector<Integer> (4, 0);
        Vector<Integer> propvect = new Vector<Integer> (4, 0);
        Vector<Integer> resvect = new Vector<Integer> (4, 0);

        //System.out.println("resposta esperada: "+resposta);

        combvect.add(combinacio/1000);
        propvect.add(proposta/1000);
        resvect.add(resposta/1000);
        combinacio -= (combinacio/1000)*1000;
        proposta -= (proposta/1000)*1000;
        resposta -= (resposta/1000)*1000;


        combvect.add(combinacio/100);
        propvect.add(proposta/100);
        resvect.add(resposta/100);
        combinacio -= (combinacio/100)*100;
        proposta -= (proposta/100)*100;
        resposta -= (resposta/100)*100;

        combvect.add(combinacio/10);
        propvect.add(proposta/10);
        resvect.add(resposta/10);
        combinacio -= (combinacio/10)*10;
        proposta -= (proposta/10)*10;
        resposta -= (resposta/10)*10;

        combvect.add(combinacio);
        propvect.add(proposta);
        resvect.add(resposta);

        //System.out.println("resvect: "+resvect.get(0) + "" +resvect.get(1) + ""+resvect.get(2) + ""+resvect.get(3));
		/* ---------------------------------------*/


        Vector<Integer> resposta2 = new Vector<Integer> (4, 0);

        Vector<Boolean> pecaMarcada = new Vector<Boolean> (4, 0);
        for (int i = 0; i < resposta2.capacity(); ++i){ //marcar negres
            pecaMarcada.add(false);
            if (propvect.get(i) == combvect.get(i)){
                resposta2.add(2);
                pecaMarcada.set(i, true);
            }
        }
        for (int i = 0; i < resposta2.capacity(); ++i){ //marcar blanques     i < codiBase...!
            for (int j = 0; j < resposta2.capacity(); ++j){   //               j < codiBase...!
                if (i != j) {
                    if (propvect.get(i) == combvect.get(j) && !pecaMarcada.get(i)) {//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        resposta2.add(1);//new Peca(1));
                        pecaMarcada.set(i, true);
                    }

                }

            }
        }

        while(resposta2.size()<resposta2.capacity()) {
            resposta2.add(0);
        }
        //System.out.println("res2 = "+resposta2 + "res = "+resvect);
        if(resposta2.get(0) == resvect.get(0) && resposta2.get(1) == resvect.get(1) && resposta2.get(2) == resvect.get(2) && resposta2.get(3) == resvect.get(3))
        {
            //System.out.println("res2 = "+resposta2 + "res = "+resvect);
            return true;
        }
        else{
            //System.out.println("falsa");
            return false;
        }


    }

    private Vector<Boolean> createSetBools(Boolean defaul){
        Vector<Boolean> sampleSet=new Vector<Boolean>(1296, 5);
        for (int i = 0; i <1296; i++){
            sampleSet.add(defaul);
        }
        return sampleSet;
    }

    private Vector<Integer> createSet(){
        Vector<Integer> sampleSet=new Vector<Integer>(1296, 5);
        for (int i = 1; i <= 6; i++){
            for (int i2 = 1; i2 <= 6; i2++){
                for (int i3 = 1; i3 <= 6; i3++){
                    for (int i4 = 1; i4 <= 6; i4++){
                        int comb = i*1000+i2*100+i3*10+i4;
                        sampleSet.add(comb);
                    }
                }
            }
        }
        return sampleSet;
    }

}