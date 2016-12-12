package matrizesesistemas;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    private static List<Matrix> matrixes = new ArrayList<>();
    
    public static void addToMatrixes(File file) {
        matrixes.add(new Matrix(file));
    }
    
    public List<Matrix> getMatrixes() {
        return matrixes;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        URL arquivoFXML = getClass().getResource("../fxml/select-file.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/matrix-icon.jpg")));
        stage.setScene(new Scene(fxmlParent, 600, 204));
        stage.setTitle("Calculadora de matrizes");
        stage.show();

    }
}
