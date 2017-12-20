package Presentacio;
import javax.swing.*;
import java.awt.*;

public class PantallaInici {
    PantallaInici(){
        JFrame frame = new JFrame("Pantalla d'Inici Mastermind");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        frame.setSize(xSize/3*2, ySize/10*9); //En una 1920:1080 --> 1280:972
        JPanel pleft = new JPanel();
        JPanel pcenter = new JPanel();
        JPanel pright = new JPanel();
        pleft.setBackground(Color.YELLOW);
        pcenter.setBackground(Color.BLUE);
        pright.setBackground(Color.RED);
        pleft.add(new RoundButton("Left"));
        pcenter.add(new RoundButton("Center"));
        pright.add(new RoundButton("Right"));
        pleft.setMinimumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        pcenter.setMinimumSize(new Dimension(xSize/3*2/2,ySize/10*9));
        pright.setMinimumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(pleft, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        frame.add(pcenter, c);
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 0;
        frame.add(pright, c);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(500,800);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //si volem pantalla completa
    }
}
