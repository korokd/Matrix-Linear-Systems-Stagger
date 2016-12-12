package matrizesesistemas;


import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;



import javafx.stage.Stage;

/**
 * @author Leu <@leunardosevla at twitter.com>
 *
 */
public class Windows extends Application {

    public static void main(String[] args) {
        launch(args);
        //Main adicionada só pra testes!!!!!
    }

    @Override
    public void start(Stage stage) throws IOException {
        URL arquivoFXML = getClass().getResource("../fxml/welcome-window.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/matrix-icon.jpg")));
        stage.setScene(new Scene(fxmlParent, 700, 100));
        stage.setTitle("Calculadora de matrizes");
        stage.show();
    }

}
