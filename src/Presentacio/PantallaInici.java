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
        pleft.setBackground(Color.BLUE);
        pcenter.setBackground(Color.YELLOW);
        pright.setBackground(Color.RED);
        pleft.add(new RoundButton("Left"));
        //pright.add(new RoundButton("Right"));
        pleft.setMinimumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        pcenter.setMinimumSize(new Dimension(xSize/3*2/2,ySize/10*9));
        pright.setMinimumSize(new Dimension(xSize/3*2/4,ySize/10*9));
        frame.setLayout(new GridBagLayout());
        pcenter.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 5;
        JLabel titol = new JLabel("MasterMind");
        titol.setHorizontalAlignment(SwingConstants.CENTER);
        titol.setFont(new Font ("Serif", Font.PLAIN, 40));
        pcenter.add(titol, c);
        c.gridy = 5;
        c.weighty = 0.3;
        c.gridheight = 1;
        JButton play = new JButton("PLAY");
        play.setBackground(new Color(0, 255, 0));
        pcenter.add(play, c);
        JButton ranking = new JButton("Ranking");
        c.gridy = 6;
        ranking.setBackground(new Color(0, 225, 0));
        pcenter.add(ranking, c);
        JButton rules = new JButton("Rules");
        c.gridy = 7;
        rules.setBackground(new Color(0, 200, 0));
        pcenter.add(rules, c);
        JButton about = new JButton("About");
        c.gridy = 8;
        about.setBackground(new Color(0, 175, 0));
        pcenter.add(about, c);
        JButton close = new JButton("Close");
        c.gridy = 9;
        close.setBackground(new Color(0, 150, 0));
        pcenter.add(close, c);
        JPanel buit = new JPanel();
        c.gridy = 10;
        buit.setBackground(new Color(0, 125, 0));
        pcenter.add(buit, c);
        c.gridwidth = 1;
        c.weightx = 0.3;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(pleft, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        frame.add(pcenter, c);
        c.weightx = 0.4;
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
