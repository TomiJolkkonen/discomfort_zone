package Taustaoperaatiot;

/**
 * Poikkeusluokka tietorakenteesta aiheutuville poikkeuksille
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.1, 23.04.2020
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