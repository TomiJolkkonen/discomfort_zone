package Taustaoperaatiot;
  
import fi.jyu.mit.ohj2.Mjonot;
import java.io.*;

/**
 * Pelaaja-yksikköluokka, huolehtii yksittäisen pelaajan tiedoista, mm antaa PelaajaID:n
 * Sisältää COM-testejä
 *
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.8, 23.04.2020
 */
    public class Pelaaja implements Comparable<Pelaaja> {
        
    private int pelaajaID = 0;
    private String nimi = "";
    private String joukkue = "";
    private String pelipaikka = "";
    private int pelatutpelit = 0;
    private int jaaaikamin = 0;
    private int maalit = 0;
    private int syotot = 0;
    private int pisteet = 0;
    private int plusmiinus = 0;
    private double aloitukset = 0.0;
    private double corsi = 0.0;
    private String loukkaantunut = "";
    
    private int pelaajanJoukkueID;
    private static int seuraavaNro = 1;

    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot pelaajalle
     */
    public void dummyPelaaja() {
        pelaajaID = 1000;
        nimi = "Teuvo Testi";
        joukkue = "Teuvon Tesmaajat";
        pelipaikka = "Hyökkääjä";
        pelatutpelit = 10;
        jaaaikamin = 1500;
        maalit = 15;
        syotot = 25;
        pisteet = 40;
        plusmiinus = 2;
        aloitukset = 50.01;
        corsi = 49.87;
        loukkaantunut = "Ei";
    }
     
    
    /** 
     * Antaa k:n kentän sisällön merkkijonona 
     * @param k monenenko kentän sisältö palautetaan 
     * @return kentän sisältö merkkijonona 
     */ 
    public String getAvain(int k) { 
        switch ( k ) { 
        case 0: return "" + pelaajaID;
        case 1: return "" + nimi; 
        case 2: return "" + joukkue; 
        case 3: return "" + pelipaikka;  
        case 4: return "" + pelatutpelit; 
        case 5: return "" + jaaaikamin;
        case 6: return "" + maalit; 
        case 7: return "" + syotot; 
        case 8: return "" + pisteet; 
        case 9: return "" + plusmiinus;  
        case 10: return "" + aloitukset;  
        case 11: return "" + corsi;
        case 12: return "" + loukkaantunut; 
        default: return "Virhe"; 
        } 
    } 
       
    
    /**
     * Palauttaa pelaajan kenttien lukumäärän
     * @return kenttien lukumäärä
     */
    public int getKenttia() {
        return 13;
    }


    /**
     * Ensimmäinen kenttä
     * @return eknn kentän indeksi
     */
    public int ekaKentta() {
        return 1;
    }


    /**
     * Ei käytössä
     */
    public Pelaaja() {
        //
    }
    
    // GETTEREITÄ JA SETTEREITÄ
    
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
     * Palauttaa pelaajan oman joukkueen ID-numeron
     * @return antaa pelaajan joukkueen ID:n
     */
    public int getPelaajanJoukkueID() {
        return pelaajanJoukkueID;
    }
   
    
    /**
     * Palautetaan pelaajan nimi
     * @return pelaajan nimi
     * @example
     * <pre name="test">
     *   Pelaaja sidney = new Pelaaja();
     *   sidney.dummyPelaaja();
     *   sidney.getNimi() === "Teuvo Testi";
     * </pre>
     */
    public String getNimi() {
        return nimi;
    }
    
    
    /**
     * @param s pelaajalle laitettava nimi
     * @return virheilmoitus, null jos ok
     */
    public String setNimi(String s) {
        nimi = s;
        return null;
    }
    
    
    /**
     * @return joukkue
     */
    public String getJoukkue() {
        return joukkue;
    }
    
    
    /**
     * @param s pelaajalle laitettava joukkue
     * @return virheilmoitus, null jos ok
     */
    public String setJoukkue(String s) {
        joukkue = s;
        return null;
    }
    
    
    /**
     * @return pelipaikka
     */
    public String getPelipaikka() {
        return pelipaikka;
    }
    
    
    /**
     * @param s pelaajalle laitettava pelipaikka
     * @return virheilmoitus, null jos ok
     */
    
    
    public String setPelipaikka(String s) {
        pelipaikka = s;
        return null;
    }
    
    
    /**
     * @return pelatut pelit
     */
    public int getPelatutPelit() {
        return pelatutpelit;
    }
    
    
    /**
     * @param s pelaajan pelatut pelit
     * @return virheilmoitus, null jos ok
     */
    public String setPelatutPelit(String s) {
        pelatutpelit = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return jääaika minuuteissa
     */
    public int getJaaaikaMin() {
        return jaaaikamin;
    }
    
    
    /**
     * @param s pelaajan jääaikaminuutit
     * @return virheilmoitus, null jos ok
     */
    public String setJaaaikaMin(String s) {
        jaaaikamin = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return maalit
     */
    public int getMaalit() {
        return maalit;
    }
    
    
    /**
     * @param s pelaajan maalit
     * @return virheilmoitus, null jos ok
     */
    public String setMaalit(String s) {
        maalit = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return syötöt
     */
    public int getSyotot() {
        return syotot;
    }
    
    
    /**
     * @param s pelaajan syötöt
     * @return virheilmoitus, null jos ok
     */
    public String setSyotot(String s) {
        syotot = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return pisteet
     */
    public int getPisteet() {
        return pisteet;
    }
    
    
    /**
     * @param s pelaajan pisteet
     * @return virheilmoitus, null jos ok
     */
    public String setPisteet(String s) {
        pisteet = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return +/- -tilasto
     */
    public int getPlusMiinus() {
        return plusmiinus;
    }
    
    
    /**
     * @param s pelaajan +/- tilasto
     * @return virheilmoitus, null jos ok
     */
    public String setPlusMiinus(String s) {
        plusmiinus = Integer.parseInt(s);
        return null;
    }
    
    
    /**
     * @return aloitusprosentti
     */
    public double getAloitukset() {
        return aloitukset;
    }
    
    
    /**
     * @param s pelaajan aloitusprosentti
     * @return virheilmoitus, null jos ok
     */
    public String setAloitukset(String s) {
        aloitukset = Double.parseDouble(s);
        return null;
    }
    
    
    /**
     * @return corsi-prosentti
     */
    public double getCorsi() {
        return corsi;
    }
    
    
    /**
     * @param s pelaajan corsi-arvo
     * @return virheilmoitus, null jos ok
     */
    public String setCorsi(String s) {
        corsi = Double.parseDouble(s);
        return null;
    }
    
    
    /**
     * @return onko loukkaantuneena
     */
    public String getLoukkaantunut() {
        return loukkaantunut;
    }
    
    
    /**
     * @param s onko pelaaja loukkaantunut kyllä/ei
     * @return virheilmoitus, null jos ok
     */
    public String setLoukkaantunut(String s) {
        loukkaantunut = s;
        return null;
    }
    // GETTERIT JA SETTERIT LOPPU
    
  
    /**
     * Antaa k:n kentän sisällön merkkijonona
     * @param k monenenko kentän sisältö palautetaan
     * @return kentän sisältö merkkijonona
     */
    public String anna(int k) {
        switch ( k ) {
        case 0: return "" + pelaajaID;
        case 1: return "" + nimi; 
        case 2: return "" + joukkue; 
        case 3: return "" + pelipaikka;  
        case 4: return "" + pelatutpelit; 
        case 5: return "" + jaaaikamin;
        case 6: return "" + maalit; 
        case 7: return "" + syotot; 
        case 8: return "" + pisteet; 
        case 9: return "" + plusmiinus;  
        case 10: return "" + aloitukset;  
        case 11: return "" + corsi;
        case 12: return "" + loukkaantunut; 
        default: return "Virhe";
        }        
    }


    /**
     * Asettaa k:n kentän arvoksi parametrina tuodun merkkijonon arvon
     * @param k kuinka monennen kentän arvo asetetaan
     * @param jono jonoa joka asetetaan kentän arvoksi
     * @return null jos asettaminen onnistuu, muuten vastaava virheilmoitus.
     * @example
     * <pre name="test">
     *   Pelaaja pelaaja = new Pelaaja();
     *   pelaaja.aseta(2,"Sidney Crosby") === null;
     *   pelaaja.aseta(3,"Pittsburgh Penguins") === null;
     * </pre>
     * 
     */
    public String aseta(int k, String jono) {
        String tjono = jono.trim();
        StringBuffer sb = new StringBuffer(tjono);
        switch ( k ) {
            case 0:
                setPelaajaID(Mjonot.erotaEx(sb, '§', getPelaajaID()));
                return null;
            case 1:
                nimi = tjono;
                return null;
            case 2:
                joukkue = tjono;
                return null;
            case 3:
                pelipaikka = tjono;
                return null;
            case 4:
                try {
                    pelatutpelit = Mjonot.erotaEx(sb, '§', pelatutpelit);
                } catch ( NumberFormatException ex ) {
                    return "Pelatut pelit pitää olla numero " + ex.getMessage();
                }
                return null;
            case 5:
                try {
                    jaaaikamin = Mjonot.erotaEx(sb, '§', jaaaikamin);
                } catch ( NumberFormatException ex ) {
                    return "Jääaika minuuteissa pitää olla numero " + ex.getMessage();
                }
                return null;
            case 6:
                try {
                    maalit = Mjonot.erotaEx(sb, '§', maalit);
                } catch ( NumberFormatException ex ) {
                    return "Maalit pitää olla numero " + ex.getMessage();
                }
                return null;
            case 7:
                try {
                    syotot = Mjonot.erotaEx(sb, '§', syotot);
                } catch ( NumberFormatException ex ) {
                    return "Syötöt pitää olla numero " + ex.getMessage();
                }
                return null;
            case 8:
                try {
                    pisteet = Mjonot.erotaEx(sb, '§', pisteet);
                } catch ( NumberFormatException ex ) {
                    return "Pisteet pitää olla numero " + ex.getMessage();
                }
                return null;
            case 9:
                try {
                    plusmiinus = Mjonot.erotaEx(sb, '§', plusmiinus);
                } catch ( NumberFormatException ex ) {
                    return "+/- -arvo pitää olla numero " + ex.getMessage();
                }
                return null;
            case 10:
                try {
                    aloitukset = Mjonot.erotaEx(sb, '§', aloitukset);
                } catch ( NumberFormatException ex ) {
                    return "Aloitus% pitää olla numero " + ex.getMessage();
                }
                return null;
            case 11:
                try {
                    corsi = Mjonot.erotaEx(sb, '§', corsi);
                } catch ( NumberFormatException ex ) {
                    return "Corsi% pitää olla numero " + ex.getMessage();
                }
                return null;
            case 12: 
                loukkaantunut = tjono;
                return null;
            default:
                return "Virhe";
        }
    }


    /**
     * Palauttaa k:tta pelaajan kenttää vastaavan kysymyksen
     * @param k kuinka monennen kentän kysymys palautetaan (0-alkuinen)
     * @return k:netta kenttää vastaava kysymys
     */
    public String getKysymys(int k) {
        switch ( k ) {
        case 0: return "" + pelaajaID;
        case 1: return "" + nimi; 
        case 2: return "" + joukkue; 
        case 3: return "" + pelipaikka;  
        case 4: return "" + pelatutpelit; 
        case 5: return "" + jaaaikamin;
        case 6: return "" + maalit; 
        case 7: return "" + syotot; 
        case 8: return "" + pisteet; 
        case 9: return "" + plusmiinus;  
        case 10: return "" + aloitukset;  
        case 11: return "" + corsi;
        case 12: return "" + loukkaantunut; 
        default: return "Virhe";
        }
    }
  
  
    /**
     * Tulostetaan pelaajan tiedot
     * @param out tanne tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(pelaajaID + this.nimi + " Joukkue: " + joukkue + " Pelipaikka: " + pelipaikka + " Pelatut pelit " + pelatutpelit + " Jääaika(min): " + jaaaikamin + " Maalit " + maalit + " Syötöt: " + syotot + " Pisteet: " + pisteet + " +/-: " + plusmiinus + " Aloitus%: " + aloitukset + " Corsi%: " + corsi + " Loukkaantunut: " + loukkaantunut);
    }
  
    
    /**
     * Tulostetaan pelaajan tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
 
 
    /**
     * Antaa pelaajalle kronologisesti seuraavan ID-numeron ettei tule samoja
     * @return pelaajan uusi pelaajaID
     * @example
     * <pre name="test">
     *   Pelaaja sidney1 = new Pelaaja();
     *   sidney1.rekisteroi();
     *   Pelaaja sidney2 = new Pelaaja();
     *   sidney2.rekisteroi();
     * </pre>
     */
    public int rekisteroi() {
        
        pelaajaID = seuraavaNro;
        seuraavaNro++;
        return pelaajaID;
    }
 
 
    /**
     * Palauttaa pelaajan tiedot merkkijonona jonka voi tallentaa tiedostoon
     * @return pelaajan tiedot tolppaeroteltuna merkkijonona  
     * @example
     * <pre name="test">
     *   Pelaaja pelaaja = new Pelaaja();
     *   pelaaja.parse("1|Sidney Crosby|Pittsburgh Penguins");
     * </pre>  
     */
    @Override
    public String toString() {
        return "" +
                pelaajaID + " | " +
                nimi + " | " +
                joukkue + " | " + 
                pelipaikka + " | " +
                pelatutpelit + " | " +
                jaaaikamin + " | " +
                maalit + " | " +
                syotot + " | " +
                pisteet + " | " +
                plusmiinus + " | " +
                aloitukset + " | " +
                corsi + " | " +
                loukkaantunut;
    }

    
    /**
     * Parseroi pelaajan tiedot tolppien avulla erotellusta merkkijonosta
     * @param rivi josta pelaajan tiedot otetaan
     * @example
     * <pre name="test">
     *   Pelaaja pelaaja = new Pelaaja();
     *   pelaaja.parse("1|Sidney Crosby|Pittsburgh Penguins");
     * </pre>
     */
    public void parse(String rivi) {
        StringBuffer sb = new StringBuffer(rivi);
        for (int k = 0; k < getKenttia(); k++)
            aseta(k, Mjonot.erota(sb, '|'));

    }
    

    /**
     * Tutkii onko pelaajan tiedot samat kuin parametrina tuodun pelaajan tiedot
     * @param pelaaja pelaaja johon verrataan
     * @return true jos kaikki tiedot samat, false muuten
     * @example
     * <pre name="test">
     *   Pelaaja pelaaja1 = new Pelaaja();
     *   pelaaja1.parse("1|Sidney Crosby|PittsburghPenguins");
     *   Pelaaja pelaaja2 = new Pelaaja();
     *   pelaaja2.parse("1|SidneyCrosby|PittsburghPenguins");
     *   Pelaaja pelaaja3 = new Pelaaja();
     *   pelaaja3.parse("1|Sidney Crosby|PittsburghPenguins");
     * </pre>
     */
    public boolean equals(Pelaaja pelaaja) {
        if ( pelaaja == null ) return false;
        for (int k = 0; k < getKenttia(); k++)
            if ( !anna(k).equals(pelaaja.anna(k)) ) return false;
        return true;
    }


    @Override
    public boolean equals(Object pelaaja) {
        if ( pelaaja instanceof Pelaaja ) return equals((Pelaaja)pelaaja);
        return false;
    }
    
    
    /**
     * Korvaava hashCode-metodi
     */
    @Override
    public int hashCode() {
        return pelaajaID;
    }
 
    
    /**
     * Testimaini pelaajalle
     * @param args ei käytössä
     */
    public static void main(String args[]) {
        Pelaaja sidney = new Pelaaja(), sidney2 = new Pelaaja();
        sidney.rekisteroi();
        sidney2.rekisteroi();
        sidney.tulosta(System.out);
        sidney.dummyPelaaja();
        sidney.tulosta(System.out);

        sidney2.dummyPelaaja();
        sidney2.tulosta(System.out);

        sidney2.dummyPelaaja();
        sidney2.tulosta(System.out);
    }


    @Override
    public int compareTo(Pelaaja o) {
        return this.getNimi().compareTo(o.getNimi());
    }

}
