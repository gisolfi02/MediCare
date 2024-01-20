package test;

import LogicTier.MediCare.CercaOspedali.CercaOspedaliLogic;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class CercaOspedaliTest {
    CercaOspedaliLogic ospedaliLogic = new CercaOspedaliLogic();

    @Test
    public void testCampoRicercaVuoto(){
        String cerca = "";
        ArrayList<String> ospedali = ospedaliLogic.cercaOspedali(cerca);
        assertNull(ospedali);
    }

    @Test
    public void testCampoRicercaNonValido(){
        String cerca = "pippo";
        ArrayList<String> ospedali = ospedaliLogic.cercaOspedali(cerca);
        assertTrue(ospedali.isEmpty());
    }

    @Test
    public void testCampoRicercaValido(){
        String cerca = "Salerno";
        ArrayList<String> ospedali = ospedaliLogic.cercaOspedali(cerca);
        assertFalse(ospedali.isEmpty());
    }
}
