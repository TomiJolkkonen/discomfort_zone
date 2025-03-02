package Taustaoperaatiot;
  
import fi.jyu.mit.ohj2.Mjonot;
import java.io.*;
  
/**
 * Joukkue-yksikköluokka, huolehtii yksittäisen joukkueen tiedoista, mm antaa JoukkueID:n
 * Sisältää COM-testejä
 *
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.8, 23.04.2020
 */
public class Joukkue implements Comparable<Joukkue> {
    
    private int joukkueID = 0;
    private String nimi = "";
    private String konferenssi = "";
    private String divisioona = "";
    private int ottelut = 0;
    private int pisteet = 0;
    private String maalivahdit = "";
    private String puolustajat = "";
    private String hyokkaajat = "";
    private String valmentaja = "";
    private String loukkaantuneet = "";
    
    private static int seuraavaNro = 1;
  
    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot joukkueelle.
     */
    public void dummyJoukkue() {
        joukkueID = 1000;
        nimi = "Teuvon Tesmaajat";
        konferenssi = "itäinen";
        divisioona = "metropolitan";
        ottelut = 70;
        pisteet = 67;
        maalivahdit = "Juha Mieto, Teppo Hieta";
        puolustajat = "Kalle Lalle, Haussa Huissa, Pele Pede";
        hyokkaajat = "Toi Noin, Juupa Eipo, Nii Qu, Jassåå";
        valmentaja = "Turo Hieho";
        loukkaantuneet = "Valmentaja Turo Hieho loukkaantunut pelaajilleen henkisesti";
    }
     
    
    /** 
     * Antaa k:n kentän sisällön merkkijonona 
     * @param k monenenko kentän sisältö palautetaan 
     * @return kentän sisältö merkkijonona 
     */ 
    public String getAvain(int k) { 
        switch ( k ) { 
        case 0: return "" + joukkueID; 
        case 1: return "" + nimi;
        case 2: return "" + konferenssi; 
        case 3: return "" + divisioona; 
        case 4: return "" + ottelut;  
        case 5: return "" + pisteet; 
        case 6: return "" + maalivahdit; 
        case 7: return "" + puolustajat; 
        case 8: return "" + hyokkaajat;
        case 9: return "" + valmentaja;
        case 10: return "" + loukkaantuneet;
        default: return "Virhe"; 
        } 
    } 
     
  
    /**
     * Alustetaan joukkue
     */
    public Joukkue() {
        // 
    }
    
    
    // GETTEREITÄ JA SETTEREITÄ
  
  
    /**
     * Palautetaan joukkueen oma ID-numero
     * @return joukkueen ID
     */
    public int getJoukkueID() {
        return joukkueID;
    }
    
    
    /**
     * Asettaa ID-numeron ja samalla varmistaa etta
     * seuraava numero on aina suurempi kuin tahan mennessä suurin
     * @param nr asetettava ID-numero
     */
    private void setJoukkueID(int nr) {
        joukkueID = nr;
        if ( joukkueID >= seuraavaNro ) seuraavaNro = joukkueID + 1;
    }
    
    
    /**
     * @return nimi
     */
    public String getNimi() {
        return nimi;
    }
    
    
    /**
     * @param s joukkueelle laitettava nimi
     * @return virheilmoitus, null jos ok
     */
    public String setNimi(String s) {
        nimi = s;
        return null;
    }
    
    
    /**
     * @return konferenssi
     */
    public String getKonferenssi() {
        return konferenssi;
    }
    
    
    /**
     * @param s joukkueelle laitettava konferenssi
     * @return virheilmoitus, null jos ok
     */
    public String setKonferenssi(String s) {
        konferenssi = s;
        return null;
    }
    
    
    /**
     * @return divisioona
     */
    public String getDivisioona() {
        return divisioona;
    }
    
    
    /**
     * @param s joukkueen divisioona
     * @return virheilmoitus, null jos ok
     */
    public String setDivisioona(String s) {
        divisioona = s;
        return null;
    }
    
    
    /**
     * @return ottelut
     */
    public int getOttelut() {
        return ottelut;
    }
    
    
    /**
     * @param s joukkueen ottelumaara
     * @return virheilmoitus, null jos ok
     */
    public String setOttelut(String s) {
        ottelut = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return pisteet
     */
    public int getPisteet() {
        return pisteet;
    }
    
    
    /**
     * @param s joukkueen pisteet
     * @return virheilmoitus, null jos ok
     */
    public String setPisteet(String s) {
        pisteet = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return maalivahdit
     */
    public String getMaalivahdit() {
        return maalivahdit;
    }
    
    
    /**
     * @param s joukkueen maalivahdit
     * @return virheilmoitus, null jos ok
     */
    public String setMaalivahdit(String s) {
        maalivahdit = s;
        return null;
    }
    
    
    /**
     * @return puolustajat
     */
    public String getPuolustajat() {
        return puolustajat;
    }
    
    
    /**
     * @param s joukkueen puolustajat
     * @return virheilmoitus, null jos ok
     */
    public String setPuolustajat(String s) {
        puolustajat = s;
        return null;
    }
    
    
    /**
     * @return hyökkääjät
     */
    public String getHyokkaajat() {
        return hyokkaajat;
    }
    
    
    /**
     * @param s joukkueen hyokkaajat
     * @return virheilmoitus, null jos ok
     */
    public String setHyokkaajat(String s) {
        hyokkaajat = s;
        return null;
    }
    
    
    /**
     * @return valmentaja
     */
    public String getValmentaja() {
        return valmentaja;
    }
    
    
    /**
     * @param s joukkueen valmentaja
     * @return virheilmoitus, null jos ok
     */
    public String setValmentaja(String s) {
        valmentaja = s;
        return null;
    }
    
    
    /**
     * @return loukkaantuneet
     */
    public String getLoukkaantuneet() {
        return loukkaantuneet;
    }
    
    
    /**
     * @param s joukkueen loukkaantumistilanne
     * @return virheilmoitus, null jos ok
     */
    public String setLoukkaantuneet(String s) {
        loukkaantuneet = s;
        return null;
    }
    // GETTERIT JA SETTERIT LOPPU

  
    /**
     * Alustetaan pelaajan joukkue  
     * @param joukkueID joukkueen ID-numero 
     */
    public Joukkue(int joukkueID) {
        this.joukkueID = joukkueID;
    }
    
    
    /**
     * @return joukkueen kenttien lukumäärä
     */
    public int getKenttia() {
        return 11;
    }


    /**
     * @return ensimmäinen käyttäjän syötettävän kentän indeksi
     */
    public int ekaKentta() {
        return 1;
    }
    

    /**
     * @param k minkä kentän kysymys halutaan
     * @return valitun kentän kysymysteksti
     */
    public String getKysymys(int k) {
        switch (k) {
            case 0: return "" + joukkueID; 
            case 1: return "" + nimi;
            case 2: return "" + konferenssi; 
            case 3: return "" + divisioona; 
            case 4: return "" + ottelut;  
            case 5: return "" + pisteet; 
            case 6: return "" + maalivahdit; 
            case 7: return "" + puolustajat; 
            case 8: return "" + hyokkaajat;
            case 9: return "" + valmentaja;
            case 10: return "" + loukkaantuneet;
            default:
            return "Virhe";
        }
    }


    /**
     * @param k Minkä kentän sisältö halutaan
     * @return valitun kentän sisältö
     * @example
     * <pre name="test">
     *   Joukkue jouk = new Joukkue();
     *   jouk.parse("1|PittsburghPenguins|Itäinen|Metropolitan|70");
     *   jouk.anna(0) === "1";   
     *   jouk.anna(1) === "PittsburghPenguins";   
     *   jouk.anna(2) === "Itäinen";   
     *   jouk.anna(3) === "Metropolitan";   
     *   jouk.anna(4) === "70";   
     *   
     * </pre>
     */
    public String anna(int k) {
        switch (k) {
            case 0: return "" + joukkueID; 
            case 1: return "" + nimi;
            case 2: return "" + konferenssi; 
            case 3: return "" + divisioona; 
            case 4: return "" + ottelut;  
            case 5: return "" + pisteet; 
            case 6: return "" + maalivahdit; 
            case 7: return "" + puolustajat; 
            case 8: return "" + hyokkaajat;
            case 9: return "" + valmentaja;
            case 10: return "" + loukkaantuneet;
        default:
            return "Virhe";
        }
    }


    /**
     * Asetetaan valitun kentän sisältö.  Mikäli asettaminen onnistuu,
     * palautetaan null, muutoin virheteksti.
     * @param k minkä kentän sisältö asetetaan
     * @param s asetettava sisältö merkkijonona
     * @return null jos ok, muuten virheteksti
     * @example
     * <pre name="test">
     *   Joukkue jouk = new Joukkue();
     *   jouk.aseta(1,"Pittsburgh Penguinskissa") === null;
     * </pre>
     */
    public String aseta(int k, String s) {

        String st = s.trim();
        StringBuffer sb = new StringBuffer(st);
        switch (k) {
            case 0:
                setJoukkueID(Mjonot.erotaEx(sb, '§', getJoukkueID()));
                return null;
            case 1:
                nimi = st;
                return null;
            case 2:
                konferenssi = st;
                return null;
            case 3:
                divisioona = st;
                return null;
            case 4:
                try {
                    ottelut = Mjonot.erotaEx(sb, '§', ottelut);
                } catch ( NumberFormatException ex ) {
                    return "Ottelut pitää olla numero " + ex.getMessage();
                }
                return null;
            case 5:
                try {
                    pisteet = Mjonot.erotaEx(sb, '§', pisteet);
                } catch ( NumberFormatException ex ) {
                    return "Pisteet pitää olla numero " + ex.getMessage();
                }
                return null;
            case 6:
                maalivahdit = st;
                return null;
            case 7:
                puolustajat = st;
                return null;
            case 8:
                hyokkaajat = st;
                return null;
            case 9:
                valmentaja = st;
                return null;
            case 10: 
                loukkaantuneet = st;
                return null;
            default:
                return "Virhe";
        }
    }
    
  
    /**
     * Tulostetaan joukkueen tiedot
     * @param out tanne tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(joukkueID + this.nimi + ", Konferenssi: " + konferenssi + " Divisioona: " + divisioona + " Ottelut: " + ottelut + " Pisteet: " + pisteet + " Maalivahdit: " + maalivahdit + " Puolustajat: " + puolustajat + " Hyökkääjät: " + hyokkaajat + " Valmentaja: " + valmentaja + " Loukkaantuneet: " + loukkaantuneet);
    }
    
  
    /**
     * Tulostetaan pelaajan tiedot
     * @param os tanne tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }

  
    /**
     * Antaa joukkueelle kronologisesti seuraavan ID-numeron, ettei tule samoja
     * @return joukkueen uusi ID-numero
     * @example
     * <pre name="test">
     *   Joukkue pittsburghpenguins1 = new Joukkue();
     *   pittsburghpenguins1.rekisteroi();
     *   Joukkue pittsburghpenguins2 = new Joukkue();
     *   pittsburghpenguins2.rekisteroi();
     *   int n1 = pittsburghpenguins1.getJoukkueID();
     *   int n2 = pittsburghpenguins2.getJoukkueID();
     *   n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        joukkueID = seuraavaNro;
        seuraavaNro++;
        return joukkueID;
    }
    
    
    /**
     * Palauttaa joukkueen tiedot merkkijonona jonka voi tallentaa tiedostoon
     * @return joukkue tolppaeroteltuna merkkijonona 
     * @example
     * <pre name="test">
     *   Joukkue joukkue = new Joukkue();
     *   joukkue.parse("1|Pittsburgh|Itäinen|Metropolitan|70");
     * </pre>
     */
    @Override
    public String toString() {
        return "" +
                joukkueID + " | " +
                nimi + " | " +
                konferenssi + " | " + 
                divisioona + " | " +
                ottelut + " | " +
                pisteet + " | " +
                maalivahdit + " | " +
                puolustajat + " | " +
                hyokkaajat + " | " +
                valmentaja + " | " +
                loukkaantuneet; 
    }


    /**
     * Selvittaa joukkueen tiedot tolpin erotellusta merkkijonosta
     * @param rivi josta joukkueen tiedot otetaan
     * @example
     * <pre name="test">
     *   Joukkue joukkue = new Joukkue();
     *   joukkue.parse("1|Pittsburgh|Itäinen|Metropolitan|70");
     * </pre>
     */
    public void parse(String rivi) {
        StringBuffer sb = new StringBuffer(rivi);
        for (int k = 0; k < getKenttia(); k++)
            aseta(k, Mjonot.erota(sb, '|'));
    }
    

    /**
     * Tutkii onko joukkueen tiedot samat kuin parametrina tuodun pelaajan tiedot
     * @param joukkue joukkue johon verrataan
     * @return true jos kaikki tiedot samat, false muuten
     */
    public boolean equals(Joukkue joukkue) {
        if ( joukkue == null ) return false;
        for (int k = 0; k < getKenttia(); k++)
            if ( !anna(k).equals(joukkue.anna(k)) ) return false;
        return true;
    }


    @Override
    public boolean equals(Object joukkue) {
        if ( joukkue instanceof Joukkue ) return equals((Joukkue)joukkue);
        return false;
    }

    
    /**
     * Korvaava hashCode-metodi
     */
    @Override
    public int hashCode() {
        return joukkueID;
    }
    
    
    @Override
    public int compareTo(Joukkue j) {
        return this.getNimi().compareTo(j.getNimi());
    }
    
 
    /**
     * Testimaini joukkueelle
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Joukkue jouk = new Joukkue();
        jouk.dummyJoukkue();
        jouk.tulosta(System.out);
    }
 
}
 