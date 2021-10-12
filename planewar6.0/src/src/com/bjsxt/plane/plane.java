package src.com.bjsxt.plane;

import java.awt.*;
import java.awt.event.KeyEvent;

public class plane extends GameObject {
    boolean left,right,up,down;//飞机控制方向
    boolean live=true;//或者
    @Override
    public void drwaMyself(Graphics g) {
        if (live){
        super.drwaMyself(g);
        //飞行算法，自定义设定
        //x+=speed;
        if(left){
           x-=speed;
        }
        if(right){
            x+=speed;
        }
        if (up){
           y-=speed;
        }
        if (down){
            y+=speed;
        }
    }
    }
public void addDirection(KeyEvent e){
    switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT -> left = true;
        case KeyEvent.VK_RIGHT -> right = true;
        case KeyEvent.VK_UP -> up = true;
        case KeyEvent.VK_DOWN -> down = true;
    }
}
public void minusDirection(KeyEvent e){
    switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT -> left = false;
        case KeyEvent.VK_RIGHT -> right = false;
        case KeyEvent.VK_UP -> up = false;
        case KeyEvent.VK_DOWN -> down = false;
    }
}
    public plane(Image img, double x, double y, int speed) {
        super(img, x, y, speed);
    }
}
