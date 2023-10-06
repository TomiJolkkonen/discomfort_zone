package NHLtietokanta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import fi.jyu.mit.ohj2.Mjonot;
  
/**
 * NHLtietokannan kaikki pelaajat joka osaa lisata uuden pelaajan
 *
 * @author Tomi Jolkkonen
 * @version 1.2, 19.03.2020 
 */
public class Pelaajat {
    private static final int MAX_PELAAJIA  = 50; // HT6 - pitää kasvaa loputtomiin
    private int lkm = 0;
    private boolean muutettu = false;
    private String kokoNimi = "";
    private String tiedostonPerusNimi = "nimet";
    private String tiedostonNimi = "";
    private Pelaaja alkiot[] = new Pelaaja[MAX_PELAAJIA];

  
    /**
     * Oletuskonstruktori
     */
    public Pelaajat() {
        //
    }
  
  
    /**
     * Lisää uuden pelaajan tietorakenteeseen
     * @param pelaaja lisataan pelaajan viite
     * @throws SailoException jos tietorakenne on jo taynna
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * Pelaajat pelaajat = new Pelaajat();
     * Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
     * pelaajat.getLkm() === 0;
     * pelaajat.lisaa(sidney1); pelaajat.getLkm() === 1;
     * pelaajat.lisaa(sidney2); pelaajat.getLkm() === 2;
     * pelaajat.lisaa(sidney1); pelaajat.getLkm() === 3;
     * pelaajat.anna(0) === sidney1;
     * pelaajat.anna(1) === sidney2;
     * pelaajat.anna(2) === sidney1;
     * pelaajat.anna(1) == sidney1 === false;
     * pelaajat.anna(1) == sidney2 === true;
     * pelaajat.anna(3) === sidney1; #THROWS IndexOutOfBoundsException 
     * pelaajat.lisaa(sidney1); pelaajat.getLkm() === 4;
     * pelaajat.lisaa(sidney1); pelaajat.getLkm() === 5;
     * pelaajat.lisaa(sidney1);  #THROWS SailoException
     * </pre>
     */
    public void lisaa(Pelaaja pelaaja) throws SailoException {
        if (lkm >= alkiot.length) throw new SailoException("Liikaa alkioita");
        alkiot[lkm] = pelaaja;
        lkm++;
        muutettu = true;
    }
  
  
    /**
     * Palauttaa viitteen i:teen pelaajaan
     * @param i monennenko pelaajan viite halutaan
     * @return viite pelaajaan, jonka indeksi on i
     * @throws IndexOutOfBoundsException jos i ei ole sallitulla alueella  
     */
    public Pelaaja anna(int i) throws IndexOutOfBoundsException {
        if (i < 0 || lkm <= i)
            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
        return alkiot[i];
    }

  
    /**
     * Lukee pelaajiston tiedostosta 
     * @param tied tiedoston perusnimi
     * @throws SailoException jos lukeminen ei onnistu
     * 
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #import java.io.File;
     * 
     *  Pelaajat pelaajat = new Pelaajat();
     *  Jasen sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
     *  sidney1.vastaaSidneyCrosby();
     *  sidney2.vastaaSidneyCrosby();
     *  String hakemisto = "testityypit";
     *  String tiedNimi = hakemisto+"/pelaajat";
     *  File ftied = new File(tiedNimi+".dat");
     *  File dir = new File(hakemisto);
     *  dir.mkdir();
     *  ftied.delete();
     *  pelaajat.lueTiedostosta(tiedNimi); #THROWS SailoException
     *  pelaajat.lisaa(sidney1);
     *  pelaajat.lisaa(sidney2);
     *  pelaajat.tallenna();
     *  pelaajat = new Pelaajat();            // Poistetaan vanhat luomalla uusi
     *  pelaajat.lueTiedostosta(tiedNimi);  // johon ladataan tiedot tiedostosta.
     *  Iterator<Pelaaja> i = pelaajat.iterator();
     *  i.next() === sidney1;
     *  i.next() === sidney2;
     *  i.hasNext() === false;
     *  pelaajat.lisaa(sidney2);
     *  pelaajat.tallenna();
     *  ftied.delete() === true;
     *  File fbak = new File(tiedNimi+".bak");
     *  fbak.delete() === true;
     *  dir.delete() === true;
     * </pre>
     */
    public void lueTiedostosta(String tied) throws SailoException {
        setTiedostonPerusNimi(tied);
        try ( BufferedReader fi = new BufferedReader(new FileReader(getTiedostonNimi())) ) {
            kokoNimi = fi.readLine();
            if ( kokoNimi == null ) throw new SailoException("Tietokannan nimi puuttuu");
            String rivi = fi.readLine();
            if ( rivi == null ) throw new SailoException("Maksimikoko puuttuu");

            while ( (rivi = fi.readLine()) != null ) {
                rivi = rivi.trim();
                if ( "".equals(rivi) || rivi.charAt(0) == ';' ) continue;
                Pelaaja pelaaja = new Pelaaja();
                pelaaja.parse(rivi);
                lisaa(pelaaja);
            }
            muutettu = false;
        } catch ( FileNotFoundException e ) {
            throw new SailoException("Tiedosto " + getTiedostonNimi() + " ei aukea");
        } catch ( IOException e ) {
            throw new SailoException("Ongelmia tiedoston kanssa: " + e.getMessage());
        }
    }


    /**
     * Luetaan aikaisemmin jo annetusta tiedostosta
     * @throws SailoException jos tulee poikkeus
     */
    public void lueTiedostosta() throws SailoException {
        lueTiedostosta(getTiedostonPerusNimi());
    }
    
    
    /**
     * Tallentaa pelaajat tiedostoon 
     * @throws SailoException jos talletus epäonnistuu
     */
    public void tallenna() throws SailoException {
        if ( !muutettu ) return;

        File fbak = new File(getBakNimi());
        File ftied = new File(getTiedostonNimi());
        File kansio = new File("Defaultkansio");
        if (!kansio.exists()) {
            try {
                kansio.mkdir();
            } catch (Exception e) {
                throw new SailoException("Kansiota " + ftied.getName() + " ei pystyta luomaan");
            }
        }
        fbak.delete();
        ftied.renameTo(fbak);
        
        System.out.println(getTiedostonPerusNimi());

        try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {
            fo.println(getKokoNimi());
            fo.println(alkiot.length);
            for (int i = 0; i < this.lkm; i++) {
                if(alkiot[i] == null) {
                    continue;
                }
                fo.println(alkiot[i].toString());
            }      

        } catch ( FileNotFoundException ex ) {
            throw new SailoException("Tiedosto " + ftied.getName() + " ei aukea");
        } catch ( IOException e ) {
            throw new SailoException("Tiedoston " + ftied.getName() + " kirjoittamisessa ongelmia");
        }

        muutettu = false;
    }
    
    
    /**
     * Palauttaa NHLtietokannan nimen
     * @return NHltietokannan koko nimi merkkijonona
     */
    public String getKokoNimi() {
        return kokoNimi;
    }

  
    /**
     * Palauttaa NHLtietokannan pelaajien lukumaaran
     * @return pelaajien lukumaara
     */
    public int getLkm() {
        return lkm;
    }


    /**
     * Palauttaa tiedoston nimen jota kaytetaan tallentamiseen
     * @return tallennustiedoston nimi
     */
    public String getTiedostonPerusNimi() {
        return tiedostonPerusNimi;
    }


    /**
     * Asettaa tiedoston perusnimen
     * @param nimi tallennustiedoston perusnimi
     */
    public void setTiedostonPerusNimi(String nimi) {
        tiedostonPerusNimi = nimi;
    }


    /**
     * Palauttaa tiedoston nimen jota kaytetaan tallennukseen
     * @return tallennustiedoston nimi
     */
    public String getTiedostonNimi() {
        return getTiedostonPerusNimi() + ".dat";
    }


    /**
     * Palauttaa backuptiedoston nimen
     * @return backuptiedoston nimi
     */
    public String getBakNimi() {
        return tiedostonPerusNimi + ".bak";
    }


    /**
     * Luokka pelaajien iterointiin
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #PACKAGEIMPORT
     * #import java.util.*;
     * 
     * Pelaajat pelaajat = new Pelaajat();
     * Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
     * sidney1.rekisteroi(); sidney2.rekisteroi();
     *
     * pelaajat.lisaa(sidney1); 
     * pelaajat.lisaa(sidney2); 
     * pelaajat.lisaa(sidney1); 
     * 
     * StringBuffer ids = new StringBuffer(30);
     * for (Pelaaja pelaaja:pelaajat)
     *   ids.append(" "+pelaaja.getPelaajaID());           
     * 
     * String tulos = " " + sidney1.getPelaajaID() + " " + sidney2.getPelaajaID() + " " + sidney1.getPelaajaID();
     * 
     * ids.toString() === tulos; 
     * 
     * ids = new StringBuffer(30);
     * for (Iterator<Pelaaja>  i=pelaajat.iterator(); i.hasNext(); ) {
     *   Pelaaja pelaaja = i.next();
     *   ids.append(" "+pelaaja.getPelaajaID());           
     * }
     * 
     * ids.toString() === tulos;
     * 
     * Iterator<Pelaaja>  i=pelaajat.iterator();
     * i.next() == sidney1  === true;
     * i.next() == sidney2  === true;
     * i.next() == sidney1  === true;
     * 
     * i.next();  #THROWS NoSuchElementException
     *  
     * </pre>
     */
    public class PelaajatIterator implements Iterator<Pelaaja> {
        private int kohdalla = 0;


        /**
         * Etsitaan vielako on seuraavaa pelaajaa
         * @see java.util.Iterator#hasNext()
         * @return true jos on viela pelaajia
         */
        @Override
        public boolean hasNext() {
            return kohdalla < getLkm();
        }


        /**
         * Annetaan seuraava pelaaja
         * @return seuraava pelaaja
         * @throws NoSuchElementException jos seuraava alkiota ei enaa ole
         * @see java.util.Iterator#next()
         */
        @Override
        public Pelaaja next() throws NoSuchElementException {
            if ( !hasNext() ) throw new NoSuchElementException("Ei loytynyt");
            return anna(kohdalla++);
        }


        /**
         * Deletointia ei ole toteutettu
         * @throws UnsupportedOperationException aina
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Ei poistettu");
        }
    }


    /** 
     * Palauttaa taulukosta hakuehtoon vastaavien pelaajien viitteet 
     * @param hakuehto hakuehto 
     * @param k etsittävän kentan indeksi  
     * @return palauttaa tietorakenteen loytyneista pelaajista
     * @example 
     * <pre name="test"> 
     * #THROWS SailoException  
     *   Pelaajat pelaajat = new Pelaajat(); 
     *   Pelaaja pelaaja1 = new Pelaaja(); pelaaja1.parse("1|Crosby Sidney|1000|Hyökkääjä|"); 
     *   Pelaaja pelaaja2 = new Pelaaja(); pelaaja2.parse("2|Rosby Sidney|1001|Hyökkääjä|"); 
     *   Pelaaja pelaaja3 = new Pelaaja(); pelaaja3.parse("3|Cosby Sidney|1002|Hyökkääjä|"); 
     *   Pelaaja pelaaja4 = new Pelaaja(); pelaaja4.parse("4|BBlosby Sidney|1003|Hyökkääjä|"); 
     *   Pelaaja pelaaja5 = new Pelaaja(); pelaaja5.parse("5|Hgrosby Sidney|1004|Hyökkääjä|"); 
     *   pelaajat.lisaa(pelaaja1); pelaajat.lisaa(pelaaja2); pelaajat.lisaa(pelaaja3); pelaajat.lisaa(pelaaja4); pelaajat.lisaa(pelaaja5);
     * </pre> 
     */ 
    @SuppressWarnings("unused")
    public ArrayList<Pelaaja> etsi(String hakuehto, int k) { 
        ArrayList<Pelaaja> loytyneet = new ArrayList<Pelaaja>(); 
        for (Pelaaja pelaaja : alkiot) { 
            loytyneet.add(pelaaja);  
        } 
        return loytyneet; 
    }

    /**
     * Testiohjelma pelaajistolle
     * @param args ei kaytossa
     */
    public static void main(String args[]) {
        Pelaajat pelaajat = new Pelaajat();
 
        Pelaaja sidney = new Pelaaja(), sidney2 = new Pelaaja();
        sidney.rekisteroi();
        sidney.vastaaSidneyCrosby(1);
        sidney2.rekisteroi();
        sidney2.vastaaSidneyCrosby(2);
 
        try {
            pelaajat.lisaa(sidney);
            pelaajat.lisaa(sidney2);
 
            System.out.println("============= Pelaajat testi =================");

            for (int i = 0; i < pelaajat.getLkm(); i++) {
                Pelaaja pelaaja = pelaajat.anna(i);
                System.out.println("Pelaaja nro: " + i);
                pelaaja.tulosta(System.out);
            }

        } catch (SailoException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
}
 