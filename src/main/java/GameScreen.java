import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.util.HashSet;
import java.awt.Color;
import java.util.ArrayList;

public class GameScreen extends JPanel implements KeyListener {

    Timer timer;
    Ball ball;
    Wall player1;
    Wall player2;
    private final HashSet<Integer> keys = new HashSet<>();

    public GameScreen() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(750, 750));
        setBackground(Color.GRAY);
        ball = new Ball(0, 0, 1, 1);
        player1 = new Wall(0, 275, 1);
        player2 = new Wall(675, 275, 2);
    }

    public void startTimer() {
        timer = new Timer(14, new TimerListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ball.move();
            for (Integer h: keys) {
                if (h == KeyEvent.VK_DOWN) {
                    player2.move(true);
                }
                if (h == KeyEvent.VK_UP) {
                    player2.move(false);
                }
                if (h == KeyEvent.VK_W) {
                    player1.move(false);
                }
                if (h == KeyEvent.VK_S) {
                    player1.move(true);
                }
            }
            player1.checkCollision(ball);
            player2.checkCollision(ball);
            /*At the end of each frame update, repaint the level to the panel*/
            repaint();
        }
    }

    /*Handles the user input for when Left, Right, and Up keys are pressed*/
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN
        || e.getKeyCode() == KeyEvent.VK_UP
        || e.getKeyCode() == KeyEvent.VK_W
        || e.getKeyCode() == KeyEvent.VK_S) {
            keys.add(e.getKeyCode());
        }
    }

    /*Handles the user release of the Left and Right keys*/
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN
        || e.getKeyCode() == KeyEvent.VK_UP
        || e.getKeyCode() == KeyEvent.VK_W
        || e.getKeyCode() == KeyEvent.VK_S) {
            keys.remove(e.getKeyCode());
        }
    }

    public void keyTyped(KeyEvent e) {}
}