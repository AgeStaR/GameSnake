package snake_game;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// Обработчик столкновений. Не миру же обрабатывать столкновения.
public class CollisionDetector
{
    private Snake snake;
    private Wall[] walls;

    public CollisionDetector(Snake snake, Wall[] walls)
    {
        this.snake = snake;
        this.walls = walls;
    }

    public boolean isSelfCollision()
    {
        throw new NotImplementedException();
    }

    public boolean isWallCollision()
    {
        throw new NotImplementedException();
    }
}
