package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game extends JPanel{
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);

    private int score = 0;

    public Game(){
        JOptionPane.showMessageDialog(this, "¿Preparado?");
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyRelease(e);
            }
        });
        setFocusable(true);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tenis");
        Game game = new Game();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(game);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            game.moveBall();
            game.repaint();
            Thread.sleep(5);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(graphics);
        racquet.paint(graphics);

        graphics.setFont(new Font("Verdana", Font.BOLD, 30));
        graphics.drawString(String.valueOf(score), 10, 30);

    }

    private void moveBall(){
        ball.move();
        racquet.move();
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over");
        System.exit(ABORT);
    }

    public void setScore(){
        score++;
    }

    public int getScore(){
        return score;
    }

}