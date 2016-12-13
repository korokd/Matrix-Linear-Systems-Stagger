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
    static double [][] doubleTrans ;
    static String [][] stringTrans;

    public void sum() throws IOException, NotMatchingSizesException {
        
        generateMatrixStage();
        //TODO: add methods to sum matrixes
    }

    public void minus() throws IOException, NotMatchingSizesException {
//        for (int i = 0; i < main.getMatrixes().size(); i++) {
//            System.out.println(main.getMatrixes().size());
//            Actions.matrixMinus(main.getMatrixes().get(i), main.getMatrixes().get(i + 1));
//        }
        generateMatrixStage();
        //TODO: add methods to minus matrixes
    }

    public void multiply() throws IOException, NotMatchingSizesException {
//        for (int i = 0; i < Main.getMatrixes().size(); i++) {
//            doubleTrans = Actions.matrixProduct(Main.getMatrixes().get(i), Main.getMatrixes().get(i+1));
//        }
//        stringMatrix = Actions.printMatrix(stringTrans);
//        stringSize = Main.getMatrixes().get(0).getSize();
//        generateMatrixStage();
//        //TODO: add methods to multiply matrixes
    }

    public void transposition() throws IOException, InvalidMatrixException {
        if (Main.getMatrixes().size() > 1) {
            throw new InvalidMatrixException("Selecione apenas uma matriz.");
        } else {
            doubleTrans = Actions.matrixTrans(Main.getMatrixes().get(0));
            stringTrans = Actions.matrixDoubleToString(doubleTrans);
            stringMatrix = Actions.printMatrix(stringTrans);
            stringSize = Main.getMatrixes().get(0).getSize();
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
