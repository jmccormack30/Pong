import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.util.HashSet;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Font;
import java.util.ArrayList;

public class GameScreen extends JPanel implements KeyListener {

    public static Timer timer;
    Ball ball;
    Wall player1;
    Wall player2;
    JLabel one, two, three;
    private final HashSet<Integer> keys = new HashSet<>();

    public GameScreen() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(750, 750));
        setBackground(Color.GRAY);
        ball = new Ball(338, 338, 1, 1);
        player1 = new Wall(0, 275, 1);
        player2 = new Wall(675, 275, 2);
    }

    public void startTimer() {
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    System.out.println("Ball Speed up x1");
                    ball.setSpeed(ball.getSpeed()+1);
                }
            }, 
            6520 
        );
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    System.out.println();
                    System.out.println("Ball Speed up x2");
                    ball.setSpeed(ball.getSpeed()+1);
                }
            }, 
            15000 
        );
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    System.out.println();
                    System.out.println("Ball Speed up x3");
                    ball.setSpeed(ball.getSpeed()+1);
                }
            }, 
            19500 
        );
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    System.out.println();
                    System.out.println("Ball Speed up x4");
                    ball.setSpeed(ball.getSpeed()+1);
                }
            }, 
            26000
        );
        timer = new Timer(14, new TimerListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
    }

    public void setUp() {
        three = new JLabel("3");
        three.setFont(new Font("Verdana", Font.BOLD, 60));
        three.setForeground(Color.BLACK);
        three.setAlignmentX(Component.CENTER_ALIGNMENT);
        two = new JLabel("2");
        two.setFont(new Font("Verdana", Font.BOLD, 60));
        two.setForeground(Color.BLACK);
        two.setAlignmentX(Component.CENTER_ALIGNMENT);
        one = new JLabel("1");
        one.setFont(new Font("Verdana", Font.BOLD, 60));
        one.setForeground(Color.BLACK);
        one.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(225));
        add(three);
        Main.frame.validate();
        Main.frame.repaint();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getMessage();
        }
        remove(three);
        Main.frame.validate();
        Main.frame.repaint();
        add(two);
        Main.frame.validate();
        Main.frame.repaint();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getMessage();
        }
        remove(two);
        Main.frame.validate();
        Main.frame.repaint();
        add(one);
        Main.frame.validate();
        Main.frame.repaint();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getMessage();
        }
        remove(one);
        startTimer();
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