package snake_game;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
class MyPanel extends JPanel {
    private int h, w, hight, width;
    private boolean running;
    Vector<Square> squares;
    Vector<Wall> walls;
    Vector<FieldWall> fieldWalls;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.h = -10;
        hight = 540;
        width = 550;
        squares = new Vector();
        walls = new Vector();
        fieldWalls = new Vector();
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

    public void addFielsWall(FieldWall fieldWall) {
        this.fieldWalls.add(fieldWall);
    }

    public void addNewPiece() {
        if (squares.isEmpty()) {
            squares.add(new Square(width, hight));
        } else {
            squares.add(new Square(squares.get(squares.size() - 1).getX(), squares.get(squares.size() - 1).getY() + 10));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = squares.size() - 1; i > 0; i--) {
            g2.setColor(Color.yellow);
            squares.get(i).setX(squares.get(i - 1).getX());
            squares.get(i).setY(squares.get(i - 1).getY());
            g2.fill(squares.get(i).getShape());
            g.setColor(Color.black);
            g.drawRect(squares.get(i).getX(), squares.get(i).getY(), 10, 10);
        }
        if (squares.isEmpty() == false) {
            hight += h;
            width += w;
            squares.firstElement().setX(width);
            squares.firstElement().setY(hight);
            g2.setColor(Color.red);
            g2.fill(squares.firstElement().getShape());
            g.setColor(Color.black);
            g.drawRect(squares.firstElement().getX(), squares.firstElement().getY(), 10, 10);
        }
        for (int i = 0; i < this.walls.size(); i++) {
            g2.setColor(Color.gray);
            g2.fill(walls.get(i).getShape());

            if ((((int) (walls.get(i).getX() / 10)) * 10) == (((int) (squares.firstElement().getX() / 10)) * 10)
                    || (((int) (walls.get(i).getY() / 10)) * 10) == (((int) (squares.firstElement().getY() / 10))) * 10) {
                System.out.println("Zone!!!");
                this.running = false;
            }
        }

        for (int i = 0; i < this.fieldWalls.size(); i++) {
            g2.setColor(Color.gray);
            g2.fill(this.fieldWalls.get(i).getShape());

            if (squares.firstElement().getX() + 5 <= this.fieldWalls.get(i).getX() + this.fieldWalls.get(i).getXsize() &&
                    squares.firstElement().getX() + 5 >= this.fieldWalls.get(i).getX() &&
                    squares.firstElement().getY() + 5 > this.fieldWalls.get(i).getY() &&
                    squares.firstElement().getY() + 5 < this.fieldWalls.get(i).getY() + this.fieldWalls.get(i).getYsize()) {
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
