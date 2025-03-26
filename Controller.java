import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.*;

public class Controller{
    private MenuOption currentMenu;
    private ElectricPanel electricPanel;
    private boolean menuChanged;
    // private HomePanel homePanel;
    // private LightsPanel lightsPanel;
    // private SettingsPanel settingsPanel;
    
    public Controller(int width, int height, MenuOption menu) {
        currentMenu = menu;
        electricPanel = new ElectricPanel(width, height);
        menuChanged = false;
    }

    public boolean update(MenuOption currentMenu){
        if(this.currentMenu != currentMenu){
            this.currentMenu = currentMenu;
            menuChanged = true;
        }
        if(currentMenu == MenuOption.ELECTRICAL)
            return electricPanel.checkFlag();
        //else if(currentMenu == MenuOption.HOME)
        return false;
    }

    public void repaint(){
        electricPanel.repaint();
    }

    public JLayeredPane getContents(){
        if(currentMenu == MenuOption.ELECTRICAL)
            return electricPanel;
        JLayeredPane pane = new JLayeredPane();
        pane.setBackground(Color.DARK_GRAY);
        pane.setPreferredSize(new Dimension(electricPanel.getWidth(), electricPanel.getHeight()));
        return pane;
    }

    public MenuOption getCurrentMenu(){
        return currentMenu;
    }

    public boolean hasMenuChanged(){
        if(menuChanged){
            menuChanged = false;
            return true;
        }
        return false;
    }
}
