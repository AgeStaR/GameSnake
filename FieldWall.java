package snake_game;

/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
class FieldWall extends Wall {
    FieldWall(int x, int y, int xsize, int ysize) {
        super(x, y, xsize, ysize);
    }

    public int getXsize() {
        return xsize;
    }

    public int getYsize() {
        return ysize;
    }
}
