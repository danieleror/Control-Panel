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

        //create new MenuIcons with associated images
        menus.put(MenuOption.HOME,new MenuIcon("images/home.png", width));
        menus.put(MenuOption.LIGHTS,new MenuIcon("images/lightbulb.png", width));
        menus.put(MenuOption.ELECTRICAL,new MenuIcon("images/plug.png", width));
        menus.put(MenuOption.SETTINGS, new MenuIcon("images/gear.png", width));

        //adds all menus to map and sets HOME to be selected menu on startup
        for(MenuOption menu : MenuOption.values()){
            add(menus.get(menu));
        }
        currentMenu = MenuOption.ELECTRICAL;

    }

    public MenuOption getCurrentMenu(){
        return currentMenu;
    }

    public boolean update(){
        //updates the currently selected menu
        for(MenuOption menu : MenuOption.values()){
            //starts by resetting them all to unselected
            menus.get(menu).setSelected(false);
            if(menus.get(menu).checkFlag()){
                //if this menu was clicked, save that the mouse was pressed, and save the currentMenu
                mousePressed = true;
                currentMenu = menu;
                if(menu == MenuOption.SETTINGS)
                    System.exit(0);  //Powers off if power button was clicked
            }
        }
        //now that currentMenu is updated from above, we can set it to selected
        menus.get(currentMenu).setSelected(true);

        if(mousePressed){
            mousePressed = false;
            return true;
        }
        return false;
    }
}
