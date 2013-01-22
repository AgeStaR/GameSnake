import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class GameFrame extends JFrame {
    Game game;
    Snake snake;
    World world;

    GameFrame(int level) {
        switch(level) {
            case 1: initWorldLevelOne();break;
            case 2: initWorldLevelTwo();break;
        }
        game = new Game(world);
        game.setBackground(Color.LIGHT_GRAY);
        game.repaint();
        
        add(game, BorderLayout.CENTER);
        
        this.addKeyListener(new SnakeController(snake));
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());
                System.out.println(e.getY());
            }
        });

        game.start();
        
        setSize(595, 625);
        setLocation(500, 200);
        setResizable(false);
        setVisible(true);
    }

    private void initWorldLevelOne() {
        ArrayList<Wall> walls = new ArrayList<Wall>();
        walls.add(new Wall(0, 0, 600, 20));
        walls.add(new Wall(0, 0, 20, 600));
        walls.add(new Wall(0, 571, 600, 600));
        walls.add(new Wall(571, 0, 600, 600));
        walls.add(new Wall(0, 100, 400, 10));
        walls.add(new Wall(80, 300, 350, 10));
        walls.add(new Wall(150, 500, 350, 10));
        
        Food food = new Food(walls,1);
        food.generateFood();
        this.snake = new Snake();
        this.world = new World(snake, walls, food);
    }
    
    private void initWorldLevelTwo() {
        ArrayList<Wall> walls = new ArrayList<Wall>();
        walls.add(new Wall(0, 0, 600, 20));
        walls.add(new Wall(0, 0, 20, 600));
        walls.add(new Wall(0, 571, 600, 600));
        walls.add(new Wall(571, 0, 600, 600));
        walls.add(new Wall(0, 100, 400, 10));
        walls.add(new Wall(80, 300, 350, 10));
        walls.add(new Wall(150, 500, 350, 10));
        
        Food food = new Food(walls,10);
        food.generateFood();
        this.snake = new Snake();
        this.world = new World(snake, walls, food);
    }
    
}
