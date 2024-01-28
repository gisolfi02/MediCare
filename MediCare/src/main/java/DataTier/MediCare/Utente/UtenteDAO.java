package DataTier.MediCare.Utente;

import DataTier.MediCare.ConPool;

import java.sql.*;
import java.time.LocalDate;

/**
 * La classe UtenteDAO è la classe che si occupa di accedere al database e estrarre o salvare le informazioni relative ad un utente.
 */
public class UtenteDAO {

    /**
     * Metodo che si occupa di accedere al database e memorizzare le informazioni relative all'utente.
     *
     * @param u  Utente che deve essere memorizzato
     * @return valore che indica se il salvataggio è avvenuto con successo o meno.
     */
    public boolean doSave(Utente u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement PS = con.prepareStatement("SELECT email FROM utente WHERE email = ?");
            PS.setString(1, u.getEmail());
            ResultSet rs = PS.executeQuery();
            if(!rs.next()) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO utente(email, password, nome, cognome, DDN, Numero) VALUES (?,?,?,?,?,?)");
                ps.setString(1, u.getEmail());
                ps.setString(2, u.getPassword());
                ps.setString(3, u.getNome());
                ps.setString(4, u.getCognome());
                ps.setDate(5, Date.valueOf(u.getDdn()));
                ps.setString(6, u.getNumero());
                if (ps.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error");
                }
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di accedere al database per ottenere le informazioni relative all'utente sulla base della sua email e password
     *
     * @param email - email dell'utente
     * @param password - password dell'utente
     * @return Utente - utente a  cui si rifersicono email e password
     */
    public Utente doRetrieveByEmailPassword(String email, String password){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT email, password, nome, cognome, Numero, DDN FROM utente WHERE email = ? AND password =SHA1(?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
               Utente u = new Utente();
               u.setEmail(rs.getString(1));
               u.setPassword(rs.getString(2));
               u.setNome(rs.getString(3));
               u.setCognome(rs.getString(4));
               u.setNumero(rs.getString(5));
               u.setDdn(rs.getDate(6).toLocalDate());
               return u;
            }else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di accedere al database e rimuovere le informazioni relative all'utente
     * @param utente
     */
    public void removeUtente(Utente utente){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Utente WHERE email=?");
            ps.setString(1, utente.getEmail());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
