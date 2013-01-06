import java.awt.geom.Rectangle2D;

class Wall {
    protected int x, y, width, height;

    Wall(int x, int y, int xsize, int ysize) {
        this.x = x;
        this.y = y;
        this.width = xsize;
        this.height = ysize;
    }

    Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
