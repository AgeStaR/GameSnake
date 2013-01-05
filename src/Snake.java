import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 1:32
 * To change this template use File | Settings | File Templates.
 */
public class Snake {

    private final static int DEFAULT_SNAKE_SIZE = 3;
    private ArrayList<Block> body;
    private Direction direction = Direction.Up;

    public Snake() {
        this(DEFAULT_SNAKE_SIZE);
    }

    public Snake(int size) {
        body = new ArrayList<Block>(size);
    }

    public void increase() {

    }
}

enum Direction {Up, Down, Left, Right};