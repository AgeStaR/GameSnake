import java.awt.*;
import java.util.Vector;
import javax.swing.*;


class Game extends JPanel {
    private World world;
    private boolean run = true;
    Thread gameThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (run) {
                repaint();
                world.tick();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    });

    public Game(World world) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.world = world;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.draw(g);
    }

    public World getWorld() {
        return world;
    }

    public void start() {
        gameThread.start();
    }
}
