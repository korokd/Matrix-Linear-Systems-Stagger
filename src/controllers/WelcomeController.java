
package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/** 
 * @author Leu <@leunardosevla at twitter.com>
 **/
public class WelcomeController {
    
    @FXML
    Button sumId, minusId, multiplyId, transpositionId, showMatrixId;        
    
    SelectWindowController swController = new SelectWindowController();
    OneFileController ofController = new OneFileController();
    
    public void sum () throws IOException { 
        Stage stage = swController.createSelectWindow();
        stage.setTitle("Somar matrizes");
        stage.show();
    }
    
    public void minus () throws IOException {    
        Stage stage = swController.createSelectWindow();
        stage.setTitle("Subtrair matrizes");
        stage.show();
    }
    
    public void multiply () throws IOException  {
        Stage stage = swController.createSelectWindow();
        stage.setTitle("Multiplicar matrizes");
        stage.show(); 
    }
    
    public void transposition () throws IOException {
        Stage stage = ofController.createOneFileWindow();        
        stage.setTitle("Transposição");
        stage.show();
    }
    
    public void showMatrix () throws IOException {
        Stage stage = ofController.createOneFileWindow();
        stage.setTitle("Mostrar matriz");
        stage.show();
    }
    
   
}
