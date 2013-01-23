import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class Level extends JPanel
{
    private Snake snake;
    private CollisionDetector collisionDetector;
    private Food food;
    private World world;

    
    public Level(Snake snake, World world, Food food) {
        this.snake = snake;
        this.food = food;
        this.world = world;
        collisionDetector = new CollisionDetector(snake, world);
        
        this.addKeyListener(new SnakeController(snake));
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());
                System.out.println(e.getY());
            }
        });
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
        world.draw(g);
    }

    public Snake getSnake() {
        return snake;
    }
    
    public Food getFood() {
        return food;
    }
    
    public CollisionDetector getCollisionDetector(){
        return collisionDetector;
    }
    
}
