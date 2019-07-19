package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainMenuController {
	String url;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> FileExtension;

    @FXML
    private TextField FileName;

    @FXML
    private Button FileConversion;

    @FXML
    private Button FileChoose;

    /*参照ボタン*/
    @FXML
    public void FileChoose_onClick(ActionEvent event) {

    		FileChooser filechooser = new FileChooser();
    		filechooser.setTitle("参照");
    		File file = filechooser.showOpenDialog(null);

    		//ファイルのフィルター設定
    		filechooser.getExtensionFilters().addAll(
    				new FileChooser.ExtensionFilter("All","*.*"));

    		//初期ディレクトリの設定
    		filechooser.setInitialDirectory
    			(new File(System.getProperty("user.home")));

    		//ファイルのパスの取得
    		url = "file:///" + file.getAbsolutePath();

    }

    		/*変換ボタン*/
    @FXML
    public void FileConversion_onClick(ActionEvent event) {

    }
    		//拡張子ボタン
    @FXML
    public void Extention_OnClick(ActionEvent event) {
    		FileExtension.getItems().add("拡張子");
    		FileExtension.getItems().add("PNG");
    		FileExtension.getItems().add("JPG");
    		FileExtension.getItems().add("JPEG");
    		FileExtension.getItems().add("BMP");
    		FileExtension.getItems().add("PICT");

    		//デフォルトを"拡張子に設定"
    		FileExtension.getSelectionModel().select(0);
    }
    		//ファイルネーム
    @FXML
    public void FileChooseName(ActionEvent event) {
    		FileName.setText(url);
    }

    @FXML
    void initialize() {
        assert FileExtension != null : "fx:id=\"FileExtension\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert FileName != null : "fx:id=\"FileName\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert FileConversion != null : "fx:id=\"FileConversion\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert FileChoose != null : "fx:id=\"FileChoose\" was not injected: check your FXML file 'MainMenu.fxml'.";

    }
}
