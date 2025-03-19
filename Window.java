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
        FPS = 60.0;
        menu = new Menu();
        controller = new Controller();
        getContentPane().add(menu, BorderLayout.EAST); //puts the menu on the right side of the screen
        getContentPane().add(controller, BorderLayout.WEST);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);//stops the program when the window closes
        pack();
        setVisible(true);
    }

    public void run(){
        while(true)
        {
            menu.repaint();
            controller.repaint();
            try {
                Thread.sleep((long) (1000 / FPS));
            }catch(InterruptedException e) {}


        }
    }
}