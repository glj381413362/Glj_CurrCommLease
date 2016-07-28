package com.CCL.panel;

import java.awt.*;
import java.text.DateFormat;
import java.util.*;
import javax.swing.*;
//数字时钟
public class Clockpael extends MPanel implements Runnable
{
  Thread clock;
  final int x;
  final int y;
  final int Xpoint=180;
  final int Ypoint=180;
  final int R=80;
  int xHour=0,yHour=0,xSecond=0,ySecond=0,xMin=0,yMin=0;
  public Clockpael(int x,int y)
  { 
	 super("images/jpanel/calender1.jpg",x,y);
	 this.x=x;
     this.y=y;
     start(); //开始进程
     
     
 }
public void start()
 { //开始进程
   if(clock==null)//如果进程为空值
   {
      clock=new Thread(this); //实例化进程
      clock.start(); //开始进程
   }
 }
public void run()//运行进程
{ 
   while (clock!=null)
   {
      repaint(); //调用paint方法重绘界面
      try
      {
        Thread.sleep(1000);  //线程暂停一秒(1000毫秒)
      }
      catch (InterruptedException ex){
      ex.printStackTrace();  //输出出错信息
   }
  }
 }
public void stop()//停止进程
{ 
   clock=null;
}
public void paint(Graphics g)//重载组件的paint方法
{ 
//	Image image = imico.getImage();              //通过ImageIco对象获得Image对象
//	System.out.println(image.getSource());
//	g.drawImage(image, 0, 0, null);              //将图片绘制到面板上
   DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
   Calendar now=new GregorianCalendar(); //实例化日历对象
   now.setTime(new Date());//dateFormat.format(now.getTime())
   String timeInfo=""; //输出信息
   int hour=now.get(Calendar.HOUR_OF_DAY); //得到小时数
   int minute=now.get(Calendar.MINUTE);   //得到分数
   int second=now.get(Calendar.SECOND);  //得到秒数
   if (hour<=9)
      timeInfo+="0"+hour+":"; //格式化输出
   else
      timeInfo+=hour+":";
   if (minute<=9)
      timeInfo+="0"+minute+":";
   else
      timeInfo+=minute+":";
   if (second<=9)
      timeInfo+="0"+second;
   else
       timeInfo+=second;
   g.setColor(Color.white);  //设置当前颜色为白色
   Dimension dim=getSize();  //得到窗口尺寸
   g.fillRect(0,0,dim.width,dim.height);  //填充背景色为白色
   
   Image image = new ImageIcon("images/jpanel/表1.jpg").getImage();              //通过ImageIco对象获得Image对象
	g.drawImage(image, 0, 0,263,251, null);                                         //将图片绘制到面板上
	 
   g.setColor(Color.black);  //设置当前颜色为红色
   g.setFont(new Font("", Font.BOLD, 30));
   
//   Image image1 = new ImageIcon("images/jpanel/caltitle.jpg").getImage();              //通过ImageIco对象获得Image对象
//	g.drawImage(image1, 0, 251,263,40, null);                                         //将图片绘制到面板上
   g.drawString(timeInfo,x+115,y+333);  //显示时间字符串、、、、、、////////////////////及位置
   g.setColor(Color.green);
   //g.drawString(dateFormat.format(now.getTime()),x+50,y+50);
   
   g.setColor(Color.black);
   g.setFont(new Font("",Font.BOLD,15));
  
/* for(int i=0,num=12;i<360;i+=6)
{ 
 double alfa = Math.toRadians(i);
 int xPos=x+Xpoint+(int)(R*Math.sin(alfa));
 int yPos=y+Ypoint-(int)(R*Math.cos(alfa));
 if(i%5==0)
 { 
  if (num%3==0)
	 
   g.setColor(Color.red); //  数字3,6,9,12为红色
  else
   g.setColor(Color.black);  // 其余数字为黑色
  if(num==12){
	  g.setFont(new Font("",Font.BOLD,17));
  g.drawString(""+num,xPos-5,yPos+3);  // 写数字
  }
  else
	  g.drawString(""+(num-12),xPos-5,yPos+3);
  num=(num+1); 
 }
 else
 {
  g.setColor(Color.black);
  g.drawString(".",xPos,yPos);
 }

}*/
 g.setColor(Color.black);
 g.fillOval(x+Xpoint-4,y+Ypoint-4,8,8);
 //画秒针
    xSecond=(int)(Xpoint+(R-10)*Math.sin(second*(2*Math.PI/60)));
    ySecond=(int)(Ypoint-(R-10)*Math.cos(second*(2*Math.PI/60)));
    g.setColor(Color.black);
    ((Graphics2D) g).setStroke(new BasicStroke(3.0f));//控制画线的粗细
    g.drawLine(x+Xpoint,y+Ypoint,x+xSecond,y+ySecond);
    //画分针
    xMin=(int)(Xpoint+(R-20)*Math.sin((minute+second/60)*(2*Math.PI/60)));
    yMin=(int)(Ypoint-(R-20)*Math.cos((minute+second/60)*(2*Math.PI/60)));
    g.setColor(Color.green);
    g.drawLine(x+Xpoint,y+Ypoint,x+xMin,y+yMin);
    //画时针
    xHour=(int)(Xpoint+(R-30)*Math.sin((hour+minute/60+second/60/60)*(2*Math.PI/12)));
    yHour=(int)(Ypoint-(R-30)*Math.cos((hour+minute/60+second/60/60)*(2*Math.PI/12)));
    g.setColor(Color.red);
    g.drawLine(x+Xpoint,y+Ypoint,x+xHour,y+yHour);
}

}