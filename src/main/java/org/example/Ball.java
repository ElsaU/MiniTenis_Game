package org.example;

import java.awt.*;

public class Ball {
    private static final int DIAMETER = 30;
    private int x = 0;
    private int y = 0;
    private int xd = 1;
    private int yd = -1;
    private int speed = 1;

    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    public void paint(Graphics2D g){
        g.fillOval(x,y,DIAMETER,DIAMETER);
    }
    public void move(){
        x = x + xd;
        y = y + yd;

        if (y >= game.getHeight() - DIAMETER){
            game.gameOver();
        }else {
            if (x + DIAMETER > game.getWidth()){
                xd = -1 * speed;
            }else if (x < 0){
                xd = 1 * speed;
            }
            if (y + DIAMETER > game.getHeight()){
                yd = -1 * speed;
            }else if (y < 0){
                yd = 1 * speed;
            }
        }

        if (collision()){
            game.setScore();
            if (game.getScore() % 5 == 0){
                speed++;
            }
            yd = -1 * speed;
            y = game.racquet.getTopY() - DIAMETER;
        }
    }

    public Boolean collision(){
        return game.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    public int getSpeed() {
        return speed;
    }
}
