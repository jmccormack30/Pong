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
import javax.swing.ImageIcon;
import java.util.HashSet;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Font;
import java.util.ArrayList;

public class GameScreen extends JPanel implements KeyListener {

    public static Timer timer;
    public static Timer timer2;
    Ball ball;
    Wall player1;
    Wall player2;
    public static int p1_score = 0;
    public static int p2_score = 0;
    JLabel score;
    JLabel one, two, three;
    Counter c1, c2, c3;
    public static java.util.Timer t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    public static boolean countdown1 = false;
    public static boolean countdown2 = false;
    public static boolean countdown3 = true;
    public static boolean boolean1 = false;
    public static boolean boolean2 = false;
    private final HashSet<Integer> keys = new HashSet<>();


    public GameScreen() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(750, 750));
        setBackground(Color.GRAY);
        ball = new Ball(338, 338, 1, 1);
        player1 = new Wall(0, 275, 1);
        player2 = new Wall(675, 275, 2);
        c1 = new Counter(346, 250, "images/1.png");
        c2 = new Counter(346, 250, "images/2.png");
        c3 = new Counter(346, 250, "images/3.png");
        score = new JLabel(Integer.toString(p1_score) + " - " + Integer.toString(p2_score));
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
        score.setFont(new Font("Verdana", Font.BOLD, 46));
        add(score);
    }

    public void startTimer() {
        t1 = new java.util.Timer();
        t1.schedule(
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean1 = true;
                }
            },
            5900
        );
        t2 = new java.util.Timer();
        t2.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean1 = true;
                }
            }, 
            11800
        );
        t3 = new java.util.Timer();
        t3.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean1 = true;
                }
            }, 
            22720
        );
        t4 = new java.util.Timer();
        t4.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean1 = true;
                }
            }, 
            31000
        );
        t5 = new java.util.Timer();
        t5.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            42000
        );
        t6 = new java.util.Timer();
        t6.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            51000
        );
        t7 = new java.util.Timer();
        t7.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            62000
        );
        t8 = new java.util.Timer();
        t8.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            71000
        );
        t9 = new java.util.Timer();
        t9.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            79000
        );
        t10 = new java.util.Timer();
        t10.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            85000
        );
        t11 = new java.util.Timer();
        t11.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            92000
        );
        t12 = new java.util.Timer();
        t12.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            100000
        );
        timer = new Timer(14, new TimerListener());
        t13 = new java.util.Timer();
        t13.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            106000
        );
        timer = new Timer(14, new TimerListener());
        t14 = new java.util.Timer();
        t14.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    boolean2 = true;
                }
            }, 
            112000
        );
        timer = new Timer(14, new TimerListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
        if (countdown3) c3.draw(g);
        if (countdown2) c2.draw(g);
        if (countdown1) c1.draw(g);
    }

    public void setUp() {
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    countdown3 = false;
                    countdown2 = true;
                    repaint();
                }
            }, 
            1050
        );
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    countdown2 = false;
                    countdown1 = true;
                    repaint();
                }
            }, 
            2100
        );
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    countdown1 = false;
                    startTimer();
                    repaint();
                }
            }, 
            3150
        );
        repaint();
    }

    public void restart() {
        ball.setXPos(338);
        ball.setYPos(338);
        ball.setSpeed(2);
        ball.setDown(1);
        ball.setRight(1);
        player1.setYPos(275);
        player2.setYPos(275);
        countdown3 = true;
        score.setText(Integer.toString(p1_score) + " - " + Integer.toString(p2_score));
        setUp();
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
            if (boolean1) {
                if (player1.checkCollision(ball) || player2.checkCollision(ball)) {
                    ball.setSpeed(ball.getSpeed()+1);
                    boolean1 = false;
                }
            }
            if (boolean2) {
                if (player1.checkCollision(ball) || player2.checkCollision(ball)) {
                    ball.setSpeed(ball.getSpeed()+2);
                    boolean2 = false;
                }
            }
            if (ball.getXPos() < -155 || ball.getXPos() > 800) {
                if (ball.getXPos() < -155) {
                    p2_score += 1;
                } else {
                    p1_score += 1;
                }
                timer.stop();
                t1.cancel();
                t2.cancel();
                t3.cancel();
                t4.cancel();
                t5.cancel();
                t6.cancel();
                t7.cancel();
                t8.cancel();
                t9.cancel();
                t10.cancel();
                t11.cancel();
                t12.cancel();
                t13.cancel();
                t14.cancel();
                boolean1 = false;
                boolean2 = false;
                new java.util.Timer().schedule( 
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            restart();
                        }
                    }, 
                    350
                );
            }
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