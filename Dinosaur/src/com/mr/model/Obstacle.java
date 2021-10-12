package com.mr.model;

import com.mr.view.BackgroundImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Obstacle {
    public int x,y;//横纵坐标
    public BufferedImage image;
    private BufferedImage stone;//石头图片
    private BufferedImage cacti;//仙人掌图片
    private int speed;//移动速度

    public Obstacle() {
        try {
            stone= ImageIO.read(new File("src/com/mr/model/石头.png" ));
            cacti=ImageIO.read(new File("src/com/mr/model/仙人掌  .png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        Random r=new Random();//创建随机对象
        if (r.nextInt(2)==0){
            image=cacti;//为0采用随机对象
        }else {
            image=stone;
        }
        x=800;//初始横坐标
        y=200-image.getHeight();//纵坐标
        speed= BackgroundImage.SPEED;
    }
    public void move(){
        x-=speed;
    }
    public boolean isLive(){
        if (x<=-image.getWidth()){
            return false;
        }
        return true;
    }
    public Rectangle getBounds(){
        if (image==cacti){
            return new Rectangle(x+7,y,15,image.getHeight());
        }
        return new Rectangle(x+5,y+4,23,21);
    }
}
