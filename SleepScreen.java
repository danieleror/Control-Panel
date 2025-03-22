import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SleepScreen extends JPanel{
    private String message;

    private boolean flag;

    private int fontSize = 70;

    public SleepScreen(int width, int height){
        setPreferredSize(new Dimension(width, height));
        message = "Tap to Wake";

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // unused
            }

            @Override
            public void mousePressed(MouseEvent e) {
                flag = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // unused
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

    public boolean update(){
        if(flag){
            flag = false;
            return true;
        }
        
        return false;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(20, 20, 20));
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setFont(new Font("Futura", Font.BOLD, fontSize));
        g2.setColor(Color.WHITE);
        g2.drawString(message, getWidth()/2 - (int) (message.length()*(fontSize/2)/2), getHeight()/2);
    }


}
