import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame{
    private Menu menu;
    private Controller controller;
    private SleepScreen sleepScreen;

    private double FPS;

    private int sleepAfterSeconds, inactiveFrameCount;

    public Window(){
        FPS = 5.0;
        inactiveFrameCount = 0;
        sleepAfterSeconds = 10;
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        setPreferredSize(new Dimension(width, height));
        menu = new Menu((int) (width*0.1), height);
        controller = new Controller((int) (width*0.9), height);
        sleepScreen = new SleepScreen(width, height);
        getContentPane().add(menu, BorderLayout.EAST); //puts the menu on the right side of the screen
        getContentPane().add(controller, BorderLayout.WEST);        
        getContentPane().add(sleepScreen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//stops the program when the window closes
        pack();
        // GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        // device.setFullScreenWindow(getWindows()[0]);
        setVisible(true);
    }

    public void run(){
        while(true)
        {
            boolean actionFromSleepScreen = sleepScreen.update();
            sleepScreen.repaint();

            boolean actionFromMenu = menu.update();
            menu.repaint();

            boolean actionFromController = controller.update(menu.getCurrentMenu());
            controller.repaint();

            if(actionFromSleepScreen || actionFromMenu || actionFromController){
                inactiveFrameCount = 0;
                sleepScreen.setVisible(false);
                menu.setVisible(true);
                controller.setVisible(true);
            }
            else
                inactiveFrameCount ++;
            
            if(inactiveFrameCount >= sleepAfterSeconds*FPS){
                inactiveFrameCount = (int) (sleepAfterSeconds*FPS); //so the screen stays asleep, but will not increment to too large a number
                menu.setVisible(false);
                controller.setVisible(false);
                sleepScreen.setVisible(true);                
            }

            try {
                Thread.sleep((long) (1000 / FPS));
            }catch(InterruptedException e) {}


        }
    }
}