import java.awt.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 1:32
 * To change this template use File | Settings | File Templates.
 */

public class Snake
{
    private final static int DEFAULT_SNAKE_SIZE = 3;
    private ArrayList<Block> body;
    private Direction direction = Direction.Up;

    public Snake()
    {
        body = new ArrayList<Block>(DEFAULT_SNAKE_SIZE);
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
        for (Block block : body)
            g.fill(new Rectangle(block.getX(), block.getY(), Block.WIDTH, Block.HEIGTH));
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

        for (Block block : body)
        {
            block.setX(block.getX() + dx);
            block.setY(block.getY() + dy);
        }
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public Direction getDirection()
    {
        return direction;
    }
}