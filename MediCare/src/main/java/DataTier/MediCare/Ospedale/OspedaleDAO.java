package DataTier.MediCare.Ospedale;

import DataTier.MediCare.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OspedaleDAO {
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
}
