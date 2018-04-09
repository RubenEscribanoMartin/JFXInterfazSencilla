package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * A <b>JavaFX</b> interface sencilla y funcional 
 * @author Ruben Escribano
 * @version 1.0
 * @see OneController
 * prueba commit 09 Afbril 2018
 */
public class Main extends Application {

	private AnchorPane rootLayout;

	/**
	 * Stage es una clase de JavaFX
	 */
	public Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {

			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("De eerste van Nederland");
			this.primaryStage.setX(200);
			this.primaryStage.setY(200);
			/**
			 * Cargamos la vista sin marco
			 */
			this.primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			
			initRootLayout();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initRootLayout() {

		try {
			
			/**
			 * Cargamos la raíz del Layout desde el FXML
			 */
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Layouts.fxml"));
			rootLayout = (AnchorPane) loader.load();

			/**
			 * Seleccionamos con qué medidas se abrirá la ventana
			 */
			Scene scene = new Scene(rootLayout, 500, 400);
			
			/**
			 * Aplicamos el cursos que hemos fabricado
			 */
			Image image = new Image("application/view/images/puntero.png");
			scene.setCursor(new ImageCursor(image)); 
			
			/**
			 * Le enchufamos el .css que también hemos creado
			 */
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			/**
			 * Aquí aplicamos las fuentes. Si queremos aplicarlas desde internet haremos lo siguiente;
			 * scene.getStylesheets().add("http://fuenteExterna_de_google.com")
			 */
			Font.loadFont(getClass().getResourceAsStream("../resources/fonts/TypoGraphica_demo.otf"), 14);
			
			primaryStage.setScene(scene);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
