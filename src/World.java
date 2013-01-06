import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 1:32
 * To change this template use File | Settings | File Templates.
 */
public class World
{
    private Snake snake;
    private Wall[] walls;

    public World(Snake snake, Wall[] walls)
    {
        this.snake = snake;
        this.walls = walls;
    }

    // Здесь обрабатываются столкновения и передвижения змеи. Лучшего названия придумать не смог. :(
    public void tick()
    {
        throw new NotImplementedException();
    }
}
