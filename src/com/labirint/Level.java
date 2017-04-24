package com.labirint;



import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

//чтение уровня,обработка
public class Level {//Добавить 2 уровень

    private Scanner sc;
    private String Level[]= new String[20];

    private Image wall,nun,exit;

    Level() { //конструктор
        ImageIcon img= new ImageIcon("images/nun.png");
        nun=img.getImage();
        img= new ImageIcon("images/wall.png");
        wall=img.getImage();
        img= new ImageIcon("images/exit.png");
        exit=img.getImage();

        openFile();
        readFile();
        closeFile();
    }


    public Image getNun(){
        return nun;
    }
    public Image getWall(){
        return wall;
    }
    public Image getExit(){
        return exit;
    }

    boolean SolveCollision() { //столкновения
        return false;
    }

    public String getLevel(int x, int y){
        String index=Level[y].substring(x,x+1); //до перемещения, стартовая позиция
        return index;
    }

    public void openFile() {
        try {
            sc = new Scanner(new File("map.txt"));
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void readFile(){
        while(sc.hasNext()) {
            for (int i = 0; i < 20; i++) {
                Level[i]=sc.next();
            }
        }
    }
    public void closeFile(){
        sc.close();
    }
}
