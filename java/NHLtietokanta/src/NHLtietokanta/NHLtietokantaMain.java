package NHLtietokanta;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import Taustaoperaatiot.NHLtietokanta;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@student.jyu.fi
 * @version 1.2 23.4.2020
 *
 * Paaohjelma NHL-tietokantaohjelman kaynnistamiseksi
 */
public class NHLtietokantaMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            final FXMLLoader ldr = new FXMLLoader(getClass().getResource("NHLtietokantaGUIView.fxml")); //paaikkuna
            final Pane root = ldr.load();
            final NHLtietokantaGUIController nhlCtrl = (NHLtietokantaGUIController)ldr.getController();
            
            final Scene scene = new Scene(root);
            
            scene.getStylesheets().add(getClass().getResource("nhltietokanta.css").toExternalForm()); //tyylitiedosto
            primaryStage.setScene(scene);
            primaryStage.setTitle("NHLtietokanta");
            
            primaryStage.setOnCloseRequest((event) -> {
                if ( !nhlCtrl.voikoSulkea() ) event.consume();
            }); 
            
            NHLtietokanta nhltietokanta = new NHLtietokanta();
            nhlCtrl.setNHLtietokanta(nhltietokanta);
            
            primaryStage.show();
            if ( !nhlCtrl.avaa() ) Platform.exit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Kaynnistetaan kayttoliittyma elikkas koko roska
     * @param args komentorivin parametrit
     */
    public static void main(String[] args) {
        launch(args);
    }
}