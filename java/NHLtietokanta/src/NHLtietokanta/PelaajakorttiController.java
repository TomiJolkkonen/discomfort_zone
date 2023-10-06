package NHLtietokanta;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Taustaoperaatiot.Pelaaja;

/**
 * Pelaajakortin hoitava luokka, pelaajakortissa tapahtuu pelaajan tietojan lisaaminen ja muokkaaminen
 * 
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.2 23.4.2020
 */
    public class PelaajakorttiController implements ModalControllerInterface<Pelaaja>,Initializable{
    
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
        @FXML private Label labelVirhe;
       
        
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        alusta();  
    }
        
    
    /**
     * OK-nappi, jossa virheentarkistukset
     */
    @FXML private void handleDefaultOK(@SuppressWarnings("unused") ActionEvent event) {       
        
        if ( pelaajaKohdalla != null && pelaajaKohdalla.getNimi().trim().equals("") ) {
            naytaVirhe("Nimi ei saa olla tyhjä");
            return;
        }
        if ( pelaajaKohdalla != null && pelaajaKohdalla.getJoukkue().trim().equals("") ) {
            naytaVirhe("Joukkue ei saa olla tyhjä");
            return;
        }
        if ( pelaajaKohdalla != null && pelaajaKohdalla.getPelipaikka().trim().equals("") ) {
            naytaVirhe("Pelipaikka ei saa olla tyhjä");
            return;
        }
        
        try {
            Integer.parseInt(editPelatutPelit.getText());
        } catch (NumberFormatException nfe) {
            naytaVirhe("Pelatut pelit pitää olla numero");
            return;
        }
        
        try {
            Integer.parseInt(editJaaaikaMin.getText());
        } catch (NumberFormatException nfe) {
            naytaVirhe("Jääaika(min) pitää olla numero");
            return;
        }
        
        try {
            Integer.parseInt(editMaalit.getText());
        } catch (NumberFormatException nfe) {
            naytaVirhe("Maalit pitää olla numero");
            return;
        }
        
        try {
            Integer.parseInt(editSyotot.getText());
        } catch (NumberFormatException nfe) {
            naytaVirhe("Syötöt pitää olla numero");
            return;
        }
        
        try {
            Integer.parseInt(editPisteet.getText());
        } catch (NumberFormatException nfe) {
            naytaVirhe("Pisteet pitää olla numero");
            return;
        }
        
        ModalController.closeStage(labelVirhe);
    }
    
    
    /**
     * Cancel-nappi
     */
    @FXML private void handleDefaultCancel(@SuppressWarnings("unused") ActionEvent event) {
        pelaajaKohdalla = null;
        ModalController.closeStage(labelVirhe);
    }


    /**
     * nayta tulos
     */
    @Override
    public Pelaaja getResult() {
        return pelaajaKohdalla;
    }

    
    /**
     * handleri
     */
    @Override
    public void handleShown() {
        editNimi.requestFocus();   
    }
    
    
    private Pelaaja pelaajaKohdalla;
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
        edits = new TextField[]{editNimi, editJoukkue, editPelipaikka, editPelatutPelit, editJaaaikaMin, editMaalit, editSyotot, editPisteet, editPlusMiinus, editAloitukset, editCorsi, editLoukkaantunut};
        int i = 0;
        for (TextField edit : edits) {
            final int k = ++i;
            edit.setOnKeyReleased( e -> kasitteleMuutosPelaajaan(k, (TextField)(e.getSource())));
        }
    }
    
    
    /**
     * defaultti
     */
    @Override
    public void setDefault(Pelaaja oletus) {
        pelaajaKohdalla = oletus;
        naytaPelaaja(edits, pelaajaKohdalla);   
    }
    
    
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
     * Käsitellään pelaajaan tullut muutos
     * @param edit muuttunut kenttä
     */
    private void kasitteleMuutosPelaajaan(int k, TextField edit) {
        if (pelaajaKohdalla == null) return;
        String s = edit.getText();
        String virhe = null;
        switch (k) {
           case 1 : virhe = pelaajaKohdalla.setNimi(s); break;
           case 2 : virhe = pelaajaKohdalla.setJoukkue(s); break;
           case 3 : virhe = pelaajaKohdalla.setPelipaikka(s); break;
           case 4 : virhe = pelaajaKohdalla.setPelatutPelit(s); break;
           case 5 : virhe = pelaajaKohdalla.setJaaaikaMin(s); break;
           case 6 : virhe = pelaajaKohdalla.setMaalit(s); break;
           case 7 : virhe = pelaajaKohdalla.setSyotot(s); break;
           case 8 : virhe = pelaajaKohdalla.setPisteet(s); break;
           case 9 : virhe = pelaajaKohdalla.setPlusMiinus(s); break;
           case 10 : virhe = pelaajaKohdalla.setAloitukset(s); break;
           case 11 : virhe = pelaajaKohdalla.setCorsi(s); break;
           case 12 : virhe = pelaajaKohdalla.setLoukkaantunut(s); break;
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
     * Näytetään pelaajan tiedot TextField komponentteihin
     * @param edits taulukko jossa tekstikenttiä
     * @param pelaaja näytettävä pelaaja
     */
    public static void naytaPelaaja(TextField[] edits, Pelaaja pelaaja) {
        if (pelaaja == null) return;
        edits[0].setText(pelaaja.getNimi());
        edits[1].setText(pelaaja.getJoukkue());
        edits[2].setText(pelaaja.getPelipaikka());
        edits[3].setText("" + pelaaja.getPelatutPelit());
        edits[4].setText("" + pelaaja.getJaaaikaMin());
        edits[5].setText("" + pelaaja.getMaalit());
        edits[6].setText("" + pelaaja.getSyotot());
        edits[7].setText("" + pelaaja.getPisteet());
        edits[8].setText("" + pelaaja.getPlusMiinus());
        edits[9].setText("" + pelaaja.getAloitukset());
        edits[10].setText("" + pelaaja.getCorsi());
        edits[11].setText(pelaaja.getLoukkaantunut());
    }
    
    
    /**
     * Luodaan jäsenen kysymisdialogi ja palautetaan sama tietue muutettuna tai null
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param oletus mitä dataan näytetään oletuksena
     * @return null jos painetaan Cancel, muuten täytetty tietue
     */
    public static Pelaaja kysyPelaaja(Stage modalityStage, Pelaaja oletus) {
        return ModalController.<Pelaaja, PelaajakorttiController>showModal(
                    PelaajakorttiController.class.getResource("Pelaajakortti.fxml"),
                    "NHL-tietokanta",
                    modalityStage, oletus, null 
                );
    }

}
