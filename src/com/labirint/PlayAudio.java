package com.labirint;

import javax.sound.sampled.*;
import java.io.File;

class PlayAudio {
    static Clip line;
    PlayAudio(){}
    public void stop()
    {
        line.stop();
        line.close();
    }
    public void play(String name){
        Clip line = null;

        try{
// Создаем объект, представляющий файл
//"src/newpackage/Imagine Dragons - Who We Are.wav"
            File f = new File (name);

// Получаем информацию о способе записи файла
            AudioFileFormat aff = AudioSystem.getAudioFileFormat(f);

// Получаем информацию о способе записи звука
            AudioFormat af = aff.getFormat();

// Собираем всю информацию вместе,
// добавляя сведения о классе
            DataLine.Info info = new DataLine.Info(Clip.class, af) ;

// Проверяем, можно ли проигрывать такой формат
            if (!AudioSystem.isLineSupported(info)){
                System.out.println("Line is not supported");
                System.exit(0);
            }
// Получаем линию связи с файлом
            line = (Clip)AudioSystem.getLine(info);

// Создаем поток байтов из файла
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);

// Открываем линию
            line.open(ais);
        }catch(Exception e){
            System.err.println(e);
        }
// Начинаем проигрывание
        line.start();
    }
}

