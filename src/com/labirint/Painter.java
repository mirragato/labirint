package com.labirint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//implements - реализация интерфейса


public class Painter extends JPanel implements ActionListener {//РАБОТАЕТ! ПОКА ЛУЧШЕ НЕ ТРОГАТЬ!

    private Timer timer;
    private Level m;
    private Player p;


    private boolean win=false;
    private  String Message="";
    private  Font font=new Font("Serif",Font.BOLD,48); //цвет и шрифт текста


    Painter(){
        m=new Level();
        p=new Player();
        addKeyListener(new Al());
        setFocusable(true);


        timer=new Timer(25,this);
        timer.start();
    };
    @Override
    public void actionPerformed(ActionEvent e) {
        if(m.getLevel(p.getTileX(),p.getTileY()).equals("e")) {
            Message="Winner";
            win=true;
        }
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(!win) {
            for (int y = 0; y < 20; y++) {
                for (int x = 0; x < 20; x++) {
                    if (m.getLevel(x, y).equals("e")) {
                        g.drawImage(m.getExit(), x * 32, y * 32, null); //32-pixsel
                    }
                    if (m.getLevel(x, y).equals("n")) {
                        g.drawImage(m.getNun(), x * 32, y * 32, null);
                    }
                    if (m.getLevel(x, y).equals("w")) {
                        g.drawImage(m.getWall(), x * 32, y * 32, null);
                    }
                }
            }
            g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
        }
        //g.drawString(Message,50,50);
        if (win) {
            g.setColor(Color.ORANGE);
            g.setFont(font);
            g.drawString(Message, 150, 200);
        }


    }

    public class Al extends KeyAdapter{ //РАБОТАЕТ - НЕ ТРОГАТЬ!!!!

        public  void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_W) {
                if (!m.getLevel(p.getTileX(), p.getTileY() - 1).equals("w")) {
                    p.move(0, -1);
                }
            }
            if (keycode == KeyEvent.VK_S) {
                if (!m.getLevel(p.getTileX(), p.getTileY() + 1).equals("w")) {
                    p.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_A) {
                if (!m.getLevel(p.getTileX() - 1, p.getTileY()).equals("w")) {
                    p.move(-1, 0);
                }
            }
            if (keycode == KeyEvent.VK_D) {
                if (!m.getLevel(p.getTileX() + 1, p.getTileY()).equals("w")) {
                    p.move(1, 0);
                }
            }
        }
    }


}
