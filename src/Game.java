import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 19:28
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JFrame
{
    public static void main(String[] args) {
        final Game game = new Game();
        game.setSize(800, 600);
        final Snake snake = new Snake();
        game.add(snake);
        game.setVisible(true);

        new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                while (true)
                {
                    snake.move();
                    game.repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }.run();

    }
}
