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
        public void start(Stage stage){
                stage.setTitle("Trabalhos do roberto o melhor professor do mundo");                
                
                //adiciona o menu pra escolher arquivo
                FileChooser fileChooser = new FileChooser();                
                fileChooser.setTitle("Selecione a matriz a ser exibida:");
                
                //limita apenas para txt
                ExtensionFilter extensionFilter = new ExtensionFilter("Arquivo de texto txt (.txt)","*.txt");
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
                        
                        manipulateRow(sb.toString());
                        
		} catch (FileNotFoundException ex) {
                        System.err.println(ex);
			System.err.printf("Nao foi possivel abrir o arquivo %s\n", file.getName());

		} catch (IOException ex) { 
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

	}
	
        
        static List<String[]> manipulateRow(String matriX) {
            //cria a matriz que armazena tudo
            List<String[]> matrixLine = new ArrayList<>();
            
            //splitedsrow armazena linha separada
            //contentOfRow armazera o conteudo de cada linha 
            String splitedsRow[], contentOfRow [];
            
            //separa todo o arquivo por ',' entendendo que a cada ',' terá
            //uma linha da matriz.
            splitedsRow = matriX.split(",");
            
            for(String wholeRow: splitedsRow){
                
                //[^0-9|\\.|\\/]+", "-" = substitui TUDO menos os números de 
                //0-9 OU o . (para numeros Double) OU o / (para numeros
                //fracionados)
                wholeRow = wholeRow.replaceAll("[^0-9|\\.|\\/]+", "-");
                
                //agora a LINHA se parecerá com isso: 2-3-4 
                //então separaremos apenas os numeros, removendo o -
                contentOfRow = wholeRow.split("-");
                
                //adiciona a array (linha) na list que contém todas as linhas
                matrixLine.add(contentOfRow);

            }
//            for(String [] oi: matrixLine){
//                for(String xd : oi){
//                    System.out.println(xd);
//                }                
//            } isso aqui tu pode usar pra exibir todos os elementos da matriz em ordem
            return matrixLine;
        }
        
        
        
        public static boolean verifyMatrix(List<String[]> matrix){
            //aqui precisa terminar, que é verificar se toda matriz é válida,
            //tipo nenhuma coluna estiver com valor nulo e etc.
            boolean doesAnyRowContainsNull = true; //remover o true
            List <Integer> lengthsValues = new ArrayList<>();
            for(String [] row : matrix){
               lengthsValues.add(row.length);
            }
            
         
             return doesAnyRowContainsNull;  
        }         
}
