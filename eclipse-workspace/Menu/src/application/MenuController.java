package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MenuController implements Initializable {
	
	//FilePath名
	String FilePath;
	//ComboBoxに表示するリスト
	ObservableList<String> extension = FXCollections.observableArrayList(
			"JPEG",
			"PNG",
			"BMP",
			"GIF"
			);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML

    private ComboBox<String> FileExtension;

    @FXML
    private Button FileConversion;

    @FXML
    private Button FileChoose;

    @FXML
    private TextField FileName;
    
    //ComboBoxの設定
    @Override
    public void initialize(URL url,ResourceBundle bundle) {
    	 FileExtension.setItems(extension);

    }
    @FXML
    void FileChooseOnClick(ActionEvent event) {
    	FileChooser filechooser = new FileChooser();
		filechooser.setTitle("File");
		File file = filechooser.showOpenDialog(null);

		//Filter
		filechooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("対応ファイル",".*\\.((jpe?|pn)g|bmp|gif)"));

		//HomeDirectory
		filechooser.setInitialDirectory
			(new File(System.getProperty("user.home")));

		//
		FilePath = file.getAbsolutePath();

		FileName.setText(FilePath);

    }

    @FXML
    void FileConversionOnClick(ActionEvent event) {

    }

    @FXML
    void FileExtensionOnClick(ActionEvent event) {
    	
    }
  
}