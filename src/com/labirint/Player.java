package com.labirint;


import javax.swing.*;
import java.awt.*;

//движение,перс,координаты
public class Player {//РАБОТАЕТ

    private int tileX, tileY;
    private Image player;

    public Player(){
        ImageIcon img= new ImageIcon("images/cat.png");
        player=img.getImage();
        tileX=1;
        tileY=1;

    }

    public Image getPlayer(){
        return player;
    }
    public int getTileX(){
        return tileX;
    }
    public int getTileY(){
        return tileY;
    }

   public void move( int tx, int ty){
       tileX+=tx;
       tileY+=ty;
   }
}