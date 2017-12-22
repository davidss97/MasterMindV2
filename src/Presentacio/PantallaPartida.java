package Presentacio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class PantallaPartida {
    public PantallaPartida(Integer[][] colors, int rondes, int forats, boolean rol){//Rol: Maker:false , Breaker:true

        /*CALLER
        Integer[][] colors = new Integer[3][3];

        Integer[] negre = {0,0,0};
        Integer[] blanc = {255,255,255};
        Integer[] vermell = {255,0,0};

        colors[0] = negre;
        colors[1] = blanc;
        colors[2] = vermell;

        new PantallaPartida(colors);*/

        JFrame frame = new JFrame("Rounded Button Example");
        frame.setLayout(new BorderLayout());

        JButton b1 = new RoundButton( colors[2][0],colors[2][1],colors[2][2]);
        JButton b2 = new RoundButton( colors[2][0],colors[2][1],colors[2][2]);

        JPanel panelCentral = new JPanel(new GridLayout(10,5));

        JPanel panelBW = new JPanel(new GridLayout(2,2));
        JButton blacksmall = new RoundButton(true,colors[0][0],colors[0][1],colors[0][2]);
        JButton whitesmall = new RoundButton(true,colors[1][0],colors[1][1],colors[1][2]);
        panelBW.add(blacksmall);
        panelBW.add(whitesmall);

        JPanel panel2 = new JPanel(new GridLayout(2,2));
        panel2.add(new RoundButton(true, 0,0,0));

        JPanel panel3 = new JPanel(new GridLayout(2,2));
        panel3.add(new RoundButton(true, 0,0,0));

        JPanel panel4 = new JPanel(new GridLayout(2,2));
        panel4.add(new RoundButton(true, 0,0,0));

        JPanel panel5 = new JPanel(new GridLayout(2,2));
        panel5.add(new RoundButton(true, 0,0,0));

        JPanel panel6 = new JPanel(new GridLayout(2,2));
        panel6.add(new RoundButton(true, 0,0,0));

        JPanel panel7 = new JPanel(new GridLayout(2,2));
        panel7.add(new RoundButton(true, 0,0,0));

        JPanel panel8 = new JPanel(new GridLayout(2,2));
        panel8.add(new RoundButton(true, 0,0,0));
/*
        List<JButton> buttonList = new ArrayList<JButton>();
        for(int i = 0; i < 8; i++) {
            JButton button = new JButton();
            buttonList.add(button);
            panelCentral.add(button);
        }*/

        JButton[] buttons = new JButton[4];
        for (JButton button : buttons) {
            button = new RoundButton( colors[3][0],colors[3][1],colors[3][2]);
            panelCentral.add(button);
        }
        /*
        panelCentral.add(b1);
        panelCentral.add(b2);
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));*/
        panelCentral.add(panelBW);


        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(panel2);

        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(panel3);

        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(panel4);

        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(panel5);

        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(panel6);

        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(panel7);

        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(panel8);


        panelCentral.add(new JLabel(""));
        panelCentral.add(new JLabel(""));
        panelCentral.add(new JLabel(""));
        panelCentral.add(new JLabel(""));
        panelCentral.add(new JLabel(""));

        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new RoundButton(0,0,0));
        panelCentral.add(new JLabel(""));

        panelCentral.setPreferredSize(new Dimension(200, 500));
        frame.add(panelCentral, BorderLayout.CENTER);
        JLabel lab = new JLabel("                        ");
        lab.setSize(new Dimension(800,300));
        JLabel lab2 = new JLabel("                       ");
        lab.setSize(new Dimension(800,300));

        frame.add(lab, BorderLayout.WEST);
        frame.add(lab2, BorderLayout.EAST);
        frame.add(panelCentral, BorderLayout.CENTER);

        frame.setSize(500, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
