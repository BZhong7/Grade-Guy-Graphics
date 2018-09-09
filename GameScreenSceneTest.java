import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * GameScreenSceneTest was made in order to test GameScreenScene in isolation.
 * Should any problems occur with GameScreenScene, this program can be used
 * to run GameScreenScene separate from other files.
 *
 * As it is used mainly for testing it should not be included in the final
 * build of the Grade Guy program.
 */
public class GameScreenSceneTest extends Application {
    /**
     * main runs the start method, which should generate the GUI components
     * of GameScreenScene.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * start generates a 1000 x 600 pixel window and places
     * gameScene inside the window.
     */
    public void start(Stage primaryStage) {
        GameScreenScene module = new GameScreenScene();

        Scene gameScene = new Scene(module.getView(), 1000, 600);

        //Testing function calls for GameScreenScene.
        module.setGPA(3.0);
        module.setMode(3);
        module.setNumLives(3);
        module.setProfStatus(3);

        //module.toggleStartLabel(true);
        //module.togglePauseGUI(true);
        //module.toggleGameOverLabel(true);
        //module.toggleCongratsLabel(true);

        //module.toggleStartLabel();
        //module.togglePauseGUI();
        //module.toggleGameOverLabel();
        //module.toggleCongratsLabel();

        //module.resetGameScreen();

        primaryStage.setTitle("Grade Guy (GameSceneScreenTest)");
        primaryStage.setScene(gameScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
