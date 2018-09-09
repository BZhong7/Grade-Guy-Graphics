import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

/**
 * GGmain program creates GUI and runs it.
 * It should generate all the GUI for the game including
 * the title screen, game screen, and the victory and defeat screens.
 * Each screen will be displayed on a single window and the program
 * will swap between each screen depending on the game's current state.
 *
 * This is mainly for testing purposes by Graphics Team
 * and will be modified often to test programs.
 */
public class GGmain extends Application {
    /**
     * main runs the start method, which should generate the GUI components.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Generates a window to place all GUI components.
     * The window is 1000 x 600 pixels.
     */
    public void start(Stage primaryStage) {
        GameScreenScene secondModule = new GameScreenScene();
        StackPane root = new StackPane();

        Scene primaryScene = new Scene(root, 1000, 600);
        Scene gameScene = new Scene(secondModule.getView(), 1000, 600);

        primaryStage.setTitle("Grade Guy");
        primaryStage.setScene(gameScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
