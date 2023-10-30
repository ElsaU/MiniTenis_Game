package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int Y = 420;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 10;
    private int x = 190;
    private int xd = 0;
    private Game game;
    public Racquet(Game game){
        this.game = game;
    }
    public void paint(Graphics2D g){
        g.fillRect(x,Y,WIDTH,HEIGHT);
    }

    public void move(){
        if (x + xd + WIDTH < game.getWidth() && x + xd > 0){
            x = x + xd;
        }
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            xd = -1 * game.ball.getSpeed();
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            xd = 1 * game.ball.getSpeed();
        }
    }

    public void keyRelease(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            xd = 0;
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y -HEIGHT;
    }
}
