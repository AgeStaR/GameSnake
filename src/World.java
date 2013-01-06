import java.awt.*;
import java.util.ArrayList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class World extends JPanel
{
    private Snake snake;
    private ArrayList<Wall> walls;
    CollisionDetector collisionDetector;

    public World(Snake snake) {
        this(snake, new ArrayList<Wall>(0));
    }

    public World(Snake snake, ArrayList<Wall> walls)
    {
        this.snake = snake;
        this.walls = walls;
        collisionDetector = new CollisionDetector(snake, walls);

        add(snake);
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
        //snake.draw(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    //To change body of overridden methods use File | Settings | File Templates.

        g.setColor(Color.gray);
        for (Wall wall : walls)
            g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
        //snake.draw(g);
    }

    public Snake getSnake() {
        return snake;
    }
}
