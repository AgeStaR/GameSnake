import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 07.01.13
 * Time: 0:44
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        World world = new World(new Snake());
        Game game = new Game(world);
        add(game);
        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }
}
