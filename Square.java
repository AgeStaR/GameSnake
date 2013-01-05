package snake_game;

import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
class Square {

    Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
    void setX(int x){
        this.x = x;
    }
    void setY(int y) {
        this.y = y;
    }

    Rectangle2D getShape(){
        return new Rectangle2D.Double(x, y, XSIZE, YSIZE);
    }

    private static final int XSIZE = 10;
    private static final int YSIZE = 10;
    private int x, y;
}
