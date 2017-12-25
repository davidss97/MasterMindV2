package Presentacio;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Vector;

public class PantallaPartida {
    public PantallaPartida(Integer[][] colors, int rondes, int forats, boolean rol){//Rol: Maker:false , Breaker:true


        if(rol){//La maquina fa de codebreaker
            /*
            Partida p = new Partida(pecesCodi, colors, rondes, repetirColors);

            p.setCodeB(new Maquina(true, p));
            p.setCodeM(new Jugador(false, p));

            System.out.println("Introdueix el codi secret en format consecutiu (1234), on cada dígit representa un color:");
            int comb = 0;
            bucle = true;
            while (bucle) {
                try {
                    comb = sc.nextInt();
                    if (comb < 0 || comb/Math.pow(10,pecesCodi-1) < 1) throw new IllegalArgumentException();
                    bucle = false;
                } catch (InputMismatchException e) {
                    System.out.println("El paràmetre introduït no és un nombre");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("El nombre introduït no és vàlid");
                }
            }
            p.getCodeM().crearCodi(intApeca(comb, pecesCodi));

            boolean segueix = true;
            int rounds = 0;
            while (segueix && rounds<rondes) {
                rounds++;

                System.out.println("Ronda: " + rounds);

                ((Maquina) p.getCodeB()).moure();

                System.out.println("Combinació a última proposta = " + pecaAint(p.getContingutUltimaFila(), pecesCodi));
                System.out.println("Resposta a última proposta = " + pecaAint(p.getSolucioUltimaFila(), pecesCodi));
                System.out.println("------------------------------------------------------");
                segueix = false;
                for (int xx = 0; xx < p.getPecesCodi(); xx++) {
                    if (p.getSolucioUltimaFila().get(xx).getColor() != 2) segueix = true;

                }
            }
            if(rounds==rondes && segueix) System.out.println("Has arribat al límit de rondes....");
            else System.out.println("SUCCESS!!! La solució es: " + pecaAint(p.getContingutUltimaFila(), pecesCodi));
             */

        }


        rondes = rondes+2;
        forats = forats;

        JFrame frame = new JFrame("Rounded Button Example");
        frame.setLayout(new BorderLayout());

        JButton b1 = new RoundButton( colors[2][0],colors[2][1],colors[2][2]);
        JButton b2 = new RoundButton( colors[2][0],colors[2][1],colors[2][2]);

        JPanel panelCentral = new JPanel(new GridLayout(rondes,forats+1));

        JButton[][] buttons = new JButton[rondes][forats];
        int count = 0;
        for (JButton[] buttonn : buttons) {
            count++;
            if (count == 2 && rol /*breaker*/) {
                for(int i = 0; i <= forats; i++) {
                    panelCentral.add(new JLabel(""));
                }
            }else if (count == rondes - 1 && !rol /*maker*/) {
                for(int i = 0; i <= forats; i++) {
                    panelCentral.add(new JLabel(""));
                }
            }else {

                buttonn = new JButton[forats];
                for (JButton button : buttonn) {
                    button = new RoundButton(190,190,190);//colors[3][0], colors[3][1], colors[3][2]);
                    button.addActionListener(new ActionListener() {
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

                            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione un color",
                                    "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                                    stockArr, "opcion 1");
                            //new Object[] { "Aceptar", "Cancelar",bg.getElements().nextElement(), jb2, jb ,chec, chec2 },"opcion 1");

                            if (seleccion != -1) {
                                System.out.println("seleccionada opcion " + (seleccion + 1));
                                if (seleccion == 0) {
                                    int inde = 0;
                                    Enumeration<AbstractButton> elems = bg.getElements();
                                    while (elems.hasMoreElements()) {
                                        if (elems.nextElement().isSelected()) {
                                            System.out.println("breaks with index " + inde);
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
                    panelCentral.add(button);
                }
                JPanel panelBW = new JPanel(new GridLayout(2, 2));
                JButton blacksmall = new RoundButton(true, colors[0][0], colors[0][1], colors[0][2]);
                JButton whitesmall = new RoundButton(true, colors[1][0], colors[1][1], colors[1][2]);
                panelBW.add(blacksmall);
                panelBW.add(whitesmall);
                panelCentral.add(panelBW);
            }

        }



        panelCentral.setPreferredSize(new Dimension(230, 500));
        frame.add(panelCentral, BorderLayout.CENTER);
        JLabel lab = new JLabel("                         ");
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
                  System.out.println("Aceptar");
                  //send to Partida
              }
          });

        frame.add(lab, BorderLayout.WEST);
        frame.add(derecha, BorderLayout.EAST);

        frame.add(panelCentral, BorderLayout.CENTER);

        frame.setSize(250+55*forats, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
