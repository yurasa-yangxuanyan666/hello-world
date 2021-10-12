package com.mr.service;

import java.io.FileNotFoundException;

public class Sound {
    static final String DIR="src/com/mr/service/";
    static final String BACKGROUD="background.wav";
    static final String JUMP="jump.wav";
    static final String HIT="hit.wav";
    private static void play(String file,boolean circulate){//播放器
        try {
            MusicPlayer player=new MusicPlayer(file,circulate);//创建播放器
            player.play();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    static public void jump(){
        play(DIR+JUMP,false);
    }
    static  public void hit(){
        play(DIR+HIT,false);
    }
    static public void backgroud(){
        play(DIR+BACKGROUD,true);
    }
}
