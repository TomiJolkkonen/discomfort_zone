package NHLtietokanta;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
/**
 * Ohjeen hoitava luokka, tahan tulostuu manuaali jossa olennaisimmat tiedot ohjelman kaytosta
 * Ei tehda erillista popuppia, jolloin tarvittaisiin fxml-tiedosto seka kontrolleri, vaan
 * tulostetaan default-huomioikkunaan
 * 
 * @author Tomi Jolkkonen
 * @version 1.0 27.2.2020
 */
    public class OhjeController implements ModalControllerInterface<String> {
    
    // Cancel-nappi
    @FXML private void handleDefaultCancel(ActionEvent event) {
        //
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(String oletus) {
        // TODO Auto-generated method stub
        
    }

}
