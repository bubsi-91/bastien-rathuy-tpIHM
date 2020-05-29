package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Graphical editor");
        primaryStage.setScene(new Scene(root, 650, 402));
        primaryStage.setResizable(false);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
