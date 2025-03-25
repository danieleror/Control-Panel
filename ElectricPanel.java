import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class ElectricPanel extends JLayeredPane {
    private ArrayList<OnOffDevice> devices;
    private int screenSections = 7;

    private double marginRatio = 0.01;
    private final int BACKGROUND_LAYER, DEVICE_LAYER, POP_UP_LAYER;
    
    
    public ElectricPanel(int width, int height) {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(width, height));
        BACKGROUND_LAYER = 2;
        DEVICE_LAYER = 1;
        POP_UP_LAYER = 0;
        devices = new ArrayList<>();
        loadDevices(width, height);
        JPanel background = new JPanel();
        background.setBackground(Color.DARK_GRAY);
        background.setBounds(0, 0, width, height);
        add(background, BACKGROUND_LAYER);
    }

    private void loadDevices(int width, int height){
        File file = new File("data/electricPanelDevices.txt");
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String[] line = reader.nextLine().split(",");
                int GPIO = Integer.parseInt(line[1]);
                int x = (int) (width * marginRatio);
                int y = (int) (devices.size() * (height/screenSections) + (width * marginRatio));
                int newHeight = (int) (height/screenSections - (width * 2 * marginRatio));
                int newWidth = (int) (width * (1 - (2 * marginRatio)));
                System.out.printf("X: %d   Y: %d   Width: %d   Height: %d\n", x, y, newWidth, newHeight);
                devices.add(new OnOffDevice(x, y, newWidth, newHeight, line[0], GPIO));
            }
        }catch(IOException e){
            System.err.println("ERROR reading file in ElectricPanel.java");
            System.exit(1);
        }
        for(OnOffDevice device : devices){
            add(device, DEVICE_LAYER);
        }
    }

    public boolean checkFlag(){
        for(Component comp : getComponents()){
            if(comp instanceof OnOffDevice)
                if(((OnOffDevice) comp).checkFlag())
                    return true;

        }
        return false;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(Component comp : getComponents()){
            comp.repaint();
        }
    }
}
