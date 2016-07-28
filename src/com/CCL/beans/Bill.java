package com.CCL.beans;

import java.util.Date;

/**
 * 账单类
 * 
 * @author Administrator
 *
 */
public class Bill {

	// 账单编号
	private Integer id;
	// 结账时间
	private Date outTime;
	// 消费时长 (分钟)
	private Long delay;
	
	// 关联的订单
	private Order order;
	// 客户名称   没有关联约束
	private String customerName;
	// 客户ID   没有关联约束
	private Integer customerId;
	// 结账方式
	private String payWay;
	// 总金额
	private float total;
	
	private Boolean isShow = true;
	
	

	public Bill(Integer id) {
		super();
		this.id = id;
	}

	public Bill(Date outTime, Long delay, Order order, String customerName, Integer customerId, String payWay,
			float total) {
		super();
		this.outTime = outTime;
		this.delay = delay;
		this.order = order;
		this.customerName = customerName;
		this.customerId = customerId;
		this.payWay = payWay;
		this.total = total;
	}

	public Bill() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return id.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


}
