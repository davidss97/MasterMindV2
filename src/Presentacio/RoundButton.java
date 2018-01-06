package Presentacio;
import java.awt.*;
import java.awt.geom.*;
import java.awt.RenderingHints;
import javax.swing.*;

public class RoundButton extends JButton {
    int tam;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    public RoundButton(Boolean small, int c1, int c2, int c3) {
        super("");
        setBackground(new Color(c1,c2,c3));
        setFocusable(false);

        tam = ySize/64;
    /*
     These statements enlarge the button so that it
     becomes a circle rather than an oval.
    */
        Dimension size = getPreferredSize();
        size.width = size.height = tam;//Math.max(50,50);//size.width, size.height);
        setPreferredSize(size);

    /*
     This call causes the JButton not to paint the background.
     This allows us to paint a round background.
    */
        setContentAreaFilled(false);
    }


    public RoundButton(int c1, int c2, int c3) {
        super("");

        setBackground(new Color(c1,c2,c3));
        setFocusable(false);
        tam = ySize/18;
    /*
     These statements enlarge the button so that it
     becomes a circle rather than an oval.
    */
        Dimension size = getPreferredSize();
        size.width = size.height = tam;//Math.max(50,50);//size.width, size.height);
        setPreferredSize(size);

    /*
     This call causes the JButton not to paint the background.
     This allows us to paint a round background.
    */
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, tam,tam);//getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.darkGray);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawOval(0, 0, tam,tam);//getSize().width - 1, getSize().height - 1);
    }

    // Hit detection.
    Shape shape;

    public boolean contains(int x, int y) {
        // If the button has changed size,  make a new shape object.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, tam,tam);//getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

}
