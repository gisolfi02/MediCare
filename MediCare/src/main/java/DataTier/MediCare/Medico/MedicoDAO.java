package DataTier.MediCare.Medico;

import DataTier.MediCare.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe che si occupa di accedere al database per ottenere informazioni relative ai medici
 */
public class MedicoDAO {
    /**
     * Metodo che si occupa di cercare i medici appartenemti ad un dato reparto di uno specifico ospedale
     * @param reparto nome del reparto
     * @param codice id dell'ospedale
     * @return lista di medici
     */
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

    /**
     * Metodo che si occupa di cercare un medico in base al suo id
     * @param id id del medico
     * @return medico
     */
    public Medico doRetriveById(int id){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT id,nome,cognome,email,DDN,nomeReparto,idOspedale from Medico WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Medico medico = new Medico();
                medico.setId(rs.getInt(1));
                medico.setNome(rs.getString(2));
                medico.setCognome(rs.getString(3));
                medico.setEmail(rs.getString(4));
                medico.setDataDiNascita(rs.getDate(5).toLocalDate());
                medico.setNomeReparto(rs.getString(6));
                medico.setIdOspedale(rs.getInt(7));
                return medico;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
