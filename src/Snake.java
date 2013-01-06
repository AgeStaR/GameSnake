import java.awt.*;
import java.util.*;

public class Snake
{
    private final static int DEFAULT_SNAKE_SIZE = 3;
    private ArrayList<Block> body;
    private Direction direction = Direction.Up;

    public Snake()
    {
        body = new ArrayList<Block>(DEFAULT_SNAKE_SIZE);
        body.add(new Block(550, 540));
        body.add(new Block(body.get(body.size() - 1).getX(), body.get(body.size() - 1).getY() + 10));
        body.add(new Block(body.get(body.size() - 1).getX(), body.get(body.size() - 1).getY() + 10));
    }

    public void increase()
    {
        Block[] tail = new Block[] { body.get(body.size() - 2), body.get(body.size() - 1) };
        Block block;

        if (tail[1].getX() < tail[0].getX())
            block = new Block(tail[1].getX() - Block.WIDTH, tail[1].getY());
        else if (tail[1].getX() > tail[0].getX())
            block = new Block(tail[1].getX() + Block.WIDTH, tail[1].getY());
        else if (tail[1].getY() > tail[0].getY())
            block = new Block(tail[1].getX(), tail[1].getY() + Block.HEIGTH);
        else
            block = new Block(tail[1].getX(), tail[1].getY() - Block.HEIGTH);

        body.add(block);
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.green);
        for (int i = 1; i < body.size(); i++) {
            g.fill(new Rectangle(body.get(i).getX(), body.get(i).getY(), Block.WIDTH, Block.HEIGTH));
        }
        g.setColor(Color.red);
        g.fill(new Rectangle(body.get(0).getX(), body.get(0).getY(), Block.WIDTH, Block.HEIGTH));
            
    }

    public void move()
    {
        int dx = 0;
        int dy = 0;

        switch (direction)
        {
            case Up:
                dy = -Block.HEIGTH;
                break;

            case Down:
                dy = Block.HEIGTH;
                break;

            case Left:
                dx = -Block.WIDTH;
                break;

            case Right:
                dx = Block.WIDTH;
                break;
        }
        
        
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setX(body.get(i - 1).getX());
            body.get(i).setY(body.get(i - 1).getY());
        }
        body.get(0).setX(body.get(0).getX()+dx);         // Head
        body.get(0).setY(body.get(0).getY()+dy);
    }

    public void setDirection(Direction direction)
    {
        if ((this.direction == Direction.Up && direction != Direction.Down) ||
            (this.direction == Direction.Down && direction != Direction.Up) ||
            (this.direction == Direction.Left && direction != Direction.Right) ||
            (this.direction == Direction.Right && direction != Direction.Left))
            this.direction = direction;
    }

    public Direction getDirection()
    {
        return direction;
    }
}