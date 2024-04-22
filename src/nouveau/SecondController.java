/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nouveau;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author JadeReynah
 */
public class SecondController implements Initializable {

    
    @FXML
    private TextField numero;
    @FXML
    private TextField adresse;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField nom;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        open();
       
    }   
    
    
    
    
    
    private Stage primaryStage;
    private void open() {
        
         // Créer un FileChooser
        FileChooser fileChooser = new FileChooser();

        // Appliquer des filtres si nécessaire
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers texte (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Afficher le FileChooser et attendre la sélection du fichier
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

     
        if (selectedFile != null) {
           
            openFicher(selectedFile);
        } else {
            // Gérer le cas où l'utilisateur annule la sélection
            System.out.println("Aucun fichier sélectionné.");
        }
    }
    private void openFicher(File file){
          
        try (BufferedReader lire = new BufferedReader(new FileReader(file))) {
            String line ;
            ArrayList<String> liste = new ArrayList<>();
      
            while((line = lire.readLine())!=null){
                   liste.add(line);
                   System.out.println(line);
   
            }
             nom.setText(liste.get(0));
             prenom.setText(liste.get(1));
             adresse.setText(liste.get(2));
             numero.setText(liste.get(3));
             email.setText(liste.get(4));
        }
        catch (IOException e) {
            System.out.println("javafxapplication1.NewFXMain.openFicher()");
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
        enregistrement(nom.getText(), prenom.getText(), adresse.getText(), numero.getText(), email.getText());
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Myapp");
        alert.setContentText("La modifiation a ete bien effectuer");
        alert.showAndWait();
        second.fenet1.close();
       
    }

    private void enregistrement(String nom,String prenom, String adresse, String numero,String email) {
   
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nom+".txt"))) {
                writer.write( nom+"\n");
                
                writer.write( prenom +"\n");
               
                writer.write(adresse+"\n");
            
                writer.write(numero+"\n");
           
                writer.write(email+"\n");
          
                System.out.println(email);
            

        }catch(IOException e){
            System.out.println("Erreur de enregitrement");
        }
    }

    @FXML
    private void annuler(ActionEvent event) {
        second.fenet1.close();
    }
}
