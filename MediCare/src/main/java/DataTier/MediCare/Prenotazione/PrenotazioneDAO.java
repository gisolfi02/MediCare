package DataTier.MediCare.Prenotazione;

import DataTier.MediCare.ConPool;

import java.sql.*;

public class PrenotazioneDAO {

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
}
