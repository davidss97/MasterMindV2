package Presentacio;

import javax.swing.*;
import java.awt.*;

public class PantallaBase {
    private JFrame frame = new JFrame("Mastermind");
    private GridBagConstraints c = new GridBagConstraints();
    public PantallaBase(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        frame.setBackground(new Color (130, 158, 199));
        frame.setSize(xSize/3*2, ySize/10*9); //En una 1920:1080 --> 1280:972
        JPanel pleft = new JPanel();
        JPanel pright = new JPanel();
        pleft.setBackground(Color.BLUE);
        pright.setBackground(Color.BLUE);
        //pleft.setMaximumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        //pright.setMaximumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        frame.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.weightx = 0.4;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(pleft, c);
        changeCenter(new PantallaInici(this));
        c.weightx = 0.4;
        c.gridx = 3;
        c.gridy = 0;
        frame.add(pright, c);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void changeCenter(JPanel center){
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        frame.add(center, c);
    }
}
