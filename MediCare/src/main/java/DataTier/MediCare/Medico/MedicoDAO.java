package DataTier.MediCare.Medico;

import DataTier.MediCare.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDAO {
    public ArrayList<Medico> doRetriveByRepartoOspedale(String reparto, String codice){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT ID, nome, cognome, email, DDN, nomeReparto, idOspedale From Medico where nomeReparto=? and idOspedale=?");
            ps.setString(1, reparto);
            ps.setInt(2, Integer.parseInt(codice));
            ResultSet rs = ps.executeQuery();
            ArrayList<Medico> medici = new ArrayList<>();
            while (rs.next()){
                Medico medico = new Medico();
                medico.setId(rs.getInt(1));
                medico.setNome(rs.getString(2));
                medico.setCognome(rs.getString(3));
                medico.setEmail(rs.getString(4));
                medico.setDataDiNascita(rs.getDate(5).toLocalDate());
                medico.setNomeReparto(rs.getString(6));
                medico.setIdOspedale(rs.getInt(7));
                medici.add(medico);
            }
            return medici;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
