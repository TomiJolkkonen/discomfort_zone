package NHLtietokanta;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * NHLtietokanta-luokka eli ns. paarekisteri, joka huolehtii pelaajistosta ja joukkueista
 * @author Tomi Jolkkonen
 * @version 1.2, 19.03.2020
 */
public class NHLtietokanta {
    private Pelaajat pelaajat = new Pelaajat();
    private Joukkueet joukkueet = new Joukkueet();
 
  
    /**
     * Palautaa NHLtietokannan pelaajamaaran
     * @return pelaajien lkm
     */
    public int getPelaajia() {
        return pelaajat.getLkm();
    }
    
    /**
     * Palauttaa NHLtietokannan joukkuemaaran
     * @return joukkueiden lkm
     */
    public int getJoukkueita() {
        return joukkueet.getLkm();
    }
  
  
    /**
     * KESKEN Poistaa pelaajistosta ja joukkueista ne joilla on haluttu numero
     * @param nro viitenumero pelaajaan tai joukkueeseen joka poistetaan
     * @return montako pelaajaa poistettiin
     */
    public int poista(@SuppressWarnings("unused") int nro) {
        return 0;
    }
  
  
    /**
     * Lisää NHLtietokantaan uuden pelaajan
     * @param pelaaja lisättävä pelaaja
     * @throws SailoException jos lisäystä ei voida tehdä
     * @example
     * <pre name="test">
     * #THROWS SailoException
     * NHLtietokanta nhltietokanta = new NHLtietokanta();
     * Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
     * sidney1.rekisteroi(); sidney2.rekisteroi();
     * nhltietokanta.getPelaajia() === 0;
     * nhltietokanta.lisaa(sidney1); nhltietokanta.getPelaajia() === 1;
     * nhltietokanta.lisaa(sidney2); nhltietokanta.getPelaajia() === 2;
     * nhltietokanta.lisaa(sidney1); nhltietokanta.getPelaajia() === 3;
     * nhltietokanta.getPelaajia() === 3;
     * nhltietokanta.annaPelaaja(0) === sidney1;
     * nhltietokanta.annaPelaaja(1) === sidney2;
     * nhltietokanta.annaPelaaja(2) === sidney1;
     * nhltietokanta.annaPelaaja(3) === sidney1; #THROWS IndexOutOfBoundsException 
     * nhltietokanta.lisaa(sidney1); nhltietokanta.getPelaajia() === 4;
     * nhltietokanta.lisaa(sidney1); nhltietokanta.getPelaajia() === 5;
     * nhltietokanta.lisaa(sidney1);            #THROWS SailoException
     * </pre>
     */
    public void lisaa(Pelaaja pelaaja) throws SailoException {
        pelaajat.lisaa(pelaaja);
    }
    
    /**
     * Lisaa-metodi joukkueen lisaamiseen
     * @param jouk joukkue
     */
    public void lisaa(Joukkue jouk) {
        joukkueet.lisaa(jouk);
    }
    
    /**
     * Palauttaa i:n pelaajan
     * @param i monesko pelaaja palautetaan
     * @return viite i:teen pelaajaan
     * @throws IndexOutOfBoundsException jos i väärin
     */
    public Pelaaja annaPelaaja(int i) throws IndexOutOfBoundsException {
        return pelaajat.anna(i);
    }
  
    /**
     * Etsitaan joukkuetta 
     * @param indeksi joukkueen indeksi
     * @return haluttu joukkue
     */
    public Joukkue annaJoukkue(int indeksi) {
        return joukkueet.annaJoukkue(indeksi);
    }
    
    /**
     * Etsitaan joukkueen indeksia pelaajatietoihin
     * @param indeksi joukkueen indeksi
     * @return haluttu joukkueindeksi pelaajatietoihin
     */
    public Joukkue annaJoukkueIndeksi(int indeksi) {
        return joukkueet.annaJoukkueIndeksi(indeksi);
    }
    
    
    /**
     * Haetaan joukkuetta halutulla ID-numerolla
     * @param joukkueid parametrina joukkueen ID
     * @return palauttaa halutun joukkueen ID:n perusteella
     */
    public Joukkue haeJoukkue(int joukkueid) {
        return joukkueet.haeJoukkue(joukkueid);
    }
 
    /**
     * Asettaa tiedostojen perusnimet
     * @param nimi uusi nimi
     */
    public void setTiedosto(String nimi) {
        File dir = new File(nimi);
        dir.mkdirs();
        String hakemistonNimi = "";
        if ( !nimi.isEmpty() ) hakemistonNimi = nimi +"/";
        pelaajat.setTiedostonPerusNimi(hakemistonNimi + "pelaajat");
        joukkueet.setTiedostonPerusNimi(hakemistonNimi + "joukkueet");
    }
    
    
    
    /**
     * Lukee nhltietokannan tiedot tiedostosta
     * @param nimi jota käyteään lukemisessa
     * @throws SailoException jos lukeminen epäonnistuu
     * 
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #import java.io.*;
     * #import java.util.*;
     * 
     *  NHLtietokanta nhltietokanta = new NHLtietokanta();
     *  
     *  Pelaaja sidney1 = new Pelaaja(); sidney1.vastaaSidneyCrosby(); sidney1.rekisteroi();
     *  Pelaaja sidney2 = new Pelaaja(); sidney2.vastaaSidneyCrosby(); sidney2.rekisteroi();
     *  Joukkue pittsburghpenguins21 = new Joukkue(); pittsburghpenguins21.vastaaPittsburghPenguins(sidney2.getTunnusNro());
     *  Joukkue pittsburghpenguins11 = new Joukkue(); pittsburghpenguins11.vastaaPittsburghPenguins(sidney1.getTunnusNro());
     *  Joukkue pittsburghpenguins22 = new Joukkue(); pittsburghpenguins22.vastaaPittsburghPenguins(sidney2.getTunnusNro()); 
     *  Joukkue pittsburghpenguins12 = new Joukkue(); pittsburghpenguins12.vastaaPittsburghPenguins(sidney1.getTunnusNro()); 
     *  Joukkue pittsburghpenguins23 = new Joukkue(); pittsburghpenguins23.vastaaPittsburghPenguins(sidney2.getTunnusNro());
     *   
     *  String hakemisto = "testijengit";
     *  File dir = new File(hakemisto);
     *  File ftied  = new File(hakemisto+"/pelaajat.dat");
     *  File fhtied = new File(hakemisto+"/joukkueet.dat");
     *  dir.mkdir();  
     *  ftied.delete();
     *  fhtied.delete();
     *  nhltietokanta.lueTiedostosta(hakemisto); #THROWS SailoException
     *  nhltietokanta.lisaa(sidney1);
     *  nhltietokanta.lisaa(sidney2);
     *  nhltietokanta.lisaa(pittsburghpenguins21);
     *  nhltietokanta.lisaa(pittsburghpenguins11);
     *  nhltietokanta.lisaa(pittsburghpenguins22);
     *  nhltietokanta.lisaa(pittsburghpenguins12);
     *  nhltietokanta.lisaa(pittsburghpenguins23);
     *  nhltietokanta.tallenna();
     *  nhltietokanta = new NHLtietokanta();
     *  nhltietokanta.lueTiedostosta(hakemisto);
     *  Collection<Pelaaja> kaikki = nhltietokanta.etsi("",-1); 
     *  Iterator<Pelaaja> it = kaikki.iterator();
     *  it.next() === sidney1;
     *  it.next() === sidney2;
     *  it.hasNext() === false;
     *  List<Joukkue> loytyneet = nhltietokanta.annaJoukkue(sidney1);
     *  Iterator<Joukkue> ih = loytyneet.iterator();
     *  ih.next() === pittsburghpenguins11;
     *  ih.next() === pittsburghpenguins12;
     *  ih.hasNext() === false;
     *  loytyneet = nhltietokanta.annaJoukkue(sidney2);
     *  ih = loytyneet.iterator();
     *  ih.next() === pittsburghpenguins21;
     *  ih.next() === pittsburghpenguins22;
     *  ih.next() === pittsburghpenguins23;
     *  ih.hasNext() === false;
     *  nhltietokanta.lisaa(sidney2);
     *  nhltietokanta.lisaa(pittsburghpenguins23);
     *  nhltietokanta.tallenna();
     *  ftied.delete()  === true;
     *  fhtied.delete() === true;
     *  File fbak = new File(hakemisto+"/pelaajat.bak");
     *  File fhbak = new File(hakemisto+"/joukkueet.bak");
     *  fbak.delete() === true;
     *  fhbak.delete() === true;
     *  dir.delete() === true;
     * </pre>
     */
    public void lueTiedostosta(String nimi) throws SailoException {

        // HUOM joukkueet ennen pelaajia, muuten tietokantaongelma koska pelaaja tarvitsee joukkueen
        joukkueet = new Joukkueet();
        pelaajat = new Pelaajat();

        setTiedosto(nimi);

        // Tassa myos joukkueet luettava ennen pelaajia
        joukkueet.lueTiedostosta();
        pelaajat.lueTiedostosta();
    }


    /**
     * Tallenttaa nhltietokannan tiedot tiedostoon.  
     * @throws SailoException jos tallettamisessa ongelmia
     */
    public void tallenna() throws SailoException {
        String virhe = "";
        try {
            pelaajat.tallenna();
        } catch ( SailoException ex ) {
            virhe = ex.getMessage();
        }

        try {
            joukkueet.tallenna();
        } catch ( SailoException ex ) {
            virhe += ex.getMessage();
        }
        if ( !"".equals(virhe) ) throw new SailoException(virhe);
    }
  
    /**
     * Testataan NHLtietokantaa
     * @param args ei käytössä
     */
    public static void main(String args[]) {
        NHLtietokanta nhltietokanta = new NHLtietokanta();
 
        try {
            // nhltietokanta.lueTiedostosta("nhl");

            int joukkueid = 0;
            Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
            sidney1.rekisteroi();
            sidney1.vastaaSidneyCrosby(joukkueid);
            sidney2.rekisteroi();
            sidney2.vastaaSidneyCrosby(joukkueid);

            nhltietokanta.lisaa(sidney1);
            nhltietokanta.lisaa(sidney2);

            System.out.println("============= NHLtietokannan testi =================");

            for (int i = 0; i < nhltietokanta.getPelaajia(); i++) {
                Pelaaja pelaaja = nhltietokanta.annaPelaaja(i);
                System.out.println("Pelaaja paikassa: " + i);
                pelaaja.tulosta(System.out);
            }

        } catch (SailoException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
