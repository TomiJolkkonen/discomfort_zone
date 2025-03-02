package NHLtietokanta;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * Pelien ennustamiseen liittyva luokka, toinen valilehti jossa valitaan toinen joukkue
 * 
 * @author Tomi Jolkkonen
 * @version 1.0 27.2.2020
 */
    public class Ennustaja2Controller implements ModalControllerInterface<String> {
    
    @FXML private Button handleEnnusta;

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
        
    };
    
}