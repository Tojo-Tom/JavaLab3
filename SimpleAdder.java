import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleAdder extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        Button addButton = new Button("Add");
        Label resultLabel = new Label("Result: ");

        // Event handler for the button
        addButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double sum = num1 + num2;
                resultLabel.setText("Result: " + sum);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers");
            }
        });

        // Arrange in a grid: (row, column)
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("Number 1:"), 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(new Label("Number 2:"), 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(addButton, 0, 2);
        grid.add(resultLabel, 1, 2);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setTitle("Simple Adder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
