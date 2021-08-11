# hello-world
my first code for our world
//商品表格显示， java方法要再学习
public class work01 {
    public static void main(String[] args) {
    commodity[] commoditys=new commodity[5];
    commodity commodity00=new commodity("百战牌鼠标","BZ-001",99.21,0.9);
    commodity commodity01=new commodity("键盘侠玩偶","WO-102",403.00,0.7);
    commodity commodity02=new commodity("实战java设计","Bk-001",89.00,0.8);
    commodity commodity03=new commodity("杨辉牌西装","GQ-XF-12",700.00,0.5);
    commodity commodity04=new commodity("大米牌手机  ","DM-ph-13",900.00,0.3);
        commoditys[0]=commodity00;
        commoditys[1]=commodity01;
        commoditys[2]=commodity02;
        commoditys[3]=commodity03;
        commoditys[4]=commodity04;
        for (int i=0;i<commoditys.length;i++){
            System.out.println(commoditys[i]);
        }
        for (int i=0;i<commoditys.length;i++){
            System.out.println(commodity.price(commoditys[i]));
        }
    }
}
class commodity{
    private String name;
    private String type;
    private double price;
    private double cut;

    public commodity() {
    }

    public commodity(String name, String type, double price, double cut) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.cut = cut;
    }
    public static  String price(commodity commoditys){
        if (commoditys.price*commoditys.cut>100){
            return commoditys.toString();
        }else {
            return "\t";
        }
    }


    @Override
    public String toString() {
        return getName()+"\t"+getType()+"\t"+getPrice()+"\t"+getCut();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCut() {
        return cut;
    }

    public void setCut(double cut) {
        this.cut = cut;
    }
}
