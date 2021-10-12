package src.com.bjsxt.plane;

import java.awt.*;

public class GameObject {
    Image img;//图片
    double x,y;//物体的坐标
    int speed;//速度
    int width,height;//高度和宽度

    public GameObject() {
    }

    public GameObject(Image img, double x, double y, int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.height=img.getHeight(null);
        this.width=img.getWidth(null);
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
    public void drwaMyself(Graphics g){
        g.drawImage(img,(int) x,(int)y,width,height,null);
    }
    //所有物体都是矩形到那个你获得对应矩形的时候，就可以做一些相关的判断操作
    public Rectangle getREc(){
        return new Rectangle((int)x,(int) y,width,height);//物体的坐标和长宽
    }
}
