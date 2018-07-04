import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
import javax.swing.JButton;
import java.awt.event.WindowEvent;

public class StartScreen extends JPanel {

    Timer timer;
    Ball ball;
    Wall player1;
    Wall player2;
    public static int p1_score = 0;
    public static int p2_score = 0;

    public StartScreen() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(750, 750));
        setBackground(Color.GRAY);
        // ball = new Ball(338, 338, 1, 1);
        // player1 = new Wall(0, 275, 1);
        // player2 = new Wall(675, 275, 2);
        
        JLabel title = new JLabel("Pong!");
        title.setFont(new Font("Verdana",Font.BOLD, 68));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(40));
        add(title);
        
        JButton start = new JButton("Start");
        start.addActionListener(new StartListener("Start"));
        start.setMinimumSize(new Dimension(166, 51));
        start.setPreferredSize(new Dimension(167, 52));
        start.setMaximumSize(new Dimension(168, 53));
        start.setFont(new Font("Verdana", Font.BOLD, 20));
        add(Box.createVerticalStrut(75));
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(start);

        JButton help = new JButton("Help");
        help.addActionListener(new HelpListener("Help"));
        help.setMinimumSize(new Dimension(166, 51));
        help.setPreferredSize(new Dimension(167, 52));
        help.setMaximumSize(new Dimension(168, 53));
        help.setFont(new Font("Verdana", Font.BOLD, 20));
        add(Box.createVerticalStrut(55));
        help.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(help);

        JButton options = new JButton("Options");
        options.addActionListener(new OptionsListener("Options"));
        options.setMinimumSize(new Dimension(166, 51));
        options.setPreferredSize(new Dimension(167, 52));
        options.setMaximumSize(new Dimension(168, 53));
        options.setFont(new Font("Verdana", Font.BOLD, 20));
        add(Box.createVerticalStrut(55));
        options.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(options);

        JButton quit = new JButton("Quit");
        quit.addActionListener(new QuitListener("Quit"));
        quit.setMinimumSize(new Dimension(166, 51));
        quit.setPreferredSize(new Dimension(167, 52));
        quit.setMaximumSize(new Dimension(168, 53));
        quit.setFont(new Font("Verdana", Font.BOLD, 20));
        add(Box.createVerticalStrut(55));
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(quit);
        repaint();
    }

    public void startTimer() {
        // timer = new Timer(14, new TimerListener());
        // timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // ball.draw(g);
        // player1.draw(g);
        // player2.draw(g);
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // ball.move();
            // player1.checkCollision(ball);
            // player2.checkCollision(ball);
            // /*At the end of each frame update, repaint the level to the panel*/
            // repaint();
        }
    }

    public class QuitListener implements ActionListener {
        private String name;

        public QuitListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    public class HelpListener implements ActionListener {
        private String name;

        public HelpListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            // Main.cardLayout.show(Game.cards, "HelpScreen");
        }
    }

    public class OptionsListener implements ActionListener {
        private String name;

        public OptionsListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            // Main.cardLayout.show(Game.cards, "HelpScreen");
        }
    }

    public class StartListener implements ActionListener {
        private String name;

        public StartListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            Main.running = false;
        }
    }
}