package src.com.bjsxt.plane;

import java.awt.*;

public class Explode {
    double x,y;
    int count;
    static Image[] images=new Image[16];
    static {
        for (int i=0;i<16;i++){
            images[i]=GameUtil.getImage("src/com/bjsxt/plane/e"+(i+1)+".gif");
            images[i].getWidth(null);//解决懒加载问题
        }
    }
    public void drawMySelf(Graphics g){
        if (count<16){
            g.drawImage(images[count],(int)x,(int)y,null );
            count++;
        }
    }
    public Explode(double x,double y){
        this.x=x;
        this.y=y;
    }
}
