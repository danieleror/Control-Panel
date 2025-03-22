import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller extends JPanel{
    private MenuOption currentMenu;
    
    private Switch s;

    public Controller(int width, int height) {
        setBackground(Color.DARK_GRAY);
        currentMenu = MenuOption.HOME;
        setPreferredSize(new Dimension(width, height));
        s = new Switch(100);
        add(s);
    }

    public boolean update(MenuOption currentMenu){
        this.currentMenu = currentMenu;
        if(s.checkFlag())
            return true;
        return false;
    }

}
