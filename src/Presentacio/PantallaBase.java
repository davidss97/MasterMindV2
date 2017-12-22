package Presentacio;

import javax.swing.*;
import java.awt.*;

public class PantallaBase {
    PantallaBase(){
        JFrame frame = new JFrame("Mastermind");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        frame.setSize(xSize/3*2, ySize/10*9); //En una 1920:1080 --> 1280:972
        JPanel pleft = new JPanel();
        JPanel pright = new JPanel();
        pleft.setBackground(Color.BLUE);
        pright.setBackground(Color.RED);
        pleft.setMinimumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        PantallaInici center = new PantallaInici();
        pright.setMinimumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.weightx = 0.4;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(pleft, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        frame.add(center, c);
        c.weightx = 0.4;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 0;
        frame.add(pright, c);

        frame.setVisible(true);
        center.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
