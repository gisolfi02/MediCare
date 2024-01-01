package DataTier.MediCare.Utente;

import DataTier.MediCare.ConPool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtenteDAO {

    public void doSave(Utente u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO utente(email, password, nome, cognome, DDN, Numero) VALUES (?,?,?,?,?,?)");
            ps.setString(1,u.getEmail());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getNome());
            ps.setString(4, u.getCognome());
            ps.setDate(5, Date.valueOf(u.getDdn()));
            ps.setString(6,u.getNumero());
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
