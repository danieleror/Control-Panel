import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class Menu extends JPanel{
    private int mouseX, mouseY;

    private boolean mousePressed;

    private MenuOption currentMenu;

    private HashMap<MenuOption, MenuIcon> menus;

    public Menu() {
        setPreferredSize(new Dimension(124, 600));
        setBackground(Color.BLUE);
        menus = new HashMap<>();
        menus.put(MenuOption.SETTINGS,new MenuIcon());
    }

    public void paintComponent(Graphics g){
        menus.get(MenuOption.SETTINGS).repaint();
    }


}
