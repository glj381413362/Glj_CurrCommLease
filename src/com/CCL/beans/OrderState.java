package com.CCL.beans;

public class OrderState {
	//	¶©µ¥±àºÅ
	private Integer id;
	// ¶©µ¥×´Ì¬Ãû
	private String name ;
	// ×´Ì¬ÃèÊö
	private String descript;
	private Boolean isShow = true;
	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	
	public OrderState() {
		super();
	}

	public OrderState(Integer id) {
		super();
		this.id = id;
	}

	public OrderState(String name, String descript) {
		super();
		this.name = name;
		this.descript = descript;
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
		OrderState other = (OrderState) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
