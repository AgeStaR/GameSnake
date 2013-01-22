
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class GameMenuFrame extends JFrame {
    private static JButton buttonNewStartGame, buttonExit, buttonContinueGame;
    static int level = 1;
    
    GameMenuFrame() {
        setTitle("Snake menu");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        ImagePanel imagePanel = new ImagePanel();
        
        this.buttonNewStartGame = new JButton("Start new game");
        buttonNewStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new GameFrame(1);
                    }
                });
            }
        });
        
        this.buttonExit = new JButton("Exit");
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        GameMenuFrame.buttonContinueGame = new JButton("Continue game");
        buttonContinueGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new GameFrame(GameMenuFrame.level);
                    }
                });
            }
        });
        
        
        if(GameMenuFrame.level == 1) {
            GameMenuFrame.buttonContinueGame.setEnabled(false);
        }
        
        
        panel.add(GameMenuFrame.buttonNewStartGame, BorderLayout.CENTER);
        panel.add(GameMenuFrame.buttonExit, BorderLayout.SOUTH);
        panel.add(GameMenuFrame.buttonContinueGame, BorderLayout.NORTH);
        
        add(panel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        
        
        setSize(600, 600);
        setLocation(500, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void endGame() {
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMenuFrame();
            }
        });
    }
    
    public static void setAdvanceGame(boolean b) {
        GameMenuFrame.buttonContinueGame.setEnabled(b);
    }
    
}
