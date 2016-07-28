package com.CCL.beans;

import java.util.Date;
import java.util.Map;

public class Order {
	
	//	订单ID
	private Integer id;
	//	客户
	private Customer customer;
	// 操作员
	private OpeUser opeUser;
	// 自行车
	private String bicycles;
	//订单状态
	private OrderState orderState;
	//下单时间
	private Date putTime;
	//开启时间
	private Date startTime;
	//结束时间
	private Date stopTime;
	//押金
	private Float deposit;
	
	private Map<Bicycle,Integer> bicyclesMap;
	
	
	
	public Order() {
		super();
	}

	public Order(Integer id) {
		super();
		this.id = id;
	}

	


	public Order(Customer customer, OpeUser opeUser, String bicycles, OrderState orderState, Date putTime,
			Date startTime, Date stopTime, Float deposit) {
		super();
		this.customer = customer;
		this.opeUser = opeUser;
		this.bicycles = bicycles;
		this.orderState = orderState;
		this.putTime = putTime;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.deposit = deposit;
	}

	public Date getPutTime() {
		return putTime;
	}

	public void setPutTime(Date putTime) {
		this.putTime = putTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	private Boolean isShow = true;
	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public OpeUser getOpeUser() {
		return opeUser;
	}
	public void setOpeUser(OpeUser opeUser) {
		this.opeUser = opeUser;
	}
	public String getBicycles() {
		return bicycles;
	}
	public void setBicycles(String bicycles) {
		this.bicycles = bicycles;
	}
	public OrderState getOrderState() {
		return orderState;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	
	public Float getDeposit() {
		return deposit;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Map<Bicycle,Integer> getBicyclesMap() {
		return bicyclesMap;
	}

	public void setBicyclesMap(Map<Bicycle,Integer> bicyclesMap) {
		this.bicyclesMap = bicyclesMap;
	}
	
}
