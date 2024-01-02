package DataTier.MediCare.Utente;

import DataTier.MediCare.ConPool;

import java.sql.*;

public class UtenteDAO {

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
}
