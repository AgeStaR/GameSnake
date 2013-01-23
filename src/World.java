
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class World {
    
    private ArrayList<Wall> walls;
    World(int level) {
        walls = new ArrayList<Wall>();
        walls.add(new Wall(0, 0, 600, 20));
        walls.add(new Wall(0, 0, 20, 600));
        walls.add(new Wall(0, 571, 600, 600));
        walls.add(new Wall(571, 0, 600, 600));
        switch(level) {
            case 1: initWorldLevelOne(); break;
            case 2: initWorldLevelTwo(); break;
            case 3: initWorldLevelThree(); break;
        }
    }
    
    public ArrayList<Wall> getWalls() {
        return walls;
    }
    
    public void draw(Graphics g) {
        
        g.setColor(Color.black);
        for (Wall wall : walls)
            g.drawRect(wall.getX()-1, wall.getY()-1, wall.getWidth()+1, wall.getHeight()+1);      // Shape
        
        g.setColor(Color.GRAY);
        for (Wall wall : walls)
            g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
    }
    
    private void initWorldLevelOne() {
        walls.add(new Wall(300, 100, 30, 400));
        walls.add(new Wall(100, 300, 400, 30));
        
    }
    
    private void initWorldLevelTwo() {
        walls.add(new Wall(0, 100, 400, 10));
        walls.add(new Wall(80, 300, 350, 10));
        walls.add(new Wall(150, 500, 350, 10));
    }
    
    private void initWorldLevelThree() {
    }
    
}
