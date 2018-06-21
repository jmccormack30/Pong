import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall {
    
    private int xPos, yPos;
    private ImageIcon image;
    private String path = "images/w_bluegray.png";
    private int player;

    public Wall(int xPos, int yPos, int player) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.player = player;
        this.image = new ImageIcon(getClass().getResource(path));
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void move(boolean direction) {
        if ((yPos + 200) > 750) {
            yPos = 550;
        }
        if (yPos < 0) {
            yPos = 0;
        }
        if (direction) {
            yPos += 8;
        } else {
            yPos -= 8;
        }
    }

    public boolean checkCollision(Ball ball) {
        Rectangle r1 = new Rectangle(xPos, yPos, 75, 200);
        Rectangle r2 = new Rectangle(ball.getXPos(), ball.getYPos(), 75, 75);
        if (r1.intersects(r2)) {
            if (player == 1) {
                if ((ball.getXPos() < (xPos + 74)) && (ball.getXPos() > (xPos + 62))) {
                    ball.setRight(1);
                } else if (ball.getXPos() < (xPos + 62) && ball.getYPos()+75 < yPos+8) {
                    ball.setDown(0);
                } else if (ball.getXPos() < (xPos + 62) && ball.getYPos() > yPos+190) {
                    ball.setDown(1);
                }
            } else if (player == 2) {
                if (ball.getXPos()+74 > xPos && ball.getXPos()+74 < xPos+12) {
                    ball.setRight(0);
                } else if (ball.getXPos() + 74 > xPos+12 && ball.getYPos()+74 < yPos+8) {
                    ball.setDown(0);
                } else if (ball.getXPos() + 74 > xPos+12 && ball.getYPos() > yPos+190) {
                    ball.setDown(1);
                }
            }
        }
        return (r1.intersects(r2));
    }

    public void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
}