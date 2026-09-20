import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonClickExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Press the button");
        Button button = new Button("Click me!");

        // Set an event handler for the button click
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //handle is the specific name that JavaFX requires for event handlers.
                // ActionEvent event is the parameter that JavaFX automatically passes to
                // the method when the button is clicked.
                // ActionEvent is an object that contains information about the click.
                label.setText("Button Clicked!");
            }
        });

        // Arrange controls vertically
        VBox root = new VBox(10); // spacing = 10 pixels
        root.getChildren().addAll(label, button);

        Scene scene = new Scene(root, 250, 150);
        primaryStage.setTitle("Button Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
