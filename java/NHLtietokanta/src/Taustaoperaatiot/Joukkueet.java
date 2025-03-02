package Taustaoperaatiot;
  
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import fi.jyu.mit.ohj2.WildChars;
  
/**
 * Joukkue-monikkoluokka, huolehtii joukkuekokoelmasta, mm lisää joukkueita
 * Sisältää COM-testejä
 *
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.9, 23.04.2020
 */
public class Joukkueet implements Iterable<Joukkue> {

    private boolean muutettu = false;
    private String tiedostonPerusNimi = "";

    /** Taulukko joukkueista, voisi olla myos ArrayList */
    private final List<Joukkue> alkiot = new ArrayList<Joukkue>();


    /**
     * Joukkueiden alustaminen, kesken
     */
    public Joukkueet() {
        //
    }
    
    
    /**
     * Haetaan joukkuetta sen ID:lla
     * @param joukkueid joukkueen ID
     * @return palauttaa halutun joukkueen
     */
    public Joukkue haeJoukkue(int joukkueid) {
        for (int i = 0; i < alkiot.size(); i++) {
            if (((ArrayList<Joukkue>) alkiot).get(i).getJoukkueID() == joukkueid) {
                return ((ArrayList<Joukkue>) alkiot).get(i);
            }
        }
        return null;
    }

 
    /**
     * Lisaa uuden joukkueen alkioihin. muuttaa muutettu-arvon trueksi, jolloin tapahtuu tallennusta.
     * @param jouk lisattava joukkue
     */
    public void lisaa(Joukkue jouk) {
        alkiot.add(jouk);
        muutettu = true;
    }
    
    
    /**
     * Korvaa joukkueen tietorakenteessa.
     * Etsitään samalla ID:llä oleva joukkue.  Jos ei löydy,
     * lisätään uutena joukkueena
     * @param jouk lisättävän joukkueen viite
     * @throws SailoException jos tietorakenne on jo täynnä
     */ 
    public void korvaaTaiLisaa(Joukkue jouk) throws SailoException {
        int id = jouk.getJoukkueID();
        for (int i = 0; i < getLkm(); i++) {
            if (alkiot.get(i).getJoukkueID() == id) {
                alkiot.set(i, jouk);
                muutettu = true;
                return;
            }
        }
        lisaa(jouk);
    }

    
    /**
     * Poistaa valitun joukkueen
     * @param jouk poistettava joukkue
     * @return tosi jos löytyi poistettava tietue 
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #import java.io.File;
     *  Joukkueet joukkueet = new Joukkueet();
     *  Joukkue pittsburghpenguins21 = new Joukkue(); pittsburghpenguins21.dummyJoukkue();
     *  Joukkue pittsburghpenguins11 = new Joukkue(); pittsburghpenguins11.dummyJoukkue();
     *  Joukkue pittsburghpenguins22 = new Joukkue(); pittsburghpenguins22.dummyJoukkue(); 
     *  Joukkue pittsburghpenguins12 = new Joukkue(); pittsburghpenguins12.dummyJoukkue(); 
     *  Joukkue pittsburghpenguins23 = new Joukkue(); pittsburghpenguins23.dummyJoukkue(); 
     *  joukkueet.lisaa(pittsburghpenguins21);
     *  joukkueet.lisaa(pittsburghpenguins11);
     *  joukkueet.lisaa(pittsburghpenguins22);
     *  joukkueet.lisaa(pittsburghpenguins12);
     * </pre>
     */
    public boolean poista(Joukkue jouk) {
        boolean ret = alkiot.remove(jouk);
        if (ret) muutettu = true;
        return ret;
    }
    

    

    /**
     * Lukee joukkueet tiedostosta.
     * @param tied tiedoston nimen alkuosa
     * @throws SailoException jos lukeminen epäonnistuu
     * 
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #import java.io.File;
     * #import java.util.Iterator;
     * 
     *  Joukkueet jengit = new Joukkueet();
     *  Joukkue pittsburghpenguins21 = new Joukkue(); pittsburghpenguins21.dummyJoukkue();
     *  Joukkue pittsburghpenguins11 = new Joukkue(); pittsburghpenguins11.dummyJoukkue();
     *  Joukkue pittsburghpenguins22 = new Joukkue(); pittsburghpenguins22.dummyJoukkue(); 
     *  Joukkue pittsburghpenguins12 = new Joukkue(); pittsburghpenguins12.dummyJoukkue(); 
     *  Joukkue pittsburghpenguins23 = new Joukkue(); pittsburghpenguins23.dummyJoukkue(); 
     *  String tiedNimi = "testikelmit";
     *  File ftied = new File(tiedNimi+".dat");
     *  ftied.delete();
     *  jengit.lueTiedostosta(tiedNimi); #THROWS SailoException
     *  jengit.lisaa(pittsburghpenguins21);
     *  jengit.lisaa(pittsburghpenguins11);
     *  jengit.lisaa(pittsburghpenguins22);
     *  jengit.lisaa(pittsburghpenguins12);
     *  jengit.lisaa(pittsburghpenguins23);
     *  jengit.tallenna();
     *  jengit = new Joukkueet();
     *  jengit.lueTiedostosta(tiedNimi);
     *  Iterator<Joukkue> i = jengit.iterator();
     *  i.next().toString() === pittsburghpenguins21.toString();
     *  i.next().toString() === pittsburghpenguins11.toString();
     *  i.next().toString() === pittsburghpenguins22.toString();
     *  i.next().toString() === pittsburghpenguins12.toString();
     *  i.next().toString() === pittsburghpenguins23.toString();
     *  i.hasNext() === false;
     *  jengit.lisaa(pittsburghpenguins23);
     *  jengit.tallenna();
     *  ftied.delete() === true;
     *  File fbak = new File(tiedNimi+".bak");
     *  fbak.delete() === true;
     * </pre>
     */
    public void lueTiedostosta(String tied) throws SailoException {
        setTiedostonPerusNimi(tied);
        try ( BufferedReader fi = new BufferedReader(new FileReader(getTiedostonNimi())) ) {

            String rivi;
            while ( (rivi = fi.readLine()) != null) {
                rivi = rivi.trim();
                if ( "".equals(rivi) || rivi.charAt(0) == ';' ) continue;
                Joukkue jouk = new Joukkue();
                jouk.parse(rivi);
                lisaa(jouk);
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
     * Tallentaa joukkueet tiedostoon silloin kun muutettu-arvo on true
     * @throws SailoException jos talletus epäonnistuu
     */
    public void tallenna() throws SailoException {
        if ( !muutettu ) return;

        File fbak = new File(getBakNimi());
        File ftied = new File(getTiedostonNimi());
        fbak.delete();
        ftied.renameTo(fbak);

        try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {
            for (Joukkue jouk : this) {
                fo.println(jouk.toString());
            }
        } catch ( FileNotFoundException ex ) {
            throw new SailoException("Tiedosto " + ftied.getName() + " ei aukea");
        } catch ( IOException ex ) {
            throw new SailoException("Tiedoston " + ftied.getName() + " kirjoittamisessa ongelmia");
        }

        muutettu = false;
    }
  
  
    /**
     * Palauttaa NHLtietokannan joukkueiden lukumaaran
     * @return joukkueiden lukumaara
     */
    public int getLkm() {
        return alkiot.size();
    }
    
    
    /**
     * Asettaa tiedostolle perusnimen
     * @param tied tallennustiedoston perusnimi
     */
    public void setTiedostonPerusNimi(String tied) {
        tiedostonPerusNimi = tied;
    }


    /**
     * Palauttaa tiedoston perusnimen
     * @return tallennustiedoston nimi
     */
    public String getTiedostonPerusNimi() {
        return tiedostonPerusNimi;
    }


    /**
     * Palauttaa tiedoston nimen oikealla paatteella jota kaytetaan tallennukseen
     * @return tallennustiedoston nimi
     */
    public String getTiedostonNimi() {
        return tiedostonPerusNimi + ".dat";
    }


    /**
     * Palauttaa backuptiedoston nimen
     * @return backuptiedoston nimi
     */
    public String getBakNimi() {
        return tiedostonPerusNimi + ".bak";
    }
  
  
    /**
     * Iteraattori kaikkien harrastusten läpikäymiseen
     * @return harrastusiteraattori
     */
    @Override
    public Iterator<Joukkue> iterator() {
        return alkiot.iterator();
    }
 
 
    /**
     * Annetaan pelaajalle oikea joukkue
     * @param indeksi joukkueen ID-numero
     * @return palautetaan pelaajalle joukkue
     */
     public Joukkue annaJoukkue(int indeksi) {
         
         for (int i = 0; i < alkiot.size(); i++) {
             if (((ArrayList<Joukkue>) alkiot).get(i).getJoukkueID() == indeksi) {
                 return ((ArrayList<Joukkue>) alkiot).get(i);
             }
         }
         return null;
     }
     
     
     /**
     * Joukkueelle oikea indeksi
     * @param indeksi joukkueen ID
     * @return palautetaan ID-numero
     */
    public Joukkue annaJoukkueIndeksi (int indeksi) {
         return ((ArrayList<Joukkue>) alkiot).get(indeksi);
     }
    
    
    /** 
     * Palauttaa taulukosta hakuehtoon sopivien pelaajien viitteet 
     * @param hakuehto hakuehto 
     * @param k etsittävän kentan indeksi  
     * @return palauttaa tietorakenteen loytyneista pelaajista
     * */
    public ArrayList<Joukkue> etsi(String hakuehto, int k) { 
        String ehto = "*"; 
        if ( hakuehto != null && hakuehto.length() > 0 ) ehto = hakuehto; 
        int hk = k; 
        if ( hk < 0 ) hk = 0;
        ArrayList<Joukkue> loytyneet = new ArrayList<Joukkue>(); 
        for (Joukkue joukkue : this) { 
            if (WildChars.onkoSamat(joukkue.anna(hk), ehto)) loytyneet.add(joukkue);   
        } 
        Joukkue[] joukkuelista = new Joukkue[loytyneet.size()]; 
        joukkuelista = loytyneet.toArray(joukkuelista);
        Arrays.sort(joukkuelista);
        return new ArrayList<Joukkue> (Arrays.asList(joukkuelista)); 
    }

 
    /**
     * Testimaini joukkueille
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Joukkueet joukkueet = new Joukkueet();
        Joukkue pittsburghpenguins1 = new Joukkue();
        pittsburghpenguins1.dummyJoukkue();
        Joukkue pittsburghpenguins2 = new Joukkue();
        pittsburghpenguins2.dummyJoukkue();
        Joukkue pittsburghpenguins3 = new Joukkue();
        pittsburghpenguins3.dummyJoukkue();
        Joukkue pittsburghpenguins4 = new Joukkue();
        pittsburghpenguins4.dummyJoukkue();

        joukkueet.lisaa(pittsburghpenguins1);
        joukkueet.lisaa(pittsburghpenguins2);
        joukkueet.lisaa(pittsburghpenguins3);
        joukkueet.lisaa(pittsburghpenguins2);
        joukkueet.lisaa(pittsburghpenguins4);
    }
 
}
 