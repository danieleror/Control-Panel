import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame{
    private Menu menu;
    private Controller controller;

    private final int WIDTH = 1024, HEIGHT = 600;

    private boolean mousePressed;
    private double FPS;

    public Window(){
        FPS = 60.0;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        menu = new Menu((int) (WIDTH*0.12), HEIGHT);
        controller = new Controller((int) (WIDTH*0.88), HEIGHT);
        getContentPane().add(menu, BorderLayout.EAST); //puts the menu on the right side of the screen
        getContentPane().add(controller, BorderLayout.WEST);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);//stops the program when the window closes
        pack();
        setVisible(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
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