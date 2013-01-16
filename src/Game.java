import java.awt.*;
import java.util.Vector;
import javax.swing.*;

class Game extends JPanel {
    private World world;
    private boolean run = true;
    Thread gameThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (run) {
                repaint();
                world.tick();
                try {
                    System.out.println(world.getCollisionDetector().isSelfCollision());
                    if (world.getCollisionDetector().isSelfCollision() ||
                            world.getCollisionDetector().isWallCollision()) {
                        throw new InterruptedException(); 
                    }
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    throw new Exception();
                }
            }
            }catch(Exception exc) {              // Exception for Exit.
                
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
