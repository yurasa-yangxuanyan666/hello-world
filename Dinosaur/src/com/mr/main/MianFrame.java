package com.mr.main;

import com.mr.service.ScoureRecorder;
import com.mr.service.Sound;
import com.mr.view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MianFrame extends JFrame {
    public MianFrame(){
        restart();
        setBounds(340,150,820,260);//设置游戏窗口大小
        setTitle("奔跑吧，小恐龙");//设置标题
        Sound.backgroud();//播放背景音乐
        ScoureRecorder.init();//记录得分
        addListener();//添加监听
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置关闭

    }
    public void restart(){
        Container c=getContentPane();//获取主容器对象
        c.removeAll();//删除容器中的所有主键
        GamePanel panel=new GamePanel();//创建新的游戏面板
        c.add(panel);//容器添加游戏面板
        addKeyListener(panel);//添加键盘事件
        c.validate();
    }

private void addListener(){//添加窗体监听，主要是保存得分记录
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
             ScoureRecorder.saveScore();
            }
        });
}
}
