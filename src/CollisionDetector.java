import java.util.ArrayList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CollisionDetector
{
    private Snake snake;
    private ArrayList<Wall> walls;

    public CollisionDetector(Snake snake, ArrayList<Wall> walls)
    {
        this.snake = snake;
        this.walls = walls;
    }

    public boolean isSelfCollision()
    {
        for (int i = 1; i < snake.getBody().size(); i++) {
            if (snake.getHead().getX() == snake.getBody().get(i).getX() &&
                    snake.getHead().getY() == snake.getBody().get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean isWallCollision()
    {
        for (Wall wall : walls) {
            if (snake.getHead().getX()+5 >= wall.getX() &&
                    snake.getHead().getY()+5 >= wall.getY() &&
                    snake.getHead().getX()+ 5 <= wall.getX() + wall.getWidth() &&
                    snake.getHead().getY()+ 5 <= wall.getY() + wall.getHeight()) {
                return true;
            }
        }
        return false;
    }
}
