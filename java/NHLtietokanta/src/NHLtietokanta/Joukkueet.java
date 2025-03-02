package NHLtietokanta;
  
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
  
/**
 * NHLtietokannan joukkueet joka osaa lisata uuden joukkueen
 *
 * @author Tomi Jolkkonen
 * @version 1.2, 19.03.2020
 */
public class Joukkueet implements Iterable<Joukkue> {

    private boolean muutettu = false; // getMuutettu esim. 
    private String tiedostonPerusNimi = "";

    /** Taulukko joukkueista, voisi olla myos ArrayList */
    private final Collection<Joukkue> alkiot = new ArrayList<Joukkue>();


    /**
     * Joukkueiden alustaminen, default
     */
    public Joukkueet() {
        //
    }
    
    
    /**
     * Haetaan joukkuetta ID:lla
     * @param joukkueid joukkueen ID-luku
     * @return palauttaa halutun joukkueen
     */
    public Joukkue haeJoukkue(int joukkueid) {
        for (int i = 0; i < alkiot.size(); i++) {
            if (((ArrayList<Joukkue>) alkiot).get(i).getjoukkueID() == joukkueid) {
                return ((ArrayList<Joukkue>) alkiot).get(i);
            }
        }
        return null;
    }

 
    /**
     * Lisaa uuden joukkueen tietorakenteeseen
     * @param jouk lisattava joukkue
     */
    public void lisaa(Joukkue jouk) {
        alkiot.add(jouk);
        muutettu = true;
    }

    /**
     * Lukee joukkueet tiedostosta
     * @param tied tiedoston nimen alkuosa
     * @throws SailoException jos lukeminen epäonnistuu
     * 
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #import java.io.File;
     *  Joukkueet jengit = new Joukkueet();
     *  Joukkue pittsburghpenguins21 = new Joukkue(); pittsburghpenguins21.vastaaPittsburghPenguins(2);
     *  Joukkue pittsburghpenguins11 = new Joukkue(); pittsburghpenguins11.vastaaPittsburghPenguins(1);
     *  Joukkue pittsburghpenguins22 = new Joukkue(); pittsburghpenguins22.vastaaPittsburghPenguins(2); 
     *  Joukkue pittsburghpenguins12 = new Joukkue(); pittsburghpenguins12.vastaaPittsburghPenguins(1); 
     *  Joukkue pittsburghpenguins23 = new Joukkue(); pittsburghpenguins23.vastaaPittsburghPenguins(2); 
     *  String tiedNimi = "testijengit";
     *  File ftied = new File(tiedNimi+".dat");
     *  ftied.delete();
     *  jengit.lueTiedostosta(tiedNimi); #THROWS SailoException
     *  jengit.lisaa(pitsi21);
     *  jengit.lisaa(pitsi11);
     *  jengit.lisaa(pitsi22);
     *  jengit.lisaa(pitsi12);
     *  jengit.lisaa(pitsi23);
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
     * Luetaan aikaisemmin jo annetusta tiedostosta
     * @throws SailoException jos tulee poikkeus
     */
    public void lueTiedostosta() throws SailoException {
        lueTiedostosta(getTiedostonPerusNimi());
    }
    
    
    /**
     * Tallentaa joukkueet tiedostoon
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
     * Asettaa tiedoston perusnimen
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
     * Palauttaa tiedoston nimen jota kaytetaan tallennukseen
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
     * Iteraattori kaikkien joukkueiden lapikaymiseen
     * @return joukkueiteraattori
     * 
     * @example
     * <pre name="test">
     * #PACKAGEIMPORT
     * #import java.util.*;
     * 
     *  Joukkueet jengit = new Joukkueet();
     *  Joukkue penguins21 = new Joukkue(2); jengit.lisaa(penguins21);
     *  Joukkue penguins11 = new Joukkue(1); jengit.lisaa(penguins11);
     *  Joukkue penguins22 = new Joukkue(2); jengit.lisaa(penguins22);
     *  Joukkue penguins12 = new Joukkue(1); jengit.lisaa(penguins12);
     *  Joukkue penguins23 = new Joukkue(2); jengit.lisaa(penguins23);
     * 
     *  Iterator<Joukkue> i2=jengit.iterator();
     *  i2.next() === penguins21;
     *  i2.next() === penguins11;
     *  i2.next() === penguins22;
     *  i2.next() === penguins12;
     *  i2.next() === penguins23;
     *  i2.next() === penguins12;  #THROWS NoSuchElementException  
     *  
     *  int n = 0;
     *  int jnrot[] = {2,1,2,1,2};
     *  
     *  for ( Joukkue jouk:jengit ) { 
     *    jouk.getpelaajaID() === jnrot[n]; n++;  
     *  }
     *  
     *  n === 5;
     *  
     * </pre>
     */
    @Override
    public Iterator<Joukkue> iterator() {
        return alkiot.iterator();
    }
 
 
    /**
     * Annetaan joukkue pelaajalle
     * @param indeksi joukkueen ID-numero
     * @return palautetaan pelaajalle joukkue
     */
     public Joukkue annaJoukkue(int indeksi) {
         
         for (int i = 0; i < alkiot.size(); i++) {
             if (((ArrayList<Joukkue>) alkiot).get(i).getjoukkueID() == indeksi) {
                 return ((ArrayList<Joukkue>) alkiot).get(i);
             }
         }
         return null;
     }
     
     
     /**
     * Annetaan joukkueelle ID-numero
     * @param indeksi joukkueen ID
     * @return palautetaan ID-numero
     */
    public Joukkue annaJoukkueIndeksi (int indeksi) {
         return ((ArrayList<Joukkue>) alkiot).get(indeksi);
     }

 
    /**
     * Testiohjelma joukkueille
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Joukkueet jengit = new Joukkueet();
        Joukkue penguins1 = new Joukkue();
        penguins1.vastaaPittsburghPenguins();
        Joukkue penguins2 = new Joukkue();
        penguins2.vastaaPittsburghPenguins();
        Joukkue penguins3 = new Joukkue();
        penguins3.vastaaPittsburghPenguins();
        Joukkue penguins4 = new Joukkue();
        penguins4.vastaaPittsburghPenguins();
 
        jengit.lisaa(penguins1);
        jengit.lisaa(penguins2);
        jengit.lisaa(penguins3);
        jengit.lisaa(penguins2);
        jengit.lisaa(penguins4);
 


    }
 
}
 