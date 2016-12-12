
package controllers;


import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import matrizesesistemas.InvalidMatrixesException;

import matrizesesistemas.Actions;
import matrizesesistemas.Main;
import matrizesesistemas.NotMatchingSizesException;
        
/** 
 * @author Leu <@leunardosevla at twitter.com>
 **/

public class OperationsController {  
    
    public void sum (Main main) throws IOException, NotMatchingSizesException{
        for(int i = 0; i < main.getMatrixes().size(); i++){
            Actions.matrixSum( main.getMatrixes().get(i), main.getMatrixes().get(i+1));
        }        
        generateMatrixStage();
        //TODO: add methods to sum matrixes
    }
    
    public void minus (Main main) throws IOException, NotMatchingSizesException {
        for(int i = 0; i < main.getMatrixes().size(); i++){
            Actions.matrixMinus( main.getMatrixes().get(i), main.getMatrixes().get(i+1));
        }        
        generateMatrixStage();
         //TODO: add methods to minus matrixes
    }
    
    public void multiply (Main main) throws IOException, NotMatchingSizesException {
        for(int i = 0; i < main.getMatrixes().size(); i++){
            Actions.matrixProduct( main.getMatrixes().get(i), main.getMatrixes().get(i+1));
        }        
        generateMatrixStage();
         //TODO: add methods to multiply matrixes
    }
    
    public void transposition (Main main) throws IOException, InvalidMatrixesException {
        
        if(main.getMatrixes().size() > 1){
            throw new InvalidMatrixesException("Selecione apenas uma matriz.");
        } else {
            Actions.matrixTrans(main.getMatrixes().get(0));
            generateMatrixStage();

        }
         //TODO: add methods to transpose matrixes
    }
    
    public void showMatrix (Main main) throws IOException, InvalidMatrixesException {
        if(main.getMatrixes().size() > 1){
            throw new InvalidMatrixesException("Selecione apenas uma matriz.");
        } else {
            Actions.printMatrix(main.getMatrixes().get(0));
            generateMatrixStage();

        }
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
