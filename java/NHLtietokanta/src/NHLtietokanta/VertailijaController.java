package NHLtietokanta;

import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Taustaoperaatiot.Joukkue;
import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * KESKEN!
 * Tähän tulee kahden joukkueen vertailu keskenään perustuen numeraalisiin tietoihin
 * Parempi joukkue näytetään vertailun lopputuloksena. Tätä tarkoitus laajentaa myöhemmin 
 * kaikkeen NHL-statistiikkaan sekä tehdä hienot algoritmit kuhan joskus ehtis..
 * 
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.1 23.4.2020
 */
    public class VertailijaController implements ModalControllerInterface<String> {
    
    @FXML private Button handleDefaultCancel;
    @FXML private Button handleVertaile;
    @FXML private TextField hakuehtoVertailuYksi;
    @FXML private TextField hakuehtoVertailu2;
    @FXML private ComboBoxChooser<Joukkue> cbKentatYksi;
    @FXML private ComboBoxChooser<Joukkue> cbKentatKaksi;
    @FXML private Label vertailunTulos;
    @FXML private Label labelVirhe;

    /**
     * Vertaile-nappi
     */
    @FXML private void handleVertaile(@SuppressWarnings("unused") ActionEvent event) {
        Dialogs.showMessageDialog("Ei osata vielä");
    }
    
    
    /**
     * Cancel-nappi
     */
    @FXML private void handleDefaultCancel(@SuppressWarnings("unused") ActionEvent event) {
        ModalController.closeStage(labelVirhe);
    }

    
    /**
     * nayta tulos
     */
    @Override
    public String getResult() {
        return null;
    }

    
    /**
     * handleri
     */
    @Override
    public void handleShown() {
        // Kesken vielä
        
    }

    
    /**
     * defaultti
     */
    @Override
    public void setDefault(String oletus) {
        // Kesken vielä
        
    }
    
}