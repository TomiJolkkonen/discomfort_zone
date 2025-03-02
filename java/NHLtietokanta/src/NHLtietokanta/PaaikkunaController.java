package NHLtietokanta;

import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.TextAreaOutputStream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import Taustaoperaatiot.Pelaaja;
import Taustaoperaatiot.Pelaajat;
import Taustaoperaatiot.NHLtietokanta;
import Taustaoperaatiot.Joukkue;
import Taustaoperaatiot.Joukkueet;
import Taustaoperaatiot.SailoException;

/**
 * Luokka NHL-tietokannan käyttöliittymän tapahtumien hoitamiseksi, nimetty paaikuunan mukaan
 * 
 * @author Tomi Jolkkonen
 * @version 1.2 19.3.2020
 *
 */

public class PaaikkunaController implements Initializable {
    
    // Elementit fxml-tiedostosta
    @FXML private TextField hakuehtoPelaaja;
    @FXML private TextField hakuehtoJoukkue;
    @FXML private ComboBoxChooser<String> kirjoitaHakuPelaaja;
    @FXML private ComboBoxChooser<String> kirjoitaHakuJoukkue;
    @FXML private ListChooser<Pelaaja> chooserPelaajat;
    @FXML private ListChooser<Joukkue> chooserJoukkueet;
    @FXML private ScrollPane panelPelaaja;
    @FXML private ScrollPane panelJoukkue;
    @FXML private Label labelVirhe;
    

    // uuden pelaajan lisaaminen, ht5-vaiheessa lisaa dummy-pelaajia, myohemmin ohjataan pelaajakorttiin
    @FXML void handleuusiPelaaja(ActionEvent event) {
        // ModalController.showModal(PaaikkunaController.class.getResource("Pelaajakortti.fxml"), "Pelaaja", null, "");
        uusiPelaaja();
    }
    
    // uuden joukkueen lisaaminen, ht5-vaiheessa lisaa dummy-joukkueita, myohemmin ohjataan joukkuekorttiin
    @FXML void handleuusiJoukkue(ActionEvent event) {
        // ModalController.showModal(PaaikkunaController.class.getResource("Joukkuekortti.fxml"), "Joukkue", null, "");
        uusiJoukkue();
    }
    
    // KESKEN, muokataan pelaajaa pelaajakortin kautta. Samanlainen tehdaan myos joukkueelle.
    @FXML void handleMuokkaa(ActionEvent event) {
        // ModalController.showModal(PaaikkunaController.class.getResource("Pelaajakortti.fxml"), "Pelaaja", null, "");
        Dialogs.showMessageDialog("Ei viela toimi");
        muokkaaPelaaja();
    }
    
    // KESKEN, poistetaan pelaaja. Samanlainen tehdaan myos joukkueelle.
    @FXML void handlePoista(ActionEvent event) {
        // ModalController.showModal(PaaikkunaController.class.getResource("Pelaajakortti.fxml"), "Pelaaja", null, "");
        Dialogs.showMessageDialog("Ei viela toimi");
        poistaPelaaja();
    }
    
    // Tallentaa muutokset tiedostoon. Myohemmin exit-dialogi.
    @FXML void handleTallenna(ActionEvent event) {
        tallenna();
        Dialogs.showMessageDialog("Tallennettu!");
    }
    
    // KESKEN. Ennustetaan pelin todennakoinen lopputulos kahden joukkueen valilla. Perustuu joukkuekortin ja pelaajakorttien tietoihin.
    @FXML void handleEnnusta(ActionEvent event) {
        // ModalController.showModal(PaaikkunaController.class.getResource("Ennustaja1.fxml"), "Ennuste", null, "");
        Dialogs.showMessageDialog("Ei viela toimi");
        ennusta();
    }

    // KESKEN. Avaa default-varoitusikkunassa manuaalin
    @FXML void handleOhje(ActionEvent event) {
        Dialogs.showMessageDialog("Tahan tulee manuaali");
    }

    // KESKEN. Poistutaan ohjelmasta. Mahdollisesti exit-dialogi "oletko varma etta poistut" default-varoitusikkunan avulla
    @FXML void handlePoistu(ActionEvent event) { 
        tallenna();
        Dialogs.showMessageDialog("Tallennettu! Nakemiin");
        Platform.exit();
    }

    // KESKEN. etusivun hakukentta josta haetaan pelaajia regexpin rajoitteilla.
    @FXML void handleHakuehto(ActionEvent event) {
        String hakukentta = kirjoitaHakuPelaaja.getSelectedText();
        String ehto = hakuehtoPelaaja.getText(); 
        if ( ehto.isEmpty() )
            naytaVirhe(null);
        else
            naytaVirhe("Ei osata vielä hakea " + hakukentta + ": " + ehto);
    }

    
    private String nhltietokannannimi = "anari";
    
    /**
     * ei kaytossa
     */
    public PaaikkunaController() {
        // KESKEN
    }
    
    // KESKEN
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        alusta();      
    }       
    
     
//===========================================================================================    
// Tästä eteenpäin ei käyttöliittymään suoraan liittyvää koodia    
     
    private NHLtietokanta nhltietokanta;
    private Pelaaja pelaajaKohdalla;
    private Joukkue joukkueKohdalla;
    private TextArea areaPelaaja = new TextArea();
    private TextArea areaJoukkue = new TextArea();
    
    /**
     * Tekee tarvittavat muut alustukset, vaihdettu HT5:ssa tilalle
     * yksi iso tekstikentta, johon voidaan tulostaa pelaajien ja joukkueiden tiedot omissa tab-valilehdissaan.
     * Alustetaan pelaajalistan kuuntelija. Myohemmin muutetaan dummyt pois. 
     */
    protected void alusta() {
        panelPelaaja.setContent(areaPelaaja);
        areaPelaaja.setFont(new Font("Courier New", 12));
        panelPelaaja.setFitToHeight(true);
        
        chooserPelaajat.clear();
        chooserPelaajat.addSelectionListener(e -> naytaPelaaja());
        
        panelJoukkue.setContent(areaJoukkue);
        areaJoukkue.setFont(new Font("Courier New", 12));
        panelJoukkue.setFitToHeight(true);
        
        chooserJoukkueet.clear();
        chooserJoukkueet.addSelectionListener(e -> naytaJoukkue());
    }
    
    // KESKEN. Virheen kasittely.
    private void naytaVirhe(String virhe) {
        if ( virhe == null || virhe.isEmpty() ) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("VIRHE!");
            return;
        }
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("VIRHE!");
    }
    
    // Hakuehdon otsikko
    private void setTitle(String title) {
        ModalController.getStage(hakuehtoPelaaja).setTitle(title);
    }
    
    
    /**
     * Alustaa nhltietokannan lukemalla sen valitun nimisestä kansiosta/tiedostosta
     * @param nimi tiedosto josta nhltietokannan tiedot luetaan
     * @return null jos onnistuu, muuten virhe tekstinä
     */
    protected String lueTiedosto(String nimi) {
        nhltietokannannimi = nimi;
        setTitle("NHLtietokanta - " + nhltietokannannimi);
        try {
            nhltietokanta.lueTiedostosta(nimi);
            haePelaaja(0);
            haeJoukkue(0);
            return null;
        } catch (Taustaoperaatiot.SailoException e) {
            haePelaaja(0);
            haeJoukkue(0);
            String virhe = e.getMessage(); 
            if ( virhe != null ) Dialogs.showMessageDialog(virhe);
            return virhe;
        }
     }

    
    /**
     * Kysytään tiedoston nimi ja luetaan se
     * @return true jos onnistui, false jos ei
     */
    public boolean avaa() {
        String uusinimi = NHLtietokannanNimiController.kysyNimi(null, nhltietokannannimi);
        if (uusinimi == null) return false;
        lueTiedosto(uusinimi);
        return true;
    }

    
    /**
     * Tietojen tallennus
     * @return null jos onnistuu, muuten virhe tekstinä
     */
    private String tallenna() {
        try {
            nhltietokanta.tallenna();
            return null;
        } catch (Taustaoperaatiot.SailoException ex) {
            Dialogs.showMessageDialog("Tallennuksessa ongelmia! " + ex.getMessage());
            return ex.getMessage();
        }
    }


    /**
     * Tarkistetaan onko tallennus tehty
     * @return true jos saa sulkea sovelluksen, false jos ei
     */
    public boolean voikoSulkea() {
        // tallenna();
        return true;
    }
    
    
    /**
     * KESKEN
     */
    protected void muokkaaPelaaja() {
        //
    }
    
    
    /**
     * KESKEN
     */
    protected void poistaPelaaja() {
        //
    }
    
    
    /**
     * KESKEN
     */
    protected void ennusta() {
        //
    }
    
    /**
     * Nayttaa listasta valitun pelaajan tiedot yhteen tekstikenttaan, HT5
     */
    protected void naytaPelaaja() {
        pelaajaKohdalla = chooserPelaajat.getSelectedObject();

        if (pelaajaKohdalla == null) return;
        
        Joukkue joukkue = nhltietokanta.haeJoukkue(pelaajaKohdalla.getPelaajanJoukkueID());
        if (joukkue == null) {
            return;
        }

        areaPelaaja.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaPelaaja)) {
            pelaajaKohdalla.tulosta(os);  
            // os.println(joukkue.getNimi() + joukkue.getjoukkueID());
        }
    }
    
    /**
     * Nayttaa listasta valitun joukkueen tiedot yhteen tekstikenttaan, HT5
     */
    protected void naytaJoukkue() {
        joukkueKohdalla = chooserJoukkueet.getSelectedObject();

        if (joukkueKohdalla == null) return;

        areaJoukkue.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaJoukkue)) {
            joukkueKohdalla.tulosta(os);  
        }
    }
    
    /**
     * Hakee pelaajien tiedot listaan
     * @param pnro pelaajan numero, joka aktivoidaan haun peraan
     */
    protected void haePelaaja(int pnro) {
        chooserPelaajat.clear();

        int index = 0;
        for (int i = 0; i < nhltietokanta.getPelaajia(); i++) {
            Pelaaja pelaaja = nhltietokanta.annaPelaaja(i);
            if (pelaaja.getPelaajaID() == pnro) {
                index = i;
            }
            chooserPelaajat.add(pelaaja.getNimi(), pelaaja);
        }
        chooserPelaajat.setSelectedIndex(index);
    }
    
    
    /**
     * Hakee joukkueiden tiedot listaan
     * @param jnro pelaajan numero, joka aktivoidaan haun peraan
     */
    protected void haeJoukkue(int jnro) {
        chooserJoukkueet.clear();

        int index = 0;
        for (int i = 0; i < nhltietokanta.getJoukkueita(); i++) {
            Joukkue joukkue = nhltietokanta.annaJoukkueIndeksi(i);
            
            if (joukkue.getjoukkueID() == jnro) {
                index = i;
            }
            chooserJoukkueet.add(joukkue.getNimi(), joukkue);
        }
        chooserJoukkueet.setSelectedIndex(index);
    }

    
    /**
     * Luo uuden pelaajan
     */
    protected void uusiPelaaja() {
            
        Pelaaja uusi = new Pelaaja();
        uusi.rekisteroi();
        
        int arvotaanJoukkue = rand(1, nhltietokanta.getJoukkueita()); //arvotaan joukkue HT5-vaiheessa
        
        uusi.vastaaSidneyCrosby(arvotaanJoukkue); //laitetaan arvottu joukkue (argumenttina) ja muut tiedot pelaajalle HT5

        try {
            nhltietokanta.lisaa(uusi);
        } catch (Taustaoperaatiot.SailoException e) {
            Dialogs.showMessageDialog("VIRHE: " + e.getMessage());
            return;
        }
        haePelaaja(uusi.getPelaajaID());
    }
    
    
    /**
     * Satunnaislukugeneraattori, kaytetaan kun luodaan ID-numeroita
     * @param ala alaraja
     * @param yla ylaraja
     * @return palauttaa luvun ala ja ylarajan valilta
     */
    public static int rand(int ala, int yla) {
        double n = (yla-ala)*Math.random() + ala;
        return (int)Math.round(n);
      }
    
    /** 
     * Luo uuden joukkueen
    */
    public void uusiJoukkue() { 
        Joukkue uusi = new Joukkue();
        uusi.rekisteroi();
        uusi.vastaaPittsburghPenguins();
        nhltietokanta.lisaa(uusi);

        haeJoukkue(uusi.getjoukkueID());         
    } 
    
 

    /**
     * @param nhltietokanta NHL-tietokanta joka kaytossa
     */
    public void setNHLtietokanta(NHLtietokanta nhltietokanta) {
        this.nhltietokanta = nhltietokanta;
        naytaPelaaja();
    }

      
    /**
     * Tulostaa pelaajan tiedot
     * @param os tietovirta johon tulostetaan
     * @param pelaaja tulostettava pelaaja
     */
    public void tulosta(PrintStream os, final Pelaaja pelaaja) {
        os.println("----------------------------------------------");
        pelaaja.tulosta(os);
        os.println("----------------------------------------------");
        Joukkue joukkue = nhltietokanta.annaJoukkue(pelaaja.getPelaajanJoukkueID());   
        joukkue.tulosta(os);  
    }
    
    
    
    /**
     * Tulostaa listassa olevat pelaajat tekstialueeseen
     * @param text alue johon tulostetaan
     */
    public void tulostaValitut(TextArea text) {
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(text)) {
            os.println("Tulostetaan kaikki pelaajat:");
            for (int i = 0; i < nhltietokanta.getPelaajia(); i++) {
                Pelaaja pelaaja = nhltietokanta.annaPelaaja(i);
                tulosta(os, pelaaja);
                os.println("\n\n");
            }
        }
    }
}