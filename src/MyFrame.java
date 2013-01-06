import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MyFrame extends JFrame {
    MyPanel snakePanel;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem, menuItemStart, menuAddPiece;
    Snake snake;
    World world;

    MyFrame() {
        initWorld();
        snakePanel = new MyPanel(snake, world);
        snakePanel.setBackground(Color.LIGHT_GRAY);
        snakePanel.repaint();
        menuBar = new JMenuBar();
        menuItem = new JMenuItem("Exit");
        menuItemStart = new JMenuItem("Start");
        menuAddPiece = new JMenuItem("Add");

        menu = new JMenu("File");

        add(menuBar, BorderLayout.NORTH);
        add(snakePanel, BorderLayout.CENTER);

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuItemStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        menu.add(menuItem);
        menu.add(menuItemStart);
        menu.add(this.menuAddPiece);
        menuBar.add(menu);

        menuAddPiece.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                snakePanel.repaint();
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_DOWN:
//                        turnDown();
//                        break;
//                    case KeyEvent.VK_UP:
//                        turnUp();
//                        break;
//                    case KeyEvent.VK_LEFT:
//                        turnLeft();
//                        break;
//                    case KeyEvent.VK_RIGHT:
//                        turnRight();
//                        break;
//                }
            }
        });
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

    private void start() {
        PrimeThread thread = new PrimeThread(world ,this.snakePanel);
        thread.start();
    }

//    private void turnLeft() {
//        snakePanel.setH(0);
//        snakePanel.setW(-10);
//    }
//
//    private void turnRight() {
//        snakePanel.setH(0);
//        snakePanel.setW(10);
//    }
//
//    private void turnUp() {
//        snakePanel.setH(-10);
//        snakePanel.setW(0);
//    }
//
//    private void turnDown() {
//        snakePanel.setH(10);
//        snakePanel.setW(0);
//    }
}
