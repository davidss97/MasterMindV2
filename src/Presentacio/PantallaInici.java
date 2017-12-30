package Presentacio;
import javax.swing.*;
import java.awt.*;

public class PantallaInici extends JPanel{
    PantallaInici(){
        super.setBackground(Color.YELLOW);
        super.setLayout(new GridBagLayout());
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
        super.add(titol, c);
        c.gridy = 5;
        c.weighty = 0.3;
        c.gridheight = 1;
        JButton play = new JButton("PLAY");
        play.setBackground(new Color(0, 255, 0));
        super.add(play, c);
        JButton ranking = new JButton("Ranking");
        c.gridy = 6;
        ranking.setBackground(new Color(0, 225, 0));
        super.add(ranking, c);
        JButton rules = new JButton("Rules");
        c.gridy = 7;
        rules.setBackground(new Color(0, 200, 0));
        super.add(rules, c);
        JButton about = new JButton("About");
        c.gridy = 8;
        about.setBackground(new Color(0, 175, 0));
        super.add(about, c);
        JButton close = new JButton("Close");
        c.gridy = 9;
        close.setBackground(new Color(0, 150, 0));
        super.add(close, c);
        JPanel buit = new JPanel();
        c.gridy = 10;
        buit.setBackground(new Color(0, 125, 0));
        super.add(buit, c);
        //frame.setSize(500,800);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //si volem pantalla completa
    }
}
