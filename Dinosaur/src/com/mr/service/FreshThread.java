package com.mr.service;

import com.mr.main.MianFrame;
import com.mr.view.GamePanel;
import com.mr.view.ScoreDialog;

import java.awt.*;
import java.util.Scanner;

public class FreshThread extends Thread{
    public static final int FREASH=20;
    GamePanel p;//游戏面板

    public FreshThread(GamePanel p) {
        this.p = p;
    }
    public void run(){
    while (!p.isFinish()){
        p.repaint();
        try {
            Thread.sleep(FREASH);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    Container c=p.getParent();
    while (!(c instanceof MianFrame)){
        c=c.getParent();
    }
    MianFrame frame=(MianFrame) c;
    new ScoreDialog(frame);
    frame.restart();
    }
}
