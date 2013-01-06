import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 1:32
 * To change this template use File | Settings | File Templates.
 */
public class World extends JPanel
{
    private Snake snake;
    private Wall[] walls;

    public World(Snake snake, Wall[] walls)
    {
        this.snake = snake;
        this.walls = walls;
    }

    @Override
    protected void printComponent(Graphics g)
    {
        super.printComponent(g);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
