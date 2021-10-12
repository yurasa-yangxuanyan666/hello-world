package src.com.bjsxt.plane;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

public class Shell extends GameObject{
    double degree;//角度，炮弹沿着指定的角度生成


    public void draw(Graphics g){
//将外部传入对象g的状态保存好
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x, (int)y, width, height);
//炮弹沿着任意角度飞行
       x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        //如下代码，用来实现碰到边界，炮弹反弹回来(原理和打台球游戏一样)
       if(y>Constant.GAME_HEIGHT-height||y<30){
           degree = -degree;
        }
       if(x<0||x>Constant.GAME_WIDTH-width){
           degree = Math.PI-degree;
       }
//返回给外部，变回以前的颜色
        g.setColor(c);
    }



    public Shell(){
        x=200;
        y=200;
        degree=Math.random()*Math.PI*2;
        width=5;
        height=5;
        speed=5;

    }
}
