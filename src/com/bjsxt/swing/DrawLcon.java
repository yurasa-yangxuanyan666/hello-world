package com.bjsxt.swing;

import javax.swing.*;
import java.awt.*;

public  class DrawLcon implements Icon {//实现Icon接口
    private int width;
    private int height;


    @Override
    public void paintIcon(Component arg0, Graphics arg1, int x, int y) {
        arg1.fillOval(x, y, width, height);//绘制一个圆
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }


    public DrawLcon(int width, int height) {//定义构造方法
        this.height = height;
        this.width = width;
    }

    public void paintlcom(Component arg0, Graphics arg1, int x, int y) {
        arg1.fillOval(x, y, width, height);//绘制一个圆
    }

    public static void main(String[] args) {
        DrawLcon icon = new DrawLcon(15, 15);
        JLabel j=new JLabel("测试",icon,SwingConstants.CENTER);
        JFrame jf=new JFrame();
        Container container=jf.getContentPane();//获取一个容器
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setBackground(Color.white);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       container.add(j);//用j来创建
    }
}