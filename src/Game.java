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
                    if (world.getCollisionDetector().isSelfCollision() ||
                            world.getCollisionDetector().isWallCollision()) {
                        throw new InterruptedException(); 
                    }
                    if (world.getFood().getFood().isEmpty() == true) {
                        run = false;
                    }
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new Exception();
                }
            }
            }catch(Exception exc) {              // Exception for Exit.
                GameMenuFrame.level = 1;
                GameMenuFrame.setAdvanceGame(false);
            }
            finally {
                GameMenuFrame.level++;
                GameMenuFrame.setAdvanceGame(true);
                System.out.print(GameMenuFrame.level);
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
