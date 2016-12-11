package matrizesesistemas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    //cria lista de matrizes
    private List<Matrix> matrixes = new ArrayList<>();

    //cria objeto arquivo global
    private File file;

    public static void main(String[] args) {

        //inicializa a janela do javafx
        Application.launch(args);

    }
    
    //TODO:{after everything done, implement in here}
    public void start(Stage stage) {
        
        stage.setTitle("Trabalhos do roberto o melhor professor do mundo");

        //adiciona o menu pra escolher arquivo
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a matriz a ser exibida:");

        //limita apenas para txt
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Arquivo de texto txt (.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);

        //atribui o arquivo selecionado para variavel global
        file = fileChooser.showOpenDialog(stage);

    }

}
