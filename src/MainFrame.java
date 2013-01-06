import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MainFrame extends JFrame {
    Game game;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem, menuItemStart, menuAddPiece;
    Snake snake;
    World world;

    MainFrame() {
        initWorld();
        game = new Game(world);
        game.setBackground(Color.LIGHT_GRAY);
        game.repaint();
        menuBar = new JMenuBar();
        menuItem = new JMenuItem("Exit");
        menuItemStart = new JMenuItem("Start");
        menuAddPiece = new JMenuItem("Add");

        menu = new JMenu("File");

        add(menuBar, BorderLayout.NORTH);
        add(game, BorderLayout.CENTER);

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuItemStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });
        menu.add(menuItem);
        menu.add(menuItemStart);
        menu.add(this.menuAddPiece);
        menuBar.add(menu);

        menuAddPiece.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.getWorld().getSnake().increase();
                game.repaint();
            }
        });

        this.addKeyListener(new SnakeController(snake));
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());
                System.out.println(e.getY());
            }
        });

        setSize(595, 645);
        setLocation(500, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initWorld() {
        ArrayList<Wall> walls = new ArrayList<Wall>();
        walls.add(new Wall(0, 0, 600, 20));
        walls.add(new Wall(0, 0, 20, 600));
        walls.add(new Wall(0, 571, 600, 600));
        walls.add(new Wall(571, 0, 600, 600));
        walls.add(new Wall(0, 100, 400, 10));
        walls.add(new Wall(80, 300, 350, 10));
        walls.add(new Wall(150, 500, 350, 10));
        this.snake = new Snake();
        this.world = new World(snake, walls);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }

//    private void turnLeft() {
//        game.setH(0);
//        game.setW(-10);
//    }
//
//    private void turnRight() {
//        game.setH(0);
//        game.setW(10);
//    }
//
//    private void turnUp() {
//        game.setH(-10);
//        game.setW(0);
//    }
//
//    private void turnDown() {
//        game.setH(10);
//        game.setW(0);
//    }
}
