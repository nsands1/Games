import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_W = 600;
    static final int SCREEN_H = 600;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNITS = (SCREEN_W*SCREEN_H)/UNIT_SIZE;
    static final int DELAY = 75; //changes speed of snake
    static final int x[] = new int[GAME_UNITS];
    static final int y[] = new int[GAME_UNITS];
    static final int scores[] = new int[10];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    int score;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    GamePanel() {

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        startGame();
    }
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

    }
    public void draw(Graphics g) {
        //gridlines
        for(int i = 0; i < SCREEN_H/UNIT_SIZE; i++) {
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_H);
            g.drawLine(0, i*UNIT_SIZE, SCREEN_W, i*UNIT_SIZE);
        }
        //apple
        g.setColor(Color.RED);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
        //snake
        for(int i = 0; i < bodyParts; i++) {
            if(i == 0) {
                g.setColor(new Color(50,200,0));
                g.fillRoundRect(x[i], y[i],UNIT_SIZE, UNIT_SIZE,UNIT_SIZE/2, UNIT_SIZE/2);
            } else {
                g.setColor(new Color(45,180,10));
                g.fillRoundRect(x[i], y[i],UNIT_SIZE, UNIT_SIZE,UNIT_SIZE/2, UNIT_SIZE/2);
            }
        }
    }
    public void newApple() {
        appleX = random.nextInt((int)(SCREEN_W/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_H/UNIT_SIZE))*UNIT_SIZE;
    }
    public void move() {
        for(int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }
    public void checkApple() {

    }
    public void checkCollisions() {
        //head collides to bodyparts
        for(int i = bodyParts; i > 0; i--) {
            if((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                //TODO end game, show score
            }
        }
        //head touches left border
        if(x[0] < 0) {
            running = false;
            //TODO end game, show score
        }
        //head touches right border
        if(x[0] > SCREEN_W) {
            running = false;
            //TODO end game, show score
        }
        //head touches top border
        if(y[0] < 0) {
            running = false;
            //TODO end game, show score
        }
        //head touches bottom border
        if(y[0] > SCREEN_H) {
            running = false;
            //TODO end game, show score
        }

        if(!running) {

        }

    }
    public void gameOver(Graphics g) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
            }

        }
    }
}
