import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuIcon extends JComponent{
    BufferedImage image;

    public MenuIcon() {
        try{
            image = ImageIO.read(new File("images/gear.png"));
        }catch(IOException e){ System.exit(1); }
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawImage(image, 0, 0, null);
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, 50, 50);
        System.out.println("here 2");
    }
}
