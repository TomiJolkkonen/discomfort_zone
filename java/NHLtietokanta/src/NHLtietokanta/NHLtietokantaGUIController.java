package NHLtietokanta;

import java.io.PrintStream;
import java.net.URL;
import java.util.Collection;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import Taustaoperaatiot.Pelaaja;
import Taustaoperaatiot.NHLtietokanta;
import Taustaoperaatiot.Joukkue;
import Taustaoperaatiot.SailoException;

/**
 * Luokka NHL-tietokannan kayttoliittyman tapahtumien hoitamiseksi
 * 
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.7 23.4.2020
 *
 */

public class NHLtietokantaGUIController implements Initializable {
    
    /**
     * elementit fxml-tiedostoista
     */
    @FXML private TextField hakuehtoPelaaja;
    @FXML private TextField hakuehtoJoukkue;
    @FXML private ComboBoxChooser<String> cbKentatPelaaja;
    @FXML private ComboBoxChooser<String> cbKentatJoukkue;
    @FXML private ListChooser<Pelaaja> chooserPelaajat;
    @FXML private ListChooser<Joukkue> chooserJoukkueet;
    @FXML private ScrollPane panelPelaaja;
    @FXML private ScrollPane panelJoukkue;
    @FXML private Label labelVirhe;
    @FXML private TextField editNimi;
    @FXML private TextField editJoukkue;
    @FXML private TextField editPelipaikka;
    @FXML private TextField editPelatutPelit; 
    @FXML private TextField editJaaaikaMin;
    @FXML private TextField editMaalit;
    @FXML private TextField editSyotot;
    @FXML private TextField editPisteet;    
    @FXML private TextField editPlusMiinus;
    @FXML private TextField editAloitukset;
    @FXML private TextField editCorsi;
    @FXML private TextField editLoukkaantunut;
    
    
    /**
     * uuden pelaajan lisaaminen
     */
    @FXML void handleuusiPelaaja(@SuppressWarnings("unused") ActionEvent event) {
        uusiPelaaja();
    }
    
    
    /**
     * uuden joukkueen lisaaminen
     */
    @FXML void handleuusiJoukkue(@SuppressWarnings("unused") ActionEvent event) {
        uusiJoukkue();
    }
    
    
    /**
     * muokataan pelaajaa pelaajakortin kautta
     */
    @FXML void handlemuokkaaPelaajaa(@SuppressWarnings("unused") ActionEvent event) {
        muokkaaPelaajaa();
    }
    
    
    /**
     * muokataan joukkuetta joukkuekortin kautta
     */
    @FXML void handlemuokkaaJoukkuetta(@SuppressWarnings("unused") ActionEvent event) {
        muokkaaJoukkuetta();
    }
    
    
    /**
     * poistetaan pelaaja
     */
    @FXML void handlepoistaPelaaja(@SuppressWarnings("unused") ActionEvent event) {
        poistaPelaaja();
    }
    
    
    /**
     * poistetaan joukkue
     */
    @FXML void handlepoistaJoukkue(@SuppressWarnings("unused") ActionEvent event) {
        poistaJoukkue();
    }
    
    
    /**
     * Tallentaa muutokset tiedostoon
     */
    @FXML void handleTallenna(@SuppressWarnings("unused") ActionEvent event) {
        tallenna();
        Dialogs.showMessageDialog("Tallennettu!");
    }
    
    
    /**
     * KESKEN, vertaillaan kahden joukkueen statistiikkaa keskenään
     * Perustuu joukkuekortin ja pelaajakorttien tietoihin jq myöhemmin algoritmeihin ja tilastoihin
     */
    @FXML void handleVertaile(@SuppressWarnings("unused") ActionEvent event) {
        vertaile();
    }

    
    /**
     * Avaa default-varoitusikkunassa linkin manuaaliin
     */
    @FXML void handleOhje(@SuppressWarnings("unused") ActionEvent event) {
        Dialogs.showMessageDialog("Ohjelman manuaali: https://tim.jyu.fi/view/kurssit/tie/ohj2/2020k/ht/tojyjolk");
    }

    
    /**
     * Poistutaan ohjelmasta, muutokset tallennetaan ja kerrotaan siitä
     */
    @FXML void handlePoistu(@SuppressWarnings("unused") ActionEvent event) { 
        tallenna();
        Dialogs.showMessageDialog("Tallennettu! Nakemiin");
        Platform.exit();
    }

    
    /**
     * etusivun hakukentta jossa pelaajia voi hakea nimen perusteella, nimet aakkosjärjestyksessä
     */
    @FXML void handleHakuehtoPelaaja(@SuppressWarnings("unused") KeyEvent event) {
        haePelaaja(0);
    }
    
    
    /**
     * etusivun hakukentta jossa joukkueita voi hakea nimen perusteella, nimet aakkosjärjestyksessä
     */
    @FXML void handleHakuehtoJoukkue(@SuppressWarnings("unused") KeyEvent event) {
        haeJoukkue(0);
    }

    
    private String nhltietokannannimi = "anari";
    
    
    /**
     * ei kaytossa
     */
    public NHLtietokantaGUIController() {
        //
    }
    
    
    /**
     * alustus
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        alusta();      
    }       
    
     
    private NHLtietokanta nhltietokanta;
    private Pelaaja pelaajaKohdalla;
    private Joukkue joukkueKohdalla;
    private TextArea areaPelaaja = new TextArea();
    private TextArea areaJoukkue = new TextArea();
    private static Pelaaja apupelaaja = new Pelaaja(); 
    private static Joukkue apujoukkue = new Joukkue(); 
    
    
    /**
     * Tekee tarvittavat muut alustukset
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
    
    
    /**
     * virheen kasittely, alusta muullekin viestinnälle
     */
    @SuppressWarnings("unused")
    private void naytaVirhe(String virhe) {
        if ( virhe == null || virhe.isEmpty() ) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("VIRHE!");
            return;
        }
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("VIRHE!");
    }
    
    
    /**
     * Hakuehdon otsikko
     */
    private void setTitle(String title) {
        ModalController.getStage(hakuehtoPelaaja).setTitle(title);
    }
    
    
    /**
     * Alustaa nhltietokannan lukemalla sen valitun nimisestä kansiosta/tiedostosta
     * @param nimi tiedosto josta nhltietokannan tiedot luetaan
     * @return null jos onnistuu, muuten virhe tekstina
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
     * Kysytaan tiedoston nimi ja luetaan se
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
     * @return null jos onnistuu, muuten virhe huomiotekstina
     */
    private String tallenna() {
        try {
            nhltietokanta.tallenna();
            return null;
        } catch (Taustaoperaatiot.SailoException ex) {
            Dialogs.showMessageDialog("Virhe " + ex.getMessage());
            return ex.getMessage();
        }
    }

    
    /**
     * Tarkistetaan onko tallennus tehty, huom tata ei ehka tarvita talla tavalla lainkaan
     * @return true jos saa sulkea sovelluksen, false jos ei
     */
    public boolean voikoSulkea() {
        tallenna();
        return true;
    }    
    
    
    /**
     * pelaajan muokkaaminen pelaajaikkunassa
     */
    protected void muokkaaPelaajaa() {
        
        if ( pelaajaKohdalla == null ) return; 
        Pelaaja pelaaja; 
        pelaaja = PelaajakorttiController.kysyPelaaja(null, pelaajaKohdalla); 
        if ( pelaaja == null ) return; 
        nhltietokanta.korvaaTaiLisaa(pelaaja); 
        haePelaaja(pelaaja.getPelaajaID());   
    }   
    
    
    /**
     * joukkueen muokkaaminen joukkueikkunassa
     */
    protected void muokkaaJoukkuetta() {
        if ( joukkueKohdalla == null ) return; 
        try { 
            Joukkue joukkue; 
            joukkue = JoukkuekorttiController.kysyJoukkue(null, joukkueKohdalla); 
            if ( joukkue == null ) return; 
            nhltietokanta.korvaaTaiLisaa(joukkue); 
            haeJoukkue(joukkue.getJoukkueID()); 
        } catch (SailoException e) { 
            Dialogs.showMessageDialog(e.getMessage()); 
        }
    }  
    
    
    /**
     * pelaajan poistaminen tietokannasta
     */
    protected void poistaPelaaja() {
        Pelaaja pelaaja = pelaajaKohdalla;
        if ( pelaaja == null ) return;
        Dialogs.showMessageDialog("Nyt sitten lähti pelaaja");
        nhltietokanta.poista(pelaaja);
        int index = chooserPelaajat.getSelectedIndex();
        haePelaaja(0);
        chooserPelaajat.setSelectedIndex(index);
    }   
    
    
    /**
     * joukkueen poistaminen tietokannasta
     */
    protected void poistaJoukkue() {
        Joukkue joukkue = joukkueKohdalla;
        if ( joukkue == null ) return;
        Dialogs.showMessageDialog("Nyt sitten lähti joukkue");
        nhltietokanta.poistaJoukkue(joukkue);
        int index = chooserJoukkueet.getSelectedIndex();
        haeJoukkue(0);
        chooserPelaajat.setSelectedIndex(index);
    }   
    
    
    /**
     * KESKEN!
     * Vertaillaan kahta joukkuetta ja ennustetaan kumpi voittaisi seuraavan pelin
     */
    protected void vertaile() {
        ModalController.showModal(NHLtietokantaGUIController.class.getResource("Vertailija.fxml"), "Vertailija", null, "");
    }
    
    
    /**
     * Nayttaa listasta valitun pelaajan tiedot yhteen tekstikenttaan
     */
    protected void naytaPelaaja() {
        pelaajaKohdalla = chooserPelaajat.getSelectedObject();

        if (pelaajaKohdalla == null) return;

        areaPelaaja.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaPelaaja)) {
            pelaajaKohdalla.tulosta(os);  
        }
    }
    
    
    /**
     * Nayttaa listasta valitun joukkueen tiedot yhteen tekstikenttaan
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
     * @param pelaajaID pelaajan ID haun peraan
     */
    protected void haePelaaja(int pelaajaID) {
        
        int pnro = pelaajaID;
        if ( pnro <= 0 ) { 
            Pelaaja kohdalla = pelaajaKohdalla; 
            if ( kohdalla != null ) pnro = kohdalla.getPelaajaID(); 
        }
        
        int k = cbKentatPelaaja.getSelectionModel().getSelectedIndex() + apupelaaja.ekaKentta(); 
        String ehto = hakuehtoPelaaja.getText(); 
        if (ehto.indexOf('*') < 0) ehto = "*" + ehto + "*"; 
        
        chooserPelaajat.clear();

        int index = 0;
        Collection<Pelaaja> pelaajat;
        pelaajat = nhltietokanta.etsiPelaaja(ehto, k);
        int i = 0;
        for (Pelaaja pelaaja:pelaajat) {
            if (pelaaja.getPelaajaID() == pnro) index = i;
            chooserPelaajat.add(pelaaja.getNimi(), pelaaja);
            i++;
        }
        chooserPelaajat.setSelectedIndex(index);
    }
    
    
    /**
     * Hakee joukkueiden tiedot listaan
     * @param joukkueID joukkueen ID numero haun peraan
     */
    protected void haeJoukkue(int joukkueID) {
        
        int jnro = joukkueID;
        if ( jnro <= 0 ) { 
            Joukkue kohdalla = joukkueKohdalla; 
            if ( kohdalla != null ) jnro = kohdalla.getJoukkueID(); 
        }
        
        int k = cbKentatJoukkue.getSelectionModel().getSelectedIndex() + apujoukkue.ekaKentta(); 
        String ehto = hakuehtoJoukkue.getText(); 
        if (ehto.indexOf('*') < 0) ehto = "*" + ehto + "*"; 
        
        chooserJoukkueet.clear();

        int index = 0;
        Collection<Joukkue> joukkueet;
        try {
            joukkueet = nhltietokanta.etsiJoukkue(ehto, k);
            int i = 0;
            for (Joukkue joukkue:joukkueet) {
                if (joukkue.getJoukkueID() == jnro) index = i;
                chooserJoukkueet.add(joukkue.getNimi(), joukkue);
                i++;
            }
        } catch (SailoException ex) {
            Dialogs.showMessageDialog("Virhe " + ex.getMessage());
        }
        chooserJoukkueet.setSelectedIndex(index); 
    }
    
    
    /**
     * Luodaan uusi pelaaja täyttämällä pelaajakortti
     */
    protected void uusiPelaaja() {     
        Pelaaja uusi = new Pelaaja();
        uusi = PelaajakorttiController.kysyPelaaja(null, uusi);  
        if ( uusi == null ) return;
        uusi.rekisteroi();
        nhltietokanta.lisaa(uusi);
        haePelaaja(uusi.getPelaajaID());
    }   
    
    
    /** 
     * Luodaan uusi joukkue täyttämällä joukkuekortti
    */
    protected void uusiJoukkue() { 
            Joukkue uusi = new Joukkue();
            uusi = JoukkuekorttiController.kysyJoukkue(null, uusi);  
            if ( uusi == null ) return;
            uusi.rekisteroi();
            nhltietokanta.lisaa(uusi);
            haeJoukkue(uusi.getJoukkueID());
            naytaJoukkue(); 
    } 
    
    
    /**
     * @param nhltietokanta NHL-tietokanta, joka on juuri nyt kaytossa
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