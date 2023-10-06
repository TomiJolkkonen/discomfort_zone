package NHLtietokanta;

import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Kysytaan ohjelman kaynnistyessa nhltietokannan nimi
 * Jos kaytetaan olemassaolevaa tietokantaa, ladataan tiedostot 
 * Jos annetaan uusi nimi, sille syntyy oma kansio ja sinne pelaajat.dat ja joukkueet.dat
 * Aina kun tehdään muutoksia, syntyy myös backup-tiedostot
 * 
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.3 23.4.2020
 */
public class NHLtietokannanNimiController implements ModalControllerInterface<String> {
    
    /**
     * tahan kirjoitetaan tietokannan nimi
     */
    @FXML private TextField textVastaus;
    private String vastaus = null;

    
    /**
     * OK-nappi
     */
    @FXML private void handleOK() {
        vastaus = textVastaus.getText();
        ModalController.closeStage(textVastaus);
    }

    
    /**
     * Cancel-nappi
     */
    @FXML private void handleCancel() {
        ModalController.closeStage(textVastaus);
    }

    
    /**
     * Annetaan vastaus
     */
    @Override
    public String getResult() {
        return vastaus;
    }

    
    /**
     * Vastaus defaultiksi
     */
    @Override
    public void setDefault(String oletus) {
        textVastaus.setText(oletus);
    }

    
    /**
     * Dialogin nayttamisen jalkeen
     */
    @Override
    public void handleShown() {
        textVastaus.requestFocus();
    }
    
    
    /**
     * Luodaan nimenkysymisdialogi, palautetaan siihen kirjoitettu nimi taikka nulli
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param oletus mita nimea naytetaan oletuksena, eli edellinen kansio elikkas tietokanta
     * @return null jos painetaan Cancel, muuten kirjoitettu nimi
     */
    public static String kysyNimi(Stage modalityStage, String oletus) {
        return ModalController.showModal(
                NHLtietokannanNimiController.class.getResource("NHLtietokannanNimiView.fxml"),
                "NHL-tietokanta",
                modalityStage, oletus);
    }
}
