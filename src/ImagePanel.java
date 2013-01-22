
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(new File("src/snake.bmp"));   // for IDE
         //image = ImageIO.read(this.getClass().getResource("snake.bmp"));      // for Jar'archive 
       } catch (IOException ex) {
           System.out.print(ex);
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null); 
    }
}