import javax.swing.*;

public class Controller{
    private MenuOption currentMenu;
    private ElectricPanel electricPanel;
    
    public Controller(int width, int height) {
        currentMenu = MenuOption.HOME;
        electricPanel = new ElectricPanel(width, height);
    }

    public boolean update(MenuOption currentMenu){
        this.currentMenu = currentMenu;
        if(electricPanel.checkFlag())
            return true;
        return false;
    }

    public void repaint(){
        electricPanel.repaint();
    }

    public JLayeredPane getContents(){
        return electricPanel;
    }

}
