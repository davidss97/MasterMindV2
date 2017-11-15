package Domini;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class FabricaTest {
    @Test
    public void setPecesCodi() throws Exception {

    }

    @Test
    public void setColors() {
        //Arrange = Inicialitzar
        Fabrica F = new Fabrica(4,6,10,true);
        //Act = Cridar funció mètode
        int actual = setColors();
        //Assert
        int expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    public void setRondes() throws Exception {

    }

    @Test
    public void setRepetirColors() throws Exception {

    }

    @Test
    public void mostrarCaracteristiquesPartida() throws Exception {
    }

}