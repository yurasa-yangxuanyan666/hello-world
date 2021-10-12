package com.mr.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundImage extends JFrame {
    public BufferedImage image;//主界面
    private BufferedImage image1,image2;//两个背景
    private Graphics2D g;//背景的绘图对象
    public int x1,x2;//两副图的坐标
    public static final int SPEED=4;//背景前进速度
    public BackgroundImage() {
        try {
            image1=ImageIO.read(new File("src/com/mr/view/背景1.png"));
            image2=ImageIO.read(new File("src/com/mr/view/背景2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        //主图片用宽800,300的彩色图片
        image=new BufferedImage(800,300,BufferedImage.TYPE_INT_RGB);//
        g=image.createGraphics();//获取主图片绘图对象
        x1=0;//两图的横坐标
        x2=800;
        g.drawImage(image1,x1,0,null);//绘制第一幅图
    }


    public void roll(){
        //图片滚动方法
        x1-=SPEED;//第一幅图左移
        x2-=SPEED;//第二幅图右移
        if(x1<-800){
            x1=800;//一个轮回x1坐标又回到800
        }
        if(x2<-800){
            x2=800;//一个轮回x1坐标又回到800
        }
        g.drawImage(image1,x1,0,null);//在主图片中绘制两幅图片
        g.drawImage(image2,x2,0,null);
    }
}
