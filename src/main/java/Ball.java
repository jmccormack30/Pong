import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;
import javafx.fxml.FXMLLoader;

public class Ball {
    
    private int xPos, yPos;
    private ImageIcon image;
    private String path = "images/b_maroon.png";
    private int right = 1;
    private int down = 1;
    private int speed = 3;

    public Ball(int xPos, int yPos, int right, int down) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.right = right;
        this.down = down;
        image = new ImageIcon(getClass().getResource(path));
    }

    public int getXPos() {
        return xPos;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getYPos() {
        return yPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public int getRight() {
        return right;
    }

    public int getDown() {
        return down;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public void move() {
        if ((yPos + 75) > 750) {
            down = 0;
        }
        if (yPos < 0) {
            down = 1;
        }
        if (right == 1) {
            xPos += speed;
        } else if (right == 0) {
            xPos -= speed;
        } else {
            xPos = xPos;
        }
        if (down == 1) {
            yPos += speed;
        } else if (down == 0) {
            yPos -= speed;
        } else {
            xPos = xPos;
        }
    }

    public void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
}