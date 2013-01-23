import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class GameMenuFrame extends JFrame {
    private static JButton buttonStartNewGame, buttonExit;
    static int gameLevel = 1;
    private Game game;
    private JPanel mainWindowPanel, gamePanel, facePanel, buttonPanel;
    
    GameMenuFrame() {
        setTitle("Snake, ver 0.02");
        this.buttonPanel = new JPanel();
        this.mainWindowPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        ImagePanel imagePanel = new ImagePanel();
        
        this.buttonStartNewGame = new JButton("Start new game");
        buttonStartNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createGame(1);
            }
        });
        
        this.buttonExit = new JButton("Exit");
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        buttonPanel.add(GameMenuFrame.buttonStartNewGame, BorderLayout.CENTER);
        buttonPanel.add(GameMenuFrame.buttonExit, BorderLayout.SOUTH);
        
        mainWindowPanel.setLayout(new BorderLayout());
        mainWindowPanel.add(buttonPanel, BorderLayout.NORTH);
        mainWindowPanel.add(imagePanel, BorderLayout.CENTER);
        this.facePanel = new JPanel();
        this.facePanel.setLayout(new BorderLayout());
        facePanel.add(mainWindowPanel);
        
        setContentPane(facePanel);
        
        this.gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        
        setSize(595, 620);
        setLocation(500, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMenuFrame();
            }
        });
    }

    public void createGame(int i) {
        World world = new World(i);
        Food food = new Food(world,i*4);
        food.generateFood();
        Snake snake = new Snake();
        Level level = new Level(snake, world , food);
        this.game = new Game(level, this);
        game.setBackground(Color.LIGHT_GRAY);
        addKeyListener(new SnakeController(snake));
        
        gamePanel.add(game, BorderLayout.CENTER);
        this.facePanel.remove(mainWindowPanel);
        this.facePanel.add(gamePanel);
        setVisible(false);
        setVisible(true);
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                game.start();
            }
        });
    }
    
}
