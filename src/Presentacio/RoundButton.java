package Presentacio;
import java.awt.*;
import java.awt.geom.*;
import java.awt.RenderingHints;
import javax.swing.*;

public class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);

        setBackground(new Color(0,255,0));
        setFocusable(false);

    /*
     These statements enlarge the button so that it
     becomes a circle rather than an oval.
    */
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
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
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.darkGray);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    // Hit detection.
    Shape shape;

    public boolean contains(int x, int y) {
        // If the button has changed size,  make a new shape object.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Rounded Button Example");
        frame.setLayout(new FlowLayout());

        JButton b1 = new RoundButton("B1");
        JButton b2 = new RoundButton("B2");
        b1.setBackground(new Color(255,0,0));

        frame.add(b1);
        frame.add(b2);

        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
