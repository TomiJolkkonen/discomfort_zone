package NHLtietokanta;
  
import fi.jyu.mit.ohj2.Mjonot;
import java.io.*;

/**
 * NHL:n pelaaja joka osaa mm. itse huolehtia pelaajaID:staan
 *
 * @author Tomi Jolkkonen
 * @version 1.2, 19.03.2020
 */
    public class Pelaaja {
    private String nimi = "";
    private int pelaajaID = 0;
    private String pelipaikka = "";
    private int pelatutPelit = 0;
    private int jaaAikaMin = 0;
    private int maalit = 0;
    private int syotot = 0;
    private int pisteet = 0;
    private int plusMiinus = 0;
    private double aloitukset = 0.0;
    private double corsi = 0.0;
    private String loukkaantunut = "";
    private int pelaajanJoukkueID;
    private static int seuraavaNro = 1;

 
    /**
     * Palautetaan pelaajan nimi
     * @return pelaajan nimi
     * @example
     * <pre name="test">
     *   Pelaaja sidney = new Pelaaja();
     *   sidney.vastaaSidneyCrosby();
     *   sidney.getNimi() =R= "Crosby Sidney .*";
     * </pre>
     */
    public String getNimi() {
        return nimi;
    }
  
  
    /**
     * Taytetaan testiarvot pelaajalle.
     * @param joukkueid on joukkueen ID-numero
     * 
     */
    public void vastaaSidneyCrosby(int joukkueid) {
        nimi = "Sidney Crosy";
        pelipaikka = "Hyokkaaja";
        pelatutPelit = rand(1000, 9999);
        jaaAikaMin = 1246;
        maalit = 45;
        syotot = 19;
        pisteet = 64;
        plusMiinus = 8;
        aloitukset = 56.34;
        corsi = 62.18;
        loukkaantunut = "Ei";
        pelaajanJoukkueID = joukkueid;
        
    }
  
  
    /**
     * Tulostetaan pelaajan tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(this.nimi + " " + pelaajaID + " | " + pelaajanJoukkueID + " | " + pelipaikka + " | " + pelatutPelit);
    }
    
    
    /**
     * Satunnaislukugeneraattori, kaytetaan kun arvotaan ID-numeroita
     * @param ala alaraja
     * @param yla ylaraja
     * @return palauttaa luvun ala ja ylarajan valilta
     */
    public static int rand(int ala, int yla) {
        double n = (yla-ala)*Math.random() + ala;
        return (int)Math.round(n);
      }
  
  
    /**
     * Tulostetaan pelaajan tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
 
 
    /**
     * Antaa pelaajalle seuraavan ID-numeron
     * @return pelaajan uusi pelaajaID
     * @example
     * <pre name="test">
     *   Pelaaja sidney1 = new Pelaaja();
     *   sidney1.getPelaajaID() === 0;
     *   sidney1.rekisteroi();
     *   Pelaaja sidney2 = new Pelaaja();
     *   sidney2.rekisteroi();
     *   int n1 = sidney1.getPelaajaID();
     *   int n2 = sidney2.getPelaajaID();
     *   n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        pelaajaID = seuraavaNro;
        seuraavaNro++;
        return pelaajaID;
    }
 
 
    /**
     * Palauttaa pelaajan ID-numeron
     * @return pelaajan ID-numero
     */
    public int getPelaajaID() {
        return pelaajaID;
    }
    
    /**
     * Asettaa ID-numeron ja samalla varmistaa että
     * seuraava numero on aina suurempi kuin tähän mennessä suurin
     * @param nr asetettava ID-numero
     */
    private void setPelaajaID(int nr) {
        pelaajaID = nr;
        if (pelaajaID >= seuraavaNro) seuraavaNro = pelaajaID + 1;
    }
    
    /**
     * Palauttaa pelaajan joukkueen ID-numeron
     * @return antaa pelaajan joukkueen ID:n
     */
    public int getPelaajanJoukkueID() {
        return pelaajanJoukkueID;
    }
   
    
    /**
     * Palauttaa pelaajan tiedot merkkijonona jonka voi tallentaa tiedostoon
     * @return pelaaja tolppaeroteltuna merkkijonona 
     * @example
     * <pre name="test">
     *   Pelaaja pelaaja = new Pelaaja();
     *   pelaaja.parse(" Crosby Sidney  | 3 | Hyokkaaja ");
     *   pelaaja.toString().startsWith("Crosby Sidney|3|Hyokkaaja|") === true;
     * </pre>  
     */
    @Override
    public String toString() {
        return "" +

                nimi + " | " +
                pelaajaID + " | " +
                pelipaikka + " | " +
                pelatutPelit + " | " +
                jaaAikaMin + " | " +
                maalit + " | " +
                syotot + " | " +
                pisteet + " | " +
                plusMiinus + " | " +
                aloitukset + " | " +
                corsi + " | " +
                loukkaantunut + " | " +
                pelaajanJoukkueID;  
    }




    /**
     * Parseroi pelaajan tiedot tolppien avulla erotellusta merkkijonosta
     * Pitää huolen että seuraavaNro on suurempi kuin tuleva pelaajaID
     * @param rivi josta pelaajan tiedot otetaan
     * 
     * @example
     * <pre name="test">
     *   Pelaaja pelaaja = new Pelaaja();
     *   pelaaja.parse(" Crosby Sidney  | 1234 | Hyokkaaja ");
     *   pelaaja.getPelaajanJoukkueID() === 1234;
     *   pelaaja.toString().startsWith("Crosby Sidney|1234|Hyokkaaja|") === true;
     *
     *   pelaaja.rekisteroi();
     *   int n = pelaaja.getPelaajanJoukkueID();
     *   pelaaja.parse(""+(n+20));
     *   pelaaja.rekisteroi();
     *   pelaaja.getPelaajaID() === n+20+1;
     *     
     * </pre>
     */
    public void parse(String rivi) {
        StringBuffer sb = new StringBuffer(rivi);
       
        nimi = Mjonot.erota(sb, '|', nimi);
        pelaajaID = Mjonot.erota(sb, '|', pelaajaID);
        pelipaikka = Mjonot.erota(sb, '|', pelipaikka);
        pelatutPelit = Mjonot.erota(sb, '|', pelatutPelit);
        jaaAikaMin = Mjonot.erota(sb, '|', jaaAikaMin);
        maalit = Mjonot.erota(sb, '|', maalit);
        syotot = Mjonot.erota(sb, '|', syotot);
        pisteet = Mjonot.erota(sb, '|', pisteet);
        plusMiinus = Mjonot.erota(sb, '|', plusMiinus);
        aloitukset = Mjonot.erota(sb, '|', aloitukset);
        corsi = Mjonot.erota(sb, '|', corsi);
        loukkaantunut = Mjonot.erota(sb, '|', loukkaantunut);
        pelaajanJoukkueID = Mjonot.erota(sb, '|', pelaajanJoukkueID);
    }
    


    // uusi equals-toiminto
    @Override
    public boolean equals(Object pelaaja) {
        if ( pelaaja == null ) return false;
        return this.toString().equals(pelaaja.toString());
    }
    
    // uusi hasCode-toiminto
    @Override
    public int hashCode() {
        return pelaajaID;
    }
 
    /**
     * Testiohjelma pelaajalle
     * @param args ei käytössä
     */
    public static void main(String args[]) {
        Pelaaja sidney = new Pelaaja(), sidney2 = new Pelaaja();
        sidney.rekisteroi();
        sidney2.rekisteroi();
        
        sidney.tulosta(System.out);
        sidney.vastaaSidneyCrosby(1);
        sidney.tulosta(System.out);
 
        sidney2.tulosta(System.out);
        sidney2.vastaaSidneyCrosby(2);
        sidney2.tulosta(System.out);

    }
 
}
