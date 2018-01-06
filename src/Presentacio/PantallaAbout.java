package Presentacio;

import javax.swing.*;
import java.awt.*;


public class PantallaAbout extends JPanel{
    private PantallaBase base;
    public PantallaAbout(PantallaBase base){
        this.base = base;
        super.setBackground(new Color(250, 50, 123));
        JLabel about = new JLabel ("<html>This game was created by Enric Sales, David Sánchez and Oscar Segarra for educational purposes. It belongs to a project from PROP in out undergraduate studies. As such, it is not allowed for it to be sold or copied.<br> Thank you for playing MasterMind.");
    }
}
