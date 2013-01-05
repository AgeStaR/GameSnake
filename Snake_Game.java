package snake_game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


class Square {

    Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
    void setX(int x){
        this.x = x;
    }
    void setY(int y) {
        this.y = y;
    }
           
    Rectangle2D getShape(){
        return new Rectangle2D.Double(x, y, XSIZE, YSIZE);
    }
    
    private static final int XSIZE = 10;
    private static final int YSIZE = 10;
    private int x, y;
}

class Wall{
    protected int x, y, xsize, ysize;
    
    Wall(int x, int y, int xsize, int ysize) {
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
    }
    Rectangle2D getShape(){
        return new Rectangle2D.Double(x, y, xsize, ysize);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

class FieldWall extends Wall {
    FieldWall(int x, int y, int xsize, int ysize) {
        super(x, y, xsize, ysize);
    }
    public int getXsize() {
        return xsize;
    }
    public int getYsize() {
        return ysize;
    }
}

class PrimeThread extends Thread {
        MyPanel panel;
        
         PrimeThread(MyPanel panel) {
             this.panel = panel;
         }
 
         public void run() {
             try{
                 while(panel.getRunning()) {
                    panel.repaint();
                    Thread.sleep(150);
                 }
             }catch(InterruptedException ex) {
             }
         }
     }

class MyPanel extends JPanel {
    private int h, w, hight, width;
    private boolean running;
    Vector<Square> squares;
    Vector<Wall> walls;
    Vector<FieldWall> fieldWalls;
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.h = -10;
        hight = 540;
        width = 550;
        squares = new Vector();
        walls = new Vector();
        fieldWalls = new Vector();
        this.running = false;
    }
    
    public void setRunning(boolean running) {
        this.running = running;
    }
    
    public boolean getRunning() {
        return this.running;
    }
    
    public void addWall(Wall wall) {
        this.walls.add(wall);
    }
    
    public void addFielsWall(FieldWall fieldWall) {
        this.fieldWalls.add(fieldWall);
    }
    
    public void addNewPiece(){
        if (squares.isEmpty()) {
            squares.add(new Square(width, hight));
        }else {
            squares.add(new Square(squares.get(squares.size()-1).getX(),squares.get(squares.size()-1).getY()+10));   
        }
    }
    
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        for (int i = squares.size()-1; i >0 ; i--) {
            g2.setColor(Color.yellow);
            squares.get(i).setX(squares.get(i-1).getX());
            squares.get(i).setY(squares.get(i-1).getY());
            g2.fill(squares.get(i).getShape());
            g.setColor(Color.black);
            g.drawRect(squares.get(i).getX(), squares.get(i).getY(), 10, 10);
        }
        if (squares.isEmpty() == false) {
            hight +=h;
            width +=w;
            squares.firstElement().setX(width);
            squares.firstElement().setY(hight);
            g2.setColor(Color.red);
            g2.fill(squares.firstElement().getShape());
            g.setColor(Color.black);
            g.drawRect(squares.firstElement().getX(), squares.firstElement().getY(), 10, 10);
        }
        for (int i =0; i < this.walls.size(); i++) {
            g2.setColor(Color.gray);
            g2.fill(walls.get(i).getShape());
            
            if ((((int)(walls.get(i).getX()/10))*10) == (((int)(squares.firstElement().getX()/10))*10)
                    || (((int)(walls.get(i).getY()/10))*10) == (((int)(squares.firstElement().getY()/10)))*10) {
                System.out.println("Zone!!!");
                this.running = false;
            }
        }
        
        for (int i = 0; i < this.fieldWalls.size(); i++) {
            g2.setColor(Color.gray);
            g2.fill(this.fieldWalls.get(i).getShape());
            
            if (squares.firstElement().getX()+5 <= this.fieldWalls.get(i).getX() + this.fieldWalls.get(i).getXsize() &&
                    squares.firstElement().getX() +5 >= this.fieldWalls.get(i).getX() &&
                    squares.firstElement().getY() +5 > this.fieldWalls.get(i).getY() &&
                    squares.firstElement().getY()+5 < this.fieldWalls.get(i).getY() + this.fieldWalls.get(i).getYsize()) {
                System.out.println("Zone!!!"+i);
                this.running = false;
            }
        }
    }
    public void setH(int h) {
        this.h = h;
    }
    public void setW(int w) {
        this.w = w;
    }
}

class MyFrame extends JFrame
{
    MyPanel snakePanel;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem, menuItemStart, menuAddPiece;
    MyFrame()
    {
        snakePanel = new MyPanel();
        snakePanel.setBackground(Color.LIGHT_GRAY);
        snakePanel.repaint();
        initWalls();
        initFieldWalls();
        menuBar = new JMenuBar();
        menuItem = new JMenuItem("Exit");
        menuItemStart = new JMenuItem("Start");
        menuAddPiece = new JMenuItem("Add");
        
        menu = new JMenu("File");
        
        add(menuBar, BorderLayout.NORTH);
        add(snakePanel, BorderLayout.CENTER);
        
        menuItem.addActionListener(new ActionListener()
        {
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
        
        menuAddPiece.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                snakePanel.addNewPiece();
                snakePanel.repaint();
            }
        });
        
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:turnDown(); break;
                    case KeyEvent.VK_UP:turnUp(); break;
                    case KeyEvent.VK_LEFT:turnLeft(); break;
                    case KeyEvent.VK_RIGHT:turnRight(); break;    
                }
            }
        } );
        this.addMouseListener(new MouseAdapter (){

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());
                System.out.println(e.getY());
            }
        });
        
        snakePanel.addNewPiece();
        snakePanel.addNewPiece();
        snakePanel.addNewPiece();
        
        setSize(595, 645);
        setLocation(500, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void initWalls() {
        snakePanel.addWall(new Wall(0,0,600,20));
        snakePanel.addWall(new Wall(0,0,20,600));
        snakePanel.addWall(new Wall(0,571,600,600));
        snakePanel.addWall(new Wall(571,0,600,600));
        snakePanel.repaint();
    }
    
    private void initFieldWalls() {
        snakePanel.addFielsWall(new FieldWall(0, 100, 400, 10));
        snakePanel.addFielsWall(new FieldWall(80, 300, 350, 10));
        snakePanel.addFielsWall(new FieldWall(150, 500, 350, 10));
    }
    
    private void start() {
        PrimeThread thread = new PrimeThread(this.snakePanel);
        this.snakePanel.setRunning(true);
        thread.start();
    }
    
    private void turnLeft() {
        snakePanel.setH(0);
        snakePanel.setW(-10);
    }
    private void turnRight() {
        snakePanel.setH(0);
        snakePanel.setW(10);
    }
    private void turnUp() {
        snakePanel.setH(-10);
        snakePanel.setW(0);
    }
    private void turnDown() {
        snakePanel.setH(10);
        snakePanel.setW(0);
    }
}

public class Snake_Game {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                    @Override
                public void run()  {
                   MyFrame frame = new MyFrame();  
                }
            });
    }
}
