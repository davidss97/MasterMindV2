package Presentacio;

import Domini.MasterMind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class PantallaFabrica extends JPanel {

    private JPanel panel =  new JPanel(new GridBagLayout());
    private JPanel panelextern =  new JPanel(new BorderLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private Toolkit tk = Toolkit.getDefaultToolkit();

    private ItemHandler hf1 = new ItemHandler();
    private ItemHandler hc1 = new ItemHandler();
    private ItemHandler hr1 = new ItemHandler();

    private ButtonGroup bg1 = new ButtonGroup();
    private JLabel roles = new JLabel("Select your Role: ");
    private JRadioButton cb = new JRadioButton("Code Breaker");
    private JRadioButton cm = new JRadioButton("Code Maker");

    private JButton home;
    private JButton start = new JButton("START!");

    private ButtonGroup bg2 = new ButtonGroup();
    private JLabel difficulty = new JLabel("Select your Difficulty: ");
    private JRadioButton esy = new JRadioButton("Easy");
    private JRadioButton mdm = new JRadioButton("Medium");
    private JRadioButton hrd = new JRadioButton("Hard");
    private JRadioButton cstm = new JRadioButton("Custom");

    private JLabel forats = new JLabel("Write the number of Holes: ");
    private JComboBox f1 = new JComboBox();

    private int cont;
    private JLabel colors = new JLabel("Write the number of Colors: ");
    private JComboBox c1 = new JComboBox();
    private JButton c2 = new JButton("Add");
    private JLabel c3 = new JLabel("Black and White already added.");
    private JLabel c4 = new JLabel("");
    private Color col;

    static <Integer> int[][] append(int[][] arr, int[] element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    private JLabel rondes = new JLabel("Select the number of Rounds: ");
    private JComboBox r1 = new JComboBox();

    private JLabel repetibles = new JLabel("Choose if Colors can be Repeated: ");
    private JCheckBox p1 = new JCheckBox("Repeatable Colors");

    private boolean roless;
    private int rondess;
    private int[][] colorss;
    private int foratss;
    private boolean repetibless;

    private PantallaBase base;

    PantallaFabrica(PantallaBase base){
        this.base = base;
        panel.setBackground(new Color(0, 225, 0));
        panelextern.setBackground(new Color(0, 225, 0));

        panelextern.add(panel,BorderLayout.CENTER);

        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        super.setSize(xSize/3*2, ySize/10*9);
        super.setLayout(new GridLayout(1,3));
        //super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        super.add(panelextern, BorderLayout.NORTH);

        //Espai mínim entre contingut i marge
        c.insets = new Insets(10,10,10,10);

        cb.setSelected(true);
        bg1.add(cb);
        bg1.add(cm);

        //esy.setSelected(true);
        bg2.add(esy);
        bg2.add(mdm);
        bg2.add(hrd);
        bg2.add(cstm);

        ((JLabel)f1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)c1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)r1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        f1.addItem("Choose...");
        c1.addItem("Choose...");
        r1.addItem("Choose...");

        for (int i=2; i<10; i++) f1.addItem(i);
        for (int i=2; i<16; i++) c1.addItem(i);
        for (int i=1; i<15; i++) r1.addItem(i);

        f1.addItemListener(hf1);
        c1.addItemListener(hc1);
        r1.addItemListener(hr1);

        c.anchor = GridBagConstraints.WEST;

        c3.setFont(new Font("Serif",Font.PLAIN,13));
        c4.setFont(new Font("Serif",Font.PLAIN,13));

        //text centrat
        //f1.setHorizontalAlignment(JTextField.CENTER);
        //c1.setHorizontalAlignment(JTextField.CENTER);
        //r1.setHorizontalAlignment(JTextField.CENTER);

        //de primeres es cb i facil
        //tema roles es indiferent pq es contempla mes endavant
        esy.doClick();
        esy.setSelected(true);

        colorss = new int[3][3];
        colorss[0][0] = 255;
        colorss[0][1] = 255;
        colorss[0][2] = 255;

        colorss[1][0] = 0;
        colorss[1][1] = 0;
        colorss[1][2] = 0;

        colorss[2][0] = 0;
        colorss[2][1] = 0;
        colorss[2][2] = 255;

        foratss = 2;
        rondess = 6;
        repetibless = false;

        f1.setSelectedItem(2);
        f1.setEnabled(false);
        c1.setSelectedItem(3);
        c1.setEnabled(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        r1.setSelectedItem(6);
        r1.setEnabled(false);
        p1.setSelected(false);
        p1.setEnabled(false);

        //si es selecciona facil, es 2 3 6 no i desactivats
        esy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setSelectedItem(2);
                f1.setEnabled(false);
                c1.setSelectedItem(3);
                c1.setEnabled(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                r1.setSelectedItem(6);
                r1.setEnabled(false);
                p1.setSelected(false);
                p1.setEnabled(false);

                //[#colors][3]   255,255,255 = blanc
                colorss = new int[3][3];
                colorss[0][0] = 255;
                colorss[0][1] = 255;
                colorss[0][2] = 255;

                colorss[1][0] = 0;
                colorss[1][1] = 0;
                colorss[1][2] = 0;

                colorss[2][0] = 0;
                colorss[2][1] = 0;
                colorss[2][2] = 255;
            }
        });

        //si es selecciona mitjana, es 3 4 8 si i desactivats
        mdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setSelectedItem(3);
                f1.setEnabled(false);
                c1.setSelectedItem(4);
                c1.setEnabled(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                r1.setSelectedItem(8);
                r1.setEnabled(false);
                p1.setSelected(true);
                p1.setEnabled(false);

                //[#colors][3]   255,255,255 = blanc
                colorss = new int[4][3];
                colorss[0][0] = 255;
                colorss[0][1] = 255;
                colorss[0][2] = 255;

                colorss[1][0] = 0;
                colorss[1][1] = 0;
                colorss[1][2] = 0;

                colorss[2][0] = 0;
                colorss[2][1] = 0;
                colorss[2][2] = 255;

                colorss[3][0] = 0;
                colorss[3][1] = 255;
                colorss[3][2] = 0;
            }
        });

        //si es selecciona dificil, es 4 6 10 si i desactivats
        hrd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setSelectedItem(4);
                f1.setEnabled(false);
                c1.setSelectedItem(6);
                c1.setEnabled(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                r1.setSelectedItem(10);
                r1.setEnabled(false);
                p1.setSelected(true);
                p1.setEnabled(false);

                //[#colors][3]   255,255,255 = blanc
                colorss = new int[6][3];
                colorss[0][0] = 255;
                colorss[0][1] = 255;
                colorss[0][2] = 255;

                colorss[1][0] = 0;
                colorss[1][1] = 0;
                colorss[1][2] = 0;

                colorss[2][0] = 0;
                colorss[2][1] = 0;
                colorss[2][2] = 255;

                colorss[3][0] = 0;
                colorss[3][1] = 255;
                colorss[3][2] = 0;

                colorss[4][0] = 255;
                colorss[4][1] = 0;
                colorss[4][2] = 0;

                colorss[5][0] = 100;
                colorss[5][1] = 100;
                colorss[5][2] = 100;
            }
        });

        //si es selecciona facil, es f1 c1 r1 p1 i activats
        cstm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);

                f1.setSelectedItem("Choose...");
                f1.setEnabled(true);
                c1.setSelectedItem("Choose...");
                c1.setEnabled(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                r1.setSelectedItem("Choose...");
                r1.setEnabled(false);
                p1.setSelected(false);
                p1.setEnabled(true);

                cont = 0;

                //[#colors][3]   255,255,255 = blanc
                //colorss = new int[Integer.parseInt(c1.getText())][3];
                colorss = new int[2][3];
                colorss[0][0] = 255;
                colorss[0][1] = 255;
                colorss[0][2] = 255;

                colorss[1][0] = 0;
                colorss[1][1] = 0;
                colorss[1][2] = 0;
            }
        });

        home = new HomeButton();
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.changeCenter(new PantallaInici(base));
                PantallaFabrica.super.setVisible(false);
            }
        });

        //boto add
        c2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cont < (int)c1.getSelectedItem() - 2){
                    col = JColorChooser.showDialog(null, "Paleto", Color.RED);
                    if (col!=null) cont++;
                }

                if (cont == ((int) c1.getSelectedItem() - 2)){
                    //c1.setEnabled(false);
                    c2.setVisible(false);
                    c3.setVisible(false);
                    c4.setVisible(false);
                    r1.setEnabled(true);
                }
                else{
                    //c3.setVisible(true);
                    c4.setText("Please add " + ((int) c1.getSelectedItem() - 2 - cont) + " more Color/s.");
                }

                if (col!=null){
                    int color[] = {col.getRed(), col.getGreen(), col.getBlue()};
                    colorss = append(colorss, color);
                }
                if (cont == ((int)c1.getSelectedItem() - 2)) c2.setEnabled(false);

                for (int i = 0; i < colorss.length; i++)
                    System.out.println("[" + colorss[i][0] + "]," + "[" + colorss[i][1] + "]," + "[" + colorss[i][2] + "],");

            }
        });

        //boto START! x passar a partida amb els parametres forats rol colors rondes i repetibles
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (esy.isSelected()){
                    foratss = 2;
                    //colorss = 3
                    rondess = 6;
                    repetibless = false;
                }
                else if (mdm.isSelected()){
                    foratss = 3;
                    //colorss = 4
                    rondess = 8;
                    repetibless = true;
                }
                else if (hrd.isSelected()){
                    foratss = 4;
                    //colorss = 6
                    rondess = 10;
                    repetibless = true;
                }
                else if (cstm.isSelected()){
                    foratss = (int) f1.getSelectedItem();
                    //colorss = Integer.parseInt(c1.getText());
                    rondess = (int) r1.getSelectedItem();
                }


                //si custom amb caracteristiques duna dificultat predeterminada
                if (cstm.isSelected() && (int)f1.getSelectedItem()==2 && (int)c1.getSelectedItem()==3 && (int)r1.getSelectedItem()==6 && !p1.isSelected()){
                    cstm.setSelected(false);
                    //esy.doClick();
                    esy.setSelected(true);
                    f1.setSelectedItem(2);
                    f1.setEnabled(false);
                    c1.setSelectedItem(3);
                    c1.setEnabled(false);
                    c2.setVisible(false);
                    c3.setVisible(false);
                    c4.setVisible(false);
                    r1.setSelectedItem(6);
                    r1.setEnabled(false);
                    p1.setSelected(false);
                    p1.setEnabled(false);

                    //[#colors][3]   255,255,255 = blanc
                    colorss = new int[3][3];
                    colorss[0][0] = 255;
                    colorss[0][1] = 255;
                    colorss[0][2] = 255;

                    colorss[1][0] = 0;
                    colorss[1][1] = 0;
                    colorss[1][2] = 0;

                    colorss[2][0] = 0;
                    colorss[2][1] = 0;
                    colorss[2][2] = 255;
                }
                else if (cstm.isSelected() && (int)f1.getSelectedItem()==3 && (int)c1.getSelectedItem()==4 && (int)r1.getSelectedItem()==8 && p1.isSelected()){
                    cstm.setSelected(false);
                    //mdm.doClick();
                    mdm.setSelected(true);
                    f1.setSelectedItem(3);
                    f1.setEnabled(false);
                    c1.setSelectedItem(4);
                    c1.setEnabled(false);
                    c2.setVisible(false);
                    c3.setVisible(false);
                    c4.setVisible(false);
                    r1.setSelectedItem(8);
                    r1.setEnabled(false);
                    p1.setSelected(true);
                    p1.setEnabled(false);

                    //[#colors][3]   255,255,255 = blanc
                    colorss = new int[4][3];
                    colorss[0][0] = 255;
                    colorss[0][1] = 255;
                    colorss[0][2] = 255;

                    colorss[1][0] = 0;
                    colorss[1][1] = 0;
                    colorss[1][2] = 0;

                    colorss[2][0] = 0;
                    colorss[2][1] = 0;
                    colorss[2][2] = 255;

                    colorss[3][0] = 0;
                    colorss[3][1] = 255;
                    colorss[3][2] = 0;
                }
                else if (cstm.isSelected() && (int)f1.getSelectedItem()==4 && (int)c1.getSelectedItem()==6 && (int)r1.getSelectedItem()==10 && p1.isSelected()){
                    cstm.setSelected(false);
                    //hrd.doClick();
                    hrd.setSelected(true);
                    f1.setSelectedItem(4);
                    f1.setEnabled(false);
                    c1.setSelectedItem(6);
                    c1.setEnabled(false);
                    c2.setVisible(false);
                    c3.setVisible(false);
                    c4.setVisible(false);
                    r1.setSelectedItem(10);
                    r1.setEnabled(false);
                    p1.setSelected(true);
                    p1.setEnabled(false);

                    //[#colors][3]   255,255,255 = blanc
                    colorss = new int[6][3];
                    colorss[0][0] = 255;
                    colorss[0][1] = 255;
                    colorss[0][2] = 255;

                    colorss[1][0] = 0;
                    colorss[1][1] = 0;
                    colorss[1][2] = 0;

                    colorss[2][0] = 0;
                    colorss[2][1] = 0;
                    colorss[2][2] = 255;

                    colorss[3][0] = 0;
                    colorss[3][1] = 255;
                    colorss[3][2] = 0;

                    colorss[4][0] = 255;
                    colorss[4][1] = 0;
                    colorss[4][2] = 0;

                    colorss[5][0] = 100;
                    colorss[5][1] = 100;
                    colorss[5][2] = 100;
                }
                //passem parametres a partida
                //AMB AIXÒ M'OBLIDO DEL ROL --> next level (true = CB)
                roless = cb.isSelected();
                repetibless = p1.isSelected();

                //CAL CHECKEJAR COLORSS.LENGTH == Integer.parseInt(c1.getText())
                if (colorss.length == (int) c1.getSelectedItem()){
                    new PantallaPartida(new MasterMind(foratss, colorss.length, rondess, repetibless), colorss, rondess, foratss, roless, repetibless);
                    base.changeCenter(new PantallaInici(base));
                    PantallaFabrica.super.setVisible(false);
                }
                else System.out.println("ERROR!");


                //CALDRA ESBORRAR, ES PER COMPROVAR QUE ELS PARAMETRES ESTAN READY TO GO
                System.out.println("Proves");
                System.out.println(cstm.isSelected());
                System.out.println(hrd.isSelected());
                System.out.println(foratss);
                System.out.println(c1.getSelectedItem());
                System.out.println(rondess);
                System.out.println(repetibless);
                System.out.println(roless);
            }
        });

        //labels en posició i buides
        inicialitzar();
    }

    private void inicialitzar(){
        c.gridx = 0;
        c.gridy = 0;
        panel.add(roles,c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(cb,c);

        c.gridx = 2;
        c.gridy = 0;
        panel.add(cm,c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(difficulty,c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(esy,c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(mdm,c);

        c.gridx = 2;
        c.gridy = 1;
        panel.add(hrd,c);

        c.gridx = 2;
        c.gridy = 2;
        panel.add(cstm,c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(repetibles,c);

        c.gridx = 1;
        c.gridy = 3;
        panel.add(p1,c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(forats,c);

        c.gridx = 1;
        c.gridy = 4;
        panel.add(f1,c);

        c.gridx = 0;
        c.gridy = 5;
        panel.add(colors,c);

        c.gridx = 1;
        c.gridy = 5;
        panel.add(c1,c);

        c.gridx = 2;
        c.gridy = 5;
        panel.add(c2,c);

        c.gridx = 1;
        c.gridy = 6;
        panel.add(c3,c);

        c.gridx = 2;
        c.gridy = 6;
        panel.add(c4,c);

        c.gridx = 0;
        c.gridy = 7;
        panel.add(rondes,c);

        c.gridx = 1;
        c.gridy = 7;
        panel.add(r1,c);

        c.gridx = 1;
        c.gridy = 20;
        panel.add(start,c);

        panelextern.add(home,BorderLayout.PAGE_END);

        super.setVisible(true);
    }

    private class ItemHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event){
            if (event.getSource() == f1){
                if (f1.getSelectedItem() != "Choose..." && cstm.isSelected()){
                    cb.setEnabled(false);
                    cm.setEnabled(false);
                    esy.setEnabled(false);
                    mdm.setEnabled(false);
                    hrd.setEnabled(false);
                    cstm.setEnabled(false);
                    p1.setEnabled(false);

                    if (!p1.isSelected()) {
                        //esborrem
                        for (int i = 2; i < 16; i++) c1.removeItem(i);
                        //afegim
                        for (int i = (int) f1.getSelectedItem(); i < 16; i++) c1.addItem(i);
                    }
                    f1.setEnabled(false);
                    c1.setEnabled(true);
                }
                if (f1.getSelectedItem() != "Choose...") {
                    f1.setEnabled(false);
                    c1.setEnabled(true);
                }
            }
            else if (event.getSource() == c1){
                if (f1.getSelectedItem()!="Choose...") {
                    if (((int) c1.getSelectedItem() - 2 - cont)==0){
                        c1.setEnabled(false);
                        r1.setEnabled(true);
                        c3.setVisible(true);
                    }
                    else {
                        c1.setEnabled(false);
                        c2.setEnabled(true);
                        c2.setVisible(true);
                        c3.setVisible(true);
                        c4.setText("Please add " + ((int) c1.getSelectedItem() - 2 - cont) + " more Color/s.");
                        c4.setVisible(true);
                    }
                }
                //r1.setEnabled(true);
            }
            else if (event.getSource()==r1){
                if (r1.getSelectedItem()!="Choose...") {
                    r1.setEnabled(false);
                    //p1.setEnabled(true);
                    start.setEnabled(true);
                }
            }
        }
    }

}