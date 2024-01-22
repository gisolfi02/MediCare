package DataTier.MediCare.Prenotazione;

import DataTier.MediCare.ConPool;
import DataTier.MediCare.Utente.Utente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe che si occupda di accedere al database per ottenere o memorizzare le informazioni relative alle prenotazioni
 */
public class PrenotazioneDAO {

    /**
     * Metodo che si occupa di memorizzare la prenotazione effettuata
     * @param prenotazione
     * @return valore booleano che indica se il salvataggio è andato a buon fine o meno
     */
    public boolean doSave(Prenotazione prenotazione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO Prenotazione(data,ora,nomePaziente,cognomePaziente,codiceFiscalePaziente,emailUtente,idMedico,idOspedale) values (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,Date.valueOf(prenotazione.getData()));
            ps.setString(2,prenotazione.getOra());
            ps.setString(3,prenotazione.getNome());
            ps.setString(4,prenotazione.getCognome());
            ps.setString(5,prenotazione.getCf());
            ps.setString(6,prenotazione.getEmailUtente());
            ps.setInt(7,prenotazione.getIdMedico());
            ps.setInt(8,prenotazione.getIdOspedale());
            if (ps.executeUpdate() != 1) {
                return false;
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            prenotazione.setCodice(id);
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di ottenere le ore non disponibili per la prenotazione presso un medico in un determinato giorno
     * @param data data della prenotazione
     * @param idMedico id del medico
     * @return lista di ore non disponibili per la prenotazione
     */
    public ArrayList<String> doRetriveOreDisp(LocalDate data, int idMedico){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT ora FROM Prenotazione where data=? and idMedico=?");
            ps.setDate(1,Date.valueOf(data));
            ps.setInt(2,idMedico);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> ore = new ArrayList<>();
            while (rs.next()){
                ore.add(rs.getString(1));
            }
            return ore;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di ottenere tutte le prenotazioni effettuate da un utente
     * @param u utente
     * @return lista di prenotazioni effettuate
     */
    public ArrayList<Prenotazione> doRetrivePrenotazioniByUtente(Utente u){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT codice,data,ora,nomePaziente,cognomePaziente,codiceFiscalePaziente,emailUtente,idMedico,idOspedale FROM Prenotazione where emailUtente=?");
            ps.setString(1,u.getEmail());
            ResultSet rs = ps.executeQuery();
            ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
            while (rs.next()){
                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setCodice(rs.getInt(1));
                prenotazione.setData(rs.getDate(2).toLocalDate());
                prenotazione.setOra(rs.getString(3));
                prenotazione.setNome(rs.getString(4));
                prenotazione.setCognome(rs.getString(5));
                prenotazione.setCf(rs.getString(6));
                prenotazione.setEmailUtente(rs.getString(7));
                prenotazione.setIdMedico(rs.getInt(8));
                prenotazione.setIdOspedale(rs.getInt(9));
                prenotazioni.add(prenotazione);
            }
            return prenotazioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di cercare una prenotazione tramite il codice
     * @param code codice della prenotazione
     * @return una prenotazione
     */
    public Prenotazione doRetrieveByCode(int code){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT codice,data,ora,nomePaziente,cognomePaziente,codiceFiscalePaziente,emailUtente,idMedico,idOspedale FROM Prenotazione where codice=?");
            ps.setInt(1,code);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setCodice(rs.getInt(1));
                prenotazione.setData(rs.getDate(2).toLocalDate());
                prenotazione.setOra(rs.getString(3));
                prenotazione.setNome(rs.getString(4));
                prenotazione.setCognome(rs.getString(5));
                prenotazione.setCf(rs.getString(6));
                prenotazione.setEmailUtente(rs.getString(7));
                prenotazione.setIdMedico(rs.getInt(8));
                prenotazione.setIdOspedale(rs.getInt(9));
                return prenotazione;
            }else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di eliminare una prenotazione
     * @param codice codice della prenotazione
     */
    public void deleteById(int codice){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prenotazione WHERE codice=?");
            ps.setInt(1, codice);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che aggiorna la prenotazione nel database con la nuova data e la nuova ora
     * @param codice codice della prenotazione
     * @param data nuova data
     * @param ora nuova ora
     */
    public void doUpdate(int codice,LocalDate data, String ora){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Prenotazione SET data=?,ora=? WHERE codice=?");
            ps.setDate(1,Date.valueOf(data));
            ps.setString(2,ora);
            ps.setInt(3,codice);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
