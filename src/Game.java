import java.awt.*;
import java.util.Vector;
import javax.swing.*;

class Game extends JPanel {
    private Level level;
    private GameMenuFrame frame;
    private boolean run = true;
    Thread gameThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (run) {
                repaint();
                level.tick();
                try {
                    if (level.getCollisionDetector().isSelfCollision() ||
                            level.getCollisionDetector().isWallCollision()) {
                        throw new InterruptedException(); 
                    }
                    if (level.getFood().getFood().isEmpty() == true) {
                        run = false;
                    }
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new Exception();
                }
            }
                GameMenuFrame.gameLevel++;
                frame.createGame(GameMenuFrame.gameLevel);
            }catch(Exception exc) {              // Exception for Exit.
                GameMenuFrame.gameLevel = 1;
                
            }
        }
    });

    public Game(Level level, GameMenuFrame frame) {
        this.level = level;
        this.frame = frame;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        level.draw(g);
    }

    public Level getLevel() {
        return level;
    }

    public void start() {
        gameThread.start();
    }
}
