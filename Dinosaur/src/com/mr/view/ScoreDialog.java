package com.mr.view;

import com.mr.service.ScoureRecorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreDialog extends JDialog {
    public ScoreDialog(JFrame frame) {
        super(frame);
        int scores[]=ScoureRecorder.getScores();
        JPanel scroeP=new JPanel(new GridLayout(4,1));
        scroeP.setBackground(Color.white);
        JLabel title=new JLabel("分数排行榜",JLabel.CENTER);
        title.setFont(new Font("黑体",Font.BOLD,20));
        title.setForeground(Color.red);
        JLabel first=new JLabel("第一名："+scores[2],JLabel.CENTER);
        JLabel second=new JLabel("第二名："+scores[1],JLabel.CENTER);
        JLabel third=new JLabel("第三名："+scores[0],JLabel.CENTER);
        JButton restart=new JButton("重新开始");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();//销毁对话框
            }
        });
        scroeP.add(title);
        scroeP.add(first);
        scroeP.add(second);
        scroeP.add(third);

        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add(scroeP,BorderLayout.CENTER);
        c.add(restart,BorderLayout.SOUTH);

        setTitle("游戏结束");
        int width,height;
        width=height=200;
        int x=frame.getX()+(frame.getWidth()-width)/2;
        int y=frame.getY()+(frame.getHeight()-height)/2;
        setBounds(x,y,width,height);
        setVisible(true);
    }
}
