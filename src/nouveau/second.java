/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package nouveau;

import java.io.IOException;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author JadeReynah
 */
public class second extends Preloader {
    
    ProgressBar bar;
    Stage stage;
    static Stage fenet1;
    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        return new Scene(p, 300, 150);        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());        
        stage.show();
    }
    
  public void fenetre1(Stage fenetre){
       try {
            // Charger le fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("premier.fxml"));
            // Configurer la scène
            Scene scene1 = new Scene(root);

            // Configurer le stage (fenêtre principale)
            fenetre.setTitle("Myapp");
            fenetre.setScene(scene1);
            fenetre.show();
        } catch (IOException e) {
        }
  }
  public void fenetre2(Stage fenetre){
       try {
           fenet1=  fenetre;
            // Charger le fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("second.fxml"));
            // Configurer la scène
            Scene scene1 = new Scene(root);

            // Configurer le stage (fenêtre principale)
            fenet1.setTitle("Myapp2");
            fenet1.setScene(scene1);
            fenet1.show();
            
        } catch (IOException e) {
        }
  }
    public void fenetre3(Stage fenetre){
       try {
            
            // Charger le fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
            // Configurer la scène
            Scene scene1 = new Scene(root);

            // Configurer le stage (fenêtre principale)
            fenetre.setTitle("Myapp");
            fenetre.setScene(scene1);
            fenetre.show();
            
        } catch (IOException e) {
        }
  }

 
}
