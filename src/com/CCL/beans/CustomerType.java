package com.CCL.beans;

public class CustomerType {
	// 编号
	private Integer id;
	// 类别名称
	private String name;
	// 类别描述
	private String descript;
	//客户折扣
	private Float discount;
	
	private Boolean isShow = true;
	
	
	
	public CustomerType(Integer id) {
		super();
		this.id = id;
	}

	public CustomerType(String name, String descript, Float discount) {
		super();
		this.name = name;
		this.descript = descript;
		this.discount = discount;
	}

	public CustomerType() {
		super();
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return name;
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
		CustomerType other = (CustomerType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
