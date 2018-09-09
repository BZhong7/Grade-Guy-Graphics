import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Parent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos; //For usage for setAlignment

import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.paint.Color; //To add color to rectangles
import javafx.scene.shape.Rectangle;

import javafx.scene.text.*; //For usage for setFont

import javafx.stage.Stage;

/**
 * GameScreenScene generates GUI relating to gameplay
 * such as the maze and score.
 */
public class GameScreenScene extends Parent {

    VBox statusPane;
    BorderPane gameScreen;
    Label startLabel, pauseLabel, gameOverLabel, congratsLabel;
    ImageView viewPauseMenu;
    Text currentScore, currentLevel, currentLives, currentProfStatus;
    int numLives = 1;

    /**
     * Constructor creates all necessary GUI components
     * for GameScreenScene.
     */
     GameScreenScene() {

        //VIEWMAZESTACKPANE
        //viewMaze shows a picture of the maze that the game takes place in.
        //Additional labels are added to indicate if the game is paused or not.
        //All of it is then added to a StackPane.
        //The dimensions of the maze is 800 x 600 pixels.
        //It is located on the left side of the screen.
        Image mazeImage = new Image("images/TestPacmanLevel_Yellow.png");
        ImageView viewMaze = new ImageView();
        viewMaze.setImage(mazeImage);

        startLabel = new Label("START!");
        startLabel.setFont(new Font("Bauhaus 93", 93));
        startLabel.setStyle("-fx-background-color: #ffffff");
        startLabel.setVisible(false);

        pauseLabel = new Label("PAUSED");
        pauseLabel.setFont(new Font("Bauhaus 93", 93));
        pauseLabel.setStyle("-fx-background-color: #ffffff");
        pauseLabel.setVisible(false);

        gameOverLabel = new Label("GAME OVER");
        gameOverLabel.setFont(new Font("Bauhaus 93", 93));
        gameOverLabel.setStyle("-fx-background-color: #ffffff");
        gameOverLabel.setVisible(false);

        congratsLabel = new Label("Congratulations!" + "\n"
                                  + "You've graduated!");
        congratsLabel.setFont(new Font("Bauhaus 93", 80));
        congratsLabel.setStyle("-fx-background-color: #ffffff");
        congratsLabel.setVisible(false);

        StackPane viewMazeStackPane = new StackPane();
        viewMazeStackPane.getChildren().addAll(viewMaze, startLabel, pauseLabel,
                                               gameOverLabel, congratsLabel);
        viewMazeStackPane.setAlignment(Pos.CENTER);

        //LABELGPASTACKPANE and CURRENTSCORESTACKPANE
        //Multiple Panes will be made to hold and organize GPA text and score.
        //Rectangle helps place the label and text in the center.
        //These pieces will be placed in a BorderPane.
        StackPane labelGPAStackPane = new StackPane();
        StackPane currentScoreStackPane = new StackPane();
        Rectangle recGPA1 = new Rectangle(200, 50, Color.WHITE);
        Rectangle recGPA2 = new Rectangle(200, 50, Color.WHITE);

        Label labelGPA = new Label("GPA");
        labelGPA.setFont(new Font(24));
        currentScore = new Text("0.0");
        currentScore.setFont(new Font(20));

        labelGPAStackPane.getChildren().addAll(recGPA1, labelGPA);
        currentScoreStackPane.getChildren().addAll(recGPA2, currentScore);

        //borderPaneGPA ties together the two StackPanes.
        BorderPane borderPaneGPA = new BorderPane();
        borderPaneGPA.setTop(labelGPAStackPane);
        borderPaneGPA.setCenter(currentScoreStackPane);

        //LABELMODESTACKPANE and CURRENTLEVELSTACKPANE
        //GUI for Mode and current level.
        //Multiple panes to hold and organize Mode text and current difficulty.
        //Rectangle helps with centering label and text.
        StackPane labelModeStackPane = new StackPane();
        StackPane currentLevelStackPane = new StackPane();
        Rectangle recMode1 = new Rectangle(200, 50, Color.WHITE);
        Rectangle recMode2 = new Rectangle(200, 50, Color.WHITE);

        Label labelMode = new Label("STAGE");
        labelMode.setFont(new Font(24));
        currentLevel = new Text("Freshman");
        currentLevel.setFont(new Font(20));

        labelModeStackPane.getChildren().addAll(recMode1, labelMode);
        currentLevelStackPane.getChildren().addAll(recMode2, currentLevel);

        //borderPaneMode ties together the two StackPanes for
        //Mode and current level.
        BorderPane borderPaneMode = new BorderPane();
        borderPaneMode.setTop(labelModeStackPane);
        borderPaneMode.setCenter(currentLevelStackPane);

        //LABELLIFE AND BORDERPANELIVES
        //GUI for number of lives left.
        //Mulitple panes are used to organize the labels and numbers.
        Label labelLife = new Label("Lives");
        labelLife.setFont(new Font(24));

        BorderPane.setAlignment(labelLife, Pos.TOP_CENTER);
        currentLives = new Text("x" + numLives);
        currentLives.setFont(new Font(20));

        BorderPane borderPaneLives = new BorderPane();
        borderPaneLives.setTop(labelLife);
        borderPaneLives.setCenter(currentLives);

        //LABELPROFSTACKPANE and CURRENTSTATUSSTACKPANE
        //GUI for Prof Gross status.
        //Multiple panes to hold and organize Prof text and current status.
        //Rectangle helps with centering label and text.
        StackPane labelProfStackPane = new StackPane();
        StackPane currentStatusStackPane = new StackPane();
        Rectangle recProf1 = new Rectangle(200, 50, Color.WHITE);
        Rectangle recProf2 = new Rectangle(200, 50, Color.WHITE);
        
        Label labelProf = new Label("PROF GROSS");
        labelProf.setFont(new Font(24));
        currentProfStatus = new Text("Wandering");
        currentProfStatus.setFont(new Font(20));
        
        labelProfStackPane.getChildren().addAll(recProf1, labelProf);
        currentStatusStackPane.getChildren().addAll(recProf2, currentProfStatus);
        
        //BORDERPANEPROF
        //borderPaneProf ties together the two StackPanes.
        BorderPane borderPaneProf = new BorderPane();
        borderPaneProf.setTop(labelProfStackPane);
        borderPaneProf.setCenter(currentStatusStackPane);

        //VIEWCONTROL and VIEWPAUSE
        //viewControl and viewPause are images that are added to the VBox.
        Image controlImage = new Image("images/Controls_Graphic.png");
        Image pauseImage = new Image("images/Pause_Graphic.png");
        ImageView viewControl = new ImageView();
        ImageView viewPause = new ImageView();
        viewControl.setImage(controlImage);
        viewPause.setImage(pauseImage);

        //STATUSPANE
        //statusPane holds the menu graphics and game information
        //such as score and current level.
        //The dimensions of this pane is 200 x 600 pixels.
        //It is located on the right side of the screen.
        statusPane = new VBox();
        statusPane.getChildren().addAll(borderPaneGPA, borderPaneMode,
                                        borderPaneLives, borderPaneProf,
                                        viewControl, viewPause);
        statusPane.setAlignment(Pos.TOP_CENTER);
        statusPane.setStyle("-fx-background-color: #ffffff");

        //VIEWPAUSEMENU
        //viewPauseMenu places an image of the pause menu on
        //the right side of the screen.
        //It is placed on top of the status menu.
        //This appears when the game is "paused" and reappears when "unpaused."
        Image pauseMenuImage = new Image("images/Pause_Menu.png");
        viewPauseMenu = new ImageView();
        viewPauseMenu.setImage(pauseMenuImage);
        viewPauseMenu.setVisible(false);

        //SIDEMENUSTACKPANE
        //sideMenuStackPane places statusPane, viewPauseMenu, and
        //other sub-menus in a single StackPane.
        StackPane sideMenuStackPane = new StackPane();
        sideMenuStackPane.getChildren().addAll(statusPane, viewPauseMenu);
        
        //GAMESCREEN
        //gameScreen ties together viewMazeStackPane and sideMenuStackPane.
        //onto a single BorderPane.
        gameScreen = new BorderPane();
        gameScreen.setRight(sideMenuStackPane);
        gameScreen.setLeft(viewMazeStackPane);
    }

    /**
     * returns gameScreen as a Parent to be added to a scene.
     */
    public Parent getView() {
        return gameScreen;
    }

    /**
     * setGPA takes in a double, converts it into a string,
     * and assigns the value to currentScore.
     */
    public void setGPA(double n) {
        currentScore.setText(Double.toString(n));
    }

    /**
     * setMode assigns text to currentLevel based on an integer value.
     * 0 is Freshman,
     * 1 is Sophmore,
     * 2 is Junior,
     * any other number is senior.
     */
    public void setMode(int n) {
        if(n == 0)
            currentLevel.setText("Freshman");
        else if(n == 1)
            currentLevel.setText("Sophmore");
        else if(n == 2)
            currentLevel.setText("Junior");
        else
            currentLevel.setText("Senior");
    }

    /**
     * setNumLives assigns an integer value to numLives and then
     * assigns a text value to currentLives.
     */
    public void setNumLives(int n) {
        numLives = n;

        currentLives.setText("x" + numLives);
    }

    /**
     * setProfStatus assigns text to currentProfStatus based on an integer.
     * 0 is Wandering,
     * 1 is Incoming,
     * any other number is Has left.
     */
    public void setProfStatus(int n) {
        if(n == 0)
            currentProfStatus.setText("Wandering");
        else if(n == 1)
            currentProfStatus.setText("Incoming");
        else
            currentProfStatus.setText("Has left");
    }

    /**
     * toggleStartLabel sets the visibility of startLabel.
     * Its visibility is based on a boolean value;
     * Ture is visible and false is invisible.
     * It is off by default.
     */
    public void toggleStartLabel(boolean n) {
        startLabel.setVisible(n);
    }

    /**
     * This version of toggleStartLabel accepts no parameters,
     * making startLabel visible if it's invisble
     * and vice versa.
     */
    public void toggleStartLabel() {
        if(startLabel.isVisible() == false)
            startLabel.setVisible(true);
        else
            startLabel.setVisible(false);
    }

    /**
     * togglePauseGUI sets the visibility of pauseLabel
     * and viewPauseMenu.
     * Its visibility is based on a boolean value;
     * True is visible and false is invisible.
     * It is off by default.
     */
    public void togglePauseGUI(boolean n) {
        pauseLabel.setVisible(n);
        viewPauseMenu.setVisible(n);
    }

    /**
     * This version of togglePauseGUI accepts no parameters,
     * making both pauseLabel and viewPauseMenu visible
     * if it's invisible and vice versa.
     */
    public void togglePauseGUI() {
        if(pauseLabel.isVisible() == false) {
            pauseLabel.setVisible(true);
            viewPauseMenu.setVisible(true);
        }
        else {
            pauseLabel.setVisible(false);
            viewPauseMenu.setVisible(false);
        }
    }

    /**
     * toggleGameOverLabel sets the visibility of gameOverLabel.
     * It accepts a boolean value and sets the visibility based on that.
     * It's off by default.
     */
    public void toggleGameOverLabel(boolean n) {
        gameOverLabel.setVisible(n);
    }

    /**
     * This version of toggleGameOverLabel accepts no parameters,
     * making gameOverLabel visible if it's invisible
     * and vice versa.
     */
    public void toggleGameOverLabel() {
        if(gameOverLabel.isVisible() == false)
            gameOverLabel.setVisible(true);
        else
            gameOverLabel.setVisible(false);
    }

    /**
     * toggleCongratsLabel sets the visibility of congratsLabel.
     * It accepts a boolean value and sets the visibility based on that.
     * It's off by default.
     */
    public void toggleCongratsLabel(boolean n) {
        congratsLabel.setVisible(n);
    }

    /**
     * This version of toggleCongratsLabel accepts no parameters,
     * making congratsLabel visible if it's invisible
     * and vice versa.
     */
    public void toggleCongratsLabel() {
        if(congratsLabel.isVisible() == false)
            congratsLabel.setVisible(true);
        else
            congratsLabel.setVisible(false);
    }

    /**resetGameScreen sets ALL values in GameScreenScene
     * to their default values.
     */
    public void resetGameScreen() {
        setGPA(0.0);
        setMode(0);
        setNumLives(1);
        setProfStatus(0);
        toggleStartLabel(false);
        togglePauseGUI(false);
        toggleGameOverLabel(false);
        toggleCongratsLabel(false);
    }
    
}

