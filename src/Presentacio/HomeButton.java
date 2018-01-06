package Presentacio;

import javax.swing.*;
import java.awt.*;

public class HomeButton extends JButton {
    int tam;
    public HomeButton() {
        tam = 50;
        setIcon(new ImageIcon("src/Presentacio/home.png"));

        Dimension size = getPreferredSize();
        setBackground(Color.WHITE);
        size.width = size.height = tam;
        setPreferredSize(size);
    }
}

