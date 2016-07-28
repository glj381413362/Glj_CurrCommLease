package com.CCL.service.glj;

import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.util.mlf.PublicDate;

public class OpeperSelect {

	
	private static OpeUser opeuser = PublicDate.getOuser();
	private static Opeper opeper = getOpeperList(opeuser);
	/**
	 * @Description  传入一个操作员对象，获得他的操作权限对象
	 * @param opeuser
	 * @return Opener
	 * @author 龚梁钧
	 * @create 2016-06-14 16:22
	 */
	public static Opeper getOpeperList(OpeUser opeuser)
	{
		return opeuser.getOpePer();
	}
	
	/**
	 * @Description  查询用户是否有使用某功能的权限
	 * @param preName
	 * @return boolean
	 * @author 龚梁钧
	 * @create 2016-06-14 16:42
	 */
	public static boolean preJudge(String preName) {
		int i = 1 ;
		boolean result = false;
		if(preName.equals("收费设置"))
		{
			i = opeper.getChargingSet();
		}else if(preName.equals("折扣设置")){
			i = opeper.getDiscountSet();
		}else if(preName.equals("日营业查询")){
			i = opeper.getTradingQuery();
		}else if(preName.equals("账单明细查询")){
			i = opeper.getBillDetails();
		}else if(preName.equals("销售趋势分析")){
			i = opeper.getChargingSet();
		}else if(preName.equals("车辆管理")){
			i = opeper.getCarManager();
		}
		result =  i==1 ? true:false;
		return result;

	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
