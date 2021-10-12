package com.mr.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MusicPlayer implements Runnable{
    File soundFile;
    Thread thread;//父线程
    boolean circulate;//判断是否循环

    public MusicPlayer() {
    }

    public MusicPlayer(String filepath, boolean circulate)throws FileNotFoundException {
       this.circulate=circulate;
       soundFile=new File(filepath);
       if (!soundFile.exists()){//如果文件不存在
           throw new FileNotFoundException(filepath+"未找到");
       }
        }

    @Override
    public void run() {
        byte[] auBuffer=new byte[1024*128];//创建128K缓存区
        do {
            AudioInputStream audioInputStream=null;
            SourceDataLine auline=null;
            try {
                //从音乐文件中获取
                audioInputStream= AudioSystem.getAudioInputStream(soundFile);
                AudioFormat format=audioInputStream.getFormat();//获取格式
                DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);

                    auline=(SourceDataLine)AudioSystem.getLine(info);
                    auline.open(format);
                    auline.start();
                    int bytwCount=0;
                    while (bytwCount!=-1){
                        bytwCount=audioInputStream.read(auBuffer,0,auBuffer.length);
                        if (bytwCount>=0){
                            auline.write(auBuffer,0,bytwCount);
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                }catch (LineUnavailableException e){
                    e.printStackTrace();

                }finally {
                    auline.drain();
                    auline.close();
                }
        }while (circulate);
    }

    public void play(){
        thread=new Thread(this);//创建线程对象
        thread.start();//开始线程
    }
    public void stop(){
        thread.stop();//强制关闭线程
    }
}

