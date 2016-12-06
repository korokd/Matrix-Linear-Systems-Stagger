package matrixPrinting;

import java.io.*;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException; //usar depois pra tratar erro
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        //inicializa a janela do javafx
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Trabalhos do roberto o melhor professor do mundo");

        //adiciona o menu pra escolher arquivo
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a matriz a ser exibida:");

        //limita apenas para txt
        ExtensionFilter extensionFilter = new ExtensionFilter("Arquivo de texto txt (.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);

        //atribui o arquivo selecionado para variavel
        File file = fileChooser.showOpenDialog(stage);
        printingFileChooser(file);
    }

    public static void printingFileChooser(File file) {
        // pega uma linha de cada vez
        String line = null;

        try {
            // cria o leitor de arquivo
            FileReader fReader = new FileReader(file);
            // coloca o leitor de arquivo dentro de um BufferedReader
            BufferedReader bReader = new BufferedReader(fReader);
            line = bReader.readLine();
            StringBuilder sb = new StringBuilder();
			// le a linha

            // roda o metodo para montar a matriz
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = bReader.readLine();
            }

            String matrix = sb.toString();

//            System.out.println(sb.toString());
            if (verifyMatrix(manipulateRow(matrix))) {
                printMatrix(manipulateRow(matrix));
            } else {
                System.out.println("Nao foi possivel encontrar uma matriz no arquivo");
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            System.err.printf("Nao foi possivel abrir o arquivo %s\n", file.getName());

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }

    }

    static List<String[]> manipulateRow(String matriX) {
        //cria a matriz que armazena tudo
        List<String[]> matrixLine = new ArrayList<>();

        //splitedsrow armazena linha separada
        //contentOfRow armazera o conteudo de cada linha 
        String splitedsRow[], contentOfRow[];

        //separa todo o arquivo por ',' entendendo que a cada ',' tera¡
        //uma linha da matriz.
        splitedsRow = matriX.split(",");

        for (String wholeRow : splitedsRow) {

            //[^0-9|\\.|\\/]+", "-" = substitui TUDO menos os numeros de 
            //0-9 OU o . (para numeros Double) OU o / (para numeros
            //fracionados)
            wholeRow = wholeRow.replaceAll("[^0-9|\\.|\\/]+", "-");

            //StringBuilder utilizado para poder retirar o primeiro caractere (-)
            //da String wholeRow, de forma a evitar um null no index 0
            StringBuilder sbWholeRow = new StringBuilder(wholeRow);
            sbWholeRow.deleteCharAt(0);
            //atribui para wholeRow a String sem o primeiro caractere
            wholeRow = sbWholeRow.toString();

            //agora a LINHA se parecera com isso: 2-3-4 
            //entao separaremos apenas os numeros, removendo o -
            contentOfRow = wholeRow.split("-");

//            for(String a : contentOfRow) {
//                System.out.println(a);
//            }
            //adiciona a array (linha) na list que contem todas as linhas
            matrixLine.add(contentOfRow);

        }

        return matrixLine;
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

        // conta se ja se atingiu a ultima linha para que imprima a ordem
        int contador = 0;

        for (String[] oi : matrixLine) {
            // imprime a linha
            for (String xd : oi) {
                System.out.printf("\t%s ", xd);
            }
            contador++;
            // imprime a ordem
            if (contador == matrixLine.size()) {
                System.out.printf(" %sx%s", matrixLine.size(), oi.length);
            }
            // pula a linha
            System.out.println();

        }

    }

}
