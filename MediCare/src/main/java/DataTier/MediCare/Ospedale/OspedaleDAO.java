package DataTier.MediCare.Ospedale;

import DataTier.MediCare.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe che si occupa di accedere al database per ottenere le informazioni relative agli ospedali
 */
public class OspedaleDAO {
    /**
     * Metodo che si occuppa di ottenere i comuni presso cui sono presenti gli ospedali
     * @return lista dei comuni
     */
    public ArrayList<String> doRetriveComuni(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT paese FROM ospedale ORDER BY paese ");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> comuni = new ArrayList();
            while (rs.next()){
                comuni.add(rs.getString(1));
            }
            return comuni;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di ottenere gli ospedali presenti in un determinato comune
     * @param comune nome del comune
     * @return lista di ospedali
     */
    public ArrayList<Ospedale> doRetriveOspedaleByComune(String comune){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT codiceStruttura, nome, indirizzo, paese FROM Ospedale WHERE paese=?");
            ps.setString(1, comune);
            ResultSet rs = ps.executeQuery();
            ArrayList<Ospedale> ospedali = new ArrayList();
            while (rs.next()) {
                Ospedale ospedale = new Ospedale();
                ospedale.setCodice(rs.getInt(1));
                ospedale.setNome(rs.getString(2));
                ospedale.setIndirizzo(rs.getString(3));
                ospedale.setPaese(rs.getString(4));
                ospedali.add(ospedale);
            }
            return ospedali;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di cercare un ospedale in base al suo id
     * @param id id dell'ospedale
     * @return ospedale
     */
    public Ospedale doRetrieveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT codiceStruttura,nome,indirizzo,paese FROM Ospedale WHERE codiceStruttura=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Ospedale ospedale = new Ospedale();
                ospedale.setCodice(rs.getInt(1));
                ospedale.setNome(rs.getString(2));
                ospedale.setIndirizzo(rs.getString(3));
                ospedale.setPaese(rs.getString(4));
                return ospedale;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che si occupa di cercare gli ospedali sulla della località inserità dall'utente
     * @param ricerca località inserità dall'utente
     * @return lista di ospedali in quella località
     */
    public ArrayList<Ospedale> doRetriveByRicerca(String ricerca) {
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT codiceStruttura, nome, indirizzo,paese FROM Ospedale WHERE paese LIKE ?");
            ps.setString(1,ricerca);
            ResultSet rs = ps.executeQuery();
            ArrayList<Ospedale> ospedali = new ArrayList<>();
            while (rs.next()){
                Ospedale ospedale = new Ospedale();
                ospedale.setCodice(rs.getInt(1));
                ospedale.setNome(rs.getString(2));
                ospedale.setIndirizzo(rs.getString(3));
                ospedale.setPaese(rs.getString(4));
                ospedali.add(ospedale);
            }
            return ospedali;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
