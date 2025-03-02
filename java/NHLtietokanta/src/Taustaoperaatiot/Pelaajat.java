package Taustaoperaatiot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import fi.jyu.mit.ohj2.WildChars;
  
/**
 * Pelaaja-monikkoluokka, huolehtii pelaajakokoelmasta, mm lisää pelaajia
 * Sisältää COM-testejä
 *
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.9, 23.04.2020 
 */
public class Pelaajat implements Iterable<Pelaaja> {
    
    private static final int MAX_PELAAJIA  = 5;
    private int lkm = 0;
    private boolean muutettu = false;
    private String kokoNimi = "";
    private String tiedostonPerusNimi = "pelaajat";
    private Pelaaja alkiot[] = new Pelaaja[MAX_PELAAJIA];

  
    /**
     * Oletuskonstruktori, kesken
     */
    public Pelaajat() {
        //
    }
  
  
    /**
     * Lisää uuden pelaajan alkioihin, vaihtaa muutettu-arvon trueksi jolloin muutokset tallentuu
     * @param pelaaja viite pelaajaan
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * Pelaajat pelaajat = new Pelaajat();
     * Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
     * pelaajat.getLkm() === 0;
     * pelaajat.lisaa(sidney1); pelaajat.getLkm() === 1;
     * pelaajat.lisaa(sidney2); pelaajat.getLkm() === 2;
     * pelaajat.lisaa(sidney1); pelaajat.getLkm() === 3;
     * </pre>
     */
    public void lisaa(Pelaaja pelaaja) {
        
        if (lkm >= alkiot.length) {
            Pelaaja [] uudet = new Pelaaja[alkiot.length + 15];
            
            for (int i = 0; i < alkiot.length; i++) {
                uudet[i] = alkiot[i];
            }
            
            alkiot = uudet;
        }
        
        alkiot[lkm++] = pelaaja;
        muutettu = true;
    }

    
    /**
     * Korvaa pelaajan tietorakenteessa.  Ottaa pelaajan omistukseensa.
     * Etsitään samalla tunnusnumerolla oleva pelaaja.  Jos ei löydy,
     * niin lisätään uutena pelaajana.
     * @param pelaaja lisättävän pelaajan viite.  Huom tietorakenne muuttuu omistajaksi
     * @throws SailoException jos tietorakenne on jo täynnä
     */
    public void korvaaTaiLisaa(Pelaaja pelaaja) throws SailoException {
        int id = pelaaja.getPelaajaID();
        for (int i = 0; i < lkm; i++) {
            if ( alkiot[i].getPelaajaID() == id ) {
                alkiot[i] = pelaaja;
                muutettu = true;
                return;
            }
        }
        lisaa(pelaaja);
    }

  
    /**
     * Palauttaa pelaajan viitteen
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
     * Poistaa pelaajan jolla on valittu pelaajaID  
     * @param id poistettavan id 
     * @return 1 jos poistettiin, 0 jos ei löydy 
     * @example 
     * <pre name="test"> 
     * #THROWS SailoException  
     * Pelaajat pelaajat = new Pelaajat(); 
     * Pelaaja sidney1 = new Pelaaja(); 
     * sidney1.rekisteroi(); 
     * int id1 = sidney1.getPelaajaID(); 
     * pelaajat.lisaa(sidney1); 
     * pelaajat.poista(id1) === 1; 
     * </pre> 
     */ 
    public int poista(int id) { 
        int ind = etsiPelaajaID(id); 
        if (ind < 0) return 0; 
        lkm--; 
        for (int i = ind; i < lkm; i++) 
            alkiot[i] = alkiot[i + 1]; 
        alkiot[lkm] = null; 
        muutettu = true; 
        return 1; 
    }
    
    
    /** 
     * Etsii pelaajan id:n perusteella 
     * @param id PelaajID, jonka mukaan etsitään 
     * @return pelaaja jolla etsittävä id tai null 
     * <pre name="test"> 
     * #THROWS SailoException  
     * Pelaajat pelaajat = new Pelaajat(); 
     * Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja(); 
     * sidney1.rekisteroi(); sidney2.rekisteroi(); 
     * int id1 = sidney1.getPelaajaID(); 
     * pelaajat.lisaa(sidney1); pelaajat.lisaa(sidney2); 
     * pelaajat.annaPelaajaID(id1) == sidney1 === true; 
     * pelaajat.annaPelaajaID(id1+1) == sidney2 === true; 
     * </pre> 
     */ 
    public Pelaaja annaPelaajaID(int id) { 
        for (Pelaaja pelaaja : this) { 
            if (id == pelaaja.getPelaajaID()) return pelaaja; 
        } 
        return null; 
    } 
    
    
    /** 
     * Etsii pelaajan id:n perusteella 
     * @param id pelaajaID, jonka mukaan etsitään 
     * @return löytyneen pelaajan indeksi tai -1 jos ei löydy 
     */ 
    public int etsiPelaajaID(int id) { 
        for (int i = 0; i < lkm; i++) 
            if (id == alkiot[i].getPelaajaID()) return i; 
        return -1; 
    } 
    
    
    /**
     * Lukee pelaajiston tiedostosta. 
     * @param tied tiedoston perusnimi
     * @throws SailoException jos lukeminen epäonnistuu
     * 
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #import java.io.File;
     * #import java.util.Iterator;
     * 
     *  Pelaajat pelaajat = new Pelaajat();
     *  Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
     *  sidney1.dummyPelaaja();
     *  sidney2.dummyPelaaja();
     *  String hakemisto = "testikelmit";
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
     * Luetaan jo aiemmin annetusta tiedostosta
     * @throws SailoException jos tulee poikkeus
     */
    public void lueTiedostosta() throws SailoException {
        lueTiedostosta(getTiedostonPerusNimi());
    }
    
    
    /**
     * Tallentaa pelaajiston tiedostoon.  
     * Tiedoston muoto:
     * <pre>
     * Anari kerho
     * 20
     * ; kommenttirivi
     * 1|Sidney Crosby|Pittsburgh Penguins|Hyökkääjä|50|1500|20|30|50|2|50.0|30.0|Ei
     * 2|Kris Letang|Pittsburgh Penguins|Puolustaja|50|1400|5|10|15|31|20.7|33.4|Kyllä
     * </pre>
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
     * Palauttaa perustiedoston nimen
     * @return perusnimi
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
     * Palauttaa tiedoston nimen oikealla paatteella jota kaytetaan tallennukseen
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
     * Luokka pelaajien iteroimiseksi.
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
         * Deletointia ei ole viela toteutettu
         * @throws UnsupportedOperationException aina
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Ei poistettu");
        }
    }
    
    
    /**
     * Palautetaan iteraattori pelaajistaan
     * @return pelaaja iteraattori
     */
    @Override
    public Iterator<Pelaaja> iterator() {
        return new PelaajatIterator();
    }

    
    /** 
     * Palauttaa "taulukossa" hsidneyehtoon vastaavien pelaajien viitteet 
     * @param hsidneyehto hsidneyehto 
     * @param k etsittävän kentän indeksi  
     * @return tietorakenteen löytyneistä pelaajista 
     */ 
    public ArrayList<Pelaaja> etsi(String hsidneyehto, int k) { 
        String ehto = "*"; 
        if ( hsidneyehto != null && hsidneyehto.length() > 0 ) ehto = hsidneyehto; 
        int hk = k; 
        if ( hk < 0 ) hk = 0;
        ArrayList<Pelaaja> loytyneet = new ArrayList<Pelaaja>(); 
        for (Pelaaja pelaaja : this) { 
            if (WildChars.onkoSamat(pelaaja.anna(hk), ehto)) loytyneet.add(pelaaja);   
        } 
        Pelaaja[] pelaajalista = new Pelaaja[loytyneet.size()]; 
        pelaajalista = loytyneet.toArray(pelaajalista);
        Arrays.sort(pelaajalista);
        return new ArrayList<Pelaaja> (Arrays.asList(pelaajalista)); 
    }
        

    /**
     * Testimaini pelaajistolle
     * @param args ei kaytossa
     */
    public static void main(String args[]) {
        Pelaajat pelaajat = new Pelaajat();

        Pelaaja sidney = new Pelaaja(), sidney2 = new Pelaaja();
        sidney.rekisteroi();
        sidney.dummyPelaaja();
        sidney2.rekisteroi();
        sidney2.dummyPelaaja();

        pelaajat.lisaa(sidney);
        pelaajat.lisaa(sidney2);

        int i = 0;
        
        for (Pelaaja pelaaja: pelaajat) { 
            System.out.println("Jäsen nro: " + i++);
            pelaaja.tulosta(System.out);
        }
    }
 
}
 