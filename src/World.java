import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
public class World
{
    private Snake snake;
    private ArrayList<Wall> walls;
    CollisionDetector collisionDetector;

    public World(Snake snake, ArrayList<Wall> walls)
    {
        this.snake = snake;
        this.walls = walls;
        collisionDetector = new CollisionDetector(snake, walls);
    }
    // Здесь обрабатываются столкновения и передвижения змеи. Лучшего названия придумать не смог. :(
    public void tick()
    {
        snake.move();
        //throw new NotImplementedException();
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.gray);
        for (Wall wall : walls) 
            g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
    }
}
