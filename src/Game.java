import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 07.01.13
 * Time: 0:46
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JPanel {

    private World world;

    public Game(World world) {
        this.world = world;
        add(world);
    }
}
