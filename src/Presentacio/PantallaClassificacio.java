package Presentacio;

import Dades.Classificacio;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedList;

public class PantallaClassificacio extends JPanel{
    private JComboBox dificultat = new JComboBox();
    private LinkedList llista;
    private JPanel panel =  new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private ItemHandler handler = new ItemHandler();
    private JButton home;
    private Toolkit tk = Toolkit.getDefaultToolkit();

    private String cadena;
    private String AA = "";
    private String BB = "";
    private Iterator iter;

    private JLabel PP = new JLabel("Posició");
    private JLabel NN = new JLabel("Nom");
    private JLabel RR = new JLabel("Rondes");

    private JLabel L1 = new JLabel(" ");
    private JLabel N1 = new JLabel(" ");
    private JLabel R1 = new JLabel(" ");

    private JLabel L2 = new JLabel(" ");
    private JLabel N2 = new JLabel(" ");
    private JLabel R2 = new JLabel(" ");

    private JLabel L3 = new JLabel(" ");
    private JLabel N3 = new JLabel(" ");
    private JLabel R3 = new JLabel(" ");

    private JLabel L4 = new JLabel(" ");
    private JLabel N4 = new JLabel(" ");
    private JLabel R4 = new JLabel(" ");

    private JLabel L5 = new JLabel(" ");
    private JLabel N5 = new JLabel(" ");
    private JLabel R5 = new JLabel(" ");

    private JLabel L6 = new JLabel(" ");
    private JLabel N6 = new JLabel(" ");
    private JLabel R6 = new JLabel(" ");

    private JLabel L7 = new JLabel(" ");
    private JLabel N7 = new JLabel(" ");
    private JLabel R7 = new JLabel(" ");

    private JLabel L8 = new JLabel(" ");
    private JLabel N8 = new JLabel(" ");
    private JLabel R8 = new JLabel(" ");

    private JLabel L9 = new JLabel(" ");
    private JLabel N9 = new JLabel(" ");
    private JLabel R9 = new JLabel(" ");

    private JLabel L10 = new JLabel(" ");
    private JLabel N10 = new JLabel(" ");
    private JLabel R10 = new JLabel(" ");

    private PantallaBase base;

    PantallaClassificacio(PantallaBase base){

        this.base = base;
        panel.setBackground(Color.GREEN);
        super.setLayout(new BorderLayout());
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        super.setSize(xSize/3*2, ySize/10*9);
        //super.setLayout(new GridLayout(1,3));
        //super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        super.add(panel, BorderLayout.CENTER);

        //Espai mínim entre contingut i marge
        c.insets = new Insets(10,10,10,10);

        //combobox per seleccionar les dificultats
        dificultat.addItem("Easy");
        dificultat.addItem("Medium");
        dificultat.addItem("Hard");
        dificultat.addItemListener(handler);

        home = new HomeButton();
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.changeCenter(new PantallaInici(base));
                PantallaClassificacio.super.setVisible(false);
            }
        });

        //labels en posició i buides
        inicialitzar();

        //ja que el primer item del combobox és Fàcil
        llista = getLlistaFacil();

        //escriurem llista (tenint en compte la dificultat)
        escriure();
    }

    private static class RoundedBorder implements Border {
        private int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    //Segons la dificultat
    public LinkedList getLlistaFacil (){ return getLlista("Facil.txt"); }
    public LinkedList getLlistaMitjana (){ return getLlista("Mitjana.txt"); }
    public LinkedList getLlistaDificil (){ return getLlista("Dificil.txt"); }
    //Agafo llista de la Capa de Dades
    public LinkedList getLlista (String path){ return Classificacio.getLlista(path); }

    private class ItemHandler implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event){
            //esborrar llista vella
            esborrar();

            if (event.getSource() == dificultat){
                if (dificultat.getSelectedItem()=="Easy") llista = getLlistaFacil();
                else if (dificultat.getSelectedItem()=="Medium") llista = getLlistaMitjana();
                else llista = getLlistaDificil();
            }
            //escriure llista nova
            escriure();
        }
    }
    private void esborrar(){
        L1.setText(" ");
        N1.setText(" ");
        R1.setText(" ");

        L2.setText(" ");
        N2.setText(" ");
        R2.setText(" ");

        L3.setText(" ");
        N3.setText(" ");
        R3.setText(" ");

        L4.setText(" ");
        N4.setText(" ");
        R4.setText(" ");

        L5.setText(" ");
        N5.setText(" ");
        R5.setText(" ");

        L6.setText("");
        N6.setText("");
        R6.setText("");

        L7.setText(" ");
        N7.setText(" ");
        R7.setText(" ");

        L8.setText(" ");
        N8.setText(" ");
        R8.setText(" ");

        L9.setText(" ");
        N9.setText(" ");
        R9.setText(" ");

        L10.setText(" ");
        N10.setText(" ");
        R10.setText(" ");
    }

    private void escriure (){

        int cont = 1;
        int posEspai = 0;

        iter = llista.iterator();
        while (iter.hasNext())
        {
            cadena = (String) iter.next();

            for (int n = 0; n < cadena.length (); n++) {
                if (cadena.charAt(n)==' '){
                    posEspai = n;
                    for (int nn=0; nn<n; ++nn) AA+=cadena.charAt(nn);
                    break;
                }
            }
            for (int nn=posEspai+1; nn<cadena.length(); ++nn) BB+=cadena.charAt(nn);

            if (cont == 1){
                L1.setText(AA);
                N1.setText("1. ");
                R1.setText(BB);
            }
            else if (cont == 2){
                L2.setText(AA);
                N2.setText("2. ");
                R2.setText(BB);
            }
            else if (cont == 3){
                L3.setText(AA);
                N3.setText("3. ");
                R3.setText(BB);
            }
            else if (cont == 4){
                L4.setText(AA);
                N4.setText("4. ");
                R4.setText(BB);
            }
            else if (cont == 5){
                L5.setText(AA);
                N5.setText("5. ");
                R5.setText(BB);
            }
            else if (cont == 6){
                L6.setText(AA);
                N6.setText("6. ");
                R6.setText(BB);
            }
            else if (cont == 7){
                L7.setText(AA);
                N7.setText("7. ");
                R7.setText(BB);
            }
            else if (cont == 8){
                L8.setText(AA);
                N8.setText("8. ");
                R8.setText(BB);
            }
            else if (cont == 9){
                L9.setText(AA);
                N9.setText("9. ");
                R9.setText(BB);
            }
            else if (cont == 10){
                L10.setText(AA);
                N10.setText("10. ");
                R10.setText(BB);
            }
            cont++;

            AA = "";
            BB = "";
        }
    }

    private void inicialitzar(){
        c.gridx = 1;
        c.gridy = 0;
        panel.add(dificultat,c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(PP,c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(NN,c);

        c.gridx = 2;
        c.gridy = 1;
        panel.add(RR,c);

        c.gridx = 2;
        c.gridy = 2;
        panel.add(L1,c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(N1,c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(R1,c);

        c.gridx = 2;
        c.gridy = 3;
        panel.add(L2,c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(N2,c);

        c.gridx = 1;
        c.gridy = 3;
        panel.add(R2,c);

        c.gridx = 2;
        c.gridy = 4;
        panel.add(L3,c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(N3,c);

        c.gridx = 1;
        c.gridy = 4;
        panel.add(R3,c);

        c.gridx = 2;
        c.gridy = 5;
        panel.add(L4,c);

        c.gridx = 0;
        c.gridy = 5;
        panel.add(N4,c);

        c.gridx = 1;
        c.gridy = 5;
        panel.add(R4,c);

        c.gridx = 2;
        c.gridy = 6;
        panel.add(L5,c);

        c.gridx = 0;
        c.gridy = 6;
        panel.add(N5,c);

        c.gridx = 1;
        c.gridy = 6;
        panel.add(R5,c);

        c.gridx = 2;
        c.gridy = 7;
        panel.add(L6,c);

        c.gridx = 0;
        c.gridy = 7;
        panel.add(N6,c);

        c.gridx = 1;
        c.gridy = 7;
        panel.add(R6,c);

        c.gridx = 2;
        c.gridy = 8;
        panel.add(L7,c);

        c.gridx = 0;
        c.gridy = 8;
        panel.add(N7,c);

        c.gridx = 1;
        c.gridy = 8;
        panel.add(R7,c);

        c.gridx = 2;
        c.gridy = 9;
        panel.add(L8,c);

        c.gridx = 0;
        c.gridy = 9;
        panel.add(N8,c);

        c.gridx = 1;
        c.gridy = 9;
        panel.add(R8,c);

        c.gridx = 2;
        c.gridy = 10;
        panel.add(L9,c);

        c.gridx = 0;
        c.gridy = 10;
        panel.add(N9,c);

        c.gridx = 1;
        c.gridy = 10;
        panel.add(R9,c);

        c.gridx = 2;
        c.gridy = 11;
        panel.add(L10,c);

        c.gridx = 0;
        c.gridy = 11;
        panel.add(N10,c);

        c.gridx = 1;
        c.gridy = 11;
        panel.add(R10,c);

        super.add(home, BorderLayout.PAGE_END);

        super.setVisible(true);
    }

}