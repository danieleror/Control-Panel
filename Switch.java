import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class Switch extends JComponent{

    private int width, height;

    private Color primaryColor, offColor, onColor;

    private boolean status, flag;  // true if switch is on, false if it is off

    public Switch(int size){
        height = size;
        width = (int) (size * 2.5);
        setPreferredSize(new Dimension(width, height));

        primaryColor = Color.WHITE;
        offColor = Color.LIGHT_GRAY;
        onColor = new Color(0, 255, 0);

        status = false;

        //gets mouse input
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // unused
            }

            @Override
            public void mousePressed(MouseEvent e) {
                status = !status;
                flag = false;
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

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(primaryColor);
        g2.fillRoundRect(0, 0, width, height, height, height);
        if(status)
            g2.setColor(onColor);
        else
            g2.setColor(offColor);
        
        g2.fillRoundRect((int) (height*0.08), (int) (height*0.08), (int) (width - (height*0.16)), (int) (height - (height*0.16)), (int) (height - (height*0.16)), (int) (height - (height*0.16)));
        
        g2.setColor(primaryColor);
        int xPos;
        if(status)
            xPos = (int) (width * 0.5 - (height * 0.12));
        else
            xPos = (int) (height * 0.12);
            

        g2.fillRoundRect(xPos, (int) (height*0.12), (int) (width * 0.5), (int) (height - (height*0.24)), (int) (height - (height*0.24)), (int) (height - (height*0.24)));

        
    }
    
}