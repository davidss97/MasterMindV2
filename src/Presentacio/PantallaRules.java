package Presentacio;

import javax.swing.*;
import java.awt.*;

public class PantallaRules extends JPanel{
    private PantallaBase base;
    public PantallaRules(PantallaBase base){
        this.base = base;
        super.setBackground (new Color(40, 40, 40));
        JLabel rules = new JLabel("<html><ul color=white><li>The computer picks a sequence of colors.<br> The number of colors is the code length. The default code length is 4 but it can be changed when starting a new game." +
                "<li>The objective of the game is to guess the exact positions of the colors in the computer's sequence." +
                "<li>By default, a color can be used only once in a code sequence.<br> If you start a new game with the 'Allow duplicates' checked, then any color can be used any number of times in the code sequence." +
                "<li>After filling a line with your guesses and clicking on the 'Check' button, the computer responses with the result of your guess." +
                "<li>For each color in your guess that is in the correct color and correct position in the code sequence, the computer display a small red color on the right side of the current guess." +
                "<li>For each color in your guess that is in the correct color but is NOT in the correct position in the code sequence, the computer display a small white color on the right side of the current guess." +
                "<li>You win the game when you manage to guess all the colors in the code sequence and when they all in the right position." +
                "<li>You lose the game if you use all attempts without guessing the computer code sequence.<br> You lose the game if you use all attempts without guessing the computer code sequence.</ul>");
        super.add(rules);
        rules.setVerticalTextPosition(JLabel.CENTER);
        rules.setHorizontalTextPosition(JLabel.CENTER);
    }
}
