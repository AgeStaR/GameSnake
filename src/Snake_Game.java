package snake_game;
import javax.swing.*;

public class Snake_Game {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame frame = new MyFrame();
            }
        });
    }
}
