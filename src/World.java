import java.awt.Graphics;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
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
    
    public void draw(Graphics g) {
        for (Wall wall : walls) 
            g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
    }
}
