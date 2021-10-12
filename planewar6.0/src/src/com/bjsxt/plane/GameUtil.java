package src.com.bjsxt.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

//游戏工具类
public class GameUtil {
    //构造器私有防止别人创建对象
    private GameUtil(){}
    //获取图片
    public static Image getImage(String path){
        BufferedImage image=null;
        URL url =GameUtil.class.getClassLoader().getResource(path);
        try {
            image=ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static void main(String[] args) {
        Image images=GameUtil.getImage("com/bjsxt/plane/plane.png");
        System.out.println(images);
    }
}
