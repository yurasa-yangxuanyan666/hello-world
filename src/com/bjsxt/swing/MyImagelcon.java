package com.bjsxt.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyImagelcon extends JFrame {
    public MyImagelcon(){
        Container container=getContentPane();
        JLabel jl=new JLabel("这是一个JFrame窗体",JLabel.CENTER);
        URL url=MyImagelcon.class.getResource("ball1.png");

        Icon icon=new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setOpaque(true);
        container.add(jl);
        setSize(250,100);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new MyImagelcon();
    }
}
