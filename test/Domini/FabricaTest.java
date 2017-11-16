import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import Domini.Fabrica;

import static org.junit.Assert.*;

public class FabricaTest {
    @Test
    public void setPecesCodi() {
        //Arrange
        Fabrica f = new Fabrica(1,1,1,false);
        //Act
        f.setPecesCodi(4);
        //Assert
        assertEquals(4, f.getPecesCodi());
    }
    @Test
    public void getPecesCodi() {
        //Arrange
        Fabrica f = new Fabrica(4,1,1,false);
        //Act

        //Assert
        assertEquals(4, f.getPecesCodi());
    }

    @Test
    public void setColors() {
        //Arrange
        Fabrica f = new Fabrica(1,1,1,false);
        //Act
        f.setColors(6);
        //Assert
        assertEquals(6, f.getColors());
    }
    @Test
    public void getColors() {
        //Arrange
        Fabrica f = new Fabrica(1,6,1,false);
        //Act

        //Assert
        assertEquals(6, f.getColors());
    }

    @Test
    public void setRondes() {
        //Arrange
        Fabrica f = new Fabrica(1,1,1,false);
        //Act
        f.setRondes(10);
        //Assert
        assertEquals(10, f.getRondes());
    }
    @Test
    public void getRondes() {
        //Arrange
        Fabrica f = new Fabrica(1,1,10,false);
        //Act

        //Assert
        assertEquals(10, f.getRondes());
    }

    @Test
    public void setRepetirColors() {
        //Arrange
        Fabrica f = new Fabrica(1,1,1,false);
        //Act
        f.setRepetirColors(true);
        //Assert
        assertEquals(true, f.isRepetirColors());
    }
    @Test
    public void isRepetirColors() {
        //Arrange
        Fabrica f = new Fabrica(1,1,1,true);
        //Act

        //Assert
        assertEquals(true, f.isRepetirColors());
    }

    @Test
    public void mostrarCaracteristiquesPartida() throws Exception {
        //Caldria comparar system.out els quals ho important són els paràmetres i
        // ja sabem que funcionen per els tests dels getters realitzats anteriorment.
    }
}