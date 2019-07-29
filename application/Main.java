package application;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jmagickOperation.ImageConvertion;
import jmagickOperation.MoveImageConvertion;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application {

	public static Scene scene1 = null;
	public static Scene scene2 = null;
	TextField txt = new TextField();
	private String chooseExtension = null;
	private Stage stage = null;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;

		stage.setTitle("image_conversion");
		// ステージの作成
		initScene1();
		stage.setScene(scene1);

		stage.show();
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public void initScene1() {

		AnchorPane root = new AnchorPane();
		Button fcbtn = new Button("参照");
		fcbtn.setOnMouseClicked(event -> fcbtnOnClick());
		this.txt.setPrefWidth(300);
		ObservableList<String> extension = FXCollections.observableArrayList("JPEG", "PNG", "BMP", "GIF");
		ComboBox cb = new ComboBox(extension);
		cb.setValue("拡張子");
		cb.setOnMouseClicked(event -> this.chooseExtension = cb.getSelectionModel().getSelectedItem().toString());
		Button btn = new Button("変換");
		btn.setOnMouseClicked(event -> btnOnClick());
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.getChildren().add(this.txt);
		hBox.getChildren().add(fcbtn);
		hBox.getChildren().add(cb);
		btn.setAlignment(Pos.BOTTOM_LEFT);
		root.getChildren().add(hBox);
		root.getChildren().add(btn);
		root.setRightAnchor(btn, (double)30);
		root.setBottomAnchor(btn, (double)20);
		Main.scene1 = new Scene(root, 450, 100);
	}

	private void btnOnClick() {
		ImageConvertion ic = new MoveImageConvertion();
		if(this.txt.getText() == null) {

			Alert alrt = new Alert(AlertType.INFORMATION);
			alrt.setTitle("警告");
			alrt.setHeaderText("エラー");
			alrt.setContentText("ファイルが選択されていません。");
			alrt.showAndWait();
		}else if(this.chooseExtension == null) {
			Alert alrt = new Alert(AlertType.INFORMATION);
			alrt.setTitle("警告");
			alrt.setHeaderText("エラー");
			alrt.setContentText("拡張子が選択されていません。");
			alrt.showAndWait();
			
		}
		switch(this.chooseExtension) {
		case "JPEG":
			this.chooseExtension = "jpg";
			return;
		case "PNG":
			this.chooseExtension = "png";
			return;
		case "BMP":
			this.chooseExtension = "bmp";
			return;
		case "GIF":
			this.chooseExtension = "gif";
			return;
		
		}
		
		initScene2(this.stage, ic.convertion(this.txt.getText(), this.chooseExtension));
		System.out.println(this.chooseExtension);
		this.stage.show();
	}

	public void fcbtnOnClick() {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("参照");
		File file = filechooser.showOpenDialog(null);

		// Filter
		filechooser.getExtensionFilters().add(
		        new FileChooser.ExtensionFilter("対応ファイル", ".*.(?:(?:jpe?|pn)g|bmp|gif)"));

		// 初期ディレクトリの設定
		filechooser.setInitialDirectory(new File(System.getProperty("user.home")));


		txt.setText(file.getAbsolutePath());
	}

	public static void initScene2(Stage stage, boolean ans) {
		String ansstr;
		int colnum;
		if (ans) {
			ansstr = "ファイルが変換されました！";
			colnum = 1;
		} else {
			ansstr = "ファイルが変換されませんでした";
			colnum = 0;
		}
		AnchorPane root = new AnchorPane();
		root.setPadding(new Insets(20, 0, 20, 20));
		scene2 = new Scene(root);

		Label lbl = new Label(ansstr);
		Color[] colors = new Color[] { Color.BLUE, Color.RED };
		lbl.setTextFill(colors[colnum]);

		Button btn = new Button("完了");
		setScene(stage, scene2);
		btn.setPrefWidth(100);
		btn.setPrefHeight(50);
		btn.setOnMouseClicked(event -> close(stage));
		// VBoxオブジェクトを生成。引数は子要素の間隔
		VBox vbox = new VBox(20d);
		// 配置位置を設定
		vbox.setAlignment(Pos.CENTER);

		// 出力用のラベルを生成
		List<Labeled> labelList = new ArrayList<Labeled>();
		labelList.add(lbl);
		labelList.add(btn);

		// 生成したラベルをVBoxに設定
		vbox.getChildren().addAll(labelList);

		Scene scene = new Scene(vbox, 240, 200, Color.WHITE);
		stage.setScene(scene);
	}

	public static void close(Stage stage) {
		stage.close();
	}

	public static void setScene(Stage stage, Scene changeScene) {
		stage.setScene(changeScene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}