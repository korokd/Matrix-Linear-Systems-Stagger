
package controllers;


import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;


        
/** 
 * @author Leu <@leunardosevla at twitter.com>
 **/

public class OperationsController {  
    
    public void sum () throws IOException{
        generateMatrixStage();
        //TODO: add methods to sum matrixes
    }
    
    public void minus () throws IOException {
        generateMatrixStage();
         //TODO: add methods to minus matrixes
    }
    
    public void multiply () throws IOException {
        generateMatrixStage();
         //TODO: add methods to multiply matrixes
    }
    
    public void transposition () throws IOException {
        generateMatrixStage();
         //TODO: add methods to transpose matrixes
    }
    
    public void showMatrix () throws IOException {
        generateMatrixStage();
         //TODO: add methods to show matrix
    }
    
    private void generateMatrixStage() throws IOException {
        Stage operationsStage = new Stage();
        URL arquivoFXML = getClass().getResource("../fxml/generated-matrix.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
        operationsStage.getIcons().add(new Image(getClass()
            .getResourceAsStream("/images/matrix-icon.jpg")));
        operationsStage.setScene(new Scene(fxmlParent, 600, 600));
        operationsStage.show();
    }
}
