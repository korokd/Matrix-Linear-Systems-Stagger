package matrixPrinting;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String fileName = "C:/Users/Diogo_2/Documents/testeRoberto.txt";
		printing(fileName);

	}

	public static void printing(String fileName) {
		// nome do arquivo a abrir
		String filename = fileName;
		// pega uma linha de cada vez
		String line = null;

		try {
			// cria o leitor de arquivo
			FileReader fReader = new FileReader(filename);
			// coloca o leitor de arquivo dentro de um BufferedReader
			BufferedReader bReader = new BufferedReader(fReader);

			// le a linha
			line = bReader.readLine();

			// roda o metodo para montar a matriz
			while (line != null) {

				arranging(line);

			}

		} catch (FileNotFoundException ex) {
			System.out.printf("Nao foi possivel abrir o arquivo %s\n", filename);

		} catch (IOException ex) {
			ex.printStackTrace();

		}

	}

	public static void arranging(String matriX) {
		// cria o vetor dinâmico bidimensional
		List<List<String>> matrix = new ArrayList<List<String>>();
		// cria o vetor dinâmico que armazenará as linhas da matriz
		List<String> matrixLine = new ArrayList<String>();
		// conta a ordem da matriz e linhas e colunas
		int order, rows, columns;
		// cria uma String para isolar os caracteres
		String isolate;
		int fin = 0;

		// roda a String
		for (int i = 0; i < matriX.length(); i++) {

			// se for uma das chaves ignora
			if (matriX.substring(i) == "{" | matriX.substring(i) == "}") {

			}
			// se for espaco tambem
			else if (matriX.substring(i) == " ") {

			}
			// se chegou no ; fecha a linha adicionando ela pra matriz
			else if (matriX.substring(i) == ";") {
				matrix.add(matrixLine);

			}
			// se nenhuma das anteriores, vai compondo a linha
			else {

				// verifica se depois não vem alguma caractere que não sirva pra
				// compor o numero
				do {
					if (!(matriX.substring(i + 1) != " " && matriX.substring(i + 1) != ";"
							&& matriX.substring(i + 1) != "{" && matriX.substring(i + 1) != "}")) {
						// incrementa o numero final do numero (quantas casas)
						fin++;
					}
				}
				// roda enquanto o que vem apos o que foi testado nao for um
				// treco bosta
				while (!(matriX.substring(i + 1) != " " && matriX.substring(i + 1) != ";"
						&& matriX.substring(i + 1) != "{" && matriX.substring(i + 1) != "}"));

				// isola o numero
				isolate = matriX.substring(i, fin);

				// verifica se e realmene um numero
				if (isNumeric(isolate)) {
					// adiciona pra linha
					matrixLine.add(isolate);

				}

				// pula pra depois desse numero
				i += fin;

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

}
