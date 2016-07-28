package com.CCL.view.huiyuan.service;

import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.util.mlf.PublicDate;

public class OperUserPerService {

	static public  Opeper getCurrentUserOpe(){
		
		
		return  PublicDate.getOuser().getOpePer();
		
//		return new Opeper(null,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1);
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
	
//	jTabbedPane1.addTab("会员卡办理", regist);
//	jTabbedPane1.addTab("会员卡充值", savemoney);
//	jTabbedPane1.addTab("会员卡注销补办", cancleanddo);
//
//	jTabbedPane1.addTab("会员余额查询/升级会员卡", queryAndupgrade);
//	jTabbedPane1.addTab("会员修改信息", update);
//	jTabbedPane1.addTab("会员信息查询", information);
//	jTabbedPane1.addTab("会员消费记录查询", records);
	
	static public boolean preJudgeByPanelTitle(String panelTitle) {

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
		}

		return true;

	}
	
	
}
