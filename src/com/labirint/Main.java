package com.labirint;

import javax.swing.*;

/**
 * Работает
 */
public class Main {
    public static void main(String[] args){
        new Main();
    }

 public Main(){
     PlayAudio audio;
     JFrame f=new JFrame();
     audio = new PlayAudio();
     f.setTitle("Labirint");
     f.add(new Painter());
     f.setSize(656, 679);//размеры окна
     audio.play("Imagine Dragons - Who We Are.wav");
     f.setLocationRelativeTo(null);//указывает расположение фрейма на экране
     f.setVisible(true);//делает видимым

     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие программы
     audio.stop();
 }
}
