package com.bjsxt.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;


public class MyJDialog extends JDialog {
    public MyJDialog(MyFrame frame){
        //实例化一个JDialog类对象，指定对话窗的父窗体、窗体标题和类型
        super(frame,"第一个JDialog窗体",true);
        Container container=getContentPane();//创建一个容器
        container.add(new JLabel("这是一个对话框"));//容器添加一个标签
        setBounds(120,120,100,100);//设置对话窗体大小
    }
}


class MyFrame extends JFrame{
    public static void main(String[] args) {
        new MyFrame();
    }
    public MyFrame(){
        JFrame jf=new JFrame();//

        Container container=jf.getContentPane();//创建一个容器Jframe
        container.setLayout(null);
        JLabel jl=new JLabel("这是一个JFrame窗体");
        jl.setHorizontalAlignment(SwingConstants.CENTER);

        container.add(jl);//容器添加一个标签
        JButton bl=new JButton("弹出对话框");//定一个按钮
        bl.setBounds(10,10,100,21);
        bl.addActionListener(new ActionListener() {//添加鼠标单击事件
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyJDialog(MyFrame.this).setVisible(true);//使MyJDialog窗体可见
            }
        });
        container.add(bl);//将按钮添加到容器中
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setBackground(Color.white);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
