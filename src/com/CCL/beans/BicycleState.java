package com.CCL.beans;
/**
 * ×ÔÐÐ³µ×´Ì¬
 * @author Jonney
 *
 */
public class BicycleState {
	//×´Ì¬ID
	private Integer id;
	//×´Ì¬Ãû³Æ
	private String name;
	//×´Ì¬ÃèÊö
	private String descript;
	
	private Boolean isShow = true;
	
	
	
	public BicycleState(Integer id) {
		super();
		this.id = id;
	}
	public BicycleState(String name, String descript) {
		super();
		this.name = name;
		this.descript = descript;
	}
	public BicycleState() {
		super();
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
		BicycleState other = (BicycleState) obj;
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
	
	
}
