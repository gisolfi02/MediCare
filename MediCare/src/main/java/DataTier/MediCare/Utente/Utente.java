package DataTier.MediCare.Utente;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Classe che rappresenta un utente registarto all'applicazione
 */
public class Utente {
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private LocalDate ddn; //usato localdate perché è il valore che viene da javafx + per portarlo a sql.Date basta fare valueof (vedi in utenteDAO)
    private String numero;

    /**
     * ritorna l'email dell'utente
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * setta l'email dell'utente
     * @param email
     */
    public void setEmail(String email) {
            this.email = email;
    }

    /**
     * ritorna la password dell'utente
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * setta l'password dell'utente criptandola utilizzando SHA-1
     * @param password
     */
    public void setPassword(String password) {
        try {
            MessageDigest digest =
                    MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x", new
                    BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ritorna il nome dell'utente
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * setta il nome dell'utente
     * @param nome
     */
    // i valori void stanno per: true: regex rispettata, valore accettato - false: regex non rispettata, valore non accettato
    public void setNome(String nome) {
            this.nome = nome;
    }

    /**
     * ritorna il cognome dell'utente
     * @return
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * setta il cognome dell'utente
     * @param cognome
     */
    public void setCognome(String cognome) {
            this.cognome = cognome;
    }

    /**
     * ritorna la data di nascita dell'utente
     * @return
     */
    public LocalDate getDdn() {
        return ddn;
    }

    /**
     * setta la data di nascita dell'utente
     * @param ddn
     */
    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }

    /**
     * ritorna il numero di telefono dell'utente
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     * setta il numero di telefono dell'utente
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
