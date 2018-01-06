package Presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaAbout extends JPanel{
    private PantallaBase base;
    public PantallaAbout(PantallaBase base){
        this.base = base;
        super.setLayout(new BorderLayout());
        super.setBackground(new Color(250, 50, 123));
        JLabel about = new JLabel ("<html><center>This game was created by Enric Sales, David Sánchez and Oscar Segarra for educational purposes.<br><br> MasterMind belongs to a project from PROP in our undergraduate studies at FIB from UPC.<br> As such, it is not allowed for it to be sold or copied.<br><br>  Thank you for playing MasterMind.</center>", SwingConstants.CENTER);
        //about.setFont(new Font("Serif", Font.PLAIN, 18));
        super.add(about, BorderLayout.CENTER);
        HomeButton home = new HomeButton();
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.changeCenter(new PantallaInici(base));
                PantallaAbout.super.setVisible(false);
            }
        });
        super.add(home, BorderLayout.PAGE_END);
    }
}
