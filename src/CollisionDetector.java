import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 4:48
 * To change this template use File | Settings | File Templates.
 */

public class CollisionDetector
{
    private Snake snake;
    private Wall[] walls;

    public CollisionDetector(Snake snake, Wall[] walls)
    {
        this.snake = snake;
        this.walls = walls;
    }

    public boolean collides()
    {
        throw new NotImplementedException();
    }
}
