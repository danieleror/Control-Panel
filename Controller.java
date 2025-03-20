import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller extends JPanel{
    private int mouseX, mouseY;

    private boolean mousePressed;

    public Controller(int width, int height) {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(width, height));
    }

    public void update(MenuOption currentMenu){
        
    }
}
