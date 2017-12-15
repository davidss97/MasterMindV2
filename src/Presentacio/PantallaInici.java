package Presentacio;
import javax.swing.*;
import java.awt.*;

public class PantallaInici {
    PantallaInici(){
        JFrame frame = new JFrame("Panalla d'Inici Mastermind");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        frame.setVisible(true);
        frame.setSize(xSize/3*2, ySize/10*9);
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.setLayout(new GridLayout(1,3));

       // frame.setSize(500,800);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //si volem pantalla completa
    }
}
