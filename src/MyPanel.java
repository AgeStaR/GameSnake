import java.awt.*;
import java.util.Vector;
import javax.swing.*;


class MyPanel extends JPanel {
    private int h, w, hight, width;
    private boolean running;
    Vector<Block> blocks;
    Vector<Wall> walls;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.h = -10;
        hight = 540;
        width = 550;
        blocks = new Vector();
        walls = new Vector();
        this.running = false;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getRunning() {
        return this.running;
    }

    public void addWall(Wall wall) {
        this.walls.add(wall);
    }

    public void addNewPiece() {
        if (blocks.isEmpty()) {
            blocks.add(new Block(width, hight));
        } else {
            blocks.add(new Block(blocks.get(blocks.size() - 1).getX(), blocks.get(blocks.size() - 1).getY() + 10));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = blocks.size() - 1; i > 0; i--) {
            g2.setColor(Color.yellow);
            blocks.get(i).setX(blocks.get(i - 1).getX());
            blocks.get(i).setY(blocks.get(i - 1).getY());
            g2.fill(blocks.get(i).getShape());
            g.setColor(Color.black);
            g.drawRect(blocks.get(i).getX(), blocks.get(i).getY(), 10, 10);
        }
        if (blocks.isEmpty() == false) {
            hight += h;
            width += w;
            blocks.firstElement().setX(width);
            blocks.firstElement().setY(hight);
            g2.setColor(Color.red);
            g2.fill(blocks.firstElement().getShape());
            g.setColor(Color.black);
            g.drawRect(blocks.firstElement().getX(), blocks.firstElement().getY(), 10, 10);
        }

        for (int i = 0; i < this.walls.size(); i++) {
            g2.setColor(Color.gray);
            g2.fill(this.walls.get(i).getShape());

            if (blocks.firstElement().getX() + 5 <= this.walls.get(i).getX() + this.walls.get(i).getWidth() &&
                    blocks.firstElement().getX() + 5 >= this.walls.get(i).getX() &&
                    blocks.firstElement().getY() + 5 > this.walls.get(i).getY() &&
                    blocks.firstElement().getY() + 5 < this.walls.get(i).getY() + this.walls.get(i).getHeight()) {
                System.out.println("Zone!!!" + i);
                this.running = false;
            }
        }
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }
}
