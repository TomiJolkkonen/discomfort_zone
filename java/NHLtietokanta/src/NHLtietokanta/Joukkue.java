package NHLtietokanta;
  
import fi.jyu.mit.ohj2.Mjonot;
import java.io.*;
  
/**
 * Joukkue joka osaa huolehtia ID-numerostaan
 *
 * @author Tomi Jolkkonen
 * @version 1.2, 19.03.2020
 */
public class Joukkue {
    private String nimi = "";
    private String joukkue = "";
    private String konferenssi = "";
    private String divisioona = "";
    private int ottelut = 0;
    private int pisteet = 0;
    private String maalivahdit = "";
    private String puolustajat = "";
    private String hyokkaajat = "";
    private String valmentaja = "";
    private String loukkaantuneet = "";
    
    private int joukkueID = 0;
    private int pelaajaID = 0;
    private static int seuraavaNro = 1;
  
  
    /**
     * KESKEN Alustetaan joukkue
     */
    public Joukkue() {
        // Vielä ei tarvita mitään
    }
  
  
    /**
     * Alustetaan pelaajan joukkue  
     * @param pelaajaID pelaajan ID-numero 
     */
    public Joukkue(int pelaajaID) {
        this.pelaajaID = pelaajaID;
    }
  
  
    /**
     * Taytetaan testiarvot joukkueelle
     * Ottelumaara arvotaan, kunhan kokeillaan randia tassa vaiheessa
     */
    public void vastaaPittsburghPenguins() {
        nimi = "Pittsburgh Penguins";
        konferenssi = "Metropolitan";
        divisioona = "Itainen";
        ottelut = rand(1000, 9999);
        pisteet = 56;
        maalivahdit = "Tristan Jarry";
        puolustajat = "Kris Letang, Olli Maatta";
        hyokkaajat = "Sidney Crosby, Jevgeni Malkin";
        valmentaja = "Jukka Jalonen";
        loukkaantuneet = "Ei";
    }

  
    /**
     * Tulostetaan joukkueen tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(this.nimi + " " + joukkueID + " | " + konferenssi + " | " + divisioona + " | " + ottelut);
    }
  
  
    /**
     * Tulostetaan pelaajan tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    
    /**
     * Satunnaisgeneraattori, kaytetaan tarvittaessa
     * @param ala alaraja
     * @param yla ylaraja
     * @return palauttaa luvun ala ja ylarajan valilta
     */
    public static int rand(int ala, int yla) {
        double n = (yla-ala)*Math.random() + ala;
        return (int)Math.round(n);
      }

  
    /**
     * Antaa joukkueelle seuraavan ID-numeron
     * @return joukkueen uusi ID-numero
     * @example
     * <pre name="test">
     *   Joukkue pittsburghpenguins1 = new Joukkue();
     *   pittsburghpenguins1.getTunnusNro() === 0;
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
     * Palautetaan joukkueen oma ID-numero
     * @return joukkueen ID
     */
    public int getjoukkueID() {
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
     * Palautetaan mille pelaajalle joukkue kuuluu
     * @return pelaajan id
     */
    public int getpelaajaID() {
        return pelaajaID;
    }
    
    
    /**
     * Palauttaa joukkueen tiedot merkkijonona jonka voi tallentaa tiedostoon
     * @return joukkue tolppaeroteltuna merkkijonona 
     * @example
     * <pre name="test">
     *   Joukkue joukkue = new Joukkue();
     *   joukkue.parse("   2   |  pittsburghpenguins  |   metropolitan  | itäinen | 22  ");
     *   joukkue.toString()    === "2|pittsburghpenguins|metropolitan|itäinen|22";
     * </pre>
     */
    @Override
    public String toString() {
        return "" + joukkueID + " | " + nimi + " | " + joukkue + " | " + konferenssi + " | " + divisioona;
    }



    /**
     * Selvittaa joukkueen tiedot tolpin erotellusta merkkijonosta
     * Pitaa huolen että joukkueID on suurempi kuin tuleva joukkueID
     * @param rivi josta joukkueen tiedot otetaan
     * @example
     * <pre name="test">
     *   Joukkue joukkue = new Joukkue();
     *   joukkue.parse("   2   |  10  |   pittsburghpenguins  | metropolitan | itäinen ");
     *   joukkue.getPelaajaID() === 10;
     *   joukkue.toString()    === "2|10|pittsburghpenguins|metropolitan|itäinen";
     *   
     *   joukkue.rekisteroi();
     *   int n = joukkue.getJoukkueID();
     *   joukkue.parse(""+(n+20));
     *   joukkue.rekisteroi();
     *   joukkue.getJoukkueID() === n+20+1;
     *   joukkue.toString()     === "" + (n+20+1) + "2|10|pittsburghpenguins|metropolitan|itäinen";
     * </pre>
     */
    public void parse(String rivi) {
        StringBuffer sb = new StringBuffer(rivi);
        joukkueID = Mjonot.erota(sb, '|', joukkueID);
        nimi = Mjonot.erota(sb, '|', nimi);
        konferenssi = Mjonot.erota(sb, '|', konferenssi);
        divisioona = Mjonot.erota(sb, '|', divisioona);
    }
    

    // korvaava equals-metodi
    @Override
    public boolean equals(Object obj) {
        if ( obj == null ) return false;
        return this.toString().equals(obj.toString());
    }
    

    // korvaava hasCode-metodi
    @Override
    public int hashCode() {
        return joukkueID;
    }
 
 
    /**
     * Testiohjelma joukkueelle
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Joukkue jouk = new Joukkue();
        jouk.vastaaPittsburghPenguins();
        jouk.tulosta(System.out);
    }


    /**
     * Palauttaa joukkueen nimen
     * @return joukkueen nimi
     */
    public String getNimi() {
        return nimi;
    }
 
}
 