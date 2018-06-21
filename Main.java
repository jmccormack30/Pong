import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Font;

public class Main {

    public static JFrame frame;
    public static JPanel cards;
    public static CardLayout cardLayout;
    public static GameScreen mainScreen;

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }

    public void start() {
        frame = new JFrame("Pong!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(750, 750));
        frame.setResizable(false);

        //Sets the Game Frame to be centered to the User's monitor
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        cards = new JPanel(new CardLayout());
        mainScreen = new GameScreen();
        cards.add(mainScreen, "mainScreen");
        frame.add(cards);
        frame.pack();
        frame.setVisible(true);
        cardLayout = (CardLayout) cards.getLayout();
        mainScreen.addKeyListener(mainScreen);
        mainScreen.setFocusable(true);
        mainScreen.requestFocusInWindow();
        mainScreen.startTimer();
        mainScreen.requestFocus();
    }
}