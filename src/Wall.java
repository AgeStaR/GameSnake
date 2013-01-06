package snake_game;

import java.awt.geom.Rectangle2D;

class Wall {
    protected int x, y, xsize, ysize;

    Wall(int x, int y, int xsize, int ysize) {
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
    }

    Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, xsize, ysize);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getXsize() {
        return xsize;
    }

    public int getYsize() {
        return ysize;
    }
}
