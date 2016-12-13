
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/** 
 * @author Leu <@leunardosevla at twitter.com>
 **/
public class GeneratedMatrixController implements Initializable {
    
    @FXML
    TextArea textArea;
    
    @FXML
    Text ordemId;
    
    @Override
    public void initialize(URL url, ResourceBundle resources){
        System.out.println(OperationsController.stringMatrix);
        textArea.setText(OperationsController.stringMatrix);
        ordemId.setText("Ordem: " + OperationsController.stringSize);
    }
   
}
