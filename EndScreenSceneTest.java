import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * EndScreenSceneTest was made in order to test EndScreenScene in isolation.
 * Should any problems occur with EndScreenScene, this program can be used
 * to run EndScreenScene separate from other files.
 *
 * As it is used mainly for testing it should not be included in the final
 * build of the Grade Guy program.
 */
public class EndScreenSceneTest extends Application {
    /**
     * main runs the start method, which should generate the GUI components
     * of EndScreenScene.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * start generates a 1000 x 600 pixel window and places
     * endScene inside the window.
     */
    public void start(Stage primaryStage) {
        EndScreenScene module = new EndScreenScene();

        Scene endScene = new Scene(module.getView(), 1000, 600);

        //Testing function calls for EndScreenScene.
        module.showWinOrLoseMessage(true);
        module.setFinalScore(2.34);
        module.setRankOne("HEY", 3.0);
        module.setRankTwo("THS", 2.9);
        module.setRankThree("ISS", 2.34);
        module.setRankFour("AAA", 1.29);
        module.setRankFive("TST", 0.4);

        primaryStage.setTitle("Grade Guy (EndScreenSceneTest)");
        primaryStage.setScene(endScene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
