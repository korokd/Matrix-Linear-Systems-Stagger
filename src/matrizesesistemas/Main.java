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

    public static boolean verifyMatrix(List<String[]> matrix) {
        //aqui precisa terminar, que vai verificar se toda matriz e valida,
        //tipo nenhuma coluna estiver com valor nulo e etc.
        boolean doesAnyRowContainsNull = true;

        //separa a matrix pelas linhas e roda por elas
        for (String[] a : matrix) {
            //roda pelos elementos da linha
            for (String b : a) {
                //se houver algum nulo atribui o valor false a variavel
                //obs: nao ha caminho de volta para true
                if (b == null) {
                    doesAnyRowContainsNull = false;
                }
            }
        }

        List<Integer> lengthsValues = new ArrayList<>();
        for (String[] row : matrix) {
            lengthsValues.add(row.length);
        }

        for (int i = 0; i < lengthsValues.size(); i++) {
            for (int j = 0; j < lengthsValues.size(); j++) {
                if (lengthsValues.get(i) != lengthsValues.get(j)) {
                    doesAnyRowContainsNull = false;
                }
            }
        }

        return doesAnyRowContainsNull;
    }

    public static void printMatrix(List<String[]> matrixLine) {

        //conta se ja se atingiu a ultima linha para que imprima a ordem
        int contador = 0;

        //formata a matriz na impressao
        String format = "|";

        //separa a matriz por linhas
        for (String[] oi : matrixLine) {

            System.out.printf("\t%s", format);

            //imprime a linha da matriz
            for (String xd : oi) {

                System.out.printf("\t%s ", xd);

            }

            System.out.printf("\t%s", format);

            contador++;

            //imprime a ordem
            if (contador == matrixLine.size()) {

                System.out.printf(" %sx%s", matrixLine.size(), oi.length);

            }

            //pula a linha
            System.out.println();

        }

    }

}
