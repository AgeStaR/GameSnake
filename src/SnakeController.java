import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class SnakeController implements KeyListener {

    private Snake snake;

    public SnakeController(Snake snake)
    {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                snake.setDirection(Direction.Up);
                break;

            case KeyEvent.VK_DOWN:
                snake.setDirection(Direction.Down);
                break;

            case KeyEvent.VK_LEFT:
                snake.setDirection(Direction.Left);
                break;

            case KeyEvent.VK_RIGHT:
                snake.setDirection(Direction.Right);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
