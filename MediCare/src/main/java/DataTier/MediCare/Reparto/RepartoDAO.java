package DataTier.MediCare.Reparto;

import DataTier.MediCare.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepartoDAO {

    public ArrayList<Reparto> doRetriveRepartiByCodice(String codice){
        try(Connection con  = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT nome,idOspedale,postiDisp,personale FROM Reparto WHERE idOspedale =?");
            ps.setInt(1, Integer.parseInt(codice));
            ResultSet rs = ps.executeQuery();
            ArrayList<Reparto> reparti = new ArrayList();
            while (rs.next()){
                Reparto reparto = new Reparto();
                reparto.setNome(rs.getString(1));
                reparto.setIdOspedale(rs.getInt(2));
                reparto.setPostiDisp(rs.getInt(3));
                reparto.setPersonale(rs.getInt(4));
                reparti.add(reparto);
            }
            return reparti;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
