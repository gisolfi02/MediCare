package test;

import DataTier.MediCare.Prenotazione.Prenotazione;
import DataTier.MediCare.Prenotazione.PrenotazioneDAO;
import LogicTier.MediCare.Prenotazione.PrenotazioneLogic;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PrenotazioneTest {

    PrenotazioneLogic plogic = new PrenotazioneLogic();
    PrenotazioneDAO pd = new PrenotazioneDAO();
    @org.junit.Test
    public void testPrenotazioneNomeNonInserito() {
        Prenotazione p1 = new Prenotazione();
        p1.setNome("");
        p1.setCognome("Cognome");
        p1.setCf("NGRGNN02H08A399T");
        p1.setData(LocalDate.parse("2024-07-03"));
        p1.setEmailUtente("email1@cognome.it");
        p1.setOra("12-24");
        p1.setIdMedico(1);
        p1.setIdOspedale(170901);
        if(plogic.doPrenotazione(p1.getNome(), p1.getCognome(), p1.getCf(), p1.getData(), p1.getOra(), p1.getEmailUtente(),"Alberto Iudicelli-1" ,"AZIENDA OSPEDALIERA REGIONALE \"S. CARLO\"-170901")==0)
            plogic.salvaPrenotazione(p1);
        Prenotazione retpd = pd.doRetrieveByCode(p1.getCodice());
        assertNull(retpd);
    }

    @Test
    public void testPrenotazioneCognomeNonInserito() {
        Prenotazione p2 = new Prenotazione();
        p2.setNome("Nome");
        p2.setCognome("");
        p2.setCf("NGRGNN02H08A399T");
        p2.setData(LocalDate.parse("2024-07-03"));
        p2.setEmailUtente("email2@cognome.it");
        p2.setOra("12-24");
        p2.setIdMedico(1);
        p2.setIdOspedale(170901);
        if(plogic.doPrenotazione(p2.getNome(), p2.getCognome(), p2.getCf(), p2.getData(), p2.getOra(), p2.getEmailUtente(),"Alberto Iudicelli-1" ,"AZIENDA OSPEDALIERA REGIONALE \"S. CARLO\"-170901")==0)
            plogic.salvaPrenotazione(p2);
        Prenotazione retpd = pd.doRetrieveByCode(p2.getCodice());
        assertNull(retpd);
    }

    @Test
    public void testPrenotazioneCFErrato() {
        Prenotazione p3 = new Prenotazione();
        p3.setNome("Nome");
        p3.setCognome("Cognome");
        p3.setCf("ABFHSGRDSHGEH");
        p3.setData(LocalDate.parse("2024-07-03"));
        p3.setEmailUtente("email3@cognome.it");
        p3.setOra("12-24");
        p3.setIdMedico(1);
        p3.setIdOspedale(170901);
        if(plogic.doPrenotazione(p3.getNome(), p3.getCognome(), p3.getCf(), p3.getData(), p3.getOra(), p3.getEmailUtente(),"Alberto Iudicelli-1" ,"AZIENDA OSPEDALIERA REGIONALE \"S. CARLO\"-170901")==0)
            plogic.salvaPrenotazione(p3);
        Prenotazione retpd = pd.doRetrieveByCode(p3.getCodice());
        assertNull(retpd);
    }

    @Test
    public void testPrenotazioneDataNonInserita() {
        Prenotazione p4 = new Prenotazione();
        p4.setNome("Nome");
        p4.setCognome("Cognome");
        p4.setCf("NGRGNN02H08A399T");
        p4.setData(null);
        p4.setEmailUtente("email4@cognome.it");
        p4.setOra("12-24");
        p4.setIdMedico(1);
        p4.setIdOspedale(170901);
        if(plogic.doPrenotazione(p4.getNome(), p4.getCognome(), p4.getCf(), p4.getData(), p4.getOra(), p4.getEmailUtente(),"Alberto Iudicelli-1" ,"AZIENDA OSPEDALIERA REGIONALE \"S. CARLO\"-170901")==0)
            plogic.salvaPrenotazione(p4);
        Prenotazione retpd = pd.doRetrieveByCode(p4.getCodice());
        assertNull(retpd);
    }


    @Test
    public void testPrenotazioneOraNonInserita() {
        Prenotazione p5 = new Prenotazione();
        p5.setNome("Nome");
        p5.setCognome("Cognome");
        p5.setCf("NGRGNN02H08A399T");
        p5.setData(LocalDate.parse("2024-07-03"));
        p5.setEmailUtente("email5@cognome.it");
        p5.setOra(null);
        p5.setIdMedico(1);
        p5.setIdOspedale(170901);
        if(plogic.doPrenotazione(p5.getNome(), p5.getCognome(), p5.getCf(), p5.getData(), p5.getOra(), p5.getEmailUtente(),"Alberto Iudicelli-1" ,"AZIENDA OSPEDALIERA REGIONALE \"S. CARLO\"-170901")==0)
            plogic.salvaPrenotazione(p5);
        Prenotazione retpd = pd.doRetrieveByCode(p5.getCodice());
        assertNull(retpd);
    }

    @Test
    public void testPrenmotazioneEffettuata() {
        Prenotazione p6 = new Prenotazione();
        p6.setNome("Nome");
        p6.setCognome("Cognome");
        p6.setCf("NGRGNN02H08A399T");
        p6.setData(LocalDate.parse("2024-07-03"));
        p6.setEmailUtente("nome9@cognome.it");
        p6.setOra("12-24");
        p6.setIdMedico(1);
        p6.setIdOspedale(170901);
        if(plogic.doPrenotazione(p6.getNome(), p6.getCognome(), p6.getCf(), p6.getData(), p6.getOra(), p6.getEmailUtente(),"Alberto Iudicelli-1" ,"AZIENDA OSPEDALIERA REGIONALE \"S. CARLO\"-170901")==0)
            plogic.salvaPrenotazione(p6);
        Prenotazione retpd = pd.doRetrieveByCode(p6.getCodice());
        assertNotNull(retpd);
    }


}

