import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
class Block {

    public static final int WIDTH = 10;
    public static final int HEIGTH = 10;
    private int x, y;

    Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, WIDTH, HEIGTH);
    }
}
