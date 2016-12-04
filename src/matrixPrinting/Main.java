package matrixPrinting;

import java.io.*;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Main extends Application {
// cria o vetor dinâmico bidimensional
        private static List<List<String>> matrix = new ArrayList<>();
// cria o vetor dinâmico que armazenará as linhas da matriz
        private static List<String> matrixLine = new ArrayList<>();
// conta a ordem da matriz e linhas e colunas
        private static int order = 0, rows = 0, columns = 0;
        
    
	public static void main(String[] args) {
                Application.launch(args);		
		
	}
        
        @Override
        public void start(Stage stage){
                stage.setTitle("Trabalhos do roberto o melhor professor do mundo");                
                
                FileChooser fileChooser = new FileChooser();                
                fileChooser.setTitle("Selecione a matriz a ser exibida:");
                
                ExtensionFilter extensionFilter = new ExtensionFilter("Arquivo de texto txt (.txt)","*.txt");
                fileChooser.getExtensionFilters().add(extensionFilter);
                
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
                        
                        arranging(sb.toString());
                        
		} catch (FileNotFoundException ex) {
                        System.err.println(ex);
			System.err.printf("Nao foi possivel abrir o arquivo %s\n", file.getName());

		} catch (IOException ex) { 
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

	}

	public static void arranging(String matriX) throws IOException { 	
            
            /*roda a String. o contador comecara onde o sinal da matriz
            comeca ('['), pois pode conter outras coisas antes da matriz, e
            isso faria com que o índice ficasse gigante :p*/
            for (int i = matriX.indexOf("["); i <= matriX.length(); i++) {

                // se chegou no ',' ou ']' fecha a linha adicionando ela pra matriz
                // adicionei isso pois pode ter uma matriz 1x1 e aí ela não teria ',' para separar as linhas.

                if (matriX.substring(i).equals(",") || matriX.substring(i).equals("]") ) {
                        matrix.add(matrixLine);
                }

                else {                     
                   addRow(manipulateRow(matriX, i));
                }
            }
	}

	// testa uma String pra ver se e numerica
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
        
        public static String[] manipulateRow(String matriX, int i) throws InvalidPropertiesFormatException{
            String selectedRow, splitedRow[];
            
            /* esse método encontra a primeira ',';            
            cria uma substring até a primeira ',';
            separa cada coisa entre os espaços em uma array. */
            
            int endRow = matriX.indexOf(",", matriX.length());
            if(endRow == -1){
                endRow = matriX.indexOf("]");
            }
            
            System.out.println(endRow);
            selectedRow = matriX.substring(i, endRow);
 
            splitedRow = selectedRow.split("//s+"); 
            
            if(endRow != -1){
                i = endRow + 1;
                rows++;
            } else {
                throw new InvalidPropertiesFormatException("O formato está incorreto. Verifique o arquivo.");
            }        
            
            return splitedRow;
        }
        
        public static void addRow(String splitedRow[]) throws InvalidPropertiesFormatException{
            /*Esse metodo verifica se todos os itens da array splitedRow são numeros;
            Adiciona-os a matriz linha.
            Salva a ultima posicao do for ('i') para leitura posterior*/
            for(String number : splitedRow){

                if (isNumeric(number)) {
                    matrixLine.add(number);                    
                } else {
                    throw new InvalidPropertiesFormatException("A matriz não é composta por apenas números");
                }                                                                               
            }
        }
}
