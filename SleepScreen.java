import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SleepScreen extends JPanel{
    private String message;

    private boolean flag;

    public SleepScreen(int width, int height){
        setBackground(new Color(20, 20, 20));
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
        g2.setFont(new Font("Serif", Font.BOLD, 100));
        g2.setColor(Color.WHITE);
        g2.drawString(message, 100, 100);

    }


}
