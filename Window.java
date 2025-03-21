import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame{
    private Menu menu;
    private Controller controller;

    private boolean mousePressed;
    private double FPS;

    public Window(){
        FPS = 12.0;
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        setPreferredSize(new Dimension(width, height));
        menu = new Menu((int) (width*0.1), height);
        controller = new Controller((int) (width*0.9), height);
        getContentPane().add(menu, BorderLayout.EAST); //puts the menu on the right side of the screen
        getContentPane().add(controller, BorderLayout.WEST);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);//stops the program when the window closes
        pack();
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        device.setFullScreenWindow(getWindows()[0]);
        setVisible(true);
    }

    public void run(){
        while(true)
        {
            menu.update();
            menu.repaint();

            controller.update(menu.getCurrentMenu());
            controller.repaint();
            try {
                Thread.sleep((long) (1000 / FPS));
            }catch(InterruptedException e) {}


        }
    }
}