/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.management.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sachi
 */
public class MainController implements Initializable {

    
       @FXML
    private Button exit_button;

    @FXML
    private Button login;

       @FXML
    private PasswordField password;

    @FXML
    private TextField username;;
    

  public void exit(){
      System.exit(0);
  }
  
  
  public void login(){
      Conn c= new Conn();

      try{
          String sql = "Select *from admin where username ='"+username.getText()+"' and password='"+password.getText()+"'";
         ResultSet rs = c.s.executeQuery(sql);
         
         
         
         if(username.getText().isEmpty() || password.getText().isEmpty()){
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Login ");
             alert.setHeaderText(null);
             alert.setContentText("Fill the Blanks Fields");
             alert.showAndWait(); 
         }else{
         
         if(rs.next()){
//             Alert alert = new Alert(AlertType.INFORMATION);
//             alert.setTitle("Login ");
//             alert.setHeaderText(null);
//             alert.setContentText("Login Successfull");
//             alert.showAndWait();
             
             
             login.getScene().getWindow().hide();
             
             Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
             
             Stage stage = new Stage();
             Scene scene = new Scene(root);
             
            stage.setScene(scene);
             stage.show();
             
             
             
         }else{
             Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Login Failed ");
             alert.setHeaderText(null);
             alert.setContentText("Login Failure");
             alert.showAndWait();
         }
         }
          
        
          
          
      }catch(Exception e){
          
      }
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
