package NHLtietokanta;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Tulostuksen hoitava luokka, tulostaa ruudulle pelaajia ja joukkueita
 * 
 * @author Tomi Jolkkonen
 * @version 1.0 27.2.2020
 */
public class TulostusController implements ModalControllerInterface<String> {
    @FXML TextArea tulostusAlue;
    
  
    // OK-nappi
    @FXML private void handleDefaultOK(ActionEvent event) {
        ModalController.closeStage(tulostusAlue);
    }

    // tulosta-nappi
    @FXML private void handleTulosta(ActionEvent event) {
        Dialogs.showMessageDialog("Ei osata vielä tulostaa");
    }

    
    @Override
    public String getResult() {
        return null;
    } 

    
    @Override
    public void setDefault(String oletus) {
        // if ( oletus == null ) return;
        tulostusAlue.setText(oletus);
    }

    
    /**
     * Mitä tehdään kun dialogi on näytetty
     */
    @Override
    public void handleShown() {
        //
    }
    
    
    /**
     * @return alue johon tulostetaan
     */
    public TextArea getTextArea() {
        return tulostusAlue;
    }
    
    
    /**
     * Näyttää tulostusalueessa tekstin
     * @param tulostus tulostettava teskti
     * @return kontrolleri, jolta voidaan pyytää lisää tietoa
     */
    public static TulostusController tulosta(String tulostus) {
        TulostusController tulostusCtrl = 
          ModalController.showModeless(TulostusController.class.getResource("Tulostus.fxml"),
                                       "Tulostus", tulostus);
        return tulostusCtrl;
    }

}
