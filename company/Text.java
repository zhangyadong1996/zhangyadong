import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        String[] names=new String[4];//保存订餐人姓名
        String[]  dishMegs=new String[4];//保存菜品及份数
        int[]  times=new int[4];//保存送出时间
        String[]  adresses=new String[4];//保存送餐地址
        int[] states =new int[4];//保存订单状态0表示你预定1 表示订单完成
        double[]  sumPrices=new double[4];//保存订单的总金额
        String[] dishName={"红烧带鱼","鱼香肉丝","时令鲜蔬"};//菜品名称
        double[]  dishPrice={38,20,10};//菜品价格
        int[]praiseNums=new int[3];//菜品点赞量
        //用户初始化

        names[0]="张三威武";
        dishMegs[0]="红烧带鱼两份";
        times[0]=12;
        adresses[0]="辽宁号航母3栋4021室";
        sumPrices[0]=76.0;
        states[0]=1;

        names[1]="王二麻子";
        dishMegs[1]="鱼香肉丝两份";
        times[1]=21;
        adresses[1]="陆家嘴御林雅苑7栋120";
        sumPrices[1]=40.0;
        states[1]=0;

        names[2]="大力水手";
        dishMegs[2]="时令鲜疏三份";
        times[2]=5;
        adresses[2]="台北县五道河小区2111";
        sumPrices[2]=30.0;
        states[2]=0;
//
//        names[3]="我是小仙女";
//        dishMegs[3]="红烧带鱼20份";
//        time[3]=7;
//        adresses[3]="南京市仙女小区仙女6栋6666号";
//        sumPrices[3]=760.0;
//        states[3]=0;
        //获取输入数据
        Scanner input=new Scanner(System.in);
        int num=-1;//用户输入0时返回主菜单否则退出系统
        boolean isExit=false;//标志用户是否退出系统：true为退出系统
        System.out.println("\n欢迎使用吃货联盟订餐系统");
        //循环：显示菜单，根据用户选择的数字执行相应的功能
        do {
            //显示菜单
            System.out.println("******************************************");
            System.out.println("1、我要订餐");
            System.out.println("2、查看餐袋");
            System.out.println("3、签收订单");
            System.out.println("4、删除订单");
            System.out.println("5、我要点赞");
            System.out.println("6、退出系统");
            System.out.println("******************************************");
            System.out.println("请选择：");
            int choose=input.nextInt();//获取用户选择的功能编号
            // 根据用户选择编号执行相应的功能
            //判断是否要退出系统
            //①
            switch (choose){
                case 1:
                    System.out.println("*****我要订餐*****");
                    Boolean isAdd=false;//记录是否可以订餐
                    for (int j=0;j<names.length;j++){//遍历names数组
                        if (names[j]==null){//找到names中的第一个空值并赋值可添加订单信息
                            isAdd=true;//置标志位，可以订餐
                            System.out.println("请输入订餐姓名");
                            String name=input.next();
                            //显示提供选择菜品的信息
                            System.out.println("序号 "+"\t\t\t"+"菜名"+"\t\t\t"+"单价"+"\t"+"点赞数");
                            for (int i=0;i<dishName.length;i++){
                                String price=dishPrice[i]+"元";
                                String priaiseNum=(praiseNums[i])>0?praiseNums[i]+"赞":"0" ;
                                System.out.println((i+1)+"\t\t\t"+dishName[i]+"\t\t"+dishMegs
                            +"\t"+price+"\t"+priaiseNum);
                            }
                            //用户点菜
                            System.out.println("请选择你要点菜的编号");
                           int chooseDish=input.nextInt();
                           System.out.println("请选择你要点菜的分数");
                           int number=input.nextInt();
                           String dishMeg=dishName[chooseDish-1]+""+number+"份";
                           double sumPrice=dishPrice[chooseDish-1]*number;//餐品的总价格
                            double deliCharge=(sumPrice>=50)?0:5; //餐品满50免送餐费5元
                            System.out.println("请输入送餐时间（送餐时间为10点-20点间整点送餐）");
                            int time=input.nextInt();
                            while (time<10&&time>20){
                                System.out.println("你的输入有误请重新输入，请输入10到20的整数");
                                time=input.nextInt();
                            }
                            System.out.println("请输入送餐地址");
                            String adress=input.next();
                            //无须添加状态默认状态是已预订状态
                            System.out.println("订餐成功");
                            System.out.println("你订的是"+dishMeg);
                            System.out.println("你的送餐时间是"+time+"点");
                            System.out.println("你的配送地址是"+adress);
                            System.out.println("餐费"+sumPrice+"元,送餐费"+deliCharge+"元，总计："+(sumPrice+deliCharge+"元"));
                            //添加数据
                            names[j]=name;
                            dishMegs[j]=dishMeg;
                            times[j]=time;
                            adresses[j]=adress;
                            sumPrices[j]=sumPrice+deliCharge;

                        }

                    }
                    if (!isAdd){
                            System.out.println("对不起，你的餐袋已满");
                    }

                    break;
                case 2:
                    System.out.println("*****查看餐袋*****");
                    System.out.println("序号\t订餐人\t\t\t餐品信息\t\t\t送餐时间\t\t\t送餐地址\t\t\t\t\t\t\t总金额\t\t\t订单状态");
                    for (int i=0;i<names.length;i++){
                        if (names[i]!=null) {
                            String state = (states[i] == 0) ? "已预订" : "已完成";
                            String date = times[i] + "点";
                            String sumPrice = sumPrices[i] + "元";
                            System.out.println((i + 1) + "\t"+names[i] + "\t\t" + dishMegs[i]+"\t\t\t"+date+"\t\t\t"+adresses[i]+"\t\t\t\t\t"+sumPrice+"\t\t\t"+state);
                        }
                    }
                    break;
                case 3:
                    System.out.println("*****签收订单*****");
                    boolean isSignFind=false;//找到要签收的订单
                    System.out.println("请选择要签收的订单编号：");
                    int signOrderId=input.nextInt();
                    for (int i=0;i<names.length;i++){
                        //状态为已预订，序号为用户输入订单编号-1：可签收
                        //状态为已完成，序号为用户输入订单号-1：不可签收
                        if(names[i]!=null&&states[i]==0&&signOrderId==i+1){//当用户不为空并且状态为预定
                            states[i]=1;//将状态置为已完成
                            System.out.println("订单签收成功！");
                            isSignFind=true;//标记找到此订单
                        }else if(names[i]!=null&&states[i]==0&&signOrderId==i+1){
                            System.out.println("你的订单已签收，不能重复签收！");
                            isSignFind=true;//标记已找到此订单
                        }
                    }
                    if (!isSignFind){
                        System.out.println("你选择的订单不存在！");
                    }

                    break;
                case 4:
                    System.out.println("*****删除订单*****");
                    boolean isDelFind=false;
                    System.out.println("请输入需要删除的订单编号");
                    int  delId=input.nextInt();
                    for (int i=0;i<names.length;i++){
                        //状态值为已完成，序号值为用户狗输入的序号—1；可删除
                        //状态值为已预订，序号值为用户名输入的序号——1：不可删除
                        if (names[i]!=null&&states[i]==1&&delId==i+1){
                                isDelFind=true;//标记已找到此订单
                            //执行删除操作：删除位置后元素依次前移
                            for (int j=0;j<names.length-1;j++){
                                names[j]=names[j+1];
                                dishMegs[j]=dishMegs[j+1];
                                times[j]=times[j+1];
                                adresses[j]=adresses[j+1];
                                states[j]=states[j+1];
                                sumPrices[j]=sumPrices[j+1];
                            }
                               //最后一位清空
                            int  endIndex=names.length-1;
                            names[endIndex]=null;
                            dishMegs[endIndex]=null;
                            times[endIndex]=0;
                            adresses[endIndex]=null;
                            states[endIndex]=0;
                            sumPrices[endIndex]=0;
                            System.out.println("删除订单成功");
                            break;
                        }else if (names[i]!=null&&states[i]==0&&delId==i+1){
                            System.out.println("你选择的订单未签收不能删除订单！");
                            isDelFind=true;//标记已找到此订单
                            break;
                        }
                    }
                    //未找到该序号的订单：不能删除
                    if (!isDelFind){
                        System.out.println("你要删除的订单不存在！");
                    }
                    break;
                case 5:
                    System.out.println("*****我要点赞*****");
                    //我要点赞
                    //显示商品信息
                    System.out.println("序号"+"\t\t"+"菜名"+"\t\t"+"单价");
                    for (int i=0;i< dishName.length;i++){
                        String price=dishPrice[i]+"元";
                        String priaiseNum=(praiseNums[i]>0?praiseNums[i]+"赞":"");
                        System.out.println((i+1)+"\t"+dishName[i]+"\t"+price+"\t"+priaiseNum);
                    }
                    System.out.println("请选择你要点赞的菜品序号");
                    int  priaiseNum=input.nextInt();
                    praiseNums[priaiseNum-1]++;//点赞数加一
                    System.out.println("点赞成功");
                    break;
                case 6:
                    System.out.println("*****退出系统*****");
                    isExit=true;
                    break;
                default:
                    //退出系统
                    isExit=true;
                    break;

            }
            if (!isExit){
                System.out.println("输入值为0，返回：");
                num=input.nextInt();
            }else {
                break;
            }

        }while (num==0);

    }
}
