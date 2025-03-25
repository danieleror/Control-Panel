import javax.swing.*;
import java.awt.*;

public class OnOffDevice extends JPanel {

    private int GPIO;

    private String name;

    private Switch button;

    private Color backGroundColor;

    public OnOffDevice(int x, int y, int width, int height, String name, int GPIO){
        setBounds(x, y, width, height);
        setLayout(null);
        backGroundColor = Color.LIGHT_GRAY;
        this.name = name;
        this.GPIO = GPIO;

        double buttonSize = height*0.75;
        double margin = height*0.125;
        button = new Switch(width - (buttonSize * Switch.WIDTH_TO_HEIGHT_RATIO) - margin, margin, buttonSize);
        add(button);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backGroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight()/2, getHeight()/2);
    }

    public boolean checkFlag(){
        return false;
    }
}