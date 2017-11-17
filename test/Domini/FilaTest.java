package Domini;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class FilaTest {
    @Test
    public void getContingutFila() {
        //Arrange
        Vector<Peca> vP = new Vector<Peca>();
        vP.add(new Peca(0));
        vP.add(new Peca(0));
        vP.add(new Peca(1));
        vP.add(new Peca(1));
        Fila f = new Fila(vP ,null);
        //Act
        //Assert
        assertEquals(vP, f.getContingutFila());
    }

    @Test
    public void getPecaAPosicio() {
        //Arrange
        Vector<Peca> vP = new Vector<Peca>();
        vP.add(new Peca(0));
        vP.add(new Peca(0));
        vP.add(new Peca(1));
        vP.add(new Peca(1));
        Fila f = new Fila(vP ,null);
        //Act
        //Assert
        assertEquals(vP.get(0), f.getPecaAPosicio(0));
    }

    @Test
    public void setSolucio() {
        //Arrange
        Vector<Peca> comb = new Vector<Peca>();
        comb.add(new Peca(2));
        comb.add(new Peca(2));
        comb.add(new Peca(2));
        comb.add(new Peca(2));
        Fila f = new Fila(comb ,null);
        //Act
        f.setSolucio(comb);
        //Assert
        assertEquals(comb, f.getSolucioFila());
    }

    @Test
    public void getSolucioFila() {
        //Arrange
        Vector<Peca> comb = new Vector<Peca>();
        comb.add(new Peca(2));
        comb.add(new Peca(2));
        comb.add(new Peca(2));
        comb.add(new Peca(2));
        Fila f = new Fila(comb ,null);
        //Act
        f.setSolucio(comb);
        //Assert
        assertEquals(comb, f.getSolucioFila());
    }

}