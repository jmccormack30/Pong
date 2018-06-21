import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;
import javafx.fxml.FXMLLoader;

public class Counter {
    
    private int xPos, yPos;
    private ImageIcon image;
    private String path;


    public Counter(int xPos, int yPos, String path) {
        this.xPos = xPos;
        this.yPos = yPos;
        image = new ImageIcon(getClass().getResource(path));
    }

    public int getXPos() {
        return xPos;
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

    public void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
}