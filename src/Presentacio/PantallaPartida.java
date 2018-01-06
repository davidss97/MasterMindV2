package Presentacio;

import Domini.*;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PantallaPartida {
    int ronda = 0;
    Integer[][] vecColors;
    int foratsGlob;
    static JButton[][] buttons;
    static JButton[][] smallbuttons;
    final int rondesS;
    public PantallaPartida(MasterMind mm, final Integer[][] colors, int rondes, final int forats, final boolean rol){//Rol: Maker:false , Breaker:true

        Partida p =  new Partida(forats, colors.length, rondes, true);//repetirForats = true

        if(rol){//La maquina fa de codebreaker
            p.setCodeM(new Maquina(false, p));
            p.setCodeB(new Jugador(true, p));
            ((Maquina) p.getCodeM()).crearCodi(forats, colors.length, true);
        }else{
            p.setCodeB(new Maquina(true, p));
            p.setCodeM(new Jugador(false, p));

        }

        vecColors = colors;
        rondesS = rondes+2;
        foratsGlob = forats;

        JFrame frame = new JFrame("Rounded Button Example");
        frame.setLayout(new BorderLayout());

        //JButton b1 = new RoundButton( colors[2][0],colors[2][1],colors[2][2]);
        //JButton b2 = new RoundButton( colors[2][0],colors[2][1],colors[2][2]);

        JPanel panelCentral = new JPanel(new GridLayout(rondesS,forats+1));

        /*panelBW = new JPanel[rondes];
        for(int i = 0 ; i < rondes;i++){
            panelBW[i] = new JPanel(new GridLayout(2, forats%2+1));
        }*/
        smallbuttons = new JButton[rondesS][forats];
        buttons = new JButton[rondesS][forats];
        int count = 0;
        for (int ii = 0; ii < rondesS ; ii++) {//JButton[] buttonn : buttons) {
            count++;
            if (count == 2 && rol /*breaker*/) {
                for(int i = 0; i <= forats +1; i++) { //+1 per alinear, afegeix label on anirien foratsBW de secreta
                    panelCentral.add(new JLabel(""));
                }
            }else if (count == rondesS - 1 && !rol /*maker*/) {
                for(int i = 0; i <= forats; i++) {
                    panelCentral.add(new JLabel(""));
                }
            }else {

                for (int jj = 0; jj<forats; jj++){//JButton button : buttonn) {
                    buttons[ii][jj] = new RoundButton(190,190,190);//colors[3][0], colors[3][1], colors[3][2]);
                    if ((count != 1 && rol /*breaker*/) || (count == rondesS && !rol /*Maker*/) ) {
                        buttons[ii][jj].addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                ButtonGroup bg = new ButtonGroup();

                                int bgCount = 0;
                                JRadioButton[] radios = new JRadioButton[colors.length];
                                for (int i = 0; i < colors.length; i++) {
                                    radios[i] = new JRadioButton();
                                    radios[i].setBackground(new Color(colors[i][0], colors[i][1], colors[i][2]));
                                    bg.add(radios[i]);
                                    bgCount++;
                                }

                                Object[] stockArr = new Object[2 + bgCount];
                                stockArr[0] = "Aceptar";
                                stockArr[1] = "Cancelar";
                                Enumeration<AbstractButton> elements = bg.getElements();
                                int i = 2;
                                while (elements.hasMoreElements()) {
                                    stockArr[i] = elements.nextElement();
                                    i++;
                                }

                                int seleccion = JOptionPane.showOptionDialog(frame, "Seleccione un color",
                                        "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                                        stockArr, "opcion 1");
                                //new Object[] { "Aceptar", "Cancelar",bg.getElements().nextElement(), jb2, jb ,chec, chec2 },"opcion 1");

                                if (seleccion != -1) {
                                    //System.out.println("seleccionada opcion " + (seleccion + 1));
                                    if (seleccion == 0) {
                                        int inde = 0;
                                        Enumeration<AbstractButton> elems = bg.getElements();
                                        while (elems.hasMoreElements()) {
                                            if (elems.nextElement().isSelected()) {
                                                //System.out.println("breaks with index " + inde);
                                                break;
                                            }
                                            inde++;
                                        }
                                        Object source = e.getSource();
                                        if (source instanceof Component) {
                                            ((Component) source).setBackground(new Color(colors[inde][0], colors[inde][1], colors[inde][2]));
                                        }
                                    } else if (seleccion == 1) {
                                        //cancel
                                    }
                                }
                            }
                        });
                    }
                    panelCentral.add(buttons[ii][jj]);
                }
                JPanel panelBW = new JPanel(new GridLayout(2, forats%2+1));
                for (int jj = 0; jj<forats; jj++) {
                    smallbuttons[ii][jj] = new RoundButton(true, colors[0][0], colors[0][1], colors[0][2]);
                    smallbuttons[ii][jj].setVisible(false);
                    panelBW.add(smallbuttons[ii][jj]);
                }

                if((!rol && ii < rondes) || (rol && ii > 1))panelCentral.add(panelBW);

            }

        }



        panelCentral.setPreferredSize(new Dimension(230, 500));
        frame.add(panelCentral, BorderLayout.CENTER);
        JLabel lab = new JLabel("                          ");
        lab.setSize(new Dimension(800,300));
        JLabel lab2 = new JLabel("                       ");
        lab.setSize(new Dimension(800,300));
        JButton acc = new JButton("Aceptar");
        JPanel derecha = new JPanel();
        derecha.setLayout(new BorderLayout());

        derecha.add(lab2, BorderLayout.CENTER);
        derecha.add(acc, BorderLayout.SOUTH);

        acc.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {

              //send to Partida
                //getSecreta();
              /**---------------------------------------------------------------------------------------*/
              if(!rol){
                    System.out.println("Introdueix el codi secret en format consecutiu (1234), on cada dígit representa un color:");
                    int comb = 0;
                    boolean bucle = true;

                    p.getCodeM().crearCodi(getSecreta());  //implementar fiches vistual a instancies de Peca


                    boolean segueix = true;
                    int rounds = 0;
                    while (segueix && rounds<rondesS) {
                        rounds++;

                        System.out.println("Ronda: " + rounds);

                        ((Maquina) p.getCodeB()).moure();
                        System.out.println("Combinació a última proposta = " + pecaAint(p.getContingutUltimaFila(), forats));
                        Vector<Peca> combi = p.getContingutUltimaFila();
                        for(int i = 0; i <  combi.size(); i++){
                            int c = combi.get(i).getColor();
                            buttons[rondes - 1 - ronda][combi.size() -1-i].setBackground(new Color(colors[c-1][0],colors[c-1][1],colors[c-1][2]));
                        }

                        Vector<Peca> res = p.getSolucioUltimaFila();
                        int posSol = 0;
                        for(int i = 0; i <  res.size(); i++){
                            int c = res.get(res.size() - i-1).getColor();
                            if(c == 2 || c == 1) {
                                smallbuttons[rondes - 1 - ronda][posSol].setBackground(new Color(colors[c - 1][0], colors[c - 1][1], colors[c - 1][2]));
                                smallbuttons[rondes - 1 - ronda][posSol++].setVisible(true);
                            }
                        }
                        //smallbuttons[rondes - 1 - ronda][0].setVisible(true);
                        ronda++;

                        System.out.println("Resposta a última proposta = " + pecaAint(p.getSolucioUltimaFila(), forats));
                        System.out.println("------------------------------------------------------");
                        segueix = false;
                        for (int xx = 0; xx < p.getPecesCodi(); xx++) {
                            if (p.getSolucioUltimaFila().get(xx).getColor() != 2) segueix = true;

                        }
                    }

                    if(rounds==rondesS && segueix) System.out.println("Has arribat al límit de rondes....");
                    else System.out.println("SUCCESS!!! La solució es: " + pecaAint(p.getContingutUltimaFila(), forats));
                     /*----------------------------------------------------------------------------------------------------------------*/
              }else{//jugar com a breaker
                    /**/

                    boolean segueix = true;
                   /* int rounds = 0;
                    while (segueix && rounds < rondes) {
                        rounds++;*/

                        System.out.println("Ronda: " + ronda);
                        System.out.println("Entri el seu intent....:");
                        int com = 0;

                        try {
                            com = getNextRonda();//agafar comb fila = rondeS - rondaActual -1;
                            if (com < 0 || com/Math.pow(10,forats-1) < 1) throw new IllegalArgumentException();

                        } catch (InputMismatchException ex) {
                            System.out.println("El paràmetre introduït no és un nombre");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("El nombre introduït no és vàlid");
                        }

                        Vector<Peca> comV = intApeca(com, forats);
                        ((Jugador) p.getCodeB()).moure(comV);//

                          Vector<Peca> res = p.getSolucioUltimaFila();
                          int posSol = 0;
                          for(int i = 0; i <  res.size(); i++){
                              int c = res.get(res.size() - i-1).getColor();
                              if(c == 2 || c == 1) {
                                  smallbuttons[rondes +2 - ronda][posSol].setBackground(new Color(colors[c - 1][0], colors[c - 1][1], colors[c - 1][2]));
                                  smallbuttons[rondes +2 - ronda][posSol++].setVisible(true);
                              }
                          }

                        //System.out.println(p.getSolucioUltimaFila());

                        System.out.println("Combinació a última proposta =" + pecaAint(p.getContingutUltimaFila(), forats));
                        System.out.println("Resposta a última proposta (2 = negra, 1 = blanca, 0 = buit)=" + pecaAint(p.getSolucioUltimaFila(), forats));
                        System.out.println("------------------------------------------------------");
                        // /System.out.println("peces codi = " + p.getPecesCodi());
                        segueix = false;
                        for (int xx = 0; xx < p.getPecesCodi(); xx++) {
                            if (p.getSolucioUltimaFila().get(xx).getColor() != 2) segueix = true;

                        }
                    if(!segueix || ronda >= rondes) {
                        if (ronda == rondes && segueix) System.out.println("Has arribat al límit de rondes....");
                        else {
                            System.out.println("SUCCESS!!! La solució és: " + pecaAint(p.getContingutUltimaFila(), forats));
                            Vector<Peca> combi = p.getContingutUltimaFila();
                            for(int i = 0; i <  combi.size(); i++){
                                int c = combi.get(i).getColor();
                                buttons[0][combi.size() -1-i].setBackground(new Color(colors[c-1][0],colors[c-1][1],colors[c-1][2]));
                            }

                            String guardar = JOptionPane.showInputDialog(frame, "Has resolt la partida en "+ronda+" rondes, vols guardar partida?\nIntrodueix el teu nom:");
                            if(guardar != null) {
                                System.out.println("El nom del jugador es: " + guardar);
                                // AFEGIR CODI PER GUARDAR PARTIDA:
                                // MasterMind.guardarPartida(guardar, ronda);
                            }

                            System.exit(0);

                        }
                    }
                     /**/


              }
          }});

        frame.add(lab, BorderLayout.WEST);
        frame.add(derecha, BorderLayout.EAST);

        frame.add(panelCentral, BorderLayout.CENTER);

        frame.setSize(250+55*forats, (rondes+2)*55);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private int getNextRonda(){
        //int comb=0;

        String number = "";

        JButton[] buttonsX = buttons[rondesS-1-ronda];
        //System.out.println("Tamany comb sec: " + buttonsX.length);
        //System.out.println("color primer = " + vecColors[1][0]);
        for (JButton button : buttonsX) {
            for(int i = 0; i < vecColors.length; i++) {
                if((button).getBackground().equals(new Color(vecColors[i][0], vecColors[i][1], vecColors[i][2]))){
                    number +=String.valueOf(i + 1);
                    break;
                }
            }
        }

        System.out.println("la combinacio a enviar es: " + number);

        ronda++;
        return Integer.parseInt(number);
    }

    private  Vector<Peca> getSecreta(){// nomes si el rol es de maker
        String number = "";

        JButton[] buttonsX = buttons[rondesS-1];
        //System.out.println("Tamany comb sec: " + buttonsX.length);
        //System.out.println("color primer = " + vecColors[1][0]);
        for (JButton button : buttonsX) {
            for(int i = 0; i < vecColors.length; i++) {
                if((button).getBackground().equals(new Color(vecColors[i][0], vecColors[i][1], vecColors[i][2]))){
                    number +=String.valueOf(i + 1);
                    break;
                }
            }
        }

        System.out.println("la combinacio secreta es: " + number);

        Vector<Peca> res= new Vector<>(foratsGlob,1);
        //int mul = (int)Math.pow(10,foratsGlob-1);

        for(int i = number.length()-1; i >= 0; i--)
            res.add( new Peca(Character.getNumericValue(number.charAt(i))) );

        //ronda++;
        return res;
    }


    private static int pecaAint(Vector<Peca> vec, int forats){
        int res=0;
        int mul = (int)Math.pow(10,forats-1);
        for(int i = 0; i<vec.size(); i++){
            res += vec.get(vec.size()-1-i).getColor()*mul;
            mul/= 10;
        }
        return res;
    }
    private static Vector<Peca> intApeca(int vec, int forats){
        Vector<Peca> res= new Vector<>(forats,1);
        int mul = (int)Math.pow(10,forats-1);

        String number = Integer.toString(vec);
        String output = "";
        for(int i = number.length()-1; i >= 0; i--)
            res.add( new Peca(Character.getNumericValue(number.charAt(i))) );

        return res;
    }


}
