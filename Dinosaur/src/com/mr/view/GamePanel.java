package com.mr.view;

import com.mr.model.Dinosaur;
import com.mr.model.Obstacle;
import com.mr.service.FreshThread;
import com.mr.service.ScoureRecorder;
import com.mr.service.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements KeyListener{
    private BufferedImage image;//主图片
    private BackgroundImage background;//背景
    private Dinosaur golden;//恐龙
    private Graphics2D g2;//主图片绘制对象
    private int addObstecleTimer=0;//添加障碍计时器
    private List<Obstacle> list=new ArrayList<Obstacle>();//障碍集合
    private boolean finish=false;//游戏结束标志
    private final int FREASH= FreshThread.FREASH;//刷新时间·
    int score=0;//分数
    int scoreTime=0;//分数计时器
    public GamePanel(){
        //主图片采用800,300的彩色图片
        image=new BufferedImage(800,300,BufferedImage.TYPE_INT_RGB);
        g2=image.createGraphics();//获取主图片绘制对象
        background=new BackgroundImage();
        golden=new Dinosaur();
        list.add(new Obstacle());//添加一个障碍物，list的add方法
        FreshThread t=new FreshThread(this);
        t.start();
    }
    public void paintImage(){
        background.roll();
        golden.move();
        g2.drawImage(background.image,0,0,this);//调用背景
        if (addObstecleTimer==1300){
            if (Math.random()*100>40){//百分之60的概率出现障碍
                list.add(new Obstacle());
            }addObstecleTimer=0;//重新计时
        }
        for (int i = 0; i <list.size() ; i++) {//遍历障碍集合
            Obstacle o=list.get(i);//获取障碍对象
            if (o.isLive()){//如果障碍对象是存活的
                o.move();//障碍移动
                g2.drawImage(o.image,o.x,o.y,this);//绘制障碍
                if (o.getBounds().intersects(golden.getFootBounds())
                        ||o.getBounds().intersects(golden.getHeadBounds())){
                    //如果头和脑袋撞到障碍我
                    Sound.hit();
                    gameOver();
                }
            }else {
                list.remove(i);//移除障碍
                i--;//循环变量前移
            }

        }
        g2.drawImage(golden.image,golden.x,golden.y,this);//绘制恐龙
        if (scoreTime>=500){//积分时间大于500分数+10，重新计算时间
            score+=10;
            scoreTime=0;
        }
        g2.setColor(Color.black);//黑色
        g2.setFont(new Font("黑体",Font.BOLD,24));//设置字体
        g2.drawString(String.format("%06d",score),700,30);//设置分数的位置以及大小
        addObstecleTimer+=FREASH;
        scoreTime+=FREASH;//设置计时器计算FREASH为线程时间

    }

    private void gameOver() {
        ScoureRecorder.addNewScore(score);//记录当前分数
        finish=true;
    }

    public void paint(Graphics g){
        paintImage();//绘制图片内容
        g.drawImage(image,0,0,this);
    }
    public boolean isFinish(){
        return finish;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_SPACE){
            golden.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
