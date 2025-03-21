import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class Menu extends JPanel{
    private int mouseX, mouseY, width;

    private boolean mousePressed;

    private MenuOption currentMenu;

    private HashMap<MenuOption, MenuIcon> menus;

    public Menu(int width, int height) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        menus = new HashMap<>();
        menus.put(MenuOption.SETTINGS,new MenuIcon("images/gear.png", width));
        menus.put(MenuOption.LIGHTS,new MenuIcon("images/lightbulb.png", width));
        menus.put(MenuOption.ELECTRICAL,new MenuIcon("images/plug.png", width));
        menus.put(MenuOption.POWER, new MenuIcon("images/power.png", width));
        for(MenuOption menu : MenuOption.values()){
            add(menus.get(menu));
        }
        currentMenu = MenuOption.SETTINGS;
    }

    public MenuOption getCurrentMenu(){
        return currentMenu;
    }

    public void update(){
        for(MenuOption menu : MenuOption.values()){
            menus.get(menu).setSelected(false);
            if(menus.get(menu).checkFlag()){
                currentMenu = menu;
                if(menu == MenuOption.POWER)
                    System.exit(0);
            }
        }
        menus.get(currentMenu).setSelected(true);
    }
}
