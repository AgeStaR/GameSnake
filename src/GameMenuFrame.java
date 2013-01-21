
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class GameMenuFrame extends JFrame {
    JButton buttonStartGame, buttonExit, buttonSomeOpportunity;
    
    GameMenuFrame() {
        
        this.buttonStartGame = new JButton("Start game");
        buttonStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setVisible(false);
                        new GameFrame();
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
        
        this.buttonSomeOpportunity = new JButton("New opportunity");
        
        add(this.buttonStartGame, BorderLayout.NORTH);
        add(this.buttonExit, BorderLayout.SOUTH);
        add(this.buttonSomeOpportunity, BorderLayout.CENTER);
        
        setSize(100, 150);
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
    
}
