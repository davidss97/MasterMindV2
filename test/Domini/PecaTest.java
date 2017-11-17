package Domini;

import org.junit.Test;

import static org.junit.Assert.*;

public class PecaTest {
    @Test
    public void setColor() {
        //Arrange
        Peca k = new Peca (0);
        //Act
        k.setColor(1);
        //Assert
        assertEquals(1, k.getColor());
    }

    @Test
    public void getColor() {
        //Arrange
        Peca k = new Peca (0);
        //Act

        //Assert
        assertEquals(0, k.getColor());
    }

}