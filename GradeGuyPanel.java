import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * GradeGuyPanel, for now, generates the Title Screen GUI.
 * Will probably undergo major changes as development continues.
 *
 * @author Brandon Zhong
 */
public class GradeGuyPanel extends JPanel {
    JPanel titleScreen,
           mainMenu,
           titleName;
    JButton newGame,
            gameRecord,
            credits;

    /**
     * Constructor creates all of the necessary GUI components.
     */
    GradeGuyPanel() {
        
        //titleName is the panel that holds the name of the game
        titleName = new JPanel();
        JLabel titleLabel = new JLabel("Grade Guy");
        titleLabel.setFont(new Font("", Font.PLAIN, 25));
        titleName.add(titleLabel);

        //mainMenu will hold all of the buttons for the titleScreen.
        mainMenu = new JPanel();
        mainMenu.setLayout(new GridLayout(3, 1, 100, 50));

        newGame = new JButton("New Game");
        gameRecord = new JButton("Game Record");
        credits = new JButton("Credits");

        mainMenu.add(newGame);
        mainMenu.add(gameRecord);
        mainMenu.add(credits);

        //titleScreen is the panel that holds mainMenu and titleName
        titleScreen = new JPanel();
        titleScreen.setLayout(new BorderLayout(100, 100));

        //blankPanel exists solely for formatting purposes.
        //They prevent mainMenu and titleName from taking up too much space.
        JPanel blankPanel1 = new JPanel();
        JPanel blankPanel2 = new JPanel();
        JPanel blankPanel3 = new JPanel();

        titleScreen.add(mainMenu, BorderLayout.CENTER);
        titleScreen.add(titleName, BorderLayout.NORTH);
        titleScreen.add(blankPanel1, BorderLayout.EAST);
        titleScreen.add(blankPanel2, BorderLayout.WEST);
        titleScreen.add(blankPanel3, BorderLayout.SOUTH);

        //Should allow swapping between panels or "screens"
        this.setLayout(new CardLayout());
        this.add(titleScreen);
    }
}
