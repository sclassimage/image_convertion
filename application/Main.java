package application;



import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventDispatcher;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application{
	
  public static Scene scene1 = null;
  public static Scene scene2 = null;

  @Override
  public void start(Stage stage)throws Exception {

  stage.setTitle("HelloJavaFX");
  stage.setHeight(200);
  stage.setWidth(150);
  // �X�e�[�W�̍쐬
  initScene1(stage);
  stage.setScene(scene1);
  

  stage.show();
  }

  public void initScene1(Stage stage) {
	  BorderPane root;
	try {
		root = (BorderPane) FXMLLoader.load(getClass().getResource("Menu.fxml"));
	} catch (IOException e) {
		// TODO �����������ꂽ catch �u���b�N
		e.printStackTrace();
		return;
	}
	  Scene scene = new Scene(root, 500, 200);
	  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	  
	  scene1 = new Scene(root);
  }
  
  public static void initScene2(Stage stage, boolean ans) {
	  String ansstr;
	  int colnum;
	  if(ans) {
		  ansstr = "�t�@�C�����ϊ�����܂����I";
		  colnum = 1;
	  }else {
		  ansstr = "�t�@�C�����ϊ�����܂���ł���";
		  colnum = 0;
	  }
    AnchorPane root = new AnchorPane();
    root.setPadding(new Insets(20, 0, 20, 20));
    scene2 = new Scene(root);

    Label lbl = new Label(ansstr);
    Color[] colors = new Color[]{Color.BLUE, Color.RED};
    lbl.setTextFill(colors[colnum]);

    
    Button btn = new Button("����");
    setScene(stage,scene2);
    btn.setPrefWidth(100);
    btn.setPrefHeight(50);
    btn.setOnMouseClicked(event -> close(stage));
 // VBox�I�u�W�F�N�g�𐶐��B�����͎q�v�f�̊Ԋu
    VBox vbox = new VBox(20d);
    // �z�u�ʒu��ݒ�
    vbox.setAlignment(Pos.CENTER);
    
    // �o�͗p�̃��x���𐶐�
    List<Labeled> labelList = new ArrayList<Labeled>();
    labelList.add(lbl);
    labelList.add(btn);
    
    // �����������x����VBox�ɐݒ�
    vbox.getChildren().addAll(labelList);

    Scene scene = new Scene(vbox, 240, 480, Color.WHITE);
    stage.setScene(scene);
  }
  
  public static void close(Stage stage) {
	  stage.close();
  }
  
  public static  void setScene(Stage stage,Scene changeScene) {
    stage.setScene(changeScene);
    stage.show();
  }
  
  	public static void main(String[] args) {
		launch(args);
	}
}