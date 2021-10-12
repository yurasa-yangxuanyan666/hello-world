package com.mr.model;

import com.mr.service.FreshThread;
import com.mr.service.Sound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;

public class Dinosaur {
    public BufferedImage image;//主图片
    private BufferedImage image1,image2,image3;//恐龙跑步图标
    public int x,y;//恐龙坐标
    private int jumpValue=0;
    private boolean jumpState=false;
    private int setpTimer=0;//跑步计时器
    private final int JUMP_HIGHTEST=100;
    private final int LOWEST_Y=120;//落地最低坐标
    private final int FREASH= FreshThread.FREASH;

    //调用恐龙方法
    public Dinosaur(){
        x=50;
        y=LOWEST_Y;
        try {
            image1= ImageIO.read(new File("src/com/mr/model/恐龙1.png"));
            image2= ImageIO.read(new File("src/com/mr/model/恐龙2.png"));
            image3= ImageIO.read(new File("src/com/mr/model/恐龙3.png"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //恐龙踏步
    public void step(){
        //每过250毫秒跟换图片，三张图片，除三取余，轮流展示这三张
        int tmp=setpTimer/250%3;
        switch (tmp){
            case 1:
                image =image1;
                break;
            case  2:
                image=image2;
            case 3:
                image=image3;
        }
        setpTimer+=FREASH;
    }

    //跳跃
    public void jump(){
        if (!jumpState){
            Sound.jump();
        }
        jumpState=true;
    }
    public void move(){
        step();//不断踏步
        if (jumpState){
            if (y>=LOWEST_Y){
                jumpValue=-4;
            }
            if (y<=LOWEST_Y-JUMP_HIGHTEST){
                jumpValue=4;
            }
            y+=jumpValue;
            if (y>=LOWEST_Y){
                jumpState=false;
            }
        }
    }
    public Rectangle getFootBounds(){
        return new Rectangle(x+30,y+59,29,18);
    }
    public Rectangle getHeadBounds(){
        return new Rectangle(x+66,y+25,32,22);
    }
}
