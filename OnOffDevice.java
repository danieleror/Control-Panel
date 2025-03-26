import javax.swing.*;
import java.awt.*;

public class OnOffDevice extends JPanel {

    private int GPIO, fontSize, margin;

    private String name;

    private Switch button;

    private Color backGroundColor, nameColor;

    public OnOffDevice(int x, int y, int width, int height, String name, int GPIO){
        setBounds(x, y, width, height);
        setLayout(null);
        backGroundColor = Color.LIGHT_GRAY;
        nameColor = Color.WHITE;
        this.name = name;
        this.GPIO = GPIO;

        double buttonSize = height*0.75;
        margin = (int) (height*0.125);
        button = new Switch(width - (buttonSize * Switch.WIDTH_TO_HEIGHT_RATIO) - margin, margin, buttonSize);
        add(button);

        fontSize = (int) (buttonSize * 0.8);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backGroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight()/2, getHeight()/2);
        g2.setColor(nameColor);
        g2.setFont(new Font("Futura", Font.BOLD, fontSize));
        FontMetrics fontData = g2.getFontMetrics();
        g2.drawString(name, fontSize/2, fontData.getAscent() + fontData.getDescent());
    }

    public boolean checkFlag(){
        return button.checkFlag();
    }
}