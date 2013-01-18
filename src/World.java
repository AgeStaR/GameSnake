import java.awt.*;
import java.util.ArrayList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class World extends JPanel
{
    private Snake snake;
    private ArrayList<Wall> walls;
    private CollisionDetector collisionDetector;
    private Food food;

    public World(Snake snake) {
        this(snake, new ArrayList<Wall>(0));
    }

    public World(Snake snake, ArrayList<Wall> walls)
    {
        this.snake = snake;
        this.walls = walls;
        collisionDetector = new CollisionDetector(snake, walls);
    }
    
    public World(Snake snake, ArrayList<Wall> walls, Food food) {
        this.snake = snake;
        this.walls = walls;
        this.food = food;
        collisionDetector = new CollisionDetector(snake, walls);
    }

    public void tick()
    {
        snake.move();
        for (int i = 0; i < food.getFood().size(); i++) {
            if (snake.getHead().getX() == food.getFood().get(i).getX() &&
                    snake.getHead().getY() == food.getFood().get(i).getY()) {
                food.ateMeat(i);
                snake.increase();
            }
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.gray);
        snake.draw(g);
        food.draw(g);
        g.setColor(Color.GRAY);
        for (Wall wall : walls)
            g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
        
        
    }

    public Snake getSnake() {
        return snake;
    }
    
    public CollisionDetector getCollisionDetector(){
        return collisionDetector;
    }
    
}
