
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class Food {
    
    private Random random = new Random();
    private ArrayList<Meat> meats;
    private ArrayList<Wall> walls;
    private int n;
    
    public Food(ArrayList<Wall> walls, int n) {
        this.meats = new ArrayList();
        this.walls = walls;
        this.n = n;
    }
    
    public void ateMeat(int n) {
        meats.remove(n);
    }
    
    public ArrayList<Meat> getFood() {
        return meats;
    }
    
    public void generateFood() {
        Meat buf;
        int xBuf;
        int yBuf;
        boolean right = false;
        while (meats.size() <= n) {
            xBuf = ((random.nextInt(500)/10))*10;
            yBuf = ((random.nextInt(500))/10)*10;
            buf = new Meat(xBuf, yBuf);
            right = true;
            for (int i = 0; i < this.walls.size(); i++) {
            if (buf.getX()  > this.walls.get(i).getX() + this.walls.get(i).getWidth() ||
                    buf.getX()  < this.walls.get(i).getX() ||
                    buf.getY()  < this.walls.get(i).getY() ||
                    buf.getY()  > this.walls.get(i).getY() + this.walls.get(i).getHeight()) {
                
                continue;
                }
            else right = false;
            }
            if (right) 
                meats.add(buf);
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        for (Meat meat : meats) {
            g.fillOval(meat.getX(), meat.getY(), 8, 8);
        }
    }
    
}
