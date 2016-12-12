
package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
public class SelectWindowController {
    File file1, file2, file3, file4, file5;
    
    @FXML
    private TextField field1Id, field2Id, field3Id, field4Id, field5Id;
    
    public void add1(){
        Stage stage = new Stage();       
        
        file1 = openFileChooser().showOpenDialog(stage);
        field1Id.setText(file1.getAbsolutePath());
    }
    public void add2(){
        Stage stage = new Stage();
                
        file2 = openFileChooser().showOpenDialog(stage);
        field2Id.setText(file2.getAbsolutePath());
    }
    public void add3(){
        Stage stage = new Stage();
       
        file3 = openFileChooser().showOpenDialog(stage);
        field3Id.setText(file3.getAbsolutePath());
    }
    public void add4(){
        Stage stage = new Stage();
        
        file4 = openFileChooser().showOpenDialog(stage);
        field4Id.setText(file4.getAbsolutePath());
    }
    public void add5(){
        Stage stage = new Stage();
        
        file5 = openFileChooser().showOpenDialog(stage);
        field5Id.setText(file5.getAbsolutePath()); 
    } 
    
    public List<File> confirm(){
        List<File> files = new ArrayList<File>();
        
        do {
           if(file1 != null){
               files.add(file1);
           }
           if(file2 != null){
               files.add(file2);
           }
           if(file3 != null){
               files.add(file3);
           }
           if(file4 != null){
               files.add(file4);
           }
           if(file5 != null){
               files.add(file5);
           }
            
        } while (files.size() < 2);
           
        return files;
    }
   
    
    Stage createSelectWindow() throws IOException{
        Stage stage = new Stage();
        URL arquivoFXML = getClass().getResource("../fxml/select-window.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/matrix-icon.jpg")));
        stage.setScene(new Scene(fxmlParent, 600, 300));        
        return stage;
    }
    public static FileChooser openFileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a matriz a ser exibida:");
        
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Arquivo de texto txt (.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        return fileChooser;
    }
}
