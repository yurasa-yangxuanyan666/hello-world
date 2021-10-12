package src.com.bjsxt.plane;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class MyGameFrame extends Frame {
    Image plane=GameUtil.getImage("src/com/bjsxt/plane/plane.png");
    Image bg=GameUtil.getImage("src/com/bjsxt/plane/bg.jpg");
    plane plane1=new plane(plane,100,100,5);
    Shell[] shells=new Shell[30];
    Explode explode;
    Date start=new Date();//游戏开始时间
    Date end;//游戏结束时间
    long Period=0;//玩了多少秒
    //游戏主窗口
        public void paint(Graphics g){
            g.drawImage(bg,0,0,500,500,null);

            drawtime(g);

            plane1.drwaMyself(g);
            for (int i=0;i<shells.length;i++){
                shells[i].draw(g);
               boolean peng= shells[i].getREc().intersects(plane1.getREc());
                if (peng){
           //         System.out.println("飞机被击中了");
                    plane1.live=false;

                    if (explode==null){
                        explode=new Explode(plane1.x,plane1.y);
                    }
                    explode.drawMySelf(g);
                }
            }

        }

        public void drawtime(Graphics g){
            Color c=g.getColor();
            g.setColor(Color.cyan);
            if (plane1.live) {
                Period = (System.currentTimeMillis() - start.getTime()) / 1000;
                g.drawString("坚持：" + Period, 30, 50);
            }else {
                if (end==null) {
                    end = new Date();
                    Period=(end.getTime()-start.getTime())/1000;
                }

                g.setColor(Color.red);
                g.setFont(new Font("微软雅黑",Font.BOLD,30));
                g.drawString("最终时间："+Period,200,200);
            }
            g.setColor(c);
        }

        //定义了一个重画窗口的线程
        //定义为内部类方便调用
        class PaintThread extends Thread{
            @Override
            public void run() {
                while (true){
                    repaint();//内部类可以直接调用外部类的成员

                    try {
                        Thread.sleep(50);//50ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public void lanchgame(){
            this.setTitle("飞机大战");
            setVisible(true);
            setSize(500,500);
            setLocation(400,400);
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            new PaintThread().start();//启动重画窗口的线程
            this.addKeyListener(new KeyMonitor());//启动键盘监听
            for (int i=0;i<shells.length;i++){
                shells[i]=new Shell();
            }
        }
    private Image offScreenImage = null;
    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(500,500);//这是游戏窗口的宽度和高度
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);

    }
class KeyMonitor extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {

        plane1.addDirection(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane1.minusDirection(e);
    }
}
    public static void main(String[] args) {
        MyGameFrame lanchFrame = new MyGameFrame();
        lanchFrame.lanchgame();
    }
}


