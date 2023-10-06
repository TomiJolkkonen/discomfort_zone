package NHLtietokanta;

import Taustaoperaatiot.Joukkue;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Joukkuekortin hoitava luokka, tassa muokataan tai lisataan joukkueen tietoja 
 * 
 * @author Tomi Jolkkonen
 * @version 1.2 23.4.2020
 */
    public class JoukkuekorttiController implements ModalControllerInterface<Joukkue>,Initializable {
    
    @FXML private TextField editNimi;
    @FXML private TextField editKonferenssi;
    @FXML private TextField editDivisioona;
    @FXML private TextField editOttelut; 
    @FXML private TextField editPisteet;
    @FXML private TextField editMaalivahdit;
    @FXML private TextField editPuolustajat;
    @FXML private TextField editHyokkaajat;    
    @FXML private TextField editValmentaja;
    @FXML private TextField editLoukkaantuneet;
    @FXML private Label labelVirhe;
        
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        alusta();  
    }
  
    
    /**
     * OK-nappi, jossa virheentarkistukset
     */
    @FXML private void handleDefaultOK(@SuppressWarnings("unused") ActionEvent event) {
        
        if ( joukkueKohdalla != null && joukkueKohdalla.getNimi().trim().equals("") ) {
            naytaVirhe("Nimi ei saa olla tyhjä");
            return;
        }
        if ( joukkueKohdalla != null && joukkueKohdalla.getKonferenssi().trim().equals("") ) {
            naytaVirhe("Konferenssi ei saa olla tyhjä");
            return;
        }
        if ( joukkueKohdalla != null && joukkueKohdalla.getDivisioona().trim().equals("") ) {
            naytaVirhe("Divisioona ei saa olla tyhjä");
            return;
        }
        
        try {
            Integer.parseInt(editOttelut.getText());
        } catch (NumberFormatException nfe) {
            naytaVirhe("Ottelut pitää olla numero");
            return;
        }
        
        try {
            Integer.parseInt(editPisteet.getText());
        } catch (NumberFormatException nfe) {
            naytaVirhe("Pisteet pitää olla numero");
            return;
        }
        
        if ( joukkueKohdalla != null && joukkueKohdalla.getMaalivahdit().trim().equals("") ) {
            naytaVirhe("Maalivahdit ei saa olla tyhjä");
            return;
        }
        if ( joukkueKohdalla != null && joukkueKohdalla.getPuolustajat().trim().equals("") ) {
            naytaVirhe("Puolustajat ei saa olla tyhjä");
            return;
        }
        if ( joukkueKohdalla != null && joukkueKohdalla.getHyokkaajat().trim().equals("") ) {
            naytaVirhe("Hyökkääjät ei saa olla tyhjä");
            return;
        }
        ModalController.closeStage(labelVirhe);
    }
    
    
    /**
     * Cancel-nappi
     */
    @FXML private void handleDefaultCancel(@SuppressWarnings("unused") ActionEvent event) {
        joukkueKohdalla = null;
        ModalController.closeStage(labelVirhe);
    }


    
    /**
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param oletus mitä dataan näytetään oletuksena
     * @return null jos painetaan Cancel, muuten täytetty tietue
     */
    public static Joukkue kysyJoukkue(Stage modalityStage, Joukkue oletus) {
        return ModalController.<Joukkue, JoukkuekorttiController>showModal(
                    JoukkuekorttiController.class.getResource("Joukkuekortti.fxml"),
                    "NHL-tietokanta",
                    modalityStage, oletus, null 
                );
    }

    
    /**
     * nayta tulos
     */
    @Override
    public Joukkue getResult() {
        return joukkueKohdalla;
    }

    
    /**
     * handleri
     */
    @Override
    public void handleShown() {
        editNimi.requestFocus();       
    }

    
    private Joukkue joukkueKohdalla;
    private TextField edits[];

    /**
     * Tyhjentään tekstikentät 
     * @param edits tauluko jossa tyhjennettäviä tektsikenttiä
     */
    public static void tyhjenna(TextField[] edits) {
        for (TextField edit : edits)
            edit.setText("");
    }


    /**
     * Tekee tarvittavat muut alustukset
     */
    protected void alusta() {
        edits = new TextField[]{editNimi, editKonferenssi, editDivisioona, editOttelut, editPisteet, editMaalivahdit, editPuolustajat, editHyokkaajat, editValmentaja, editLoukkaantuneet};
        
        int i = 0;
            for (TextField edit : edits) {
            final int k = ++i;
            edit.setOnKeyReleased( e -> kasitteleMuutosJoukkueeseen(k, (TextField)(e.getSource())));
         }
    }
    
    
    /**
     * defaultti
     */
    @Override
    public void setDefault(Joukkue oletus) {
        joukkueKohdalla = oletus;
        naytaJoukkue(edits, joukkueKohdalla);
        
    }
    
    /**
     * virhelabeli jota voi käyttää viestien näyttämiseen
     */
    private void naytaVirhe(String virhe) {
        if ( virhe == null || virhe.isEmpty() ) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("virhe");
            return;
        }
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("virhe");
    }

    
    /**
     * Käsitellään joukkueeseen tullut muutos
     * @param edit muuttunut kenttä
     */
    private void kasitteleMuutosJoukkueeseen(int k, TextField edit) {
        if (joukkueKohdalla == null) return;
        String s = edit.getText();
        String virhe = null;
        switch (k) {
           case 1 : virhe = joukkueKohdalla.setNimi(s); break;
           case 2 : virhe = joukkueKohdalla.setKonferenssi(s); break;
           case 3 : virhe = joukkueKohdalla.setDivisioona(s); break;
           case 4 : virhe = joukkueKohdalla.setOttelut(s); break;
           case 5 : virhe = joukkueKohdalla.setPisteet(s); break;
           case 6 : virhe = joukkueKohdalla.setMaalivahdit(s); break;
           case 7 : virhe = joukkueKohdalla.setPuolustajat(s); break;
           case 8 : virhe = joukkueKohdalla.setHyokkaajat(s); break;
           case 9 : virhe = joukkueKohdalla.setValmentaja(s); break;
           case 10 : virhe = joukkueKohdalla.setLoukkaantuneet(s); break;
           default:
        }
        if (virhe == null) {
            Dialogs.setToolTipText(edit,"");
            edit.getStyleClass().removeAll("virhe");
            naytaVirhe(virhe);
        } else {
            Dialogs.setToolTipText(edit,virhe);
            edit.getStyleClass().add("virhe");
            naytaVirhe(virhe);
        }
    }
    
    
    /**
     * Näytetään joukkueen tiedot TextField komponentteihin
     * @param edits taulukko jossa tekstikenttiä
     * @param joukkue näytettävä joukkue
     */
    public static void naytaJoukkue(TextField[] edits, Joukkue joukkue) {
        if (joukkue == null) return;
        edits[0].setText(joukkue.getNimi());
        edits[1].setText(joukkue.getKonferenssi());
        edits[2].setText(joukkue.getDivisioona());
        edits[3].setText("" + joukkue.getOttelut());
        edits[4].setText("" + joukkue.getPisteet());
        edits[5].setText(joukkue.getMaalivahdit());
        edits[6].setText(joukkue.getPuolustajat());
        edits[7].setText(joukkue.getHyokkaajat());
        edits[8].setText(joukkue.getValmentaja());
        edits[9].setText(joukkue.getLoukkaantuneet());
    }

}