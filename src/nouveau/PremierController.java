/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nouveau;

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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JadeReynah
 */
public class PremierController implements Initializable {

    @FXML
    private Menu me;
    @FXML
    private Label bien;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    private Stage primaryStage;
    @FXML
    private void open(ActionEvent event) {
    Stage wind1 = new Stage();
    second fenetre2 = new second();
    fenetre2.fenetre2(wind1);
     
    }

    @FXML
    private void about(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText("Nom de l'application : JavaFX");
        alert.setContentText("Version: 1.0 \n Auteur : Sonio \n Date: 2024");
        alert.showAndWait();
    }

    @FXML
    private void nouveau(ActionEvent event) {
        System.out.println("Ouvre le formulaire de saisi...");
        Label nom = new Label("Nom:");
        TextField nomSaisi = new TextField();
        Label prenom = new Label("Prenom:");
        TextField prenomSaisi = new TextField();
        Label adresse = new Label("Adresse:");
        TextField adresseSaisi = new TextField();
        Label numero = new Label("Numero:");
        TextField numeroSaisi = new TextField();
        Label email = new Label("Email:");
         TextArea emailSaisi = new TextArea() ;
        //creation de btn
        Button btnValide = new Button("Valider");
            //Creation Label et Champ de saisi
           btnValide.setOnAction((action) -> {
        String nomEn = nomSaisi.getText();
        String prenomEn = prenomSaisi.getText();
        String numeroEn = numeroSaisi.getText();
        String adresseEn = adresseSaisi.getText();
        String emailEn = emailSaisi.getText();
   
        System.out.println("NOM    :"+ nomEn);
        System.out.println("Prenom :"+ prenomEn);
        System.out.println("numero :"+ numeroEn);
        System.out.println("Adresse:"+ adresseEn);
        System.out.println("Email  :"+ emailEn);
            enregistrement(nomEn, prenomEn, adresseEn, numeroEn, emailEn);
        });

        //Oraganisation dans le grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        //ajouter les element dans grille
        GridPane.setConstraints(nom, 0, 0);
        GridPane.setConstraints(nomSaisi, 1, 0);
        GridPane.setConstraints(prenom, 0, 1);
        GridPane.setConstraints(prenomSaisi, 1, 1);
        GridPane.setConstraints(adresse, 0, 2);
        GridPane.setConstraints(adresseSaisi, 1, 2);
        GridPane.setConstraints(numero, 0, 3);
        GridPane.setConstraints(numeroSaisi, 1, 3);
        GridPane.setConstraints(email, 0, 4);
        GridPane.setConstraints(emailSaisi,1, 4);
        GridPane.setConstraints(btnValide, 1, 6);
        grid.getChildren().addAll(nom,nomSaisi,prenom,prenomSaisi,adresse,adresseSaisi,numero,numeroSaisi,email,emailSaisi,btnValide);

     
        //une fenetre de formulaire de saisi
        Stage formStage = new Stage();
        // ajouter les element de votre Formulaire
        formStage.setTitle("Saisi");
        Scene scene = new Scene(grid,560,300);
        formStage.setScene(scene);
        formStage.show();
    }
    
    
    
    
    
    
    private void openFicher(File file){
      
        try (BufferedReader lire = new BufferedReader(new FileReader(file))) {
            String line ;
            while((line = lire.readLine())!=null){
                
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("javafxapplication1.NewFXMain.openFicher()");
        }
    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
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
    private void fermer(ActionEvent event) {
        Nouveau.fen0.close();
    }

    @FXML
    private void aide(ActionEvent event) {
         Stage wind2 = new Stage();
         second fenetre3 = new second();
         fenetre3.fenetre3(wind2);
    }
}
