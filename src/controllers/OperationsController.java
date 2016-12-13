package controllers;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import matrizesesistemas.InvalidMatrixException;

import matrizesesistemas.Actions;
import matrizesesistemas.Main;
import matrizesesistemas.NotMatchingSizesException;

/**
 * @author Leu <@leunardosevla at twitter.com>
 *
 */
public class OperationsController {

    static String stringMatrix, stringSize;    
    
    public void sum() throws IOException, NotMatchingSizesException, InvalidMatrixException {
        
        int q = Main.getMatrixes().size();
        if (q == 2) {
            Main.addToMatrixes(Actions.matrixSum(Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(2)); 
            stringSize = Main.getMatrixes().get(2).getSize();
        }
        if (q == 3) {
            Main.addToMatrixes(Actions.matrixSum(Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
            Main.addToMatrixes(Actions.matrixSum(Main.getMatrixes().get(2), Main.getMatrixes().get(3)));
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(4)); 
            stringSize = Main.getMatrixes().get(4).getSize();
        }
        if (q == 4){
            Main.addToMatrixes(Actions.matrixSum(Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
            Main.addToMatrixes(Actions.matrixSum(Main.getMatrixes().get(2), Main.getMatrixes().get(3)));
            Main.addToMatrixes(Actions.matrixSum(Main.getMatrixes().get(4), Main.getMatrixes().get(5)));
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(6)); 
            stringSize = stringSize = Main.getMatrixes().get(6).getSize();
        }
        generateMatrixStage();
        //TODO: add methods to sum matrixes
        
    }

    public void minus() throws IOException, NotMatchingSizesException, InvalidMatrixException {
        
        int q = Main.getMatrixes().size();
        if (q == 2) {           
           Main.addToMatrixes(Actions.matrixMinus(Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
           stringMatrix = Actions.printMatrix(Main.getMatrixes().get(2));
           stringSize = Main.getMatrixes().get(2).getSize();
        }
        
        if(q == 3){
            Main.addToMatrixes(Actions.matrixMinus(Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
            Main.addToMatrixes(Actions.matrixMinus(Main.getMatrixes().get(2), Main.getMatrixes().get(3)));
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(3));
            stringSize = Main.getMatrixes().get(3).getSize();
        }
        
        if (q == 4){
            Main.addToMatrixes(Actions.matrixMinus(Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
            Main.addToMatrixes(Actions.matrixMinus(Main.getMatrixes().get(2), Main.getMatrixes().get(3)));
            Main.addToMatrixes(Actions.matrixMinus(Main.getMatrixes().get(4), Main.getMatrixes().get(5)));
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(6));
            stringSize = Main.getMatrixes().get(6).getSize();
        }
        
        
        generateMatrixStage();
        //TODO: add methods to minus matrixes
    }

    public void multiply() throws IOException, NotMatchingSizesException, InvalidMatrixException {
        int q = Main.getMatrixes().size();
        
        if(q == 1) {
            throw new InvalidMatrixException("Selecione mais de uma matriz!");
        }
        
        
        if (q == 2) {            
           Main.addToMatrixes(Actions.matrixProduct
                (Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
           stringMatrix = Actions.printMatrix(Main.getMatrixes().get(2));
           stringSize = Main.getMatrixes().get(2).getSize();            
        }
        if (q == 3) {
            Main.addToMatrixes(Actions.matrixProduct
                (Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
            Main.addToMatrixes(Actions.matrixProduct
                (Main.getMatrixes().get(2), Main.getMatrixes().get(3)));
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(4));
            stringSize = Main.getMatrixes().get(4).getSize();
        }
        
        if (q == 4) {
            Main.addToMatrixes(Actions.matrixProduct
                (Main.getMatrixes().get(0), Main.getMatrixes().get(1)));
            Main.addToMatrixes(Actions.matrixProduct
                (Main.getMatrixes().get(2), Main.getMatrixes().get(3)));
            Main.addToMatrixes(Actions.matrixProduct
                (Main.getMatrixes().get(4), Main.getMatrixes().get(5)));
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(5));
            stringSize = Main.getMatrixes().get(5).getSize();
        }
        
        generateMatrixStage();
//        //TODO: add methods to multiply matrixes
    }

    //TODO:{not working}
    public void transposition() throws IOException, InvalidMatrixException {
        if (Main.getMatrixes().size() > 1) {
            throw new InvalidMatrixException("Selecione apenas uma matriz.");
        } else {
            Main.addToMatrixes(Actions.matrixTrans(Main.getMatrixes().get(0)));            
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(1));            
            stringSize = Main.getMatrixes().get(1).getSize();
            
            generateMatrixStage();            

        }
    }

    public void showMatrix() throws IOException, InvalidMatrixException {

        if (Main.getMatrixes().size() > 1) {
            throw new InvalidMatrixException("Selecione apenas uma matriz.");
        } else {
            stringMatrix = Actions.printMatrix(Main.getMatrixes().get(0));
            stringSize = Main.getMatrixes().get(0).getSize();
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
