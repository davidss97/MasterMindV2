package Presentacio;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class PantallaFabrica extends JPanel {

    private JPanel panelextern = new JPanel(new BorderLayout());
    private JPanel panel =  new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private Toolkit tk = Toolkit.getDefaultToolkit();

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
    private JTextField f1 = new JTextField(3);

    private JLabel colors = new JLabel("Select the Colors: ");
    private JTextField c1 = new JTextField(3);
    private JButton c2 = new JButton("Add");
    private Color col;

    static <Integer> int[][] append(int[][] arr, int[] element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    private JLabel rondes = new JLabel("Write the number of Rounds: ");
    private JTextField r1 = new JTextField(3);

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
        panel.setBackground(Color.RED);
        panelextern.setBackground(Color.RED);

        panelextern.add(panel, BorderLayout.CENTER);

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

        esy.setSelected(true);
        bg2.add(esy);
        bg2.add(mdm);
        bg2.add(hrd);
        bg2.add(cstm);

        //text centrat
        f1.setHorizontalAlignment(JTextField.CENTER);
        c1.setHorizontalAlignment(JTextField.CENTER);
        r1.setHorizontalAlignment(JTextField.CENTER);

        //de primeres es cb i facil
        //tema roles es indiferent pq es contempla mes endavant
        f1.setText("2");
        f1.setEnabled(false);
        c1.setText("3");
        c1.setEnabled(false);
        c2.setEnabled(false);
        r1.setText("6");
        r1.setEnabled(false);
        p1.setSelected(false);
        p1.setEnabled(false);

        //si es selecciona facil, es 2 3 6 no i desactivats
        esy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("2");
                f1.setEnabled(false);
                c1.setText("3");
                c1.setEnabled(false);
                c2.setEnabled(false);
                r1.setText("6");
                r1.setEnabled(false);
                p1.setSelected(false);
                p1.setEnabled(false);
            }
        });

        //si es selecciona mitjana, es 3 4 8 si i desactivats
        mdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("3");
                f1.setEnabled(false);
                c1.setText("4");
                c1.setEnabled(false);
                c2.setEnabled(false);
                r1.setText("8");
                r1.setEnabled(false);
                p1.setSelected(true);
                p1.setEnabled(false);
            }
        });

        //si es selecciona dificil, es 4 6 10 si i desactivats
        hrd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("4");
                f1.setEnabled(false);
                c1.setText("6");
                c1.setEnabled(false);
                c2.setEnabled(false);
                r1.setText("10");
                r1.setEnabled(false);
                p1.setSelected(true);
                p1.setEnabled(false);
            }
        });

        //si es selecciona facil, es f1 c1 r1 p1 i activats
        cstm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("");
                f1.setEnabled(true);
                c1.setText("");
                c1.setEnabled(true);
                c2.setEnabled(true);
                r1.setText("");
                r1.setEnabled(true);
                p1.setSelected(false);
                p1.setEnabled(true);
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

        colorss = new int[0][0];
        c2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                col = JColorChooser.showDialog(null,"Paleto",Color.RED);
                int color[] = {col.getRed(), col.getGreen(),col.getBlue()};
                colorss = append(colorss,color);

                for(int i = 0; i < colorss.length; i++)
                    System.out.println( "[" + colorss[i][0] +"]," +"[" + colorss[i][1] +"]," +"[" + colorss[i][2] +"],");
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
                    foratss = Integer.parseInt(f1.getText());
                    //colorss = Integer.parseInt(c1.getText());
                    rondess = Integer.parseInt(r1.getText());
                    repetibless = p1.isSelected();
                }

                //si custom amb caracteristiques duna dificultat predeterminada
                if (cstm.isSelected() && f1.getText().equals("2") && c1.getText().equals("3") && r1.getText().equals("6") && !p1.isSelected()){
                    cstm.setSelected(false);
                    esy.doClick();
                }
                else if (cstm.isSelected() && f1.getText().equals("3") && c1.getText().equals("4") && r1.getText().equals("8") && p1.isSelected()){
                    cstm.setSelected(false);
                    mdm.doClick();
                }
                else if (cstm.isSelected() && f1.getText().equals("4") && c1.getText().equals("6") && r1.getText().equals("10") && p1.isSelected()){
                    cstm.setSelected(false);
                    hrd.doClick();
                }
                //passem parametres a partida
                //AMB AIXÒ M'OBLIDO DEL ROL --> next level (true = CB)
                roless = cb.isSelected();

                //base.changeCenter(new PantallaPartida(colorss,rondess,foratss,roless));
                base.changeCenter(new PantallaInici(base));
                PantallaFabrica.super.setVisible(false);

                //CALDRA ESBORRAR, ES PER COMPROVAR QUE ELS PARAMETRES ESTAN READY TO GO
                System.out.println("Proves");
                System.out.println(cstm.isSelected());
                System.out.println(hrd.isSelected());
                System.out.println(foratss);
                System.out.println(c1.getText());
                System.out.println(rondess);
                System.out.println(repetibless);
                System.out.println(roless);

            }
        });

        f1.addKeyListener(new KeyListener() {
              public void keyTyped(KeyEvent e) {
                  char c = e.getKeyChar();
                  //que fagi un beep() si NO és un digit o la tecla d'esborrar
                  if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                      getToolkit().beep();
                      e.consume();
                  }
              }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        c1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //que fagi un beep() si NO és un digit o la tecla d'esborrar
                if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        r1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //que fagi un beep() si NO és un digit o la tecla d'esborrar
                if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

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
        panel.add(forats,c);

        c.gridx = 1;
        c.gridy = 3;
        panel.add(f1,c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(colors,c);

        c.gridx = 1;
        c.gridy = 4;
        panel.add(c1,c);

        c.gridx = 2;
        c.gridy = 4;
        panel.add(c2,c);

        c.gridx = 0;
        c.gridy = 5;
        panel.add(rondes,c);

        c.gridx = 1;
        c.gridy = 5;
        panel.add(r1,c);

        c.gridx = 0;
        c.gridy = 6;
        panel.add(repetibles,c);

        c.gridx = 1;
        c.gridy = 6;
        panel.add(p1,c);

        c.gridx = 1;
        c.gridy = 20;
        panel.add(start,c);

        panelextern.add(home, BorderLayout.PAGE_END);

        super.setVisible(true);
    }

}