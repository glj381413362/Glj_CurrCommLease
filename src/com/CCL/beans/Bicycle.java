package com.CCL.beans;

/**
 * 自行车实体类
 * 
 * @author Jonney
 *
 */
public class Bicycle {

	// 直行车ID号
	private Integer id;
	// 直行车状态
	private BicycleState state;
	// 直行车类别
	private BicycleType type;
	// 名称
	private String name;
	// 描述
	private String descript;
	// 价格
	private Integer price;
	// 库存
	private Integer inventory;
	// 厂商
	private String factory;
	// 是否打折
	private Integer isDaZhe = 1;
	// 是否参加积分
	private Integer isJiFen = 1;

	private Integer baseTime;
	
	private Integer chargeTime;
	
	private Integer overTimePrice;
	
	private Boolean isShow = true;
	
	

	public Integer getBaseTime() {
		return baseTime;
	}

	public void setBaseTime(Integer baseTime) {
		this.baseTime = baseTime;
	}

	public Integer getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(Integer chargeTime) {
		this.chargeTime = chargeTime;
	}

	public BicycleState getState() {
		return state;
	}

	public void setState(BicycleState state) {
		this.state = state;
	}

	public BicycleType getType() {
		return type;
	}

	public void setType(BicycleType type) {
		this.type = type;
	}

	public Bicycle() {
	}
	
	public Bicycle(BicycleState state, BicycleType type, String name, String descript, Integer price, Integer inventory,
			String factory, Integer isDaZhe, Integer isJiFen, Integer baseTime, Integer chargeTime,
			Integer overTimePrice) {
		super();
		this.state = state;
		this.type = type;
		this.name = name;
		this.descript = descript;
		this.price = price;
		this.inventory = inventory;
		this.factory = factory;
		this.isDaZhe = isDaZhe;
		this.isJiFen = isJiFen;
		this.baseTime = baseTime;
		this.chargeTime = chargeTime;
		this.overTimePrice = overTimePrice;
	}
	
	
	
	public Bicycle(Integer id) {
		super();
		this.id = id;
	}

	public Integer getIsDaZhe() {
		return isDaZhe;
	}

	public void setIsDaZhe(Integer isDaZhe) {
		this.isDaZhe = isDaZhe;
	}

	public Integer getIsJiFen() {
		return isJiFen;
	}

	public void setIsJiFen(Integer isJiFen) {
		this.isJiFen = isJiFen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BicycleState getBicycleState() {
		return state;
	}

	public void setBicycleState(BicycleState bicycleState) {
		this.state = bicycleState;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
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
		Bicycle other = (Bicycle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getOverTimePrice() {
		return overTimePrice;
	}

	public void setOverTimePrice(Integer overTimePrice) {
		this.overTimePrice = overTimePrice;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	
	

	
	
	

}
