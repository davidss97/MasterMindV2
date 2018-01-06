package Presentacio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInici extends JPanel{
    private PantallaBase base;
    public PantallaInici(PantallaBase base){
        this.base = base;
        super.setBackground(new Color(0, 255, 0));
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
        titol.setFont(new Font("Serif", Font.PLAIN, 70));
        super.add(titol, c);
        c.gridy = 5;
        c.weighty = 0.3;
        c.gridheight = 1;
        JButton play = new JButton("PLAY");
        play.setFont(new Font("Serif", Font.PLAIN, 30));
        play.setBackground(new Color(0, 225, 0));
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.changeCenter(new PantallaFabrica(base));
                PantallaInici.super.setVisible(false);
            }
        });
        super.add(play, c);
        JButton ranking = new JButton("Ranking");
        ranking.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridy = 6;
        ranking.setBackground(new Color(0, 195, 0));
        ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.changeCenter(new PantallaClassificacio(base));
                PantallaInici.super.setVisible(false);
            }
        });
        super.add(ranking, c);
        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridy = 7;
        rules.setBackground(new Color(0, 165, 0));
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.changeCenter(new PantallaRules(base));
                PantallaInici.super.setVisible(false);
            }
        });
        super.add(rules, c);
        JButton about = new JButton("About");
        about.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridy = 8;
        about.setBackground(new Color(0, 135, 0));
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.changeCenter(new PantallaAbout(base));
                PantallaInici.super.setVisible(false);
            }
        });
        super.add(about, c);
        JButton close = new JButton("Close");
        close.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridy = 9;
        close.setBackground(new Color(0, 105, 0));
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        super.add(close, c);
        /*JPanel buit = new JPanel();
        c.gridy = 10;
        buit.setBackground(new Color(0, 125, 0));
        super.add(buit, c);*/
        //frame.setSize(500,800);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //si volem pantalla completa
    }
}
