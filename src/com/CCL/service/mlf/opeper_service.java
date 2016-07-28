package com.CCL.service.mlf;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.Dao.impl.OpeperDaoImpl;
import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.util.mlf.PublicDate;

public class opeper_service {
	
	private OpeperDao opeperDao = new OpeperDaoImpl();
	private Opeper opeper;
	private JList list;
	private int i;
	private String name;
	private String pwd;
	private OpeUserDao Opdao;
	private OpeUser oper;
	public opeper_service()
	{
		Opdao=new OpeUserDaoImpl();
		oper=new OpeUser();
	}
	public Vector<Object> readQuanxian_vctor(Opeper opeper,String name,int j)
	{
		this.opeper = opeper;
//		List<Opeper> opeperlist = opeperDao.queryAll();
		Vector<Object> temp =null;//new Vector<Object>();;
		if(name.equals("前台收银管理"))
		{
			Vector<Object> vc=new Vector<Object>();
				if(opeper.getToChange()==j)
				{
					vc.addElement("换车管理");
				}
				if(opeper.getPointsFor()==j)
			    {
					vc.addElement("积分兑换");
					
			}
			temp =vc;
		}
		
		if(name.equals("会员卡管理"))
		{
			Vector<Object> vc=new Vector<Object>();
				 if(opeper.getUpgrade()==j)
				    {
					 vc.addElement("会员卡升级");
				    }
				    if(opeper.getReCard()==j)
				    {
				    	vc.addElement("会员卡补办");
				    }
				    if(opeper.getCardTopup()==j)
				    {
				    	vc.addElement("会员卡充值");
				    }
				    if(opeper.getMoneyQuery()==j)
				    {
				    	vc.addElement("余额查询");
				    }
				    if(opeper.getReInfo()==j)
				    {
				    	vc.addElement("信息修改");
				    }
				    if(opeper.getReCordQuery()==j)
				    {
				    	vc.addElement("消费记录查询");
				    }
			temp = vc;
		}
		if(name.equals("系统管理"))
		{
			Vector<Object> vc=new Vector<Object>();
				 if(opeper.getChargingSet()==j)
				    {
					    vc.addElement("收费设置");
				    }
				    if(opeper.getDiscountSet()==j)
				    {
				    	vc.addElement("折扣设置");
				    }
				    
				    if(opeper.getCarManager()==j)
				    {
				    	vc.addElement("车辆管理");
				    }
			return vc;
		}
		if(name.equals("其它"))
		{
			Vector<Object> vc=new Vector<Object>();
				if(opeper.getDataBackup()==j)
			    {
			    	vc.addElement("数据备份");
			    }
			    if(opeper.getMessageTel()==j)
			    {
			    	vc.addElement("短信提醒");
			    }
			temp = vc;
		}
	   
	   return temp;
	}
	public  Vector<Object> readQuanXian(Opeper opeper,int i)
	  {  
		DefaultListModel  listmodel=new DefaultListModel();
		this.opeper=opeper;
	    this.list=list;
	    this.i=i;
	    List<Opeper> opeperlist = opeperDao.queryAll();
		Vector<Object> vc=new Vector<Object>();
	    if(opeper.getToChange()==i)
	    {
	    	vc.addElement("换车管理");
	    }
	    if(opeper.getBillPrint()==i)
	    {
	    	vc.addElement("账单管理");
	    }
	    if(opeper.getPointsFor()==i)
	    {
	    	vc.addElement("积分兑换");
	    }
	    if(opeper.getUpgrade()==i)
	    {
	    	vc.addElement("会员卡升级");
	    }
	    if(opeper.getReCard()==i)
	    {
	    	vc.addElement("会员卡补办");
	    }
	    if(opeper.getCardTopup()==i)
	    {
	    	vc.addElement("会员卡充值");
	    }
	    if(opeper.getMoneyQuery()==i)
	    {
	    	vc.addElement("余额查询");
	    }
	    if(opeper.getReInfo()==i)
	    {
	    	vc.addElement("信息修改");
	    }
	    if(opeper.getReCordQuery()==i)
	    {
	    	vc.addElement("消费记录查询");
	    }
	    if(opeper.getChargingSet()==i)
	    {
	    	vc.addElement("收费设置");
	    }
	    if(opeper.getDiscountSet()==i)
	    {
	    	vc.addElement("折扣设置");
	    }
	    
	    if(opeper.getCarManager()==i)
	    {
	    	vc.addElement("车辆管理");
	    }
	    if(opeper.getDataBackup()==i)
	    {
	    	vc.addElement("数据备份");
	    }
	    if(opeper.getMessageTel()==i)
	    {
	    	vc.addElement("短信提醒");
	    }
	    return vc;
	}
	public void shouQuan(Opeper opeper,String name,int s)
	{
		this.opeper = opeper;
		if(name.equals("换车管理"))
		{
			opeper.setToChange(s);
		}
		if(name.equals("账单管理"))
		{
			opeper.setBillPrint(s);
	
		}
		if(name.equals("积分兑换"))
		{
			opeper.setPointsFor(s);
		}
		if(name.equals("会员卡升级"))
		{
			opeper.setUpgrade(s);
		}
		if(name.equals("会员卡补办"))
		{
			opeper.setReCard(s);
		}
		if(name.equals("会员卡充值"))
		{
			opeper.setCardTopup(s);
		}
		if(name.equals("余额查询"))
		{
			opeper.setMoneyQuery(s);
		}
		if(name.equals("信息修改"))
		{
			opeper.setReInfo(s);
		}
		if(name.equals("消费记录查询"))
		{
			opeper.setReCordQuery(s);
		}
		if(name.equals("收费设置"))
		{
			opeper.setChargingSet(s);
		}	
		if(name.equals("折扣设置"))
		{
			opeper.setDiscountSet(s);
		}
		if(name.equals("车辆管理"))
		{
			opeper.setCarManager(s);
		}
		if(name.equals("数据备份"))
		{
			opeper.setDataBackup(s);
		}
		if(name.equals("短信提醒"))
		{
			opeper.setMessageTel(s);
		}
		
	}
	public OpeUser selectByNameAndPwd(String name,String pwd)
	{
		this.name=name;		
		this.pwd=pwd;
		OpeUser oper=null;
		List<OpeUser> user=Opdao.queryAll();
		for(OpeUser u:user)
		{
			if(u.getUserName().equals(name)&&u.getPassword().equals(pwd))
			{
				oper=u;
			}
		}
		return oper;
	}
	public static  boolean preJudgeByPanelTitle(String panelTitle) 
	{

		switch(panelTitle){
		case "会员卡充值":
			return preJudge("cardTopup");
		case "会员卡注销补办":
			return preJudge("reInfo");
		case "会员余额查询/升级会员卡":
			return preJudge("reInfo");
		case "会员修改信息":
			return preJudge("reInfo");
		case "会员消费记录查询":
			return preJudge("reCordQuery");
		case "车辆管理":
		    return preJudge("carManager");
		}

		return true;

	}
static public  Opeper getCurrentUserOpe(){
		
		
		return  PublicDate.getOuser().getOpePer();
		
//		return new Opeper(null,1,1,1,1,1,0,1,1,1,1,1,1,1,1);
//		return new Opeper();
		
	}
	static public boolean preJudge(String preName) {

		switch (preName) {

		case "pointsFor":
			if (getCurrentUserOpe().getPointsFor() == 1) {
				return true; // 积分兑换权限
			}
			;
			break;
		case "upgrade":
			if (getCurrentUserOpe().getUpgrade() == 1) {
				return true; // 升级会员卡权限
			}
			;
			break;
		case "cardTopup":
			if (getCurrentUserOpe().getCardTopup() == 1) {
				return true; // 会员卡充值
			}
			;
			break;
		case "reCard":
			if (getCurrentUserOpe().getReCard() == 1) {
				return true; // 补办会员卡
			}
			;
			break;
		case "moneyQuery":
			if (getCurrentUserOpe().getMoneyQuery() == 1) {
				return true; // 余额查询
			}
			;
			break;
		case "reCordQuery":
			if (getCurrentUserOpe().getReCordQuery() == 1) {
				return true; // 消费记录查询
			}
			;
			break;
		case "reInfo":
			if (getCurrentUserOpe().getReInfo() == 1) {
				return true; // 信息修改
			}
			;
			break;
		}

		return false;

	}

}
