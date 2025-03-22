import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuIcon extends JComponent{
    private BufferedImage image;
    private boolean mousePressed, currentlySelected, flag;

    public MenuIcon(String imageFilePath, int size) {
        try{
            image = ImageIO.read(new File(imageFilePath));
            
        }catch(IOException e){ 
            System.err.println("ERROR: Image not found given path \"" + imageFilePath + "\"");
            System.exit(1); 
        }
        setPreferredSize(new Dimension(size, size));
        mousePressed = false;
        currentlySelected = false;
        flag = false;

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // unused
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // unused
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                flag = true;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // unused
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // unused
            }
            
        });
    }

    /**
     * checkFlag() returns true if the user has clicked this menu icon. After the method call, the flag will be set to false. 
     * @return
     */
    public boolean checkFlag(){
        if(flag){
            flag = false;
            return true;
        }
        return false;
    }


    public void setSelected(boolean selected){
        currentlySelected = selected;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(currentlySelected){
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRoundRect((int) (getWidth()*0.05), (int) (getHeight()*0.05), (int) (getWidth()*0.9), (int) (getHeight()*0.9), (int) (getWidth()*0.35), (int) (getHeight()*0.35));
        }
        g2.drawImage(image, (int) (getWidth()*0.1), (int) (getHeight()*0.1), (int) (getWidth()*0.8), (int) (getHeight()*0.8), null);
    }
}
