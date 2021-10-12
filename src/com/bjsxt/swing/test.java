package com.bjsxt.swing;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame{
        public void CreateJFrame(String title){
            JFrame jf=new JFrame(title);//
            Container container=jf.getContentPane();//获取一个容器
            JLabel jl=new JLabel("这是一个JFrame窗体");//创建一个Jlabel标签
            jl.setHorizontalAlignment(SwingConstants.CENTER);//使标签的文字居中

            container.add(jl);//将标签添加到容器内；
            container.setBackground(Color.white);
            jf.setVisible(true);//使窗体可视
            jf.setSize(200,150);
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗体关闭方式
        }

    public static void main(String[] args) {
        new test().CreateJFrame("创建一个JFrame窗体");//调用
    }
}

