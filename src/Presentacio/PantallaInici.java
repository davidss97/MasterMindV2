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
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setBackground(Color.YELLOW);
        p2.setBackground(Color.BLUE);
        p3.setBackground(Color.RED);
        p2.setSize(640,ySize/10*9);
        frame.setLayout(new BorderLayout());
        frame.add(p1,BorderLayout.WEST);
        frame.add(p2,BorderLayout.CENTER);
        frame.add(p3,BorderLayout.EAST);
        frame.setVisible(true);

        //frame.setSize(500,800);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //si volem pantalla completa
    }
}
