package matrizesesistemas;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/** 
 * @author Leu <@leunardosevla at twitter.com>
 **/
public class Windows extends Application {
    public static void main(String[] args) {
        launch(args);
        //Main adicionada só pra testes!!!!!
    }
    
    @Override
    public void start(Stage stage){
        Button buttonSum = new Button();
        Button buttonMultiply = new Button();
        Button buttonMinus = new Button();
        Button buttonTransposition = new Button();
        Button buttonShowMatrix = new Button();
        
        buttonSum.setText("Somar");
        buttonMultiply.setText("Multiplicar");
        buttonMinus.setText("Subtrair");
        buttonTransposition.setText("Transposição");
        buttonShowMatrix.setText("Exibir Matriz");
        
        buttonSum.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonMinus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonMultiply.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonTransposition.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonShowMatrix.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        
        buttonSum.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Work in progress");
            }
        });
        
        buttonMultiply.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Work in progress");
            }
        });
        
        buttonMinus.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Work in progress");
            }
        });
        
        buttonTransposition.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Work in progress");
            }
        });
        
        buttonShowMatrix.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                Stage stageShowMatrix = new Stage();
                stageShowMatrix.setTitle("Exibir matriz");                
            
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Selecione a matriz a ser exibida:");

                FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Arquivo de texto txt (.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extensionFilter);

                File matrix = fileChooser.showOpenDialog(stageShowMatrix);
                //TODO: retornar esse file matrix pra ser exibido em outra janela efetivamente.
            }
        });
        
        Text t = new Text();
        t.setText("Escolha a operação:");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.add(t, 0,0);
        grid.add(buttonSum, 1, 2);
        grid.add(buttonMinus, 2, 2);
        grid.add(buttonMultiply, 3, 2);
        grid.add(buttonTransposition, 4, 2);
        grid.add(buttonShowMatrix, 5, 2);
        
        Scene scene = new Scene(grid, 600, 100);        
        
        stage.setTitle("Calculadora de Matrizes");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/matrix-icon.jpg")));
        stage.show();
    }    
    
}