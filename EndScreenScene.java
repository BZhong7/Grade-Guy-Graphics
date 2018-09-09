import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Parent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;

import javafx.geometry.Pos; //For usage for setAlignment.
import javafx.geometry.Insets; //For usage for setMargin.

import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.*;

import javafx.stage.Stage;

/**
 * EndScreenScene generates the GUI for the
 * game's high scores as well as buttons to
 * play the game again or return to the title screen.
 */
public class EndScreenScene extends Parent {
    
    BorderPane endScreen;
    
    private Label victoryLabel, defeatLabel, winMessageLabel, loseMessageLabel;
    private Label rankOne, rankTwo, rankThree, rankFour, rankFive;

    /**
     * Constructor that generates all the necessary
     * GUI elements for the end of the game.
     */
    EndScreenScene() {

        //victoryLabel displays text to indicate
        //that the user has won the game.
        victoryLabel = new Label("VICTORY!");
        victoryLabel.setFont(new Font("Bauhaus 93", 80));
        victoryLabel.setStyle("-fx-background-color: #ffffff");
        victoryLabel.setVisible(false);

        //defeatLabel displays text to indicate
        //that the user has lost the game.
        defeatLabel = new Label("DEFEATED!");
        defeatLabel.setFont(new Font("Bauhaus 93", 80));
        defeatLabel.setStyle("-fx-background-color: #ffffff");
        defeatLabel.setVisible(false);

        //victoryOrDefeat is a StackPane that holds the
        //victoryLabel and defeatLabel.
        //The labels are made visible based on whether
        //the user has won or lost the game.
        StackPane victoryOrDefeat = new StackPane();
        victoryOrDefeat.getChildren().addAll(victoryLabel, defeatLabel);

        //winMessageLabel is displayed when the user has won the game.
        winMessageLabel = new Label("Congratulations! You have graduated from" + "\n"
                                    + "Brooklyn College. Your final GPA is 0.0." 
                                    + "\n" + "Here are the top graduates:");
        winMessageLabel.setFont(new Font("Bauhaus 93", 24));
        winMessageLabel.setStyle("-fx-background-color: #ffffff");
        winMessageLabel.setVisible(false);
        
        //loseMessageLabel is displayed when the user has lost the game.
        loseMessageLabel = new Label("Sorry! You have failed this time." + "\n"
                                     + "Your final GPA is 0.0."
                                     + "\n" + "Here are the top graduates:");
        loseMessageLabel.setFont(new Font("Bauhaus 93", 24));
        loseMessageLabel.setVisible(false);

        //winLoseStackPane holds the victory/defeat messages
        //in a single space.
        StackPane winLoseStackPane = new StackPane();
        Rectangle recWinLose = new Rectangle(600, 200, Color.WHITE);
        winLoseStackPane.getChildren().addAll(recWinLose, winMessageLabel, loseMessageLabel);
        winLoseStackPane.setAlignment(Pos.CENTER);

        //The rank labels holds the top 5 scores and their names.
        rankOne = new Label("1. NUL 0.0");
        rankOne.setFont(new Font("Bauhaus 93", 20));

        rankTwo = new Label("2. NUL 0.0");
        rankTwo.setFont(new Font("Bauhaus 93", 20));

        rankThree = new Label("3. NUL 0.0");
        rankThree.setFont(new Font("Bauhaus 93", 20));

        rankFour = new Label("4. NUL 0.0");
        rankFour.setFont(new Font("Bauhaus 93", 20));

        rankFive = new Label("5. NUL 0.0");
        rankFive.setFont(new Font("Bauhaus 93", 20));
        

        //listOfScores sorts both the winLoseStackPane object
        //and the rank labels vertically.
        VBox listOfScores = new VBox();
        listOfScores.getChildren().addAll(winLoseStackPane, rankOne, rankTwo,
                                          rankThree, rankFour, rankFive);
        listOfScores.setAlignment(Pos.TOP_CENTER);

        //tryAgainButton places the user at the game screen
        //to play the game again.
        Button tryAgainButton = new Button("Try Again");
        tryAgainButton.setFont(new Font(20));
        tryAgainButton.setMinSize(200, 50);

        //exitButton sends the user back to the title screen.
        Button exitButton = new Button("Exit");
        exitButton.setFont(new Font(20));
        exitButton.setMinSize(200, 50);
        //exitButton.addActionListener(new ExitListener());

        //listOfButtons sorts tryAgainButton
        //and exitButton horizontally.
        HBox listOfButtons = new HBox(50);
        listOfButtons.getChildren().addAll(tryAgainButton, exitButton);
        listOfButtons.setAlignment(Pos.CENTER);

        //endScreen is a BorderPane that ties together all of the
        //GUI and places them in the appropriate location.
        endScreen = new BorderPane();
        endScreen.setMargin(listOfButtons, new Insets(0,0,50,0));
        endScreen.setStyle("-fx-background-color: #ffffff");
        endScreen.setTop(victoryOrDefeat);
        endScreen.setCenter(listOfScores);
        endScreen.setBottom(listOfButtons);

    }

    /**
     * returns endScreen as a Parent to be added to a scene.
     */
    public Parent getView() {
        return endScreen;
    }

    /**
     * ExitListener 
     */

    /**
     * setFinalScore modifies the text in the message labels to reflect
     * the final score.
     */
    public void setFinalScore(double num) {
        winMessageLabel.setText("Congratulations! You have graduated from" + "\n"
                                + "Brooklyn College. Your final GPA is " + num
                                + "." + "\n" + "Here are the top graduates:");
        loseMessageLabel.setText("Sorry! You have failed this time." + "\n"
                                 + "Your final GPA is " + num + "."
                                 + "\n" + "Here are the top graduates:");
    }

    /**
     * showWinOrLoseMessage determines whether the
     * victoryLabel or defeatLabel is displayed.
     * If the player won, victoryLabel and
     * winMessageLabel is made visible.
     * Otherwise, defeatLabel and
     * loseMessageLabel is made visible.
     */
    public void showWinOrLoseMessage(boolean n) {
        if(n == true) {
            victoryLabel.setVisible(true);
            winMessageLabel.setVisible(true);
        }
        else {
            defeatLabel.setVisible(true);
            loseMessageLabel.setVisible(true);
        }
    }

    /**
     * setRankOne modifies the text within the label
     * rankOne.
     * It takes a String and a double as parameters.
     */
    public void setRankOne(String name, double GPA) {
        rankOne.setText("1. " + name + " " + GPA);
    }

    /**
     * setRankTwo modifies the text within the label
     * rankTwo.
     * It takes a String and a double as parameters.
     */
    public void setRankTwo(String name, double GPA) {
        rankTwo.setText("2. " + name + " " + GPA);
    }

    /**
     * setRankThree modifies the text within the label
     * rankThree.
     * It takes a String and a double as parameters.
     */
    public void setRankThree(String name, double GPA) {
        rankThree.setText("3. " + name + " " + GPA);
    }

    /**
     * setRankFour modifies the text within the label
     * rankFour.
     * It takes a String and a double as a parameter.
     */
    public void setRankFour(String name, double GPA) {
        rankFour.setText("4. " + name + " " + GPA);
    }

    /**
     * setRankFive modifies the text within the label
     * rankFive.
     * It takes a String and a double as a parameter.
     */
    public void setRankFive(String name, double GPA) {
        rankFive.setText("5. " + name + " " + GPA);
    }

    /**
     * resetVictoryAndDefeat sets the visibility of
     * both the victoryLabel and defeatLabel to be
     * invisible.
     * It also sets winMessageLabel and loseMessageLabel
     * to be invisible.
     */
    public void resetVictoryAndDefeat() {
        victoryLabel.setVisible(false);
        winMessageLabel.setVisible(false);
        defeatLabel.setVisible(false);
        loseMessageLabel.setVisible(false);
    }
}
