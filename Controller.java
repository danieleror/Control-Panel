import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller extends JPanel{
    private int mouseX, mouseY;

    private boolean mousePressed;

    private MenuOption currentMenu;
    
    private Switch s;

    public Controller(int width, int height) {
        setBackground(Color.DARK_GRAY);
        currentMenu = MenuOption.HOME;
        setPreferredSize(new Dimension(width, height));
        s = new Switch(100);
        s.setLocation(0, 0);
        add(s);
        
    }

    public boolean update(MenuOption currentMenu){
        boolean flag = false;
        if(s.checkFlag())
            flag = true;
        this.currentMenu = currentMenu;
        return flag;
    }

}
