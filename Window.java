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

    private boolean sleeping;

    public Window(){
        FPS = 5.0;
        inactiveFrameCount = 0;
        sleepAfterSeconds = 15;
        sleeping = false;

        //gets the device screen size and sets that to be the size of the JFrame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        setPreferredSize(new Dimension(width, height));

        //initializes and adds panels
        menu = new Menu((int) (width*0.1), height);
        controller = new Controller((int) (width*0.9), height);
        sleepScreen = new SleepScreen(width, height);
        getContentPane().add(menu, BorderLayout.EAST); //puts the menu on the right side of the screen
        getContentPane().add(controller, BorderLayout.WEST);        


        setDefaultCloseOperation(EXIT_ON_CLOSE);//stops the program when the window closes
        pack();

        //full screen
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        device.setFullScreenWindow(getWindows()[0]);


        setVisible(true);

    }

    public void run(){
        while(true)
        {
            //updates all panels, saving booleans that will determine whether a click occured or not
            boolean actionFromMenu = menu.update();
            boolean actionFromController = controller.update(menu.getCurrentMenu());
            boolean actionFromSleepScreen = sleepScreen.update();

            controller.repaint();
            menu.repaint();
            sleepScreen.repaint();

            //wakes up the screen, or just zeros inactive time whenever the screen is pressed
            if(actionFromSleepScreen || actionFromMenu || actionFromController){
                inactiveFrameCount = 0;
                if(sleeping){ 
                    getContentPane().remove(sleepScreen);
                    getContentPane().add(controller, BorderLayout.WEST);
                    getContentPane().add(menu, BorderLayout.EAST);
                    revalidate();
                    sleeping = false;
                }
            }
            else
                inactiveFrameCount ++;
            
            // puts the screen to sleep if inactive time exceeds limit
            if(inactiveFrameCount >= sleepAfterSeconds*FPS){
                inactiveFrameCount = (int) (sleepAfterSeconds*FPS); //so the screen stays asleep, but will not increment to too large a number
                if(!sleeping){
                    getContentPane().remove(controller);
                    getContentPane().remove(menu);
                    getContentPane().add(sleepScreen);
                    revalidate();
                    sleeping = true;
                }
            }

            try {
                Thread.sleep((long) (1000 / FPS));
            }catch(InterruptedException e) {}


        }
    }
}