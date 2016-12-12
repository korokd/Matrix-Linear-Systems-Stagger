
package controllers;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/** 
 * @author Leu <@leunardosevla at twitter.com>
 **/
public class OneFileController { 
    File file;
    
    @FXML
    TextField fieldId;
    
    public File confirm(){
        return file;
    }
    
    public void add(){
        
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a matriz a ser exibida:");
        
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Arquivo de texto txt (.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
         
        file = fileChooser.showOpenDialog(stage);
        fieldId.setText(file.getAbsolutePath()); 
    }
    
    public Stage createOneFileWindow() throws IOException{
        Stage stage = new Stage();
        URL arquivoFXML = getClass().getResource("../fxml/onefile-window.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/matrix-icon.jpg")));
        stage.setScene(new Scene(fxmlParent, 600, 158));
        return stage;
    }
    
    
    
}
