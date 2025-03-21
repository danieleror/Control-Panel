import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller extends JPanel{
    private int mouseX, mouseY;

    private boolean mousePressed;

    private MenuOption currentMenu;

    public Controller(int width, int height) {
        setBackground(Color.DARK_GRAY);
        currentMenu = MenuOption.SETTINGS;
        setPreferredSize(new Dimension(width, height));
    }

    public void update(MenuOption currentMenu){
        this.currentMenu = currentMenu;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Serif", Font.BOLD, 100));
        g2.drawString(currentMenu.name(), 50, 50);

    }
}
