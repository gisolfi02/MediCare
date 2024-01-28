package DataTier.MediCare;

import java.sql.*;

/**
 * La seguente classe si occupa di effettuare una connessione al database
 */
public class ConPool {
    /**
     * Metodo che si occuopa di istanziare una connesssione al datatbase, utilizzando i driver JDBC]]
     * @return connessione al database
     */
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/medicare","Inserire qui il nome utente di MySQL","Inserire qui la password di MySQL");
            //here sono is database name, root is username and password
            return con;
        }catch(Exception e){System.out.println(e);}
        return null;
    }
}
