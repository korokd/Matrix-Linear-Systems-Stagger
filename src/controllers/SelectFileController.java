package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import matrizesesistemas.Main;

/**
 * @author Leu <@leunardosevla at twitter.com>
 *
 */
public class SelectFileController {

    private ObservableList<String> nomeArquivos = observableArrayList(); //lista para printar o nome no ListView
    static List<File> selectedFiles = new ArrayList<File>(); //lista dos arquivos

    @FXML
    ListView<String> listViewId;

    public void add() {

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a matriz a ser exibida:");

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Arquivo de texto txt (.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);

        List<File> files = fileChooser.showOpenMultipleDialog(stage);

        if (files != null) {
            //o for adiciona os arquivos na lista selectedFiles E também
            //o seu nome no nomeArquivos.
            for (File file : files) {
                nomeArquivos.clear();
                nomeArquivos.add(file.getName());
                selectedFiles.add(file);
                listViewId.getItems().addAll(nomeArquivos);
                Main.addToMatrixes(file);
            }
        }

    }

    public void confirm() throws IOException {

        if (!selectedFiles.isEmpty()) {
            Stage operationsStage = new Stage();
            URL arquivoFXML = getClass().getResource("../fxml/operations.fxml");
            Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
            operationsStage.getIcons().add(new Image(getClass()
                    .getResourceAsStream("/images/matrix-icon.jpg")));
            operationsStage.setTitle("Calculadora de matrizes");
            operationsStage.setScene(new Scene(fxmlParent, 237, 204));
            operationsStage.show();
        }
    }
}
