package Taustaoperaatiot;

import java.io.File;
import java.util.Collection;


/**
 * NHLtietokanta-luokka eli ns. paarekisteri/-tietokanta, joka huolehtii koko pelaajistosta ja joukkueista
 * Sisältää COM-testejä
 * 
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.9, 23.04.2020
 * 
 * Testien alustus
 * @example
 * <pre name="testJAVA">
 * #import NHLtietokanta.SailoException;
 *  private NHLtietokanta nhltietokanta;
 *  private Pelaaja sidney1;
 *  private Pelaaja sidney2;
 *  private int jid1;
 *  private int jid2;
 *  private Joukkue pittsburghpenguins21;
 *  private Joukkue pittsburghpenguins11;
 *  private Joukkue pittsburghpenguins22; 
 *  private Joukkue pittsburghpenguins12; 
 *  private Joukkue pittsburghpenguins23;
 *  
 *  public void alustaNHLtietokanta() {
 *    nhltietokanta = new NHLtietokanta();
 *    sidney1 = new Pelaaja(); sidney1.dummyPelaaja(); sidney1.rekisteroi();
 *    sidney2 = new Pelaaja(); sidney2.dummyPelaaja(); sidney2.rekisteroi();
 *    jid1 = sidney1.getPelaajaID();
 *    jid2 = sidney2.getPelaajaID();
 *    pittsburghpenguins21 = new Joukkue(jid2); pittsburghpenguins21.dummyJoukkue();
 *    pittsburghpenguins11 = new Joukkue(jid1); pittsburghpenguins11.dummyJoukkue();
 *    pittsburghpenguins22 = new Joukkue(jid2); pittsburghpenguins22.dummyJoukkue(); 
 *    pittsburghpenguins12 = new Joukkue(jid1); pittsburghpenguins12.dummyJoukkue(); 
 *    pittsburghpenguins23 = new Joukkue(jid2); pittsburghpenguins23.dummyJoukkue();
 *    try {
 *    nhltietokanta.lisaa(sidney1);
 *    nhltietokanta.lisaa(sidney2);
 *    nhltietokanta.lisaa(pittsburghpenguins21);
 *    nhltietokanta.lisaa(pittsburghpenguins11);
 *    nhltietokanta.lisaa(pittsburghpenguins22);
 *    nhltietokanta.lisaa(pittsburghpenguins12);
 *    nhltietokanta.lisaa(pittsburghpenguins23);
 *    } catch ( Exception e) {
 *       System.err.println(e.getMessage());
 *    }
 *  }
 * </pre>
*/
public class NHLtietokanta {
    private Pelaajat pelaajat = new Pelaajat();
    private Joukkueet joukkueet = new Joukkueet();
 
  
    /**
     * Palauttaa NHLtietokannan pelaajamaaran
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
     * Lisää NHLtietokantaan uuden pelaajan
     * @param pelaaja lisättävä pelaaja
     * @example
     * <pre name="test">
     *  alustaNHLtietokanta();
     *  nhltietokanta.etsiPelaaja("*",0).size() === 2;
     *  nhltietokanta.lisaa(sidney1);
     *  nhltietokanta.etsiPelaaja("*",0).size() === 3;
     * </pre>
     */
    public void lisaa(Pelaaja pelaaja) {
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
     * Poistaa pelaajistosta ja joukkueesta pelaajan tiedot 
     * @param pelaaja joka poistetaan
     * @return montako pelaajaa poistettiin
     */
    public int poista(Pelaaja pelaaja) {
        if ( pelaaja == null ) return 0;
        int ret = pelaajat.poista(pelaaja.getPelaajaID()); 
        return ret; 
    }


    /** 
     * Poistaa pelaajan joukkueen 
     * @param joukkue pelaajalta poistettava joukkue 
     */ 
    public void poistaJoukkue(Joukkue joukkue) { 
        joukkueet.poista(joukkue); 
    } 
    
    /** 
     * Korvaa pelaajan tietorakenteessa.  Ottaa pelaajan omistukseensa. 
     * Etsitään samalla ID:llä oleva pelaaja.  Jos ei löydy, 
     * niin lisätään uutena pelaajana. 
     * @param pelaaja lisättävän pelaajan viite.  Huom tietorakenne muuttuu omistajaksi 
     * @example
     * <pre name="test">
     * #THROWS SailoException  
     *  alustaNHLtietokanta();
     *  nhltietokanta.etsiPelaaja("*",0).size() === 2;
     *  nhltietokanta.korvaaTaiLisaa(sidney1);
     *  nhltietokanta.etsiPelaaja("*",0).size() === 2;
     * </pre>
     */ 
    public void korvaaTaiLisaa(Pelaaja pelaaja) { 
        try {
            pelaajat.korvaaTaiLisaa(pelaaja);
        } catch (SailoException e) {
            // ei 
            e.printStackTrace();
        } 
    } 
    
    /** 
     * Korvaa joukkueen tietorakenteessa.
     * Etsitään samalla ID:llä oleva joukkue. Jos ei löydy, 
     * niin lisätään uutena 
     * @param joukkue lisättävän joukkueen viite.
     * @throws SailoException virhe
     */ 
    public void korvaaTaiLisaa(Joukkue joukkue) throws SailoException { 
        joukkueet.korvaaTaiLisaa(joukkue); 
    } 
    
    /**
     * Palauttaa i:n pelaajan
     * @param i viite monesko pelaaja palautetaan
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
     * Etsitaan joukkueen indeksia haluttuihin pelaajatietoihin
     * @param indeksi joukkueen indeksi
     * @return haluttu joukkueindeksi pelaajatietoihin
     */
    public Joukkue annaJoukkueIndeksi(int indeksi) {
        return joukkueet.annaJoukkueIndeksi(indeksi);
    }
    
    
    /**
     * Haetaan joukkuetta tietylla ID-numerolla
     * @param joukkueid parametrina joukkueen ID
     * @return palauttaa halutun joukkueen ID:n perusteella
     */
    public Joukkue haeJoukkue(int joukkueid) {
        return joukkueet.haeJoukkue(joukkueid);
    }
    
    
    /** 
     * Palauttaa "taulukossa" hsidneyehtoon vastaavien joukkueiden viitteet 
     * @param hsidneyehto hsidneyehto  
     * @param k etsittävän kentän indeksi  
     * @return tietorakenteen löytyneistä joukkueista
     * @throws SailoException Jos jotakin menee väärin
     */ 
    public Collection<Joukkue> etsiJoukkue(String hsidneyehto, int k) throws SailoException { 
        return joukkueet.etsi(hsidneyehto, k); 
    } 
    
    /** 
     * Palauttaa "taulukossa" hsidneyehtoon vastaavien pelaajien viitteet 
     * @param hsidneyehto hsidneyehto  
     * @param k etsittävän kentän indeksi  
     * @return tietorakenteen löytyneistä pelaajista
     * @example 
     * <pre name="test">
     *   alustaNHLtietokanta();
     *   Pelaaja jasen3 = new Pelaaja(); jasen3.rekisteroi();
     *   jasen3.aseta(1,"Susi Sepe");
     *   nhltietokanta.lisaa(jasen3);
     * </pre>
     */ 
    public Collection<Pelaaja> etsiPelaaja(String hsidneyehto, int k) { 
        return pelaajat.etsi(hsidneyehto, k); 
    } 
    

    /**
     * Asettaa tiedostoille perusnimet
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
     *   
     *  String hakemisto = "testikelmit";
     *  File dir = new File(hakemisto);
     *  File ftied  = new File(hakemisto+"/pelaajat.dat");
     *  File fhtied = new File(hakemisto+"/joukkueet.dat");
     *  dir.mkdir();  
     *  ftied.delete();
     *  fhtied.delete();
     *  nhltietokanta = new NHLtietokanta(); // tiedostoja ei ole, tulee poikkeus 
     *  nhltietokanta.lueTiedostosta(hakemisto); #THROWS SailoException
     *  alustaNHLtietokanta();
     *  nhltietokanta.setTiedosto(hakemisto); // nimi annettava koska uusi poisti sen
     *  nhltietokanta.tallenna(); 
     *  nhltietokanta = new NHLtietokanta();
     *  nhltietokanta.lueTiedostosta(hakemisto);
     *  nhltietokanta.tallenna(); // tekee molemmista .bak
     *  ftied.delete()  === true;
     *  fhtied.delete() === true;
     *  File fbak = new File(hakemisto+"/nimet.bak");
     *  File fhbak = new File(hakemisto+"/harrastukset.bak");
     *  fbak.delete() === true;
     *  fhbak.delete() === true;
     *  dir.delete() === true;
     * </pre>
     */
    public void lueTiedostosta(String nimi) throws SailoException{

        // HUOM joukkueet ennen pelaajia, muuten tietokantaongelma koska pelaaja tarvitsee joukkueen
        joukkueet = new Joukkueet();
        pelaajat = new Pelaajat();

        setTiedosto(nimi);

        // Tassa myos joukkueet luettava ennen pelaajia
        try {
            joukkueet.lueTiedostosta();
        } catch (SailoException e) {
            // ei
            e.printStackTrace();
        }
        try {
            pelaajat.lueTiedostosta();
        } catch (SailoException e) {
            // ei
            e.printStackTrace();
        }
    }


    /**
     * Tallentaa nhltietokannan tiedot tiedostoon  
     * @throws SailoException jos tallentamisessa ongelmia
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
     * Testimain NHLtietokannalle
     * @param args ei käytössä
     */
    public static void main(String args[]) {    

        Pelaaja sidney1 = new Pelaaja(), sidney2 = new Pelaaja();
        sidney1.rekisteroi();
        sidney1.dummyPelaaja();
        sidney2.rekisteroi();
        sidney2.dummyPelaaja();

    }

}
