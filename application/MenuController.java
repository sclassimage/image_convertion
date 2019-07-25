package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import jmagickOperation.ImageConvertion;
import jmagickOperation.MoveImageConvertion;

public class MenuController {
	String url;
	ObservableList<String> extension = FXCollections.observableArrayList(
			"JPEG",
			"PNG"
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


    @FXML
    void FileChooseOnClick(ActionEvent event) {
    	FileChooser filechooser = new FileChooser();
		filechooser.setTitle("�Q��");
		File file = filechooser.showOpenDialog(null);

		//Filter
		filechooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All","*.*"));

		//�����f�B���N�g���̐ݒ�
		filechooser.setInitialDirectory
			(new File(System.getProperty("user.home")));

		//path�擾
		url = file.getAbsolutePath();

		FileName.setText(url);

    }

    @FXML
    void FileConversionOnClick(ActionEvent event) {
    	if(url == null) {
    		return;
    	}
    	ImageConvertion mic = new MoveImageConvertion();
    	mic.convertion(url, "png");
    }

    @FXML
    void FileExtensionOnclick(ActionEvent event) {

    }

    public void initialize() {
    	 assert FileName != null : "fx:id=\"FileName\" was not injected: check your FXML file 'MainMenu.fxml'.";
         assert FileExtension != null : "fx:id=\"FileExtension\" was not injected: check your FXML file 'MainMenu.fxml'.";
         assert FileConversion != null : "fx:id=\"FileConversion\" was not injected: check your FXML file 'MainMenu.fxml'.";
         assert FileChoose != null : "fx:id=\"FileChoose\" was not injected: check your FXML file 'MainMenu.fxml'.";


    }
}