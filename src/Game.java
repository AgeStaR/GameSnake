import java.awt.*;
import java.util.Vector;
import javax.swing.*;

class Game extends JPanel {
    private World world;
    private JFrame gameFrame;
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
                GameMenuFrame.level++;
                GameMenuFrame.setAdvanceGame(true);
                JOptionPane.showMessageDialog(gameFrame, "Вы прошли уровень!\nТеперь в меню вам доступен следущий.");
                gameFrame.dispose();
            }catch(Exception exc) {              // Exception for Exit.
                GameMenuFrame.level = 1;
                GameMenuFrame.setAdvanceGame(false);
                JOptionPane.showMessageDialog(gameFrame, "Вы проиграли!\nПридется начать сначала.");
                gameFrame.dispose();
            }
        }
    });

    public Game(World world, JFrame frame) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.world = world;
        this.gameFrame = frame;
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
