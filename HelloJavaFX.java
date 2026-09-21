import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label with the text
        Label label = new Label("Hello, JavaFX!");

        // Put the label in a layout container (StackPane centers its children)
        StackPane root = new StackPane(label);

        // Create a scene with the root and set its size
        Scene scene = new Scene(root, 300, 200);

        // Set the scene on the stage and show it
        primaryStage.setTitle("My First JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//javac --module-path "E:\Java\openjfx-24.0.2_windows-x64_bin-sdk\javafx-sdk-24.0.2\lib"
//--add-modules javafx.controls HelloJavaFX.java
