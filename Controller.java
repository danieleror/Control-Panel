import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller extends JPanel{
    private int mouseX, mouseY;

    private boolean mousePressed;

    public Controller() {
        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.WHITE);

    }
}
