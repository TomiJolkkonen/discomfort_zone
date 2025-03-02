package NHLtietokanta;

/**
 * Poikkeusluokka tietorakenteesta aiheutuville poikkeuksille.
 * @author Tomi Jolkkonen
 * @version 1.0, 23.04.2020
 */
public class SailoException extends Exception {
    private static final long serialVersionUID = 1L;


    /**
     * Poikkeuksen muodostaja jolle tuodaan poikkeuksessa
     * käytettävä viesti
     * @param viesti Poikkeuksen viesti
     */
    public SailoException(String viesti) {
        super(viesti);
    }
}