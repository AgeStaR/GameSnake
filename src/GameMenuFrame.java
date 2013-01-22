
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class GameMenuFrame extends JFrame {
    private static JButton buttonNewStartGame, buttonExit, buttonContinueGame;
    static int level = 1;
    
    GameMenuFrame() {
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
        
        add(GameMenuFrame.buttonNewStartGame, BorderLayout.CENTER);
        add(GameMenuFrame.buttonExit, BorderLayout.SOUTH);
        add(GameMenuFrame.buttonContinueGame, BorderLayout.NORTH);
        
        setSize(100, 110);
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
